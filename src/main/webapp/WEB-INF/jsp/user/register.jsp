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

  function validateRegistrationForm() {
    if (document.userForm.password.value != document.userForm.cPassword.value) {
      alert("Enter same password");
      document.userForm.password.value = "";
      document.userForm.cPassword.value = "";
      return false;
    }
  }

</script>

<body>
<jsp:include page="../partials/bodyHeader.jsp"/>
<div class="content">
  <div class="container">
    <div class="page-header">
    </div>
    <div class="row">
      <div class="span6 offset3">
        <h4 class="widget-header"><i class="icon-th-list"></i> Register Here</h4>

        <div class="widget-body">
          <div class="center-align">
            <div class="registration-form">
              <form:form modelAttribute="user" method="post" class="form-horizontal form-signin-signup"
                         id="add-user-form" name="userForm" onsubmit="return validateRegistrationForm()">
              <controls:inputField label="Employee Id" name="employeeId"/>
              <controls:inputField label="Full Name" name="fullName"/>
              <controls:inputField label="Password" name="password" type="password"/>
                <%--<controls:passwordField label="Password" name="password"/>--%>

              <c:set var="cssGroup" value="control-group ${status.error ? 'error' : '' }"/>
              <div class="control-group ${status.error ? 'error' : '' }">
                <label class="control-label">Confirm Password</label>

                <div class="controls">
                  <input type="password" name="cPassword" required="true"/>
                  <span class="help-inline">${status.errorMessage}</span>
                </div>
              </div>

            </div>
            <div>
              <button type="submit" class="btn btn-primary btn-large">Sign Up</button>
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
