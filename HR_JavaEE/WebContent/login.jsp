<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>"> <!--作用是当前页面的连接的前缀都是basePath  -->
	</head>
	<style type="text/css">
		#layer1{
			text-align: center;
			width: 600px; 
			height: 300px; 
			margin: 0 auto;
			padding-top: 50px;
		}
		
		#loginDiv{
			width:500px;
			margin-left:150px;
		}
		div:hover{
			color: red;
		}
	</style>
	
	<body>
		<c:if test="${not empty cookie.un and not empty cookie.pwd }">
			<jsp:forward page="LoginServlet?userName=${cookie.un.value }&pwd=${cookie.pwd.value }"></jsp:forward>
		</c:if>
		<div id="layer1"  >
				<font color="blue" size="5"><b><i>中软国际</i></b></font><br/><br/><br/>
			<div id="loginDiv">
				<table border="0" width="300px" bgcolor="yellowgreen" >
					<tr><td><font color="red">${requestScope.msg }</font></td></tr>
					<tr>
						<td >
							<form action="LoginServlet" method="post">
								用户名：<input type="text"  size="20" name="userName"/><br><br>
								密码	   &nbsp;&nbsp;&nbsp;：<input type="password" size="20" name="pwd"/><br/><br/>
								自动登录:<select name="timelength">
										<option value="0" select>每天都登录</option>
										<option value="10">10天登录</option>
										<option value="30">30天登录</option>
									</select>
								<br/><br/>
								<div style="margin-left: 2px;">
									<input type="submit" value="登录" />
								    <INPUT  TYPE="RESET" VALUE="重置" style="margin-left: 30px;" />
								</div> 							
							</form>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>