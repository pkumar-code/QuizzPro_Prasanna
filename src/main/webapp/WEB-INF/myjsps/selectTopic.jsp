<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE  html>
<html>
<head>
<link rel="stylesheet" href="/mycss/selectTopic.css" />
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
		<span class="topic">
			<b>${ COUNAME} - </b> practice test are available in the following 
			        select the topic to take a practice Test  
			</span>
		</div>	
		<br/>
		<div class="container-fluid">
			<c:forEach var = "topic"  items="${TOPICS}"> 
			<span class="topic">
			<a href="/startTest?topicId=${topic.key}&topicName=${topic.value} " >
			<c:out value="${topic.value}" ></c:out>
			</a> 
			</span>
			</c:forEach>
		</div>
	</div>
	<c:import url="myfooter.jsp"></c:import>
</body>
</html>