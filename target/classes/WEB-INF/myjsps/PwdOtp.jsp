<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE  html>
<html>
<head>
<title>QuizzPro</title>
<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css"
	rel="stylesheet">
<style>
h1 {
	font-size: 20px;
	margin: 0px;
	color: red;
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}

h2 {
	color: blue;
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}

input {
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	font-size: 20px;
	font-weight: bold;
	color: blue;
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
	text-align: center;
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	font-weight: bold;
	font-size: 20px;
	padding: 20px;
}
</style>

</head>
<body>
	<br>
	<div class="container" align="center">
		<h2>QuizzPro OTP Verification</h2>
		<h1>
			Time Remaining for Enter OTP : <span id="timer"></span>
		</h1>
		<form action="/verifyotpPWD" method="get">
			<table>
				<tr>
					<td><input type="hidden" name="email" value="${EM }" /></td>
				</tr>
				<tr>
					<td>Enter OTP</td>
					<td><input type="tel" name="otp" placeholder="Enter your otp" /></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><input type="submit"
						value="Submit Now" /></td>
				</tr>
			</table>
		</form>

	</div>

	<script type="text/javascript">
		let timerOn = true;

		function timer(remaining) {
			var m = Math.floor(remaining / 60);
			var s = remaining % 60;

			m = m < 10 ? '0' + m : m;
			s = s < 10 ? '0' + s : s;
			document.getElementById('timer').innerHTML = m + ':' + s;
			remaining -= 1;

			if (remaining >= 0 && timerOn) {
				setTimeout(function() {
					timer(remaining);
				}, 1000);
				return;
			}

			if (!timerOn) {
				return;
			}
			alert('Timeout for otp');

		}

		timer(60);
	</script>
</body>
</html>