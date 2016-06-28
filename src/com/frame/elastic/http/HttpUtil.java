package com.frame.elastic.http;

import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	/**
	 * https post
	 * 
	 * @param url
	 * @param json
	 * @param headers
	 * @return
	 */
	public static String post(String url, String json,
			Map<String, String> headers) {
		String result = null;
		try {
			CloseableHttpClient client = createSSLClientDefault();
			HttpPost post = new HttpPost(url);
			StringEntity s = new StringEntity(json.toString());
			s.setContentEncoding("UTF-8");
			s.setContentType("application/json");
			Iterator<Entry<String, String>> iter = headers.entrySet()
					.iterator();
			while (iter.hasNext()) {
				Map.Entry<String, String> entry = (Map.Entry<String, String>) iter
						.next();
				post.setHeader(entry.getKey().toString(), entry.getValue()
						.toString());
			}
			post.setEntity(s);
			CloseableHttpResponse response = client.execute(post);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					result = EntityUtils.toString(entity, "UTF-8");
				}
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("deprecation")
	public static CloseableHttpClient createSSLClientDefault() throws Exception {
		SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null,
				new TrustStrategy() {
					// 信任所有
					public boolean isTrusted(X509Certificate[] chain,
							String authType) throws CertificateException {
						return true;
					}
				}).build();
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
				sslContext);
		return HttpClients.custom().setSSLSocketFactory(sslsf).build();
	}

	/**
	 * http post
	 * 
	 * @param url
	 * @param json
	 * @return
	 */
	public static String post(String url, String json) {
		String result = null;
		try {
			CloseableHttpClient client = HttpClients.createDefault();
			HttpPost post = new HttpPost(url);
			StringEntity s = new StringEntity(json);
			post.setEntity(s);
			CloseableHttpResponse response = client.execute(post);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					result = EntityUtils.toString(entity, "UTF-8");
				}
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * http get
	 * 
	 * @param url
	 * @param headers
	 * @return
	 */
	public static String get(String url, Map<String, String> headers) {
		String result = null;
		try {
			CloseableHttpClient client = HttpClients.createDefault();
			HttpGet get = new HttpGet(url);
			if (headers != null) {
				Iterator<Entry<String, String>> iter = headers.entrySet()
						.iterator();
				while (iter.hasNext()) {
					Map.Entry<String, String> entry = (Map.Entry<String, String>) iter
							.next();
					get.setHeader(entry.getKey().toString(), entry.getValue()
							.toString());
				}
			}
			CloseableHttpResponse response = client.execute(get);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					result = EntityUtils.toString(entity, "UTF-8");
				}
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * http delete
	 * 
	 * @param url
	 */
	public static void delete(String url) {
		try {
			URL url2 = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) url2
					.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("DELETE");
			connection.getResponseCode();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println(HttpUtil.post("http://101.201.212.96:9200/family/system_config/_search?pretty", ""));
	}
}
