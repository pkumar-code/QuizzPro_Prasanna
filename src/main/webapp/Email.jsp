<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE  html>
<html>
<head>
<title>QuizzPro</title>
<link rel="stylesheet" href="/mycss/style.css" />
<link href=" webjars/bootstrap/5.3.3/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" />
</head>
<body>

<div class="wrapper">
		<div class="title">
			<span>Forgot Form</span>
		</div>
		<form action="/verifyEmail" method="get">
			<div class="row">
				<i class="fas fa-user"></i> <input type="email" name="email"
					placeholder="Eneter Email"  required />
			</div>		
			<div class="row button">
				<input type="submit" value="Submit Now" />
			</div>
		</form>
	</div>
</body>
</html>