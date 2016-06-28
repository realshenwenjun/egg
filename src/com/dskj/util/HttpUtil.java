package com.dskj.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
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

import com.frame.elastic.json.JSONUtil;

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
			StringEntity s = new StringEntity(json,"UTF-8");
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
		String method = "POST";
		String url = "http://msg.umeng.com/api/send";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("appkey","56fa4323e0f55adf32000b30");
		map.put("timestamp",System.currentTimeMillis());
		map.put("type","unicast");
		map.put("device_tokens","ArO0VdkW10VHJaa4-Pj7QwZdfU-TYTfMASdXy3WJKSZl");
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("display_type","notification");
		Map<String,Object> map2 = new HashMap<String,Object>();
		map2.put("ticker","呵呵");
		map2.put("title","截图我看看");
		map2.put("text","傻逼赵硕");
		map2.put("after_open","go_app");
		map1.put("body",map2);
		map.put("payload",map1);
		String AppMasterSecret = "0zdtwyykh2vrmqkgfs7osz0mt0jlondi";
		try {
			String body = JSONUtil.objToString(map);
			String sign = MD5Util.MD5Encode(method+url+ body +AppMasterSecret,"UTF-8");
			System.out.println(sign);
			String result = HttpUtil.post(url + "?sign=" + sign, body);
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
