<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.hr.pojo.*"%>	
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>"> <!--作用是当前页面的连接的前缀都是basePath  -->
<style type="text/css">
	#main{
		margin:0 auto;
		width:1200px;
	}
	#header{
		height:30px;
		background-color: yellowgreen;
		text-align:center;
		margin-bottom:80px;
	}
	
	#content{
		margin:0 auto;
		width:800px;
		background-color: #d4e3e5;
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
	.itx{
		margin-left:100px;
		margin-top:20px;
	}
</style>
</head>
<body>
	<div id="main">
		<div id="header">
			<span id="projectName">修改部门</span>
			 <a id="logoff"	href="LogOffServlet">注销</a> 
				<span id="guestCount" >您是第<%=application.getAttribute("guestLoginCount") %>位访客</span>
		</div>
		<div id="content">
			<h4 style="margin-left:200px;">修改部门</h4>
			<form action="DeptUpdateServlet" method="post">
				<%String msg = (String)request.getAttribute("msg");
						if(null !=msg && !"".equals(msg)){
				%>
						<div class="itx"><font color="red"><%=msg %></font></div>
				<%}
				Dept dept = (Dept)request.getAttribute("dept");
				%>
				<div class="itx">部门编号：<input name="deptId" value="<%=dept.getDeptId()%>" readonly></div>
				<div class="itx">部门名称：<input name="deptName"  value="<%=dept.getDeptName()%>"></div>
				<div class="itx">部门地址：<input name="deptAddr"  value="<%=dept.getDeptLoc()%>"></div>
				<div class="itx">
					<input type="submit" value="提交">
					<input type="reset" value="重置">
				</div>
			</form>
		</div>
	</div>
</body>
</html>