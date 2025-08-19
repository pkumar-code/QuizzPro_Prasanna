<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
	import="java.util.*, com.quizz.pro.entity.Questions,com.quizz.pro.entity.QuestionOptions,com.quizz.pro.dto.QuestionDTO"%>

<%
		List<QuestionDTO> qdto =(List<QuestionDTO>) session.getAttribute("Questionsdto");
		Integer currentIndex = (Integer) session.getAttribute("currentIndex");
		if (currentIndex == null || qdto  == null || currentIndex >=qdto .size()) {
				response.sendRedirect("submit.jsp");
            return ;
		}
			QuestionDTO q = qdto .get(currentIndex);
			List<QuestionOptions> options=q.getOptions();
			List<String>list= new ArrayList<>();
			
			for(QuestionOptions op: options){
				list.add(op.getOption_data());
			}
			session.setAttribute("SIZE", qdto .size());
			session.setAttribute("LIST", list);
			
			%>
<!DOCTYPE  html>
<html>
<head>
<link rel="stylesheet" href="/mycss/testPage.css" />
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
		<div class="quizz-container">
		
			<div class="header">
				<h2>Practice Test - Course : ${COUNAME} || Topic : ${TOPICNAME}</h2>
				<div class="question-number">
					Question <span id="current"><%=currentIndex + 1%> </span> of <span
						id="total"><%=qdto.size()%></span> ||  <span id="timer">10:00</span>
				</div>
			</div>
			<form:form action="/next" method="post"  >
				<div class="question">
				<input type="hidden" value="<%=q.getQuestion()%>" name="question"/>
					<p >
						<strong>Q <%=q.getQid()%> :
						</strong>
						<%=q.getQuestion()%>
					</p>
				</div>
				<div class="options">
					<label> 
					<input type="radio" name="option" value="${LIST[0]}"> 
					<input type="checkbox" name="chkA" value="${LIST[0]}"> ${LIST[0]}
					</label> <label> 
						<input type="radio" name="option" value="${LIST[1]}">
						<input type="checkbox" name="chkB" value="${LIST[1]}"> ${LIST[1]}
					</label> <label> 
						<input type="radio" name="option" value="${LIST[2]}">
						<input type="checkbox" name="chkC" value="${LIST[2]}">  ${LIST[2]}
					</label> <label> 
						<input type="radio" name="option" value="${LIST[3]}"> 
						<input type="checkbox" name="chkD" value="${LIST[3]}">  ${LIST[3]}
					</label>
				</div>
				<div class="submit-btn">
				<c:choose>
				<c:when test="${currentIndex eq  SIZE -1 }">
					<input type="hidden" value="<%=q.getQid()%>" name="qid"/>
					<input type="submit" value="Submit" class="btn btn-primary  btn-lg" />
				</c:when>
				<c:otherwise>
				<input type="hidden" value="<%=q.getQid()%>" name="qid"/>
					<input type="submit" value="Next" class="btn btn-primary  btn-lg" />
				</c:otherwise>
				</c:choose>
				</div>
			</form:form>
		</div>
	</div>
	<c:import url="myfooter.jsp"></c:import>
	<script>
    // Starting time in seconds (10 minutes = 600 seconds)
    let timeLeft = 10 * 60;

    function updateTimer() {
      let minutes = Math.floor(timeLeft / 60);
      let seconds = timeLeft % 60;

      // Format as MM:SS
      let formattedTime = 
        (minutes < 10 ? "0" : "") + minutes + ":" + 
        (seconds < 10 ? "0" : "") + seconds;

      document.getElementById("timer").textContent = formattedTime;

      // Stop when timer reaches 0
      if (timeLeft <= 0) {
        clearInterval(timerInterval);
        document.getElementById("timer").textContent = "Time's up!";
      }

      timeLeft--;
    }

    // Update every second
    let timerInterval = setInterval(updateTimer, 1000);

    // Run immediately to avoid 1-second delay
    updateTimer();
  </script>
</body>
</html>
