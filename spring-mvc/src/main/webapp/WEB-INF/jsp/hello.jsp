<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/hello.css" type="text/css"/>
</head>
<body>
	<!-- 引用变量 --> 
	This is my JSP page.${username} ${id} ${a.username}
	
	<!-- GET方法 -->
	<form:form method="get" modelAttribute="user">
	   	id:<form:input path="id"/><form:errors path="id"/><br/>
	   	name:<form:input path="name"/><form:errors path="name"/><br/>
	   	<input type="submit" value="GET提交"/>
	</form:form>
	
	<!-- POST方法  -->
	<form:form method="post" modelAttribute="user">
	   	id:<form:input path="id"/><form:errors path="id"/><br/>
	   	name:<form:input path="name"/><form:errors path="name"/><br/>
	   	<input type="submit" value="POST提交"/>
	</form:form>
	
	<!-- 页面跳转  -->
	<form:form method="post" modelAttribute="user" enctype="multipart/form-data">
	   	id:<form:input path="id"/><form:errors path="id"/><br/>
	   	name:<form:input path="name"/><form:errors path="name"/><br/>
	   	Attachs:<input type="file" name="attachs"/><br/>
	   	<input type="file" name="attachs"/><br/>
	   	<input type="submit" value="跳转提交"/>
	</form:form>
</body>
</html> 