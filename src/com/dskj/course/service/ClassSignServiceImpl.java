package com.dskj.course.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.base.Base;
import com.dskj.course.entity.ClassSign;
import com.dskj.course.entity.ClassSignUser;
import com.dskj.course.entity.CourseVO;
import com.dskj.course.mapper.AdminCourseMapper;
import com.dskj.course.mapper.ClassMapper;
import com.dskj.course.mapper.ClassSignMapper;
import com.dskj.course.mapper.CourseMapper;
import com.dskj.course.mapper.GatherMapper;
import com.dskj.course.mapper.LackMapper;
import com.dskj.course.mapper.PlanMapper;
import com.dskj.course.mapper.PlanSignMapper;
import com.dskj.course.mapper.SuppleMapper;

@Service
public class ClassSignServiceImpl extends Base implements ClassSignService {
	@Autowired
	private AdminCourseMapper adminCourseMapper;
	@Autowired
	private ClassMapper classMapper;
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private ClassSignMapper classSignMapper;
	@Autowired
	private GatherMapper gatherMapper;
	@Autowired
	private LackMapper lackMapper;
	@Autowired
	private PlanMapper planMapper;
	@Autowired
	private PlanSignMapper planSignMapper;
	@Autowired
	private SuppleMapper suppleMapper;

	public void addUserToClass(String json) throws Exception {
		int classId = readTreeAsInt(json, "classId");
		String institutionId = readTree(json, "institutionId");
		List<String> userIds = jsonToList(readTree(json, "users"),
				ArrayList.class, String.class);
		List<ClassSign> classSigns = new ArrayList<ClassSign>();
		for (String userId : userIds) {
			if (classSignMapper.getClassSignByUserIdAndClassId(userId, classId) == 0) {
				ClassSign classSign = new ClassSign();
				classSign.setClassId(classId);
				classSign.setCreateTime(new Date());
				classSign.setInstitutionId(institutionId);
				classSign.setUserId(userId);
				classSigns.add(classSign);
			}
		}
		if (classSigns.size() != 0)
			classSignMapper.addClassSign(classSigns);
		clearCache();
	}

	public void deleteClassSign(String userId, int classId) throws Exception {
		classSignMapper.deleteClassSign(userId, classId);
		clearCache();
	}

	public List<ClassSignUser> getUsersFromClass(int id) throws Exception {
		return classSignMapper.getUsersFromClass(id);
	}

	public List<CourseVO> getCourseListByUser(String userId) throws Exception {
		return classSignMapper.getCourseListByUser(userId);
	}

	public List<ClassSignUser> getUnSignUsersByName(String name, int classId)
			throws Exception {
		return classSignMapper.getUnSignUsersByName(name, classId);
	}

	public List<ClassSignUser> getMyUsersByName(String userName,
			String institutionId) throws Exception {
		return classSignMapper.getMyUsersByName(userName, institutionId);
	}
	public void clearCache() throws Exception {
		adminCourseMapper.clear();
		classMapper.clear();
		courseMapper.clear();
		gatherMapper.clear();
		lackMapper.clear();
		planMapper.clear();
		planSignMapper.clear();
		suppleMapper.clear();
	}
}
