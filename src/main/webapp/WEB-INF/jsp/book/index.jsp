<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="en">


<jsp:include page="../partials/headTag.jsp"/>

<body>
<div class="container">
	<jsp:include page="../partials/bodyHeader.jsp"/>

         <% boolean isAdmin = ${isAdmin};
          if(isAdmin==true) { %>
           <li><b><a href="new"> add book </a></b></li> <li><b><a href =""> edit book </a></b></li>

	<h2>List Of Books</h2>

	<jsp:useBean id="books" scope="request" type="com.thoughtworks.models.Books"/>
	<datatables:table id="books" data="${books.bookList}" cdn="true" row="book" theme="bootstrap2"
										cssClass="table table-striped" paginate="false" info="false">
		<datatables:column title="Name">
			<c:out value="${book.name}"></c:out>
		</datatables:column>
		<datatables:column title="Author">
			<c:out value="${book.author}"></c:out>
		</datatables:column>
		<datatables:column title="Category">
			<c:out value="${book.category}"></c:out>
		</datatables:column>
		<datatables:column title="Edition">
			<c:out value="${book.edition}"></c:out>
		</datatables:column>
		<datatables:column title="NoOfCopies">
			<c:out value="${book.noOfCopies}"></c:out>
		</datatables:column>
		<datatables:column>
			<spring:url value="books/{bookId}/edit" var="bookUrl">
				<spring:param name="bookId" value="${book.id}"/>
			</spring:url>
			<a href="${fn:escapeXml(bookUrl)}">Edit Book</a>
		</datatables:column>
	</datatables:table>
	<jsp:include page="../partials/footer.jsp"/>
</div>
</body>

</html>
