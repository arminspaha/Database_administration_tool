<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en" ng-app="loginApp">

<head>

<title>Login Page</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Reference Bootstrap files -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<script type="text/javascript" src="./resources/dist/index.js"></script>

</head>

<body ng-controller="loginController">

	<div class="container">

		<div class="card-deck mt-4">

			<div class="card text-white bg-danger mb-3 col-md-5">
				<div class="card-header">Sign In</div>

				<div style="padding-top: 30px" class="card-body">

					<div class="form-group">
						<div class="col-xs-15">
							<div>

								<!-- Check for login error checked on Server side -->

								<c:if test="${param.error != null}">

									<div class="alert alert-danger col-xs-offset-1 col-xs-10">
										Invalid username and password.</div>

								</c:if>

							</div>
						</div>
					</div>

					<!-- Login Form -->
					<form
						action="${pageContext.request.contextPath}/authenticateTheUser"
						method="POST" name="loginForm" novalidate>

						<div class="form-group">

							<label for="inputUsername">Username</label> 
							<input type="text"
								name="username" ng-model="credentials.username" ng-minlength="3"
								class="form-control" id="inputUsername"
								placeholder="Enter username" autofocus required>

							<p
								ng-show="loginForm.username.$invalid && !loginForm.username.$pristine"
								class="help-block">Username is required.</p>
							<p ng-show="loginForm.username.$error.minlength"
								class="help-block">Username is too short.</p>
						</div>

						<div class="form-group">

							<label for="inputPassword">Password</label> 
							<input
								type="password" name="password" ng-model="credentials.password"
								class="form-control" id="inputPassword" placeholder="Password"
								required ng-minlength="6">

							<p
								ng-show="loginForm.$submitted 
										&& loginForm.password.$error.required
										&& loginForm.password.$invalid"
								class="help-block">Password is required.</p>
							<p ng-show="loginForm.password.$error.minlength"
								class="help-block">Password is too short.</p>
						</div>
						<button type="submit" ng-disabled="loginForm.$invalid"
							class="btn btn-primary">Login</button>

						<!-- manually adding tokens! -->

						<%-- <input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /> --%>
					</form>

				</div>

			</div>

		</div>
		<div>
			<span class="d-inline-block" tabindex="0" data-toggle="tooltip"
				data-html="true"
				title="<u>Registration</u> doesn't work.
				You may use predefined usernames such as 
				<kbd>admin</kbd>, <kbd>manager</kbd> or <kbd>employee</kbd>
				with password <code>test123</code>">
					
				<button style="pointer-events: none;" type="button"
					class="btn btn-primary" ng-disabled="isDisabled">
					Register New User
				</button>
			</span>
		</div>
	</div>
<script>
$(function () {
	  $('[data-toggle="tooltip"]').tooltip()
	})
</script>
</body>
</html>