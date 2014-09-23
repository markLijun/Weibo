<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Come on!</title>
<link rel='stylesheet' href='css/member.css' type='text/css'>
</head>
<body  background="images/backgrou.jpg">
<form action='blaNew.do' method='post'>
<table  bgcolor='#ccccc'>
<tr>
<td>
你好，${sessionScope.login}
</td>
<td>
<a href='logout.do'>退出登录</a>
</td>
<tr>
<td>
<c:if test= "${requestScope.more!=null }">
不能多于140字！
</c:if>
</td>
<tr>
<td>
<textarea cols='60' rows='4' name='blabla'>${requestScope.blabla }</textarea><br>
</td>
<tr>
<td>
<button type='submit'>GO</button>
</td></tr></table>
</form>

<hr>
<table bgcolor='#ccccc'>
<tr>
<td>
<c:forEach items="${requestScope.blahs}" var="blah">
<tr>
<td style='vertical-align:to;'>${blah.name }<br>
<c:out value="${blah.txt }"/><br>
<fmt:formatDate value="${blah.date }" type="both" dateStyle="full" timeStyle="full"/>
</td></tr>
</c:forEach>
</tbody></table>
<hr style='width:100%;height:1px'>
</body>
</html>