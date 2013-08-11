<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>ThoughtWorks :: Library Management System</title>

	<spring:url value="/resources/css/main.css" var="mainCss"/>
	<link href="${mainCss}" rel="stylesheet"/>

	<spring:url value="/resources/css/bookCss.css" var="bookCss"/>
	<link href="${bookCss}" rel="stylesheet"/>

	<spring:url value="/webjars/jquery/1.9.0/jquery.js" var="jQuery"/>
	<script src="${jQuery}"></script>

	<spring:url value="/webjars/jquery-ui/1.9.2/js/jquery-ui-1.9.2.custom.js" var="jQueryUi"/>
	<script src="${jQueryUi}"></script>

	<spring:url value="/webjars/jquery-ui/1.9.2/css/smoothness/jquery-ui-1.9.2.custom.css" var="jQueryUiCss"/>
	<link href="${jQueryUiCss}" rel="stylesheet"/>

	<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

	<!-- Bootstrap responsive -->
	<link href="<c:url value="/resources/css/bootstrap-responsive.min.css"/>" rel="stylesheet">

	<!-- Font awesome - iconic font with IE7 support -->
	<link href="<c:url value="/resources/css/font-awesome.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/font-awesome-ie7.css"/>" rel="stylesheet">

	<!-- Bootbusiness theme -->
	<link href="<c:url value="/resources/css/boot-business.css"/>" rel="stylesheet">
</head>


