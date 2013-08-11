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
							<a href="<spring:url value="/" htmlEscape="true" />">
								<i class="icon-search"></i>
								Find Books
							</a>
						</li>
						<li>
							<a href="<spring:url value="/new" htmlEscape="true" />">
								<i class="icon-th-list"></i>
								Return Books
							</a>
						</li>
						<li>
							<a href="<spring:url value="/oups.html" htmlEscape="true" />">
								<i class=" icon-question-sign"></i>
								Suggest A Book
							</a>
						</li>
						<li>
							<a href="<spring:url value="/oups.html" htmlEscape="true" />">
								<i class=" icon-question-sign"></i>
								Volunteer
							</a>
						</li>
						<c:choose>
							<c:when test="${sessionScope.isAdmin}">
								<li>
									<a href="/new">
										<i class="icon-th-list"></i>
										Add Book
									</a>
								</li>
								<li>
									<a href="<c:url value="/logout"/>">
										<i class="icon-warning-sign"></i>
										Logout
									</a>
								</li>
							</c:when>
							<c:otherwise>
								<li>
									<a href="<c:url value="/login"/>">
										<i class=" icon-warning-sign"></i>
										Login
									</a>
								</li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End: Navigation wrapper -->
</header>