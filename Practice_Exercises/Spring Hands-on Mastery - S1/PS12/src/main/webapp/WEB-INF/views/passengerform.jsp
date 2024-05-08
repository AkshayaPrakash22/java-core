<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>

	<h1>Add New Passenger</h1>
	<form action="save" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input name="name" type="text" /></td>
			</tr>
			<tr>
				<td>Date of Birth:</td>
				<td><input name="dob" type="date" /></td>
			</tr>
			<tr>
				<td>Phone Number:</td>
				<td><input name="phoneno" type="text" /></td>
			</tr>
			<tr>
				<td>Email Id:</td>
				<td><input name="email" type="text" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>

		</table>
	</form>

</body>
</html>