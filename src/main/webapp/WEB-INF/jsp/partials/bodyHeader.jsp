<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:url value="/resources/images/logo.jpg" var="logo"/>

<h2 style="float: left;">ThoughtWorks</h2>

<div class="navbar" style=" float: right;">

	<div class="navbar-inner">
		<ul class="nav">
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
							<i class="icon-warning-sign"></i>
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
