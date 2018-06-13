<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

<!--  copied from links in the bootstrap folder -->

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/dataTables.bootstrap.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/dataTables.bootstrap.js"></script>

<title>Home</title>
</head>
<body>
	<!-- Start navbar -->
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="index.jsp">Index</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="upload">Upload</a></li>
					<li><a href="email">Contact</a></li>
					<li><a href="gallery">Gallery</a></li>
					<li><a href="student">StudentForm</a></li>
					<li><a href="#">Profile</a></li>
					<li class="active"><a
						href="${pageContext.request.contextPath}/logout">Logout<span
							class="sr-only">(current)</span></a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- End navbar -->
	<h1>Hala Madrid!!!!!!</h1>

	<P>The time on the server is ${serverTime}.</P>

	<table id="myTable" class="table table-stripted">
		<thead>
			<tr class="success">
				<td>First Name</td>
				<td>Last Name</td>
				<td>College</td>
				<td>Faculty</td>
				<td>Actions</td>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="student" items="${slist }">
				<tr class="danger">
					<td>${student.fname }</td>
					<td>${student.lname }</td>
					<td>${student.college }</td>
					<td>${student.faculty }</td>
					<td>
						<button class="btn btn-success" onclick = "editStudent(${student.id})">Edit</button>
						<button class="btn btn-danger" onclick = "deleteStudent(${student.id})">Delete</button>
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>


	<script type="text/javascript">

		function editStudent(id){
			
			window.location = "${pageContext.request.contextPath}/"+id+"/edit";
			
		}
		
		
		function deleteStudent(id){
			
			var msg = confirm("Do you want ato delete the data ?");
			
			if(msg == true){
				window.location = "${pageContext.request.contextPath}/"+id+"/delete";
			}
			
		}
	
	
	$(document).ready( function () { 
		$('#myTable').DataTable(); } );

	</script>

</body>
</html>
