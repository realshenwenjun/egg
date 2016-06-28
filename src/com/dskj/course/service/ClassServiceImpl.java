package com.dskj.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.base.Base;
import com.dskj.course.entity.Clazz;
import com.dskj.course.entity.CourserClassTeacherList;
import com.dskj.course.entity.ManageCourseCount;
import com.dskj.course.entity.PassClass;
import com.dskj.course.entity.PlanByClass;
import com.dskj.course.exception.DeleteException;
import com.dskj.course.mapper.AdminCourseMapper;
import com.dskj.course.mapper.ClassMapper;
import com.dskj.course.mapper.ClassSignMapper;
import com.dskj.course.mapper.CourseMapper;
import com.dskj.course.mapper.GatherMapper;
import com.dskj.course.mapper.LackMapper;
import com.dskj.course.mapper.PlanMapper;
import com.dskj.course.mapper.PlanSignMapper;
import com.dskj.course.mapper.SuppleMapper;
import com.dskj.util.Page;

@Service
public class ClassServiceImpl extends Base implements ClassService {
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
	@Autowired
	private PlanService planService;
	
	public void addClass(Clazz clazz) throws Exception {
		classMapper.addClass(clazz);
		clearCache();
	}

	public void updateClass(Clazz clazz) throws Exception {
		classMapper.updateClass(clazz);
		clearCache();
	}

	public int deleteClass(int id) throws Exception {
		List<PlanByClass> planByClasses = planMapper.getPlanByClass(id);
		for (PlanByClass planByClass : planByClasses) {
			int i = planService.deleteById(planByClass.getId());
			if (i != 0) {
				DeleteException e = new DeleteException();
				e.setI(i);
				throw e;
			}
		}
		{
			classSignMapper.deleteClassSignByClass(id);// 删除班级的学生
		}
		classMapper.deleteClass(id);
		clearCache();
		return 0;
	}

	public List<ManageCourseCount> getManageCourseCount(int courseTypeId,
			String institutionId) throws Exception {
		return classMapper.getManageCourseCount(courseTypeId, institutionId);
	}

	public List<Clazz> getClassByCourse(int courseId) throws Exception {
		return classMapper.getClassByCourse(courseId);
	}

	public List<Clazz> getByName(String name, int courseId, String institutionId)
			throws Exception {
		return classMapper.getByName(name, courseId, institutionId);
	}

	public List<CourserClassTeacherList> getClassByCourseId(int courseId) throws Exception {
		return classMapper.getClassByCourseId(courseId);
	}

	public List<PassClass> getPassClass(int courseId, Page page)
			throws Exception {
		return classMapper.getPassClass(courseId, page);
	}
	public void clearCache() throws Exception {
		adminCourseMapper.clear();
		courseMapper.clear();
		classSignMapper.clear();
		gatherMapper.clear();
		lackMapper.clear();
		planMapper.clear();
		planSignMapper.clear();
		suppleMapper.clear();
	}
}
