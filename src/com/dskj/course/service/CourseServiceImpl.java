package com.dskj.course.service;

import com.dskj.base.Base;
import com.dskj.comment.entity.Comment;
import com.dskj.comment.mapper.CommentMapper;
import com.dskj.course.entity.*;
import com.dskj.course.entity2_0.*;
import com.dskj.course.mapper.*;
import com.dskj.user.mapper.CollectMapper;
import com.dskj.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseServiceImpl extends Base implements CourseService {
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
    private CollectMapper collectMapper;
    @Autowired
    private ClassCommentMapper classCommentMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ClassLoveMapper classLoveMapper;
    @Autowired
    private ClassFansMapper classFansMapper;

    public void addCourse(Course course) throws Exception {
        courseMapper.addCourse(course);
        clearCache();
    }

    public List<Course> getByName(String name, String institutionId)
            throws Exception {
        return courseMapper.getByName(name, institutionId);
    }

    public List<CourseVO> getCourseListByTypeOf(String institutionId, int id,
                                                Page page) throws Exception {
        return courseMapper.getCourseListByTypeOf(
                "".equals(institutionId) ? null : institutionId, id, page);
    }

    public void updateCourse(Course course) throws Exception {
        courseMapper.updateCourse(course);
        clearCache();
    }

    public Course getCourse(int id) throws Exception {
        return courseMapper.getCourse(id);
    }

    public void deleteCourse(int id) throws Exception {
        courseMapper.deleteCourse(id);
        clearCache();
    }

    public List<CourseVO> getCourseListByType(String institutionId, int type,
                                              Page page) throws Exception {
        return courseMapper.getCourseListByType(institutionId, type, page);
    }

    public List<CourseVO> getCourseListByInstitution(String insId, Page page)
            throws Exception {
        return courseMapper.getCourseListByInstitution(insId, page);
    }

    public List<Clazz> getClassByCourse(int courseId) throws Exception {
        return classMapper.getClassByCourse(courseId);
    }

    public List<CourseVO> getCourseVOByName(String name) throws Exception {
        return courseMapper.getCourseVOByName(name);
    }

    public void clearCache() throws Exception {
        adminCourseMapper.clear();
        classMapper.clear();
        classSignMapper.clear();
        gatherMapper.clear();
        lackMapper.clear();
        planMapper.clear();
        planSignMapper.clear();
        suppleMapper.clear();
    }

    public void addCourseClass2_0(CourseClass courseClass, List<String> imgUrls)
            throws Exception {
        classMapper.addCourseClass2_0(courseClass);
        List<CourseClassImg> imgs = new ArrayList<CourseClassImg>();
        for (String url : imgUrls) {
            CourseClassImg courseClassImg = new CourseClassImg();
            courseClassImg.setClassId(courseClass.getId());
            courseClassImg.setCreateTime(new Date());
            courseClassImg.setUrl(url);
            imgs.add(courseClassImg);
        }
        if (imgs.size() != 0)
            classMapper.addCourseClassImg2_0(imgs);
    }

    public CourseClassDetail getCourseClassDetail2_0(int classId)
            throws Exception {
        return classMapper.getCourseClassDetail2_0(classId);
    }

    public void updateCourseClass2_0(CourseClass courseClass,
                                     List<String> imgUrls) throws Exception {
//		classMapper.deleteCourseClass2_0(courseClass.getId());
//		classMapper.deleteCourseClassImg2_0(courseClass.getId());
//		this.addCourseClass2_0(courseClass, imgUrls);
        //删除图片
        classMapper.deleteCourseClassImg2_0(courseClass.getId());
        //修改课程
        classMapper.updateCourseClass2_0(courseClass);
        //保存图片
        List<CourseClassImg> imgs = new ArrayList<CourseClassImg>();
        for (String url : imgUrls) {
            CourseClassImg courseClassImg = new CourseClassImg();
            courseClassImg.setClassId(courseClass.getId());
            courseClassImg.setCreateTime(new Date());
            courseClassImg.setUrl(url);
            imgs.add(courseClassImg);
        }
        if (imgs.size() != 0)
            classMapper.addCourseClassImg2_0(imgs);
    }

    public void deleteCourseClass2_0(int classId) throws Exception {
        classMapper.deleteCourseClass2_0(classId);
        classMapper.deleteCourseClassImg2_0(classId);
    }

    public List<CourseClassList> getCourseClassList2_0(String institutionId,
                                                       Date date, Page page) throws Exception {
        return classMapper.getCourseClassList2_0(institutionId, date, page);
    }

    public List<CourseClassList> getCourseClassTeacherList2_0(String userId,
                                                              Page page) throws Exception {
        return classMapper.getCourseClassTeacherList2_0(userId, page);
    }

    public List<CourseClassList> getCourseClassStudentList2_0(String userId,
                                                              Page page) throws Exception {
        List<Integer> classIds = classSignMapper.getStudentClass(userId, page);
        if (classIds == null || classIds.size() == 0)
            return new ArrayList<CourseClassList>();
        return classMapper.getCourseClassStudentList2_0(classIds);
    }

    public CourseClassInfo getCourseClassInfo(int classId, String userId)
            throws Exception {
        CourseClassInfo classInfo = classMapper.getCourseClassInfo(classId);
        classInfo.setSignCount(classSignMapper.getClassStudentCount(classId));
        classInfo.setCollectId(collectMapper.getClassCollectId(classId, userId));
        classInfo.setCommentCount(classCommentMapper.getCommentCount(classId));
        classInfo.setLoveCount(classLoveMapper.getClassLoveCount(classId));
        classInfo.setLoveId(classLoveMapper.getLoveId(classId, userId));
        classInfo.setFansId(classFansMapper.getFansId(classId, userId));
        return classInfo;
    }

    public void addClassComment(int classId, String userId, String context)
            throws Exception {
        Comment comment = new Comment();
        comment.setContext(context);
        comment.setCreateTime(new Date());
        comment.setIsOriginal(false);
        comment.setUserId(userId);
        commentMapper.add(comment);
        ClassComment classComment = new ClassComment();
        classComment.setClassId(classId);
        classComment.setCommentId(comment.getId());
        classComment.setCreateTime(new Date());
        classCommentMapper.add(classComment);
    }

    public void deleteClassComment(int classId, int commentId) throws Exception {
        commentMapper.delete(commentId);
        classCommentMapper.delete(classId, commentId);
    }

    public Object getCourseClassCommentList(int classId, String userId,
                                            Page page) throws Exception {
        List<Integer> commentIds = classCommentMapper.getCommentIds(classId,
                page);
        if (commentIds != null && commentIds.size() != 0) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("list", commentIds);
            map.put("userId", userId);
            Object o = commentMapper.getCommentsByIds(map);
            return o;
        }
        return null;
    }

    public void addClassLove(ClassLove classLove) throws Exception {
        classLoveMapper.add(classLove);
    }

    public void deleteClassLove(int loveId) throws Exception {
        classLoveMapper.delete(loveId);
    }

    public void addClassFans(ClassFans classFans) throws Exception {
        classFansMapper.add(classFans);
    }

    public void deleteClassFans(int fansId) throws Exception {
        classFansMapper.delete(fansId);
    }

    public void addCourseClassSign2_0(CourseClassSign courseClassSign)
            throws Exception {
        int classSignOrderCount = classSignMapper.getClassSignOrderByUserIdAndClassId(courseClassSign.getUserId(), courseClassSign.getClassId());
        if (classSignOrderCount != 0)
            throw new RuntimeException("不允许重复报名");
        classSignMapper.addClassSign2_0(courseClassSign);
    }

    public List<CourseClassTypeOf> getCourseClassType() throws Exception {
        return adminCourseMapper.getCourseClassType();
    }

    public List<CourseClassList> getCourseClassListByType2_0(Integer regionId, int courseId,
                                                             Page page) throws Exception {
        if (regionId == null)
            regionId = 0;
        return classMapper.getCourseClassListByType2_0(regionId, courseId, page);
    }

    public CourseClassType getCourseTypeSearch2_0(String key) throws Exception {
        return adminCourseMapper.getCourseTypeSearch2_0(key);
    }

    @Override
    public Object getCourseClassSignList2_0(String userId, Date date) throws Exception {
        return classSignMapper.getStudentClassSign(userId, date);
    }

    @Override
    public void addCourseClassPlanSign2_0(PlanSign planSign) throws Exception {
        PlanSign sign = planSignMapper.getByUserIdAndClassIdAndDate(planSign.getUserId(), planSign.getClassId(), new Date());
        if (sign == null) {
            planSign.setUserId(planSign.getUserId());
            planSign.setClassId(planSign.getClassId());
            planSign.setAddress(planSign.getAddress());
            planSign.setCreateTime(new Date());
            planSignMapper.addPlanSign(planSign);
        }
    }

    public Object getCourseClassManageList2_0(String userId, Date date)
            throws Exception {
        return classMapper.getCourseClassManageList2_0(userId, date);
    }

    public Object getCourseClassManageStudentList2_0(Integer classId)
            throws Exception {
        return classSignMapper.getCourseClassManageStudentList2_0(classId);
    }

    public Object getCourseClassManageStudentSearch2_0(Integer classId,
                                                       String key) throws Exception {
        if ("".equals(key))
            key = null;
        return classSignMapper.getCourseClassManageStudentSearch2_0(classId, key);
    }

    public Object getCourseClassManageNotStudentSearch2_0(Integer classId, String key, Page page) throws Exception {
        if ("".equals(key))
            key = null;
        return classSignMapper.getCourseClassManageNotStudentSearch2_0(classId, key, page);
    }

    public void addCourseClassManageStudent(Integer classId, List<String> userId)
            throws Exception {
        List<ClassSign> classSigns = new ArrayList<ClassSign>();
        if (userId != null && userId.size() != 0) {
            for (String id : userId) {
                ClassSign classSign = new ClassSign();
                classSign.setClassId(classId);
                classSign.setCreateTime(new Date());
                classSign.setUserId(id);
                classSigns.add(classSign);
            }
            classSignMapper.addClassSign(classSigns);
        }

    }

    public void deleteCourseClassManageStudent(Integer classId,
                                               List<String> userId) throws Exception {
        if (userId != null && userId.size() != 0) {
            for (String id : userId) {
                classSignMapper.deleteClassSign(id, classId);
            }
        }
    }

    public Object getCourseClassTeacherPlanList2_0(String userId, Date date) throws Exception {
        return classMapper.getCourseClassTeacherPlanList2_0(userId, date);
    }

    public Object getCourseTeacherStudentList2_0(String userId, String key)
            throws Exception {
        if ("".equals(key))
            key = null;
        return classSignMapper.getCourseTeacherStudentList2_0(userId, key);
    }

    public Object getCourseClassSignInfo2_0(String userId, Date date)
            throws Exception {
        return planSignMapper.getCourseClassSignInfo2_0(userId, date);
    }

    public Object getCourseClassStudentSignList2_0(Integer classId, Date date)
            throws Exception {
        return planSignMapper.getCourseClassStudentSignList2_0(classId, date);
    }

    public Object getCourseClassStudentUnSignList2_0(Integer classId, Date date)
            throws Exception {
        return planSignMapper.getCourseClassStudentUnSignList2_0(classId, date);
    }

    public Object getCourseClassOrderManageList2_0(String institutionId, Date date)
            throws Exception {
        return classSignMapper.getCourseClassOrderManageList2_0(institutionId, date);
    }
}
