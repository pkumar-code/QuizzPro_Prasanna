<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/mycss/viewQuestions.css" rel="stylesheet">
<link href=" webjars/bootstrap/5.3.3/css/bootstrap.min.css"
	rel="stylesheet" />
<title>QuizzPro</title>
</head>
<body>
	<div class="container" style="padding-top:20px; ">
		<form action="/showQuestions">
			<table class="table table-striped table-bordered table-light ">
				<tr>
					<td align="center">
					<select name="course"   class="form-control mytext">
					<option >Select Course</option>
							<c:forEach var="course" items="${COURSES}">
								<option    value="${course.key}">
									<c:out value="${course.value}" />
								</option>	
							</c:forEach>
					</select></td> 
					<td align="center">
					<select name="topic"   class="form-control">
					<option>Select Topic</option>
							<c:forEach var="topic" items="${TOPICS}">
								<option   value="${topic.key}">
									<c:out value="${topic.value}" />
								</option>				
							</c:forEach>
					</select></td>
					<td>
					<input class="btn btn-primary" type="submit"value="Show Books " />
					</td>
				</tr>
			</table>
		</form>
	</div>
<br/>
	<div class="container">
	<h3 align="right">${FROM } to ${TO } of ${TotalQuestions}</h3>
		<table class="table table-striped table-bordered table-hover"
			style="font-size: 20px; font-weight: bold;">
			<tr>
				<th>Question ID</th>
				<th>Question</th>
				<th>CorrectAnswer</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="questions" items="${ALLQUESTIONS}">
				<tr>
					<td>${questions.question_Id }</td>
					<td>${questions.question}</td>
					<td>${questions.correct_Answer }</td>
					
					<td><form:form action="viewQuestion?questionId=${questions.question_Id }"
							method="get">
							<input type="hidden" name="questionId" value="${questions.question_Id}" />
							<input type="submit" value="fullView" class="btn btn-success  btn-lg" />
						</form:form></td>
					
					<td><form:form action="editquestion?questionId=${questions.question_Id }" method="get">
							<input type="hidden" name="questionId" value="${questions.question_Id }" />
							<input type="submit" value="Edit" class="btn btn-primary  btn-lg" />
						</form:form></td>

					<td><form:form action="deleteQuestion?questionId=${questions.question_Id}"
							method="get">
							<input type="hidden" name="questionId" value="${questions.question_Id }" />
							<input type="submit" value="Delete" class="btn btn-success  btn-lg" />
						</form:form></td>
				</tr>
			</c:forEach>
		</table>
		<h3 align="center">
			<c:if test="${ShowPrevious eq 'TRUE' }">
				<a href="previousLeads">Previous</a>
			</c:if>
			&nbsp;&nbsp;
			<c:if test="${ShowNext eq 'TRUE' }">
				<a href="nextLeads">Next</a>
			</c:if>
		</h3>
	</div>
	
</body>
</html>