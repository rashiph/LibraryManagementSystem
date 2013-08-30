<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:url value="/resources/images/logo.jpg" var="logo"/>

<header>
	<!-- Start: Navigation wrapper -->
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a href="http://www.thoughtworks.com" class="brand brand-bootbus">ThoughtWorks</a>
				<c:if test="${sessionScope.isLogin}">
					<!-- Below button used for responsive navigation -->
					<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<!-- Start: Primary navigation -->
					<div class="nav-collapse collapse">
						<ul class="nav pull-right">

							<li>
								<a href="<spring:url value="/book/index" htmlEscape="true" />">
									<i class="icon-search"></i>
									Find Books
								</a>
							</li>
							<li>
								<a href="<spring:url value="/book/return" htmlEscape="true" />">
									<i class="icon-th-list"></i>
									Return Books
								</a>
							</li>
							<li>
								<a href="<spring:url value="/suggest" htmlEscape="true" />">
									<i class=" icon-question-sign"></i>
									Suggest A Book
								</a>
							</li>
							<c:if test="${sessionScope.isAdmin}">
								<li>
									<a href="<c:url value="/new"/>">
										<i class="icon-th-list"></i>
										Add Book
									</a>
								</li>
							</c:if>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">${sessionScope.fullName}<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li>
										<a href="<c:url value="/logout"/>">
											<i class="icon-warning-sign"></i>
											Logout
										</a>
									</li>
								</ul>
							</li>
						</ul>
					</div>
				</c:if>
			</div>

		</div>
	</div>
	<!-- End: Navigation wrapper -->
</header>