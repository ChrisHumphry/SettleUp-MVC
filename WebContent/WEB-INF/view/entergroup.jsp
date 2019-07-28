<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/ShowGroups">
		Enter group : <input type = "text", name = "gName"/>
			<input type = "submit" value = "Go"/>
	</form>
		<form action="/AddTransaction">
		Enter group : <input type = "text", name = "amount"/>
			<input type = "submit" value = "Go"/>
	</form>
</body>
</html>