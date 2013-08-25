<%@ page import="java.util.Date" %>
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="controls" tagdir="/WEB-INF/tags" %>


<html lang="en">

<jsp:include page="../partials/headTag.jsp"/>
<script>
	$(function () {
		$("#dateOfPurchase").datepicker({ dateFormat: 'yy/mm/dd'});
	});
</script>
<body>
<jsp:include page="../partials/bodyHeader.jsp"/>
<div class="content">
	<div class="container">
		<div class="page-header">
			<h1><c:choose>
				<c:when test="${book['new']}">
					Add New Book
				</c:when>
				<c:otherwise>
					Update Book
				</c:otherwise>
			</c:choose></h1>
		</div>
		<div class="row">
			<div class="span6 offset3">
				<h4 class="widget-header"><i class="icon-th-list"></i> Book Details</h4>

				<div class="widget-body">
					<div class="center-align">
						<c:choose>
							<c:when test="${book['new']}">
								<c:set var="method" value="post"/>
							</c:when>
							<c:otherwise>
								<c:set var="method" value="put"/>
							</c:otherwise>
						</c:choose>
						<form:form modelAttribute="book" method="${method}" class="form-horizontal form-signin-signup"
											 id="add-book-form">
							<controls:inputField label="Book Name" name="name"/>
							<controls:inputField label="Author Name" name="author"/>
							<controls:inputField label="Category" name="category"/>
							<controls:inputField label="Edition" name="edition"/>
							<controls:inputField label="Price" name="price"/>
							<c:choose>
								<c:when test="${book['new']}">
									<controls:inputFieldWIthoutinding name="dateOfPurchase" label="Date Of Purchase" id="dateOfPurchase"
																										type="text"/>
									<controls:inputFieldWIthoutinding name="noOfCopies" label="No. of copies"/>
								</c:when>
								<c:otherwise>
									<fmt:formatDate value="${book.bookDetails[0].dateOfPurchase}" pattern="yyyy/MM/dd"
																	var="purchaseDate"></fmt:formatDate>
									<controls:inputFieldWIthoutinding name="dateOfPurchase" label="Date Of Purchase" id="dateOfPurchase"
																										type="text" value="${purchaseDate}"/>
									<controls:inputFieldWIthoutinding name="noOfCopies" label="No. of copies"
																										value="${fn:length(book.bookDetails)}"/>
								</c:otherwise>
							</c:choose>

							<controls:inputField label="Vendor" name="vendor"/>
							<div>
								<c:choose>
									<c:when test="${book['new']}">
										<button type="submit" class="btn btn-primary btn-large">Add Book</button>
									</c:when>
									<c:otherwise>
										<button type="submit" class="btn btn-primary btn-large">Update Book</button>
									</c:otherwise>
								</c:choose>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../partials/footer.jsp"/>
</body>

</html>
