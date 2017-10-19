[toc]
# 一、LearnServlet
## 人事管理系统（HR_JavaEE）

   *该案例主要是运用 javaEE基础知识进行开发，目的是让读者了解javaEE知识点如何在项目中应用。*
	
### 主要功能
 
 - 登录、注销
 - 部门管理的增删改查；
 - 通过cookie完成n天内免登录；
 - 过滤器
       （对/dept/路径拦截，未登录自动跳转到登录界面)；
	   （防止中文乱码）
 - 监听器（对服务器启动&停止监听，实现网站访问次数功能）；
 - 分页（部门一览模块）
 - web.xml中通过error-page，实现网站出错后跳转到指定页面；
 
 ### 部分界面
![登录][1] 


----------


![部门一览][2]


----------


![添加部门][3]
  
###   其他

 - 数据库是Oracle，工程导出sql在webcontent目录中。

# 二、JavaTimeStampTest
 刚入门的新人初次接触到java.sql.Timestamp数据类型时，往往会遇到各种错误（类型转换失败、数据格式化失败），本篇博客主要通过一个对学生表的插入和查询案例介绍Timestamp类型。


  [1]: https://github.com/psp0001060/LearnServlet/blob/master/HR_JavaEE/readme/2017-10-16_141649.png
  [2]: https://github.com/psp0001060/LearnServlet/blob/master/HR_JavaEE/readme/2017-10-16_142726.png
  [3]: https://github.com/psp0001060/LearnServlet/blob/master/HR_JavaEE/readme/2017-10-16_141723.png