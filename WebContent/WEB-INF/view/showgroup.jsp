<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>User</th>
<th>Owes</th>
<th>Owed</th>
</tr>

<ps:forEach items="${OO}" var="owesOwed">
<tr>
	<td>${owesOwed.name}</td>
	<td>${owesOwed.owes}</td>
	<td>${owesOwed.owed}</td>
	</tr>
</ps:forEach>
</table>

<table>
<tr>
<th>Amount</th>
<th>Paid by</th>
</tr>

<ps:forEach items="${Trans}" var="trans">
<tr>
	<td>${trans.amount}</td>
	<td>${trans.paidBy}</td>
	</tr>
</ps:forEach>
</table>

</body>
</html>