<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>Save Book</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-book-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>LMS - Library Management System</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save/Update Book</h3>

		<form:form action="saveBook" modelAttribute="book" method="POST">

			<form:hidden path="bookId" />

			<table>
				<tbody>
					<tr>
						<td><label>Book name:</label></td>
						<td><form:input path="bookName" /></td>
					</tr>

					<tr>
						<td><label>Book Category:</label></td>
						<td><form:input path="bookCategory" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>


				</tbody>
			</table>


		</form:form>

		<div style=""></div>

		<p>
			<a href="${pageContext.request.contextPath}">Back to List</a>
		</p>

	</div>

</body>

</html>