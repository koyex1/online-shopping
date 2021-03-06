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

		<%@include file="./shared/navbar.jsp"%>


		<!-- Page Content -->
		<div class="content">
			<!-- Only when user clicks Home -->
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Only when user clicks About -->
			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Only when user clicks Contact -->
			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<!-- Load when user clicks all products -->
			<c:if test="${userClickAllProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			<c:if test="${userClickC==true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			<!-- load only the userr click show products -->
			<c:if test="${userClickShowProduct==true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			
				<!-- load only the userr click manage products -->
			<c:if test="${userClickManageProducts==true}">
				<%@include file="manageProducts.jsp"%>
			</c:if>
			

		</div>
		


		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript vendor/jquery vendor/bootstrap/js -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/bootstrap.min.js"></script>
		
		<!-- jquery validator -->
		<script src="${js}/jquery.validate.js"></script>
		
		<!-- DataTablel Plugin -->
		<script src="${js}/jquery.dataTables.js"></script> 
		
		<%-- <!-- DataTable Bootstrap Script -->
		<script src="${js}/dataTables.bootstrap.js"></script> 
		 --%>
		 
		 <!-- DataTable bootbox Script -->
		<script src="${js}/bootbox.min.js"></script> 
		
		<!-- self coded javascript -->
		<script src="${js}/myapp.js"></script>

	</div>

</body>

</html>
