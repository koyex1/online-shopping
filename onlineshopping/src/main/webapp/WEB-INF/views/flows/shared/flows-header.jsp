<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title> Olu Store- ${title}</title>
<script>
	window.menu = "${title}"; //A way to get constants of variables that are not id values but actuall values
	window.contextRoot ='${contextRoot}'
</script>

<!-- Bootstrap core CSS vendor/bootstrap/css -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap DataTable theme-->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">


 <!-- Bootstrap Readable theme-->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet"> 

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">
	
		<!-- Navigation -->
		<%@include file="flows-navbar.jsp"%>
		

		<!-- Page Content -->
		<div class="content">