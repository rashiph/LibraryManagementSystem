<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="name" required="true" rtexprvalue="true"
							description="Name of corresponding property in bean object" %>
<%@ attribute name="label" required="true" rtexprvalue="true"
							description="Label appears in red color if input is considered as invalid after submission" %>
<%@ attribute name="type" rtexprvalue="true"
							description="Label appears in red color if input is considered as invalid after submission" %>
<%@ attribute name="id" rtexprvalue="true"
							description="Label appears in red color if input is considered as invalid after submission" %>
<%@ attribute name="value" rtexprvalue="true"
							description="Label appears in red color if input is considered as invalid after submission" %>

<c:set var="cssGroup" value="control-group ${status.error ? 'error' : '' }"/>
<div class="${cssGroup}">
	<label class="control-label">${label}</label>

	<div class="controls">
		<input type="${type}" name="${name}" id="${id}" value="${value}"/>
		<span class="help-inline">${status.errorMessage}</span>
	</div>
</div>