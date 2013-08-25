<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html lang="en">

<jsp:include page="../partials/headTag.jsp"/>

<script type="text/javascript">
	function Delete(bookId) {
		var httpReq = new XMLHttpRequest();
		deleteBookUrl = "/books/" + bookId + "/deleteBook";
		httpReq.open("GET", deleteBookUrl, true);
		httpReq.send();
		httpReq.onload = function () {
			if (httpReq.readyState == 4 && httpReq.status == 200) {
				alert("book has deleted");
			}
		}
	}
</script>


<body>
<jsp:include page="../partials/bodyHeader.jsp"/>

<div class="content">
	<div class="container">
		<div class="page-header">
			<h1>List Of Issued Books</h1>

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
				<datatables:column title="Issued Date">
					<fmt:formatDate value="${book.issueDate}" pattern="yyyy/MM/dd"></fmt:formatDate>
				</datatables:column>
				<datatables:column title="Action" sortable="false" searchable="false">
					<spring:url value="/{bookId}/return" var="returnBookUrl">
						<spring:param name="bookId" value="${book.id}"/>
					</spring:url>
					<a href="${fn:escapeXml(returnBookUrl)}">Return</a>
				</datatables:column>
			</datatables:table>
		</div>
	</div>
</div>

<jsp:include page="../partials/footer.jsp"/>

</body>
</html>
