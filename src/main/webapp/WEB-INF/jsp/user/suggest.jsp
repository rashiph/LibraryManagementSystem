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
<jsp:include page="../partials/bodyHeader.jsp"/>
<div class="content">
	<div class="container">
		<div class="page-header">
			<h1>Suggest A Book</h1>
		</div>

		<div class="row">
			<div class="span6 offset3">
				<h4 class="widget-header"><i class=" icon-question-sign"></i> Suggest Book</h4>

				<div class="widget-body">
					<div class="center-align">

						<form:form modelAttribute="suggestBook" method="POST" class="form-horizontal form-signin-signup"
						id="suggest-Book-form">
							<controls:inputField label="Book Name" name="bookName"/>
							<controls:inputField label="Author Name" name="authorName"/>
							<controls:inputField label="Edition" name="edition"/>
							<div>
								<button type="submit" class="btn btn-primary btn-large">suggest</button>
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
