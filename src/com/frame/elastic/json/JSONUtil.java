package com.frame.elastic.json;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

<<<<<<< HEAD
import com.dskj.census.entity.SearchResult;
import com.dskj.census.entity.TimingCensusUserSignList;
import com.dskj.census.entity.UserCensusByChildInstitution;
import com.dskj.census.entity.UserCensusByCourseType;
import com.dskj.community.entity.Information;
import com.dskj.community.entity.Post;
import com.dskj.community.entity.PostCollect;
import com.dskj.community.entity.PostDetails;
import com.dskj.community.entity.PostLove;

=======
import com.dskj.community.entity.Information;
import com.dskj.course.entity.ClassSignUser;
>>>>>>> 03b1d83889e641ee167a1e0a32ac19ee83b6207e
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.type.JavaType;

import com.dskj.activity.entity.CancelReason;
import com.dskj.activity.entity.ChildActivityAsk;
import com.dskj.activity.entity.ChildActivityCollect;
import com.dskj.activity.entity.ChildActivityLove;
import com.dskj.activity.entity.ChildActivityReservation;
import com.dskj.comment.entity.Comment;
import com.dskj.comment.entity.CommentChildVO;
import com.dskj.comment.entity.CommentLove;
import com.dskj.comment.entity.CommentVO;
<<<<<<< HEAD
import com.dskj.course.entity.PlanSign;
import com.dskj.course.entity2_0.ClassFans;
import com.dskj.course.entity2_0.ClassLove;
import com.dskj.course.entity2_0.ClassSignList;
import com.dskj.course.entity2_0.CourseClassInfo;
import com.dskj.course.entity2_0.CourseClassList;
import com.dskj.course.entity2_0.CourseClassSign;
import com.dskj.course.entity2_0.CourseClassType;
import com.dskj.course.entity2_0.CourseClassTypeOf;
import com.dskj.course.entity2_0.TeacherSign;
import com.dskj.user.entity.ChildInstitutionList;
import com.dskj.user.entity.Collect;
import com.dskj.user.entity.InstitutionWithPropa;
import com.dskj.user.entity.UserEntity;
import com.dskj.user.entity.UserFace;
import com.dskj.user.entity.UserFans;
import com.dskj.user.entity2_0.MyCollect;
import com.dskj.user.entity2_0.MyFans;
import com.dskj.user.entity2_0.UserAsk;
=======
>>>>>>> 03b1d83889e641ee167a1e0a32ac19ee83b6207e

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
<<<<<<< HEAD
		System.out.println(JSONUtil.objToString(new InstitutionWithPropa()));
=======
		System.out.println(JSONUtil.objToString(new ClassSignUser()));
>>>>>>> 03b1d83889e641ee167a1e0a32ac19ee83b6207e
	}
}
