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

	$(document).ready(function () {
		$('.borrower').qtip({
			content: {
				text: 'Loading...', // Loading text...
				ajax: {
					url: '/book/borrower', // URL to the JSON script
					type: 'GET', // POST or GET
					data: { bookId: $('.borrower').attr('id') }, // Data to pass along with your request
//					dataType: 'json', // Tell it we're retrieving JSON
					success: function (data, status) {
						/* Process the retrieved JSON object
						 * Retrieve a specific attribute from our parsed
						 * JSON string and set the tooltip content.
						 */
//						var content = 'My name is ' + data.person.firstName;

						// Now we set the content manually (required!)
						this.set('content.text', data);
					}
				}
			},
			position: {
				viewport: $(window) // Adjust position to keep within the window
			},
			style: {
				classes: 'qtip-light',
				tip: {
					corner: 'bottom center',
					mimic: 'bottom left',
					border: 1,
					width: 88,
					height: 66
				}
			}
		});
	})
	;
</script>


<body>
<jsp:include page="../partials/bodyHeader.jsp"/>

<div class="content">
	<div class="container">
		<div class="page-header">
			<h1>List Of Books</h1>
		</div>

		<div class="row-fluid">
			<div class="alert-block">
				<div class="alert-success">
					${successMessage}
				</div>
				<div class="alert-error">
					${errorMessage}
				</div>
			</div>
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

				<datatables:column title="Available no. of copies">
					<c:out value="${book.availableCopies}"/>
				</datatables:column>

				<datatables:column title="Action" sortable="false" searchable="false">
					<c:choose>
						<c:when test="${book.availableCopies > 0}">
							<spring:url value="/{bookId}/issue" var="issueBookUrl">
								<spring:param name="bookId" value="${book.id}"/>
							</spring:url>
							<a href="${fn:escapeXml(issueBookUrl)}">Issue</a>
						</c:when>
						<c:otherwise>
							<div id="${book.id}" class="borrower">Borrower</div>
						</c:otherwise>
					</c:choose>
				</datatables:column>

				<datatables:column visible="${sessionScope.isAdmin}" title="Admin Action" sortable="false">
					<spring:url value="/{bookId}/edit" var="editBookUrl">
						<spring:param name="bookId" value="${book.id}"/>
					</spring:url>
					<a href="${fn:escapeXml(editBookUrl)}">Update</a>
					<spring:url value="/books/{bookId}/deleteBook" var="deleteBookUrl">
						<spring:param name="bookId" value="${book.id}"/>
					</spring:url>
					<a href="javascript:Delete(${book.id})">Delete</a>
				</datatables:column>

			</datatables:table>
		</div>
	</div>
</div>

<jsp:include page="../partials/footer.jsp"/>

</body>
</html>
