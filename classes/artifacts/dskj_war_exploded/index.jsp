<%@page import="com.dskj.system.support.MyDispatcherServlet"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<br />
<%
	long max = Runtime.getRuntime().maxMemory()/1024/1024;
	long total = Runtime.getRuntime().totalMemory()/1024/1024;
	long used = total - Runtime.getRuntime().freeMemory()/1024/1024;
	out.print("【内存监控】");
	out.print("<br/>最大可用内存" + max + "M");
	out.print("<br/>内存总量" + total + "M");
	out.print("<br/>已使用内存" + used + "M");
	out.print("<br/>【PV】" + MyDispatcherServlet.pv + "<br/>");
%>
<p>【cache】</p><a href="<%=request.getContextPath()%>/sys/cache/clear?cache=all">clear all</a><br/>
<l>
AnnouncementMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.announcement.mapper.AnnouncementMapper">clear</a><br/>
AnnouncementReadMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.announcement.mapper.AnnouncementReadMapper">clear</a><br/>
AnnouncementTypeMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.announcement.mapper.AnnouncementTypeMapper">clear</a><br/>
</l>
<l>
DailyLiveCensusMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.census.mapper.DailyLiveCensusMapper">clear</a><br/>
ScatterCensusMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.census.mapper.ScatterCensusMapper">clear</a><br/>
SignCensusMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.census.mapper.SignCensusMapper">clear</a><br/>
TimingCensusMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.census.mapper.TimingCensusMapper">clear</a><br/>
UserCensusMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.census.mapper.UserCensusMapper">clear</a><br/>
</l>
<l>
AdminCourseMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.course.mapper.AdminCourseMapper">clear</a><br/>
ClassMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.course.mapper.ClassMapper">clear</a><br/>
ClassSignMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.course.mapper.ClassSignMapper">clear</a><br/>
CourseMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.course.mapper.CourseMapper">clear</a><br/>
GatherMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.course.mapper.GatherMapper">clear</a><br/>
LackMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.course.mapper.LackMapper">clear</a><br/>
PlanMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.course.mapper.PlanMapper">clear</a><br/>
PlanSignMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.course.mapper.PlanSignMapper">clear</a><br/>
SuppleMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.course.mapper.SuppleMapper">clear</a><br/>
WorkTimeMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.course.mapper.WorkTimeMapper">clear</a><br/>
</l>
<l>
PropaMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.spread.mapper.PropaMapper">clear</a><br/>
</l>
<l>
InstitutionMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.user.mapper.InstitutionMapper">clear</a><br/>
UserLoginLogMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.user.mapper.UserLoginLogMapper">clear</a><br/>
UserMapper                                    <a href="<%=request.getContextPath()%>/sys/cache/clear?cache=com.dskj.user.mapper.UserMapper">clear</a><br/>
</l><br/>
<form action="<%=request.getContextPath()%>/file/xml/upload" method="post" enctype="multipart/form-data">
xml <input type="file" name="file"/>
<input type="submit" value="上传"/>
</form>
<form action="<%=request.getContextPath()%>/file/apk/upload" method="post" enctype="multipart/form-data">
apk <input type="file"/>
<input type="submit" value="上传"/>
</form>