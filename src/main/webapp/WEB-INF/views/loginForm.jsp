<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src='https://www.google.com/recaptcha/api.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="resources/css/style.css">

<title>Login Form</title>
</head>
<body>

	<h1 align="center">Login Form</h1>
	<hr />


	<div class="login">
		<div class="login-triangle"></div>

		<h2 class="login-header">Log in</h2>

		<form class="login-container" action="login" method="post">
			<p>
				<input type="text" placeholder="User Name" name="username">
			</p>
			<p>
				<input type="password" placeholder="Password" name="password">
			</p>
			<div class="g-recaptcha"
				data-sitekey="6LeIP14UAAAAABhHHQq1RhG0dOG4HZUKZwrjWfgo"></div>
			<p>
				<input type="submit" value="Log in">
			</p>
		</form>
	</div>





</body>
</html>