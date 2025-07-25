<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="card-header" style="padding-top:30px">
		<h1 class="text-center"> Edit Question Form</h1>
	</div>
	<br>
	<div align="center" class="container">
		<form:form action="saveUpdate" method="post">
			<table class="table" style="font-size: 20px; font-weigth: bold;">
				<tr>
					<td>QuestionId</td>
					<td><input type="text" name="questionId" value="${Question.question_Id }"disabled
						class="formpcontrol form-control-lg" /></td>
				</tr>

				<tr>
					<td>CourseName</td>
					<td>
					<input type="text" name="course" value="${COUNAME}" disabled
						class="formpcontrol form-control-lg" /></td>
				</tr>
				<tr>
					<td>TopicName</td>
					<td>

					<input type="text" name="topic" value="${TOPICNAME }" disabled
						class="formpcontrol form-control-lg" /></td>
				</tr>

				<tr>
					<td>Question</td>
					<td><input type="text" name="question"
						value="${Question.question}"
						class="formpcontrol form-control-lg" /></td>
				</tr>
				<tr>
					<td>Option A</td>
					<td><input type="text" name="optA"
						value="${LIST[0]}"
						class="formpcontrol form-control-lg" /></td>
				</tr>
				<tr>
					<td>Option B</td>
					<td><input type="text" name="optB"
						value="${LIST[1]}"
						class="formpcontrol form-control-lg" /></td>
				</tr>
				<tr>
					<td>Option C</td>
					<td><input type="text" name="optC"
						value="${LIST[2]}"
						class="formpcontrol form-control-lg" /></td>
				</tr>
				<tr>
					<td>Option D</td>
					<td><input type="text" name="optD"
						value="${LIST[3]}"
						class="formpcontrol form-control-lg" /></td>
				</tr>

				<tr>
					<td>Correct Answer</td>
					<td><input type="text" name="correct"
						value="${Question.correct_Answer}" class="formpcontrol form-control-lg" /></td>
				</tr>
				<tr>
					<td align="center" colspan="3">
					    <input type="hidden" name="topic" value="${TOPICNAME}" />
					     <input type="hidden" name="course" value="${COUNAME }" />
					      <input type="hidden" name="questionId" value="${Question.question_Id }" />
							<input type="submit" value="Update" class="btn btn-primary btn-lg" />
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>