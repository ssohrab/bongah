<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
	<script src="<c:url value="/resources/js/jquery-2.1.0.min.js" />"></script>	

	<title>Better MSL</title>
	
	<style>
		.centerText {text-align: center;}
		.block {display: block;}
		.username {padding: 0px 5px 0px 0px;}
		.password {padding: 0px 7px 0px 0px;}
		.phoneNumber {padding: 0px 19px 0px 0px;}
		.city {padding: 0px 41px 0px 0px;}
	</style>
</head>
<body>
	<h1 class="centerText">
		Welcome to a better MLS!
	</h1>
	
	<div class="centerText">
		<input type="button" value="Create account" onClick="createAccount();"/>
		<input type="button" value="Login" onClick="login();"/>
	</div>
	
	<br/>
	
	<form class="centerText" id="loginForm" method="post" action="${loginUrl}" style="display: none">
		<label class="username" for="username">Username</label>
		<input id="username" type="text"/><br/>
	
		<label class="password" for="password">Password</label>
		<input id="password" type="password"/><br/>
		
		<input type="submit"/>
	</form>
	
	<form id="createAccountForm" class="centerText" method="post" action="${newAccountUrl}" style="display: none">
		<label class="username" for="newusername">Username</label>
		<input id="newusername" type="text"/><br/>
	
		<label class="password" for="newpassword">Password</label>
		<input id="newpassword" type="password"/><br/>

		<label class="city" for="city" style="text-align: left;">City</label>
		<input id="city" type="text"/><br/>

		<label class="phoneNumber" for="phoneNumber">Phone#</label>
		<input id="phoneNumber" type="text"/><br/>
		
		<input type="submit" />	
	</form>
	
	<br/>
	
	<p class="centerText">  The time on the server is ${serverTime}. </p>
	
	<script>
		$(document).ready(function () {
		});
		
		function login() {
			$("#loginForm").attr("style", "display: block");
			
			$("#createAccountForm").attr("style", "display: none");
		}

		function createAccount() {
			$("#createAccountForm").attr("style", "display: block");
			
			$("#loginForm").attr("style", "display: none");
		}
	</script>
</body>
</html>
