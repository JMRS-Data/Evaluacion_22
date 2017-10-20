<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Experiment Form</title>
</head>
<body>
	<form action="ExperimentController">
		<label>Title:</label><br />
		<input type="text" name="title" value="${experiment.title}" /><br /><br />
		<label>Description:</label><br />
		<input type="text" name="description" value="${experiment.description}" /><br /><br />
		<label>Creation Date:</label><br />
		<input type="text" name="creationDate" value="${experiment.creationDate}" /><br /><br />
		<label>Modification Date:</label><br />
		<input type="text" name="modificationDate" value="${experiment.modificationDate}" /><br /><br />
		<input type="submit" name="btn_save" value="Save">
	</form>
</body>
</html>