package com.dskj.fileutil.controll;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dskj.base.Base;
import com.dskj.fileutil.service.FileUpload;

@Controller
public class FileControll extends Base {
	@Autowired
	private FileUpload fileUpload;

	/*
	 * 上传图片
	 */
	@RequestMapping("/file/upload")
	public void uploadImageTest(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		try {
			String filePath = fileUpload.upload(file);
			if (filePath.contains(".temp"))
				write(response, null, null, null, filePath);
			else
				write(response, false, 911, filePath, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 上传xml
	 */
	@RequestMapping("/file/xml/upload")
	public void uploadXMlTest(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		try {
			File tempFile = new File(request.getSession().getServletContext().getRealPath("") + "/xml/update.xml");
			if (!tempFile.exists())
				tempFile.createNewFile();
			file.transferTo(tempFile);
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 上传apk
	 */
	@RequestMapping("/file/apk/upload")
	public void uploadAPKTest(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		try {
			File tempFile = new File(request.getSession().getServletContext().getRealPath("") + "/xml/"+file.getOriginalFilename());
			if (!tempFile.exists())
				tempFile.createNewFile();
			file.transferTo(tempFile);
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
}
