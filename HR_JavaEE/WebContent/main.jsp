<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	#main{
		margin:0 auto;
		width:1200px;
	}
	
	
	#content{
		margin:0 auto;
		width:800px;
	}
	
</style>
</head>
<body>
<div id="main">
	<jsp:include page="top.jsp">
		<jsp:param value="主界面" name="title"/>
	</jsp:include>

	<c:if test="${empty sessionScope.username }">
		<c:set var="msg" value="该资源必须登录后访问" scope="request"></c:set>
		<jsp:forward page="login.jsp"></jsp:forward>
	</c:if>
	<div id="content">
		<a href="DeptListServlet">查看所有部门</a>
	</div>
</div>
</body>
</html>