<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>2.0接口文档</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table border="1">
    	<tr>
    		<td style="background-color: gray;">接口名称</td><td style="color:red;">登录</td><td></td><td></td>
    	</tr>
    	<tr>
    		<td style="background-color: gray;">接口说明</td><td>用户登录。密码采用MD5加密</td><td></td><td></td>
    	</tr>
    	<tr>
    		<td style="background-color: gray;">接口地址</td><td>/user/login</td><td></td><td></td>
    	</tr>
    	<tr style="background-color: gray;">
    		<td>参数名称</td><td>参数类型</td><td>输入/输出</td><td>说明</td>
    	</tr>
    	<tr>
    		<td>user</td><td>String</td><td>输入</td><td>user={"phone":"18600084079","password":"123456"}</td>
    	</tr>
    	<tr>
    		<td>返回值</td><td>String</td><td>输出</td><td>说明</td>
    	</tr>
    	<tr>
    		<td>接口描述</td><td><l style="color:blue;">正常返回：</l>
								{"success":true,"code":0,"message":"登录成功","result":
								{"id":"KtOOCUHz","levelId":2,"type":0,"name":"骞冲彴","phone":"000",
								"password":"c6f057b86584942e415435ffb1fa93d4","photo":null,"qqOpenId":null,
								"sinaOpenId":null,"weixinOpenId":null,"address":null,"sex":null,"birthday":null,
								"regionId":null,"loginDayCount":45,"createTime":1454521372000,"realName":null,
								"interest":null,"shortIntroduction":null}}
								<l style="color:blue;">异常返回：</l>
								{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : null}
								</td><td></td><td></td>
    	</tr>
    </table>
    <br/>
    <br/>
    
  </body>
</html>
