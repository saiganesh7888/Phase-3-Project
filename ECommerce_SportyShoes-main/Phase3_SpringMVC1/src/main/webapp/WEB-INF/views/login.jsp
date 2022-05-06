<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login User</title>
</head>
<body>

	<!-- <jsp:include page="../../index.jsp"></jsp:include> -->
	<div align="center" style="border: 2px solid green; padding: 10px;">
		<h1>Login User</h1>
		<form:form action="loginProcess" method="post" modelAttribute="login">
			<table border="0">
				<tr>
					<td>User ID:</td>
					<td><form:input path="id" /></td>
				</tr>

				<tr>
					<td>User Name:</td>
					<td><form:input path="name" /></td>
				</tr>
				
				<tr>
					<td>User Password:</td>
					<td><form:input path="password" /></td>
				</tr>

				<tr>
					<td>Submit</td>
					<td><input type="submit" value="Login" /></td>
				</tr>

			</table>

		</form:form>
	</div>
</body>
</html>