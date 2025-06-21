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
}

button {
	font-size: 20px;
	color: blue;
	border-radius: 5px;
}

body {
	margin-top: 30px;
	margin-left: 250px;
	margin-right: 250px;
	margin-bottom: 100px;
	border: 1px solid;
	background-color: azure;
}

input {
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	font-size: 20px;
	font-weight: bold;
	border-radius: 5px;
}

table, tr, td {
	text-align: center;
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	font-weight: bold;
	padding: 20px;
	font-size: 20px;
	padding: 20px;
}
</style>

</head>
<body>
	<br>
	<div class="container" align="center">
		<h2>QuizzPro Updating New Password</h2>

		<form action="/forgotpw" method="get">
			<table>

				<tr>
					<td><input type="hidden" name="email" value="${EM }"
						placeholder="Enter Email" /></td>
				</tr>
				<tr>
					<td>Enter New Password</td>
					<td><input type="password" name="npass1"
						placeholder="Enter new password" /></td>
				</tr>
				<tr>
					<td>Re-Enter New Password</td>
					<td><input type="password" name="npass"
						placeholder="Re-Enter new password" /></td>
				</tr>
				<tr>
					<td colspan="3" align="center">
						<button onclick="show1()">Submit</button>
					</td>
				</tr>
			</table>
		</form>
	</div>

	<script type="text/javascript">
	
	  function show1() {
          window.alert("Updated new password succesfully");
          window.console.log('Click on JS Training');
      }
	    
	     
	</script>
</body>
</html>