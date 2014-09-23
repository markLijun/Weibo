<%@ page
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Let's Login</title>
</head>
<body background="images/backgrou.jpg">
<div>
<c:if test="${requestScope.error}!=null">
Wrong Name or Password</c:if></div>
<div style="top:500px;width:300px;margin:0 auto">
<form action='login.do' method='post'>
<table bgcolor='#ccccc'>
<tr>
	<td>登录吧！</td>
	</tr>
<tr>
<td>用户名:</td>
<td><input type='text' name='name' value='${param.name}'></td>
<tr>
<td>密码:</td>
<td><input type='password' name='password' value='${param.password }'>
</td>
<tr>
<td><input type='submit' name='submit' value='提交'></td>
<td><c:if test="${requestScope.nameError != null }">用户不存在！</c:if>
<c:if test="${requestScope.passwordError != null }">密码错误！</c:if></td>
</tr>
<tr>
<td>
<a href='Register.jsp'>
没有账号？注册
</a>
</td>
</tr>
</table>
</form>
</div>


</body>
</html>