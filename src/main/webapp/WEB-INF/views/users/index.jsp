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
		<div class="d-flex justify-content-between">
			<h3>User List</h3>
			<div>
				<c:url var="searchAction" value="/users/search" />
				<form action="${searchAction}" method="GET" class="d-flex">
					<input type="text" name="keyword" class="form-control"
						placeholder="Search....." />
					<button type="submit" class="btn btn-success ml-3">Search</button>
				</form>
			</div>
			<c:url var="createAction" value="/users/create" />
			<a class="inline-block btn btn-primary" href="${createAction}">Add
				New</a>
		</div>
		<table class="table table-bordered table-striped pt-5">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Roles</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>
						<c:forEach items="${user.roles}" var="role" >
							${role}
						</c:forEach>
					</td>
					<td><c:url var="editAction" value="/users/edit?id=${user.id}" />
						<c:url var="deleteAction" value="/users/destroy?id=${user.id}" />
						<a class="btn btn-info" href="${editAction }">Edit</a> <a
						class="btn btn-danger" href="${deleteAction}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>