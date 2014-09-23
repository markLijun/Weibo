<%@ page 
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Let's Register</title>
<style type = "text/css">
<!--
.style1{color:black;font-size:25px;font-family:楷体}
style2{color:black;font-size:15px;font-family:楷体}
.style3{margin:0 auto;width:500px}
body{ text-align:center} 
.div{ margin:0 auto; width:500px; height:200px;top:500px} 
-->
</style>
</head>
<body background='images/backgrou.jpg'>
<div class=div>
<form action='register.do' method='post'>
<table bgcolor='#ccccc'>
<tr><td><style2>Let's Register!</style2></td></tr>
<tr>
<td class=style1>用户名:</td>
<td><input type="text" name="name" value = '${param.name }'></td>
<td><c:if test="${requestScope.nameWrong != null }"><style2>对不起，用户名已经存在</c:if></td>
</tr>
<tr>
<td class=style1>密码:</td>
<td><input type="password" name="password" value='${param.password}'></td>
<td><c:if test="${requestScope.passwordWrong != null }"><style2>${requestScope.passwordWrong}</c:if></td>
</tr>

<tr>
<td class=style1>确认密码:</td>
<td><input type="password" name="cpassword" value='${param.cpassword}'></td>
<td><c:if test="${requestScope.cWrong != null }"><style2>两次输入的密码不一致</c:if></td>
</tr>

<tr>
<td class=style1>电子邮箱:</td>
<td><input type="text" name="email" value = '${param.email }'></td>
<td><c:if test = "${requestScope.emailWrong != null }">
<style2>${requestScope.emailWrong}</c:if></td>
</tr>
<tr>
<td><a href="index.jsp">我要登陆</a></td>
<td><input type="submit" name="submit" value="注册"></td>
</tr>
</table>
</form></div>


</body>
</html>