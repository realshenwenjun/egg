package com.frame.elastic.json;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.type.JavaType;

import com.dskj.course.entity.ClassSignUser;

public class JSONUtil {
	private static ObjectMapper objectMapper;
	
	static{
		objectMapper = new ObjectMapper();
		objectMapper.setVisibility(JsonMethod.FIELD, Visibility.ANY);
		objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
		objectMapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		objectMapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	/**
	 * Object转成String
	 * 
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	public static String objToString(Object object) throws JsonGenerationException, JsonMappingException, IOException {
		// 将结果转化为JSON字符串
		String jsonString = objectMapper.writeValueAsString(object);
		Pattern p = Pattern.compile("\t|\r|\n|\\s");
		Matcher m = p.matcher(jsonString);
		jsonString = m.replaceAll("");
//		jsonString = jsonString.replaceAll(" ", "");
		return jsonString;
	}

	/**
	 * String转Object
	 * 
	 * @param json
	 * @param T
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T stringToObj(String json, Class<?> T) throws JsonParseException, JsonMappingException, IOException {
		T t = (T) objectMapper.readValue(json, T);
		return t;
	}

	/**
	 * 获取泛型的Collection Type
	 * 
	 * @param collectionClass
	 *            泛型的Collection
	 * @param elementClasses
	 *            元素类
	 * @return JavaType Java类型
	 * @since 1.0
	 */
	private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}

	public static <T> List<T> jsonToList(String json, Class<?> collectionClass, Class<?>... elementClasses) {
		if (json == null)
			return null;
		JavaType javaType = getCollectionType(collectionClass, elementClasses);
		List<T> list = null;
		try {
			list = objectMapper.readValue(json, javaType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) throws Exception {
		System.out.println(JSONUtil.objToString(new ClassSignUser()));
	}
}
