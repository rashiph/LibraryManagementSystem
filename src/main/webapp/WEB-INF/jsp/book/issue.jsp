<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="controls" tagdir="/WEB-INF/tags" %>


<html lang="en">

<jsp:include page="../partials/headTag.jsp"/>

<body>
<div class="container">
	<jsp:include page="../partials/bodyHeader.jsp"/>
	<c:choose>
		<c:when test="${issueBook['issue_book']}"><c:set var="method" value="post"/></c:when>
		<c:otherwise><c:set var="method" value="put"/></c:otherwise>
	</c:choose>

	<h2>
		<c:if test="${issueBook['issue_book']}">Issue </c:if> Book
	</h2>
	<form:form modelAttribute="book" method="${method}" class="form-horizontal" id="issue-book-form">
		<controls:inputField label="bookId" name="bookId"/>

		<div class="form-actions">
			<c:choose>
				<c:when test="${issueBook['issue_book']}">
					<button type="submit">Issue Book</button>
				</c:when>
				<c:otherwise>
					<button type="submit">Issue Book</button>
				</c:otherwise>
			</c:choose>
		</div>
	</form:form>
</div>
<jsp:include page="../partials/footer.jsp"/>
</body>

</html>
