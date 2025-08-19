<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE  html>
<html>
<head>
<link rel="stylesheet" href="/mycss/student.css" />
<link href=" webjars/bootstrap/5.3.3/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" />
<title>QuizzPro</title>
</head>
<body>
	<div class=" home">
		<nav class="navbar navbar-light rounded  text-bg-success p-3">
			<div class="container-fluid">
				<span> <img src="#" alt="logo">
				</span> <span class="navbar-text"> <b>Student DashBorad</b>
				</span> <span> Welcome to : ${USER.full_Name} || <a href="/logout">logout</a>
				</span>
			</div>
		</nav>
		<br/>
		<div class="container-fluid">
			<h1>Assigned Tests : </h1>
			<p> No Tests assigned to you as of now !!!! </p>
		</div>	
		<br/>
		<div class="container-fluid">
			<h1>Practice Tests : </h1>
			<c:forEach var = "course"  items="${COURSE}"> 
			<span class="course">
			<a href="/topic?couId=${course.key}&couName=${course.value }" >
			<c:out value="${course.value }"></c:out>
			</a> 
			</span>	
			</c:forEach>
		</div>
	</div>
	<c:import url="myfooter.jsp"></c:import>
</body>
</html>