<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/mycss/addquestion.css" />
<link href=" webjars/bootstrap/5.3.3/css/bootstrap.min.css"
	rel="stylesheet" />
<title>QuizzPro</title>
</head>
<body>
	<div>
		<div style="padding-left: 200px;">
			<h1>Add Question</h1>
		</div>
		<form:form action="/addquestion" method="post" modelAttribute="question">
			<table>
				<tr>
					<td>Courses</td>
					<td>
					<select name="course" class="form-control form-control-lg">
					<option>--------------------SelectCourse--------------------</option>
					 <c:forEach var="course" items="${COURSES }">
					    <option value="${course.key}">					
					               <c:out value="${course.value }"/>  
					    </option>
					 </c:forEach>
					</select>					
					</td>
				</tr>
				<tr>
					<td>Topics</td>
					<td>
					<select name="topic" class="form-control form-control-lg">
						<option>--------------------SelectTopic----------------------</option>
					 <c:forEach var="topic" items="${TOPICS }">
					    <option value="${topic.key }">
					               <c:out value="${topic.value }"/>  
					    </option>
					 </c:forEach>
					</select>
					</td>
				</tr>
				<tr>
				<tr>
					<td>Question</td>
					<td><textarea name="question" id="question" rows="5" cols="50"></textarea></td>
				</tr>

				<tr>
					<td>Option A :</td>
					<td><textarea name="optA" id="optA"></textarea></td>
				</tr>

				<tr>
					<td>Option B :</td>
					<td><textarea name="optB" id="optB"></textarea></td>
				</tr>

				<tr>
					<td>Option C :</td>
					<td><textarea name="optC" id="optC"></textarea></td>
				</tr>
				<tr>
					<td>Option D :</td>
					<td><textarea name="optD" id="optD"></textarea></td>
				</tr>
				<tr>
					<td>Correct Answer :</td>
					<td><textarea name="correct" id="correct"></textarea></td>
				</tr>
				<tr>
					<td class="text-center" colspan="2">
					<input type="submit"
						value="Add Question" class="btn btn-primary btn-lg" /></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>