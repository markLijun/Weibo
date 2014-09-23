<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  <c:choose>
    <c:when test="${requestScope.blahs != null }">
    	<div class='leftPanel'>
    	${requestScope.name }is blahing
    	</div>
    	<table style='text-align:left;width:510px;height:88px;'
    	border='0' cellpadding='2' cellspacing='2'>
    	<thead>
    		<tr>
    			<th><hr></th>
    			</tr>
    			</thead>
    			<tbody>
    			<%
    			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,Locale.TAIWAN);
    			%>
    			<c:forEach items="${requestScope.blahs }" var="blah" >
    			<tr>
    			<td style='vertical-align:top;'>
    			 ${blah.name }<br>
    			 <c:out value="${blah.txt }"><br>
    			 ${blah.date.time }<br>
    			 </c:out></td></tr></c:forEach></tbody></table></c:when>
    	<c:otherwise>
    	   DONT EXISTED
    	   </c:otherwise></c:choose>
    			 
    			
  </body>
</html>
