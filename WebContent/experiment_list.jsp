<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Experiment List</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>
				<form action="ExperimentController">
					<input type="submit" name="btn_new" value="New">
				</form>
			</th>
			<th>Id</th>
			<th>Title</th>
			<th>Description</th>
			<th>Creation Date</th>
			<th>Modification Date</th>
		</tr>
			<c:forEach var="experiment" items="${experiments}">
				<tr>
					<td>
						<form action="ExperimentController">
							<input type="hidden" name="id" value="${experiment.id}">
							<input type="submit" name="btn_edit" value="Edit">
							<input type="submit" name="btn_delete" value="Delete">
						</form>
					</td>
					<td>${experiment.id}</td>
					<td>${experiment.title}</td>
					<td>${experiment.description}</td>
					<td>${experiment.creationDate}</td>
					<td>${experiment.modificationDate}</td>	
				</tr>
			</c:forEach>
	</table>
</body>
</html>