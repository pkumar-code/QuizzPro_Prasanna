<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE  html>
<html>
<head>
<link rel="stylesheet" href="/mycss/teacher.css" />
<link href=" webjars/bootstrap/5.3.3/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" />
<title>QuizzPro</title>
</head>
<body>
	<div class=" home">
		<nav class="navbar navbar-light rounded "
			style="background-color: #e3f2fd;">
			<div class="container-fluid">
				<span> <img src="#" alt="logo">
				</span> <span class="navbar-text"> <b>Teachers DashBorad</b>
				</span> <span> Welcome to : ${USER.full_Name} || <a href="/logout">logout</a>
				</span>
			</div>
		</nav>
			<div >
				<a href="addquestionpage">Add Question</a> <a
					href="viewquestionspage">ViewQuestion</a> <a
					href="uploadQuestions.jsp">Upload Questions</a>
			</div>
		</div>
</body>
</html>