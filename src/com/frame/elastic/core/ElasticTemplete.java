package com.frame.elastic.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.frame.elastic.http.HttpUtil;
import com.frame.elastic.init.XmlMapping;
import com.frame.elastic.json.JSONUtil;
import com.frame.elastic.util.JaxbUtil;
import com.frame.elastic.util.JaxbUtil.CollectionWrapper;

public class ElasticTemplete {

	private static String host = null;

	private static String port = null;

	private String makeUrl() throws Exception {
		return "http://" + host + ":" + port;
	}

	public String query(String index, String type, String queryDsl)
			throws Exception {
		return HttpUtil.post(makeUrl() + "/" + index + "/" + type + "/_search",
				queryDsl);
	}

	public String add(String index, String type, String jsonBean)
			throws Exception {
		return HttpUtil.post(makeUrl() + "/" + index + "/" + type,
				JSONUtil.objToString(jsonBean));
	}

	public String update(String index, String type, String id, String jsonBean)
			throws Exception {
		return HttpUtil.post(makeUrl() + "/" + index + "/" + type + "/" + id,
				jsonBean);
	}

	public void delete(String index, String type, String id) throws Exception {
		HttpUtil.delete(makeUrl() + "/" + index + "/" + type + "/" + id);
	}

	public static void setHost(String host) {
		ElasticTemplete.host = host;
	}

	public static void setPort(String port) {
		ElasticTemplete.port = port;
	}

	public void initIndexMapping() throws Exception {
		scan(new File(this.getClass().getResource("/").toURI()));
	}

	/**
	 * 初始化创建库
	 * 
	 * @param f
	 * @throws Exception
	 */
	public void scan(File f) throws Exception {
		if (f != null && f.exists() && f.isDirectory()) {
			File[] fileArray = f.listFiles();
			if (fileArray != null) {
				for (int i = 0; i < fileArray.length; i++) {
					// 递归调用
					scan(fileArray[i]);
				}
			}
		} else {
			if (f.getName().contains("Mapping.xml")) {

				JaxbUtil resultBinder = new JaxbUtil(XmlMapping.class,
						CollectionWrapper.class);
				XmlMapping xmlMapping = resultBinder
						.fromXml(readFileByLines(f));
				String reponse = HttpUtil.get(
						makeUrl() + "/" + xmlMapping.getIndex() + "/_mapping/"
								+ xmlMapping.getType(), null);
				if ("{}".equals(reponse) || reponse.contains("error")) {
					HttpUtil.post(makeUrl() + "/" + xmlMapping.getIndex(),
							xmlMapping.getMappings());
				}
			}
		}
	}

	/**
	 * 以行为单位读取文件，常用于读面向行的格式化文件
	 */
	public static String readFileByLines(File file) {
		BufferedReader reader = null;
		StringBuffer sb = new StringBuffer();
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				sb.append(tempString);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return sb.toString();
	}
}
