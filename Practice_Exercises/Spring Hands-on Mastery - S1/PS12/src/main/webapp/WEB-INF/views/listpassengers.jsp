<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bus Booking System</title>
</head>
<body>
<h1>Passenger List</h1>
<table border="1">
	<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>DATE OF BIRTH</th>
		<th>PHONE NO</th>
		<th>EMAIL ID</th>
	</tr>
	<c:forEach var="passenger" items="${passengers}">
	
		<tr>
		<td>${passenger.id}</td>
		<td>${passenger.name}</td>
		<td>${passenger.dob}</td>
		<td>${passenger.phoneno}</td>
		<td>${passenger.email}</td>
	</tr>
	
	</c:forEach>

</table>
<h4><a href="index.jsp">BACK</a></h4>

</body>
</html>