<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.hr.pojo.*"%>
<%@ page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>"> <!--作用是当前页面的连接的前缀都是basePath  -->
<style type="text/css">
table.hovertable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}

table.hovertable th {
	background-color: #c3dde0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}

table.hovertable td {
	background-color: #d4e3e5;
	border-width: 1px;
	padding: 1px;
	border-style: solid;
	border-color: #a9c6c9;
	text-align: center;
}

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
	<jsp:include page="../top.jsp">
		<jsp:param value="部门一览" name="title"/>
	</jsp:include>
	
	<div id="content">
			<a href="dept/deptInsert.jsp">插入</a>
			<hr>
			<table class="hovertable" width="100%">
				<tr>
					<td>部门编号</td>
					<td>部门名称</td>
					<td>部门地址</td>
					<td>操作1</td>
					<td>操作2</td>
				</tr>
				<c:forEach items="${requestScope.pagination.list }" var="dept">
					<tr>
						<td>${dept.deptId }</td>
						<td>${dept.deptName }</td>
						<td>${dept.deptLoc }</td>
						<td><a href="ToDeptUpdateServlet?deptId=${dept.deptId }">更新</a></td>
						<td><a href="">删除</a></td>
					</tr>
				</c:forEach>
				<tr>
		            <td colspan="5" align="right">
		            <c:if test="${pagination.pageNo > 1 }">
		            	<a href="DeptListServlet?pageNo=1">首页</a>
		            	<a href="DeptListServlet?pageNo=${pagination.pageNo-1} ">上一页</a>
		            </c:if>
		            <c:if test="${pagination.pageNo < pagination.totalPage }">
		            	<a href="DeptListServlet?pageNo=${pagination.pageNo+1}">下一页</a>
			            <a href="DeptListServlet?pageNo=${pagination.totalPage}">末页</a>
		            </c:if>
		            
				</tr>
			</table>
		</div>
	</div>
</body>
</html>