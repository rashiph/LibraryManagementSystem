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
	<br/><br/>
	<c:choose>
		<c:when test="${book['new']}">
			<c:set var="method" value="post"/>
		</c:when>
		<c:otherwise>
			<c:set var="method" value="put"/>
		</c:otherwise>
	</c:choose>

	<h2>
		<c:if test="${book['new']}">New </c:if> Book
	</h2>
	<form:form modelAttribute="book" method="${method}" class="form-horizontal" id="add-book-form">
		<controls:inputField label="Book Name" name="name"/>
		<controls:inputField label="Author Name" name="author"/>
		<controls:inputField label="Category" name="category"/>
		<controls:inputField label="Edition" name="edition"/>
		<controls:inputField label="Price" name="price"/>
		<controls:inputField label="Date Of Purchase" name="dateOfPurchase"/>
		<controls:inputField label="Vendor" name="vendor"/>
		<div class="form-actions">
			<c:choose>
				<c:when test="${book['new']}">
					<button type="submit">Add Book</button>
				</c:when>
				<c:otherwise>
					<button type="submit">Update Book</button>
				</c:otherwise>
			</c:choose>
		</div>
	</form:form>
<jsp:include page="../partials/footer.jsp"/>
</div>
</body>

</html>
