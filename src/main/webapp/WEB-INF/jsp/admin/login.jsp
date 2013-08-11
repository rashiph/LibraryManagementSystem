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
	<h2>
		Admin Login
	</h2>
	<form:form modelAttribute="book" method="post" class="form-horizontal" id="issue-book-form">
		<controls:inputField label="employee Id" name="employeeId"/>

		<div class="form-actions">
			<button type="submit">login</button>
		</div>
	</form:form>
</div>
<jsp:include page="../partials/footer.jsp"/>
</body>

</html>
