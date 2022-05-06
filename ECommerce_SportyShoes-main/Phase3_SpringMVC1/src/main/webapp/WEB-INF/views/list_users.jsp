<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Users</title>
</head>
<style>
	table, th, td , tr{
		border: 2px solid red;
		padding:10px;
	}
</style>
<body>
	<!-- <jsp:include page="../../index.jsp"></jsp:include> -->

	<h1>List all Users</h1>
	<table>
		<thead>
			<tr>
				<th>User Id</th>
				<th>Product Name</th>
				<th>Product Password</th>
			
			</tr>
		</thead>
		<tbody>
			<core:forEach var="user" items="${list}">
				<tr>
					<td>${user.getId()}</td>
					<td>${user.getName()}</td>
					<td>${user.getPassword()}</td>
					
				</tr>
			</core:forEach>

		</tbody>
	</table>

</body>
</html>