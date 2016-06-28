package com.dskj.course.controll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dskj.base.Base;
import com.dskj.course.entity.Clazz;
import com.dskj.course.entity.Course;
import com.dskj.course.entity.CourseVO;
import com.dskj.course.entity.PlanSign;
import com.dskj.course.entity2_0.ClassFans;
import com.dskj.course.entity2_0.ClassLove;
import com.dskj.course.entity2_0.CourseClass;
import com.dskj.course.entity2_0.CourseClassDetail;
import com.dskj.course.entity2_0.CourseClassInfo;
import com.dskj.course.entity2_0.CourseClassList;
import com.dskj.course.entity2_0.CourseClassSign;
import com.dskj.course.exception.DeleteException;
import com.dskj.course.service.ClassService;
import com.dskj.course.service.CourseService;
import com.dskj.fileutil.service.FileUpload;
import com.dskj.util.Page;

@Controller
public class CourseControll extends Base {
	@Autowired
	private CourseService courseService;
	@Autowired
	private ClassService classService;
	@Autowired
	private FileUpload fileUpload;

	/*
	 * 8 增加课程-附带图片
	 * course={"courseTypeId":"","institutionId":"","name":"","describition"
	 * :"","cover":""}
	 */
	@RequestMapping("/course/add")
	public void addCourse(HttpServletRequest request,
			HttpServletResponse response) {
		Course course = null;
		String tempFile = null;
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			course = stringToObj(jsonString, Course.class);
			List<Course> courses = courseService.getByName(course.getName(),
					course.getInstitutionId());
			if (courses != null && courses.size() != 0) {
				write(response, false, 900, "该名称已被使用", null);
				return;
			}
			course.setCreateTime(new Date());
			courseService.addCourse(course);
			write(response, null, null, null, course);
		} catch (Exception e) {
			e.printStackTrace();
			fileUpload.dropTempImg(tempFile);
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 9 修改课程-附带图片
	 * course={"id":1,"courseTypeId":"","name":"","describition":"","cover":""}
	 */
	@RequestMapping("/course/update")
	public void updateCourse(HttpServletRequest request,
			HttpServletResponse response) {
		Course course = null;
		String tempFile = null;
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			course = stringToObj(jsonString, Course.class);
			Course oldCourse = courseService.getCourse(course.getId());
			List<Course> courses = courseService.getByName(course.getName(),
					course.getInstitutionId());
			if (course.getName() != null
					&& !course.getName().equals(oldCourse.getName())
					&& courses != null && courses.size() != 0) {
				write(response, false, 900, "该名称已被使用", null);
				return;
			}
			courseService.updateCourse(course);
			course = course.convert(oldCourse);
			write(response, null, null, null, course);
		} catch (Exception e) {
			e.printStackTrace();
			fileUpload.dropTempImg(tempFile);
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 获取单个课程 course={"id":1}
	 */
	@RequestMapping("/course/get")
	public void getCourse(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Course course = courseService.getCourse(readTreeAsInt(jsonString,
					"id"));
			write(response, null, null, null, course);
		} catch (Exception e) {
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 删除单个课程 course={"id":1}
	 */
	@RequestMapping("/course/delete")
	public void delCourse(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Course course = courseService.getCourse(readTreeAsInt(jsonString,
					"id"));
			// 获取课程下面的班级
			List<Clazz> clazzs = courseService.getClassByCourse(course.getId());
			int i = 0;
			for (Clazz z : clazzs) {
				// classService.deleteClass(z.getId());// 逐个删除下面的班级
				try {
					i = classService.deleteClass(z.getId());
				} catch (Exception e) {
					if (e instanceof DeleteException) {
						i = ((DeleteException) e).getI();
						switch (i) {
						case 1:
							write(response, false, 801, "本次课已上，不能删除！", null);
							break;
						case 2:
							write(response, false, 802, "本次课已有人请假，不能删除！", null);
							break;
						case 3:
							write(response, false, 803, "本次课已有人补课，不能删除！", null);
							break;
						default:
							break;
						}
					}
				}
				if (i != 0)
					break;
			}
			if (i != 0)
				return;
			courseService.deleteCourse(readTreeAsInt(jsonString, "id"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 根据总课程分类获取课程列表 -匿名浏览 course={"ofId":1,"pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/course/list/by/of")
	public void getCourseListByTypeOf(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			List<CourseVO> courses = courseService.getCourseListByTypeOf(
					readTree(jsonString, "institutionId"),
					readTreeAsInt(jsonString, "ofId"), page);
			write(response, null, null, null, courses);
		} catch (Exception e) {
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 7 (匿名浏览也会用到) 根据第二级课程分类获取课程列表
	 * course={"institutionId":"6Fk31iKT","typeId":1,"pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/course/list/by/type")
	public void getCourseListByType(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			List<CourseVO> courses = courseService.getCourseListByType(null,
					readTreeAsInt(jsonString, "typeId"), page);
			write(response, null, null, null, courses);
		} catch (Exception e) {
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 根据机构获取课程列表 -匿名浏览 course={"institutionId":"","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/course/list/by/institution")
	public void getCourseListByIns(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			List<CourseVO> courses = courseService.getCourseListByInstitution(
					readTree(jsonString, "institutionId"), page);
			write(response, null, null, null, courses);
		} catch (Exception e) {
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 根据课程名称搜索课程 - 匿名浏览 course={"name":""}
	 */
	@RequestMapping("/course/get/by/name")
	public void getCourseByName(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			List<CourseVO> course = courseService.getCourseVOByName(readTree(
					jsonString, "name"));
			if (course == null || course.size() == 0)
				write(response, false, 870, "没有结果", null);
			else
				write(response, null, null, null, course);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0 增加一个课程
	 * course={"cover":"","institutionId":"","courseTypeId":1,"courseId"
	 * :1,"userId" :"","name"
	 * :"","summary":"","price":50.00,"startDate":11322420000,"endDate"
	 * :12322323000
	 * ,"startTime":"09:00:00","endTime":"12:00:00","address":"","studentCount"
	 * :9,"imgUrls":["",""]}
	 */
	@RequestMapping("/course/class/add/2_0")
	public void addCourseClass2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			CourseClass courseClass = stringToObj(jsonString, CourseClass.class);
			courseClass.setCreateTime(new Date());
			List<String> imgUrls = jsonToList(readTree(jsonString, "imgUrls"),
					ArrayList.class, String.class);
			courseService.addCourseClass2_0(courseClass, imgUrls);
			write(response, null, null, null, courseClass);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0 获取一个课程 course={"classId":1}
	 */
	@RequestMapping("/course/class/get/2_0")
	public void getCourseClass2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			CourseClassDetail classDetail = courseService
					.getCourseClassDetail2_0(readTreeAsInt(jsonString,
							"classId"));
			write(response, null, null, null, classDetail);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0 更新一个课程
	 * course={"id":1,"cover":"","institutionId":"","courseTypeId":1,"courseId"
	 * :1,"userId" :"","name"
	 * :"","summary":"","price":50.00,"startDate":11322420000,"endDate"
	 * :12322323000
	 * ,"startTime":"09:00:00","endTime":"12:00:00","address":"","studentCount"
	 * :9,"imgUrls":["",""]}
	 */
	@RequestMapping("/course/class/update/2_0")
	public void updateCourseClass2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			CourseClass courseClass = stringToObj(jsonString, CourseClass.class);
			courseClass.setCreateTime(new Date());
			List<String> imgUrls = jsonToList(readTree(jsonString, "imgUrls"),
					ArrayList.class, String.class);
			courseService.updateCourseClass2_0(courseClass, imgUrls);
			write(response, null, null, null, courseClass);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0 删除一个课程 course={"classId":1}
	 */
	@RequestMapping("/course/class/delete/2_0")
	public void deleteCourseClass2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			courseService.deleteCourseClass2_0(readTreeAsInt(jsonString,
					"classId"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0 获取机构课程列表
	 * course={"institutionId":"","date":1232310000,"pageNo":0,"pageSize":10}
	 * date可以不传
	 */
	@RequestMapping("/course/class/list/2_0")
	public void getCourseClassList2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Long dateTime = readTreeAsLong(jsonString, "date");
			if (dateTime == null || dateTime == 0) {
				dateTime = null;
			}
			Date date = null;
			if (dateTime != null)
				date = new Date(dateTime);
			List<CourseClassList> classLists = courseService
					.getCourseClassList2_0(
							readTree(jsonString, "institutionId"), date, page);
			write(response, null, null, null, classLists);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0 获取教师主页课程列表 course={"userId":"","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/course/class/teacher/list/2_0")
	public void getCourseClassTeacherList2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			List<CourseClassList> classLists = courseService
					.getCourseClassTeacherList2_0(
							readTree(jsonString, "userId"), page);
			write(response, null, null, null, classLists);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0 获取学生主页课程列表 course={"userId":"","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/course/class/student/list/2_0")
	public void getCourseClassStudentList2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			List<CourseClassList> classLists = courseService
					.getCourseClassStudentList2_0(
							readTree(jsonString, "userId"), page);
			write(response, null, null, null, classLists);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0 获取课程详情 course={"classId":1,"userId":""}
	 */
	@RequestMapping("/course/class/info/get/2_0")
	public void getCourseClassInfo2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			CourseClassInfo classInfo = courseService.getCourseClassInfo(
					readTreeAsInt(jsonString, "classId"),
					readTree(jsonString, "userId"));
			write(response, null, null, null, classInfo);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0评论课程 course={"classId":1,"userId":"","context":""}
	 */
	@RequestMapping("/course/class/comment/add/2_0")
	public void addCourseClassComment2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			courseService.addClassComment(readTreeAsInt(jsonString, "classId"),
					readTree(jsonString, "userId"),
					readTree(jsonString, "context"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0删除课程评论 course={"classId":1,"commentId":1}
	 */
	@RequestMapping("/course/class/comment/delete/2_0")
	public void deleteCourseClassComment2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			courseService.deleteClassComment(
					readTreeAsInt(jsonString, "classId"),
					readTreeAsInt(jsonString, "commentId"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0课程评论列表 course={"classId":1,"userId":"","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/course/class/comment/list/2_0")
	public void getCourseClassCommentList2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Object o = courseService.getCourseClassCommentList(
					readTreeAsInt(jsonString, "classId"),
					readTree(jsonString, "userId"), page);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0点赞课程 course={"classId":1,"userId":""}
	 */
	@RequestMapping("/course/class/love/add/2_0")
	public void addCourseClassLove2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			ClassLove classLove = stringToObj(jsonString, ClassLove.class);
			classLove.setCreateTime(new Date());
			courseService.addClassLove(classLove);
			write(response, null, null, null, classLove);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0取消点赞课程 course={"loveId":1}
	 */
	@RequestMapping("/course/class/love/delete/2_0")
	public void deleteCourseClassLove2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			courseService.deleteClassLove(readTreeAsInt(jsonString, "loveId"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0关注课程 course={"classId":1,"userId":"}
	 */
	@RequestMapping("/course/class/fans/add/2_0")
	public void addCourseClassFans2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			ClassFans classFans = stringToObj(jsonString, ClassFans.class);
			classFans.setCreateTime(new Date());
			courseService.addClassFans(classFans);
			write(response, null, null, null, classFans);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0取消关注课程 course={"fansId":1}
	 */
	@RequestMapping("/course/class/fans/delete/2_0")
	public void deleteCourseClassFans2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			courseService.deleteClassFans(readTreeAsInt(jsonString, "fansId"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0课程报名
	 * course={"code":"","userId":"","userName":"","userPhone":"","institutionId"
	 * :
	 * "","institutionName":"","classId":1,"classNmae":"","price":20.00,"userCount"
	 * :1}
	 */
	@RequestMapping("/course/class/order/add/2_0")
	public void addCourseClassOrder2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			CourseClassSign classSign = stringToObj(jsonString,
					CourseClassSign.class);
			classSign.setCreateTime(new Date());
			courseService.addCourseClassSign2_0(classSign);
			write(response, null, null, null, classSign);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0课程类型列表 course={}
	 */
	@RequestMapping("/course/class/type/list/2_0")
	public void getCourseTypeList2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Object o = courseService.getCourseClassType();
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0搜索课程类型列表 course={"key":""}
	 */
	@RequestMapping("/course/class/type/search/2_0")
	public void getCourseTypeSearch2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			Object o = courseService.getCourseTypeSearch2_0(readTree(
					jsonString, "key"));
			logger.info(jsonString);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0根据类型查询课程列表 course={"regionId":2,"courseId":1,"pageNo":0,"pageSize":10}
	 * regionId传的是省份id也就是1级地址id,可以不传
	 */
	@RequestMapping("/course/class/list/by/type/2_0")
	public void getCourseClassListByType2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Object o = courseService.getCourseClassListByType2_0(readTreeAsInt(jsonString, "regionId"),
					readTreeAsInt(jsonString, "courseId"), page);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0 获取学生要签到的课程列表course={"userId":"","date":19922302002000}
	 */
	@RequestMapping("/course/class/sign/list/2_0")
	public void getCourseClassSignList2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Object o = courseService.getCourseClassSignList2_0(
					readTree(jsonString, "userId"),
					new Date(readTreeAsLong(jsonString, "date")));
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0 学生签到course={"userId":"","classId":1,"address":""}
	 */
	@RequestMapping("/course/class/sign/add/2_0")
	public void addCourseClassSign2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			PlanSign planSign = stringToObj(jsonString, PlanSign.class);
			courseService.addCourseClassPlanSign2_0(planSign);
			write(response, null, null, null, planSign);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0 获取教师要上课的课程列表course={"userId":"","date":19922302002000}
	 */
	@RequestMapping("/course/class/manage/list/2_0")
	public void getCourseClassManageList2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Object o = courseService.getCourseClassManageList2_0(
					readTree(jsonString, "userId"),
					new Date(readTreeAsLong(jsonString, "date")));
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0 教师获取一个班里学生列表course={"classId":1}
	 */
	@RequestMapping("/course/class/manage/student/list/2_0")
	public void getCourseClassManageStudentList2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Object o = courseService
					.getCourseClassManageStudentList2_0(readTreeAsInt(
							jsonString, "classId"));
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0 教师搜索一个班里学生列表course={"classId":1,"key":""}
	 */
	@RequestMapping("/course/class/manage/student/search/2_0")
	public void getCourseClassManageStudentSearch2_0(
			HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Object o = courseService.getCourseClassManageStudentSearch2_0(
					readTreeAsInt(jsonString, "classId"),
					readTree(jsonString, "key"));
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0 教师搜索非此班里学生列表course={"classId":1,"key":"","pageNo":0,"pageSize":20}
	 */
	@RequestMapping("/course/class/manage/not/student/search/2_0")
	public void getCourseClassManageNotStudentSearch2_0(
			HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Object o = courseService.getCourseClassManageNotStudentSearch2_0(
					readTreeAsInt(jsonString, "classId"),
					readTree(jsonString, "key"),page);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0 教师添加学生course={"classId":1,"userIds":["",""]}
	 */
	@RequestMapping("/course/class/manage/student/add/2_0")
	public void addCourseClassManageStudent2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			List<String> userIds = jsonToList(readTree(jsonString, "userIds"),
					ArrayList.class, String.class);
			courseService.addCourseClassManageStudent(
					readTreeAsInt(jsonString, "classId"), userIds);
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0 教师删除学生course={"classId":1,"userIds":["",""]}
	 */
	@RequestMapping("/course/class/manage/student/delete/2_0")
	public void deleteCourseClassManageStudent2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			List<String> userIds = jsonToList(readTree(jsonString, "userIds"),
					ArrayList.class, String.class);
			courseService.deleteCourseClassManageStudent(
					readTreeAsInt(jsonString, "classId"), userIds);
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 2.0 教师"我的课表"course={"userId":"","date":178966230000}
	 */
	@RequestMapping("/course/class/teacher/plan/list/2_0")
	public void getCourseClassTeacherPlanList2_0(
			HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Date date = null;
			Long dateTime = readTreeAsLong(jsonString,"date");
			if (dateTime == null || dateTime == 0)
				date = new Date();
			else
				date = new Date(dateTime);
			Object o = courseService.getCourseClassTeacherPlanList2_0(
					readTree(jsonString, "userId"),
					date);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 2.0 教师"我的学生"course={"userId":"","key":""}
	 */
	@RequestMapping("/course/teacher/student/list/2_0")
	public void getCourseTeacherStudentList2_0(
			HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Object o = courseService.getCourseTeacherStudentList2_0(readTree(jsonString, "userId"),readTree(jsonString, "key"));
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 2.0 教师"上课情况"course={"userId":"","date":178966230000}
	 */
	@RequestMapping("/course/class/sign/info/2_0")
	public void getCourseClassSignInfo2_0(
			HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Date date = null;
			Long dateTime = readTreeAsLong(jsonString,"date");
			if (dateTime == null || dateTime == 0)
				date = new Date();
			else
				date = new Date(dateTime);
			Object o = courseService.getCourseClassSignInfo2_0(
					readTree(jsonString, "userId"),
					date);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 2.0 教师"已签到"course={"classId":1,"date":178966230000}
	 */
	@RequestMapping("/course/class/student/sign/list/2_0")
	public void getCourseClassStudentSignList2_0(
			HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Date date = null;
			Long dateTime = readTreeAsLong(jsonString,"date");
			if (dateTime == null || dateTime == 0)
				date = new Date();
			else
				date = new Date(dateTime);
			Object o = courseService.getCourseClassStudentSignList2_0(
					readTreeAsInt(jsonString, "classId"),
					date);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 2.0 教师"未签到"course={"classId":1,"date":178966230000}
	 */
	@RequestMapping("/course/class/student/unsign/list/2_0")
	public void getCourseClassStudentUnSignList2_0(
			HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Date date = null;
			Long dateTime = readTreeAsLong(jsonString,"date");
			if (dateTime == null || dateTime == 0)
				date = new Date();
			else
				date = new Date(dateTime);
			Object o = courseService.getCourseClassStudentUnSignList2_0(
					readTreeAsInt(jsonString, "classId"),
					date);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 2.0报名管理
	 * course={"institutionId":"","date":12132444400}
	 */
	@RequestMapping("/course/class/order/manage/2_0")
	public void getCourseClassOrderManageList2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("course");
			logger.info(jsonString);
			Date date = null;
			Long dateTime = readTreeAsLong(jsonString,"date");
			if (dateTime == null || dateTime == 0)
				date = new Date();
			else
				date = new Date(dateTime);
			Object o = courseService.getCourseClassOrderManageList2_0(readTree(jsonString, "institutionId"),date);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
}
