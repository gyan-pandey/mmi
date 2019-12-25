<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h1>Edit Employee</h1>
	<form method="get" action="save"> <!-- /TestMe/editemp/save -->
		<table>
			<c:forEach items="${employeeDetailsList}" var="employeeDetails">
				<tr>
					<td>Id :</td>
					<td><input type="text" name="id" value="${employeeDetails.id}" /></td>
				</tr>
				<tr>
					<td>Name :</td>
					<td><input type="text" name="name"
						value="${employeeDetails.name}" /></td>
				</tr>
				<tr>
					<td>Salary :</td>
					<td><input type="text" name="salary"
						value="${employeeDetails.salary}" /></td>
				</tr>
				<tr>
					<td>Designation :</td>
					<td><input type="text" name="designation"
						value="${employeeDetails.designation}" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="submit" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>