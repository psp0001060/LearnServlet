# LearnServlet
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
![enter description here][1] 

  
###   其他

 - 数据库是Oracle，工程导出sql在webcontent目录中。


  [1]: https://github.com/psp0001060/LearnServlet/blob/master/HR_JavaEE/readme/2017-10-16_141649.png