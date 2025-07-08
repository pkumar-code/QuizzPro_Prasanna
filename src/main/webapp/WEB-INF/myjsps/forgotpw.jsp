<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE  html>
<html>
<head>
<title>QuizzPro</title>
<link rel="stylesheet" href="style.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" />
</head>
<body>
<div class="wrapper">
		<div class="title">
			<span> New Password Form</span>
		</div>
		<form action="/forgotpw" method="get">
		<div>
		<input type="hidden" name="email" value="${EM }"
						placeholder="Enter Email" />
		</div>	
			<div class="row">
				<i class="fas fa-lock"></i> <input type="password" name="npass1"
					placeholder="Enter new password" required />
			</div>
			<div class="row">
				<i class="fas fa-lock"></i> <input type="password" name="npass"
					placeholder="Re-Enter new password" required />
			</div>
			
			<div class="row button">
				<input  onclick="show1()"  type="submit" value="Login" />
			</div>
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