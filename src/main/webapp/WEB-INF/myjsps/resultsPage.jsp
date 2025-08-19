<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE  html>
<html>
<head>
<link rel="stylesheet" href="/mycss/resultPage.css" />
<link href=" webjars/bootstrap/5.3.3/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" />
<title>QuizzPro</title>
</head>
<body>
	<div class=" home" >
	<div >
		<nav class="navbar navbar-light rounded  text-bg-success p-3">
			<div class="container-fluid">
				<span> <img src="#" alt="logo">
				</span> <span class="navbar-text"> <b>Student DashBorad</b>
				</span> <span> Welcome to : ${USER.full_Name} || <a href="/logout">logout</a>
				</span>
			</div>
		</nav>
		<br />
		</div>
		<div>
		<h2 style="text-align: left;">Result of Practice Test : ${score} / ${SIZE}</h2>
		<hr/>
		<table>
			<tr>
				<th>QusId</th>
				<th>Question</th>
				<th>CorrectAnswer</th>
				<th>YourAnswer</th>
				<th>Status</th>
			</tr>
			<c:forEach var="list" items="${LIST}">
				<tr>
					<td> ${list.qid}</td>
					<td>${list.question}</td>
					<td>${list.correctAnswer}</td>
					<td>${list.yourAnswer}</td>
					<td class="${list.status == 'Correct' ? 'Correct' : 'Wrong'}">${list.status}</td>
				</tr>
			</c:forEach>
		</table>
		</div>
		<div class="btn">
				<a href="/topic?couId=${COUID }&couName=${COUNAME }" >Take Another Test</a>
	</div>
	</div>
	<c:import url="myfooter.jsp"></c:import>
</body>
</html>
