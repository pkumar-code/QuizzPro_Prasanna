<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
<div class="container" style="padding-top:40px;">
	<table class="table table-striped table-bordered table-hover"
		style="font-size: 20px; font-weight: bold;">
		<tr>
			<td align="center" colspan="3">Question Details</td>
		</tr>
		<tr>
			<td>Course_Id</td>
			<td>${Question.question_Id }</td>
		</tr>
		
		<tr>
			<td>CourseName</td>
			<td>${COUNAME}</td>
		</tr>

		<tr>
			<td>TopicName</td>
			<td>${TOPICNAME }</td>
		</tr>
		<tr>
			<td>Question </td>
			<td>${Question.question}</td>
		</tr>
		<tr>
			<td>Question A</td>
			<td>${LIST[0]}</td>
		</tr>
		<tr>
			<td>Question B</td>
			<td>${LIST[1]}</td>
		</tr>
		<tr>
			<td>Question C</td>
			<td>${LIST[2]}</td>
		</tr>
		<tr>
			<td>Question D </td>
			<td>${LIST[3]}</td>
		</tr>
		<tr>
			<td>Correct Answer</td>
			<td>${Question.correct_Answer}</td>
		</tr>		
		<tr  >
			<td colspan="2" align="center">
			<form:form action="editquestion?questionId=${Question.question_Id}" method="get">
							<input type="hidden" name="questionId" value="${Question.question_Id }" />
							<input type="submit" value="GoEdit" class="btn btn-success  btn-lg" />
			</form:form></td>
		</tr>
	</table>
</div>
</body>
</html>