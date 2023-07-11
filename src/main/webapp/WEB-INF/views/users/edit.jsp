<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User list</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="../nav.jsp" />
	<div class="container py-5">
		<h1>User Edit</h1>
		<c:url var="updateAction" value="/users/update?id=${userForm.getId()}"></c:url>
		<form:form action="${updateAction}" method="POST" modelAttribute="userForm">
			<div class="mb-3">
				<label for="name" class="form-label">Name</label> 
				<form:input type="text" path="name" class="form-control" placeholder="Enter Name" />
				<form:errors path="name" cssClass="text-danger" />
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">Email</label> 
				<form:input type="email" path="email" class="form-control" placeholder="name@gmail.com" />
				<form:errors path="email" cssClass="text-danger" />
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password</label> 
				<form:input type="password" path="password" class="form-control" placeholder="********" />
				<form:errors path="password" cssClass="text-danger" />
			</div>
			<div class="mb-3">
				<button type="submit" class="btn btn-success">Update</button>
			</div>
		</form:form>
	</div>
</body>
</html>