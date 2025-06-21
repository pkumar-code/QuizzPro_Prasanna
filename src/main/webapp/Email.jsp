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
	color: blue;
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	font-weight: bold;
	font-size: 30px;
}

input {
	border-radius: 5px;
	font-size: 20px;
}

body {
	margin-top: 30px;
	margin-left: 250px;
	margin-right: 250px;
	margin-bottom: 100px;
	border: 1px solid;
	background-color: azure;
}

table, tr, td {
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	font-weight: bold;
	text-align: center;
	padding: 20px;
	font-size: 20px;
	padding: 20px;
}
</style>

</head>
<body>
	<br>
	<div class="container" align="center">
		<h2>QuizzPro Verification</h2>

		<form action="/verifyEmail" method="get">
			<table>
				<tr>
					<td>Enter Your Email</td>
					<td><input type="email" name="email"
						placeholder="Eneter Email" required /></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><input style="color:blue;" type="submit"
						value="Submit Now" /></td>
				</tr>
			</table>
		</form>

	</div>
</body>
</html>