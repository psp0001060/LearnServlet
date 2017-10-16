<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	#header{
		height:30px;
		background-color: yellowgreen;
		text-align:center;
		margin-bottom:80px;
	}

	#logoff{
		float:right;
		margin-right:50px;
		line-height:30px;
	}
	#projectName{
		font-size:20px;
		margin-left:50px;
	}
	#guestCount{
		margin-right:50px;
		float:right;
		line-height:30px;
	}
</style>
</head>
<body>
	<div id="header">
		<span id="projectName" >${param.title }</span>
		<a id="logoff" href="LogOffServlet">注销</a>
		<span id="guestCount" >您是第<%=application.getAttribute("guestLoginCount") %>位访客</span>
	</div>
</body>
</html>