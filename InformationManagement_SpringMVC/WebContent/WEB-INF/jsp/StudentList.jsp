<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<style type="text/css">
body {
	font-size: 14px;
	text-align: center;
}

header {
	text-align: left;
	color: white;
	background-color: tomato;
	padding: 10px;
}

h5 {
	margin: 0;
}

h3 {
	padding-top: 10px;
	margin: 0
}

#add {
	float: left;
	margin-bottom: 10px;
}

.studentList {
	padding: 0 20px;
}

.class1 {
	list-style-type: none;
	padding: 0;
	float: right;
}

ul {
	padding: 0;
	margin: 0;
}

ul li {
	display: inline-block;
}

#list {
	color: white;
}

a:hover {
	text-decoration: none;
}

#search {
	float: left;
	margin-left: 5px;
}
</style>
</head>
<body>
	<header>
		<h5>
			<a id="list" href="/InformationManagement_SpringMVC/">INFORMATION MANAGEMENT PROJECT</a>
		</h5>
	</header>
	<h3>Student List</h3>
	<div class="studentList">
		<div>
			<a id="add" href="new" class="btn btn-success">Add Student</a> <a
				id="search" href="search" class="btn btn-success">Search
				Student</a>
		</div>
		<table class="table" border="1">
			<thead class="thead-light">
				<tr>
					<th scope="col">#</th>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">Year Of Birth</th>
					<th scope="col">Gender</th>
					<th scope="col">School Year</th>
					<th scope="col">Major</th>
					<th scope="col">Phone Number</th>
					<th scope="col">Email</th>
					<th scope="col">Function</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listStudent}" var="student">
					<tr>
						<th scope="row">${listStudent.indexOf(student) + 1}</th>
						<td>${student.id}</td>
						<td>${student.name}</td>
						<td>${student.yearOfBirth}</td>
						<td>${student.gender}</td>
						<td>${student.schoolYear}</td>
						<td>${student.major}</td>
						<td>${student.phoneNumber}</td>
						<td>${student.email}</td>
						<td><a href="edit?id=${student.id}">Edit</a> <a
							href="delete?id=${student.id}"
							onclick="if (confirm('Are you sure you want to delete this student?')) form.action='/Config?pg=FIBiller&amp;cmd=delete'; else return false;">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul class="class1">
			<li><a href="backup" class="btn btn-success">Backup</a></li>
			<li><a href="restore" class="btn btn-success">Restore</a></li>
		</ul>
	</div>
</body>
</html>