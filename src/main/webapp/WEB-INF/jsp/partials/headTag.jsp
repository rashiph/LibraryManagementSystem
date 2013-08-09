<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>ThoughtWorks :: Library Management System</title>


    <spring:url value="/webjars/bootstrap/2.3.0/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>

    <spring:url value="/resources/css/main.css" var="mainCss"/>
    <link href="${mainCss}" rel="stylesheet"/>

    <spring:url value="/resources/css/bookCss.css" var="bookCss"/>
    <link href="${bookCss}" rel="stylesheet"/>

    <spring:url value="/webjars/jquery/1.9.0/jquery.js" var="jQuery"/>
    <script src="${jQuery}"></script>

    <spring:url value="/webjars/jquery-ui/1.9.2/js/jquery-ui-1.9.2.custom.js" var="jQueryUi"/>
    <script src="${jQueryUi}"></script>

    <spring:url value="/webjars/jquery-ui/1.9.2/css/smoothness/jquery-ui-1.9.2.custom.css" var="jQueryUiCss"/>
    <link href="${jQueryUiCss}" rel="stylesheet" />


	<script src="<c:url value="/resources/js/validation.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
	<%--<link href="/public/css/bootstrap.css" rel="stylesheet" type="text/css"></link>--%>
	<%--<link href="/public/css/bootstrap.min.css" rel="stylesheet" type="text/css"></link>--%>
	<%--<link href="/public/css/main.css" rel="stylesheet" type="text/css"></link>--%>
	<%--<link href="/public/css/jquery-ui.css" rel="stylesheet" type="text/css"></link>--%>


</head>


