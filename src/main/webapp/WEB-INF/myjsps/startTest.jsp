<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE  html>
<html>
<head>
<link rel="stylesheet" href="/mycss/startTest.css" />
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
		<br />
		<div class="box">
			<h2>You are ready to take the practice test</h2>

			<div class="details">
				Course: <span>${COUNAME }</span>
			</div>
			<div class="details">
				Topic: <span> ${TOPICNAME}</span>
			</div>

			<div class="instructions">		
				<p>Please read the following instructions carefully before
					starting the quiz:</p>
					The test contains <b>10
					questions</b>
				<ul>
					<li>You will have <strong>10 minutes</strong> to complete the quiz.
					</li>
					<li>The quiz contains <strong>10 multiple-choice
							questions</strong>.
					</li>
					<li>Each question carries <strong>1 mark</strong>. No negative
						marking.
					</li>
					<li>You can go back to a previous question once you move
						forward.</li>
					<li>Click the <strong>Submit</strong> button at the end to see
						your score.
					</li>
					<li>Do not refresh or close the browser window during the
						quiz.</li>
				</ul>

			</div>

			<a href="/questionsPage?topicId=${TOPICID }" class="start-button" >Start Test</a>
		</div>
	</div>
	<c:import url="myfooter.jsp"></c:import>
</body>
</html>