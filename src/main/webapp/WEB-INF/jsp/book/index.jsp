<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="en">

<jsp:include page="../partials/headTag.jsp"/>

<body>
<jsp:include page="../partials/bodyHeader.jsp"/>

<div class="content">
	<div class="container">
		<div class="page-header">
			<h1>List Of Books</h1>
      ${message}
		</div>
		<div class="row-fluid">
			<jsp:useBean id="books" scope="request" type="com.thoughtworks.models.Books"/>

			<datatables:table id="books" data="${books.bookList}" cdn="true" row="book" theme="bootstrap2"
												cssClass="table table-striped" paginate="true" info="false">
				<datatables:column title="Name">
					<c:out value="${book.name}"/>
				</datatables:column>
				<datatables:column title="Author">
					<c:out value="${book.author}"/>
				</datatables:column>
				<datatables:column title="Category">
					<c:out value="${book.category}"/>
				</datatables:column>
				<datatables:column title="Edition">
					<c:out value="${book.edition}"/>
				</datatables:column>
				<datatables:column title="Total no. of copies">
					<c:out value="${fn:length(book.bookDetails)}"/>
				</datatables:column>
				<datatables:column title="Action" sortable="false" searchable="false">
					<spring:url value="books/{bookId}/issue" var="issueBookUrl">
						<spring:param name="bookId" value="${book.id}"/>
					</spring:url>
					<a href="${fn:escapeXml(issueBookUrl)}">Issue</a>
				</datatables:column>
				<datatables:column visible="${sessionScope.isAdmin}" title="Admin Action" sortable="false">
					<spring:url value="/{bookId}/edit" var="editBookUrl">
						<spring:param name="bookId" value="${book.id}"/>
					</spring:url>
					<a href="${fn:escapeXml(editBookUrl)}">Update</a>
					<spring:url value="/books/{bookId}/deleteBook" var="deleteBookUrl">
						<spring:param name="bookId" value="${book.id}"/>
					</spring:url>
					<a href="${fn:escapeXml(deleteBookUrl)}">Delete</a>
				</datatables:column>
			</datatables:table>
		</div>
	</div>
</div>

<jsp:include page="../partials/footer.jsp"/>

</body>
</html>
