<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE  html>
<html>
<head>
<title>QuizzPro</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" />
<link rel="stylesheet" href="style.css" />

</head>
<body>
<div class="wrapper">
		<div class="title">
			<span>QuizzPro OTP Verification</span>
		</div>
		<form action="/verifyotpPWD" method="get">
			<div>
				<p style="color: red;">
					Time Remaining for Enter OTP : <span id="timer"></span>
				</p>
			</div>
			<div>
			<input type="hidden" name="email" value="${EM }" />
			</div>
			<div class="row">
				<i class="fa-solid fa-envelope"></i> <input type="tel" name="otp"
					placeholder="Enter your otp " required />
			</div>

			<div class="row button">
				<input type="submit" value="Submit Now" />
			</div>
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