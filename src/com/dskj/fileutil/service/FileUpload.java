package com.dskj.fileutil.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dskj.base.Base;
import com.dskj.fileutil.mapper.FileUpLoadMapper;

/**
 * 默认可以上传所有类型文件
 * 
 * @author Administrator
 * 
 */
@Service
public class FileUpload extends Base{
	private Long maxSize;// 文件上传大小限制
	@Autowired
	private FileUpLoadMapper fileUpLoadMapper;
	private Map<String, String> fileUploadConfigs = new HashMap<String, String>();

	private void InitUpload() {
		if (fileUploadConfigs.get("ins_file_maxsize").endsWith("M") || fileUploadConfigs.get("ins_file_maxsize").endsWith("m")) {
			String size = fileUploadConfigs.get("ins_file_maxsize").substring(0, fileUploadConfigs.get("ins_file_maxsize").length() - 1);
			maxSize = Long.valueOf(size) * 1024 * 1024;
		} else if (fileUploadConfigs.get("ins_file_maxsize").endsWith("K") || fileUploadConfigs.get("ins_file_maxsize").endsWith("k")) {
			String size = fileUploadConfigs.get("ins_file_maxsize").substring(0, fileUploadConfigs.get("ins_file_maxsize").length() - 1);
			maxSize = Long.valueOf(size) * 1024;
		} else if (fileUploadConfigs.get("ins_file_maxsize").endsWith("G") || fileUploadConfigs.get("ins_file_maxsize").endsWith("g")) {
			String size = fileUploadConfigs.get("ins_file_maxsize").substring(0, fileUploadConfigs.get("ins_file_maxsize").length() - 1);
			maxSize = Long.valueOf(size) * 1024 * 1024 * 1024;
		} else {
			maxSize = Long.valueOf(fileUploadConfigs.get("ins_file_maxsize"));
		}
		logger.info("fileUpload init success.");
	}

	/**
	 * 
	 * @param fileSrc缓存文件名称
	 * @param fileDes目标文件真实根路径
	 * @param type业务类型
	 * @return
	 * @throws Exception
	 */
	public String transferTo(String fileSrc, String fileDes, String type) throws Exception {
		File tempFile = new File(fileUploadConfigs.get("ins_file_cache") + fileSrc);
		if (!tempFile.exists())
			return "图片不存在";
		File realFile = new File(fileDes + "/image/" + type + "/" + fileSrc.replace(".temp", ""));
		if (!realFile.getParentFile().exists())
			realFile.getParentFile().mkdirs();
		if (!realFile.exists()) {
			realFile.createNewFile();
		}
		FileUtils.copyFile(tempFile, realFile);
		tempFile.delete();
		return "/image/" + type + "/" + fileSrc.replace(".temp", "");
	}

	/**
	 * 
	 * @param fileDes目标文件真实根路径
	 * @param type业务类型
	 * @param fileName文件名称
	 * @throws Exception
	 */
	public void dropImg(String fileDes, String fileName) throws Exception {
		File file = new File(fileDes + fileName);
		if(file.exists() && file.isFile())
			file.delete();
	}

	public void dropTempImg(String fileName) {
		File file = new File(fileUploadConfigs.get("ins_file_cache") + fileName);
		if (file.exists() && file.isFile())
			file.delete();
	}

	public String upload(MultipartFile file) throws FileUploadException, IOException {
		if (file == null || file.getSize() == 0) {
			return "没有选择文件";
		}
		if (file.getSize() > maxSize) {
			return "超过最大限制" + fileUploadConfigs.get("ins_file_maxsize");
		}
		String fileExtName = file.getOriginalFilename();
		fileExtName = fileExtName.substring(fileExtName.lastIndexOf(".") + 1);
		if (!fileUploadConfigs.get("ins_file_suffix").contains(fileExtName)) {
			return "文件类型只支持" + fileUploadConfigs.get("ins_file_suffix");
		}
		String filename = System.currentTimeMillis() + ".temp." + fileExtName;
		File tempFile = new File(fileUploadConfigs.get("ins_file_cache") + filename);
		if (!tempFile.exists())
			tempFile.mkdirs();
		file.transferTo(tempFile);
		return tempFile.getName();
	}
}
