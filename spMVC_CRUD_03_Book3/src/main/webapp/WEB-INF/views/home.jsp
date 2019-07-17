<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--  rootPath = pageContext.request.contextPath  -->  
<%
	// String rootPath = request.getRequestURL().toString();
%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/book-main.css?var=2019071702">
	<link rel="stylesheet" type="text/css"
	href="${rootPath}/css/book-input.css?var=20190717">	
<link rel="stylesheet" type="text/css"
	href="${rootPath}/css/my-button.css?var=2019071702">
	<link rel="stylesheet" type="text/css" href="${rootPath}/css/book-view.css?var=2019071703">	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script>
	$(function(){
		
	})
	</script>

</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>

<c:choose>
	<c:when test="${BODY == 'LOGIN'}">
		<%@ include file="/WEB-INF/views/body/book-login.jspf" %>
	</c:when>
	<c:when test="${BODY == 'JOIN'}">
		<%@ include file="/WEB-INF/views/body/book-join.jspf" %>
	</c:when>
	<c:when test="${BODY == 'MEMBER-VIEW'}">
	<P>ID : ${MEMBER.m_userid} </P>
	<P>PASSWORD : ${MEMBER.m_password} </P>
	<P>NAME : ${MEMBER.m_name} </P>
	<P>EMATL : ${MEMBER.m_email} </P>
	<P>TEL : ${MEMBER.m_tel} </P>
	</c:when>
	
	<c:when test="${BODY == 'BOOK-LIST'}">
		<%@ include file="/WEB-INF/views/body/book-list.jspf" %>
	</c:when>
	
	<c:when test="${BODY == 'BOOK-INPUT'}">
		<%@ include file="/WEB-INF/views/body/book-input-form.jspf" %>
	</c:when>
	<c:when test="${BODY == 'BOOK-VIEW'}">
		<%@ include file="/WEB-INF/views/body/book-view.jspf" %>
	</c:when>
	
	<c:otherwise>
	<%@include file="/WEB-INF/views/body/book-member-view.jspf" %>
	</c:otherwise>
	
</c:choose>

</body>
</html>



