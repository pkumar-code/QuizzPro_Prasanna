<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE  html>
<html>
<head>
<title>QuizzPro</title>
<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css"
	rel="stylesheet">
<style>
h2 {
	font-size: 30px;
	font-weight: bold;
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	border: 1px solid #000;
	color: aquamarine;
	padding: 2px 4px;
	background-color: grey;
}

a {
	font-size: 25px;
	text-decoration: none;
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	font-weight: bold;
	text-align: center;
	margin-bottom: 5px;
}

input {
	font-size: 20px;
	font-weight: bold;
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	border-radius: 5px;
	padding-bottom: 5px;
}

body {
	margin-top: 30px;
	margin-left: 250px;
	margin-right: 250px;
	border: 1px solid;
	background-color: azure;
}

table, tr, td {
	text-align: center;
	padding: 15px;
	font-weight: bold;
	font-size: 20px;
}
</style>

</head>
<body>
	<br>
	<div class="container" align="center">
		<h2>QuizzPro User Login</h2>

		<table>
			<form:form action="/myuser" method="get">
				<tr>
					<td>Username</td>
					<td><input type="text" name="email" placeholder="Enter username..." required /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="pass"  placeholder="Enter password..." required/></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><input style="color:blue;" type="submit"
						value="LoginNow" /></td>
				</tr>
			</form:form>
		</table>

		<a href="Email.jsp">Forgot</a>

	</div>
</body>
</html>