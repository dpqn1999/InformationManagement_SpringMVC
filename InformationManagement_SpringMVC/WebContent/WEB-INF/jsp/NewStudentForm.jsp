<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Student</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<style type="text/css">
header {
	text-align: left;
	color: white;
	background-color: tomato;
	padding: 10px;
}

body {
	font-size: 14px;
	text-align: center;
}

h5 {
	margin: 0;
}

#list {
	color: white;
}

a:hover {
	text-decoration: none;
}

form {
	text-align: left;
	font-size: 15px;
}

input {
	width: 100%;
}

select {
	width: 100%;
	padding: 2px 0;
}

fieldset {
	padding-bottom: 5px;
}

.col-md-4 {
	margin-top: 20px !important;
}

#male {
	width: auto;
	margin-left: 80px;
}

#female {
	width: auto;
	margin-left: 80px;
}

.btn {
	width: 100%;
	margin-bottom: 2px;
}
</style>
</head>
<body>
	<header>
		<h5>
			<a id="list" href="/InformationManagement_SpringMVC/">INFORMATION
				MANAGEMENT PROJECT</a>
		</h5>
	</header>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4"
				style="border: 1px solid grey; margin-top: 50px;">
				<h3>New Student Information</h3>
				<form:form action="add" method="POST" modelAttribute="student">

					<form:label path="id">ID:</form:label>
					<form:input path="id" required="required" />


					<form:label path="name">Name:</form:label>
					<form:input path="name" required="required" />


					<form:label path="yearOfBirth">Year Of Birth:</form:label>
					<form:input path="yearOfBirth" required="required" />

					<form:label path="schoolYear">School Year:</form:label>
					<form:input path="schoolYear" required="required" />

					<form:label path="major">Major:</form:label>
					<form:select path="major" required="required">
						<form:option value="" />
						<form:options items="${majors}" />
					</form:select>

					<form:label path="phoneNumber">Phone Number:</form:label>
					<form:input path="phoneNumber" required="required" />


					<form:label path="email">E-mail:</form:label>
					<form:input path="email" required="required" />

					<form:label path="gender">Gender:</form:label>
					<form:radiobutton path="gender" value="Male" label="Male"
						required="required" />
					<form:radiobutton path="gender" value="Female" label="Female" />

					<input type="submit" value="ADD" class="btn btn-success">
				</form:form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
</body>
</html>