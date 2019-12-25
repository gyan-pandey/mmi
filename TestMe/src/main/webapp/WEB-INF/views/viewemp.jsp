<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2 align="center">
	<font><strong>Employees</strong></font>
</h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">

	<tr>
		<td><b>id</b></td>
		<td><b>name</b></td>
		<td><b>salary</b></td>
		<td><b>designation</b></td>
		<td><b>editemp</b></td>
		<td><b>deleteemp</b></td>

	</tr>
	<c:forEach items="${employeeDetailsList}" var="employeesDetails">

		<tr>
			<td>${employeesDetails.id}</td>
			<td>${employeesDetails.name}</td>
			<td>${employeesDetails.salary}</td>
			<td>${employeesDetails.designation}</td>
			<td><a href="/TestMe/editemp/${employeesDetails.id}">Edit</a></td>
			<td><a href="/TestMe/deleteemp/${employeesDetails.id}">Delete</a></td>

		</tr>
	</c:forEach>
</table>

<pre align="center" cellpadding="5" cellspacing="5" border="1">
	<b> <a href="/TestMe/addEmployee">Add New Employee</a>     <a
		href="/TestMe/viewemp">View All Employee</a> </b>
</pre>