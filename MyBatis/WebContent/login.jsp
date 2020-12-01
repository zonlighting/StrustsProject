<%@ taglib prefix="s" uri="/struts-tags"%>
<%--
  Created by IntelliJ IDEA.
  User: summer
  Date: 17-2-20
  Time: 下午12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Numans');

html, body {
	background-image:
		url('http://getwallpapers.com/wallpaper/full/a/5/d/544750.jpg');
	background-size: cover;
	background-repeat: no-repeat;
	height: 100%;
	font-family: 'Numans', sans-serif;
}

.container {
	height: 100%;
	align-content: center;
}

.card {
	height: 370px;
	margin-top: auto;
	margin-bottom: auto;
	width: 400px;
	background-color: rgba(0, 0, 0, 0.5) !important;
}

.social_icon span {
	font-size: 60px;
	margin-left: 10px;
	color: #FFC312;
}

.social_icon span:hover {
	color: white;
	cursor: pointer;
}

.card-header h3 {
	color: white;
}

.social_icon {
	position: absolute;
	right: 20px;
	top: -45px;
}

.input-group-prepend span {
	width: 50px;
	background-color: #FFC312;
	color: black;
	border: 0 !important;
}

input:focus {
	outline: 0 0 0 0 !important;
	box-shadow: 0 0 0 0 !important;
}

.remember {
	color: white;
}

.remember input {
	width: 20px;
	height: 20px;
	margin-left: 15px;
	margin-right: 5px;
}

.login_btn {
	color: black;
	background-color: #FFC312;
	width: 100px;
}

.login_btn:hover {
	color: black;
	background-color: white;
}

.links {
	color: white;
}

.links a {
	margin-left: 4px;
}

#form-control {
	width: 300px;
}

#form-control1 {
	width: 300px;
}

#form-control2 {
	width: 300px;
}

#inputLogin {
	border: 1px solid transparent;
	padding: .375rem .75rem;
	font-size: 1rem;
	line-height: 1.5;
	border-radius: .25rem;
	background-color: #FFC312;
	width: 100px;
	cursor: pointer;
	float: right !important
}

.errorDiv {
	color: red;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Login Page</title>

</head>
<body>
	<s:url value="register.jsp" action="register" var="registerUrl">
	</s:url>
	<div class="card-body">
		<s:if test="hasActionErrors()">
			<div class="errorDiv">
				<s:actionerror />
			</div>
		</s:if>
		<form action="login">
			<div class="input-group form-group">
				<div class="input-group-prepend">
					<span class="input-group-text"><i class="fas fa-user"></i></span>
				</div>
				<s:textfield type="text" name="username" label="username"
					id="form-control1" placeholder="username" />
			</div>
			<div class="input-group form-group">
				<div class="input-group-prepend">
					<span class="input-group-text"><i class="fas fa-key"></i></span>
				</div>
				<s:password name="password" label="password" type="password"
					id="form-control2" placeholder="password" />

			</div>
			<div class="row align-items-center remember">
				<input type="checkbox" id="myCheck">Remember Me
			</div>
			<div class="form-group">
				<s:submit value="Login" id="inputLogin"></s:submit>
			</div>
		</form>
	</div>
	<div class="card-footer">
		<div class="d-flex justify-content-center links">
			Don't have an account?<a href='<s:property value="#registerUrl"/>'>
				Sign Up </a>
		</div>
		<div class="d-flex justify-content-center">
			<a href="#">Forgot your password?</a>
		</div>
	</div>
</body>

</html>