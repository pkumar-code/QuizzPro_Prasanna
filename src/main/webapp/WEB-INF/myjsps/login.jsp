<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" />
<title>QuizzPro</title>
</head>
<body>
	<div class="wrapper">
		<div class="title">
			<span>Login Form</span>
		</div>
		<form action="/myuser" method="get">
			<div class="row">
				<i class="fas fa-user"></i> <input type="text" name="email"
					placeholder="Email " required />
			</div>
			<div class="row">
				<i class="fas fa-lock"></i> <input type="password" name="pass"
					placeholder="Password" required />
			</div>
			<div class="pass">
				<a href="Email.jsp">Forgot password?</a>
			</div>
			<div class="row button">
				<input type="submit" value="Login" />
			</div>
		</form>
	</div>

</body>
</html>