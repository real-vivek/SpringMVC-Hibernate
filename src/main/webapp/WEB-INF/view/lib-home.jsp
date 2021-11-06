<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>Library</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>LMS - Library Management System</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!-- put new button: Add Book -->

			<input type="button" value="Add Book"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<!--  add our html table here -->

			<table>
				<tr>
					<th>Book Id</th>
					<th>Book Name</th>
					<th>Category</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="book" items="${books}">

					<tr>
						<td>${book.bookId}</td>
						<td>${book.bookName}</td>
						<td>${book.bookCategory}</td>
						<td><input type="button" value="Update Book"
							onclick="window.location.href='showFormForUpdate?bookId=${book.bookId}'; return false;"
							class="add-button" /></td>
						<td><input type="button" value="Delete Book"
							onclick="window.location.href='deleteBook?bookId=${book.bookId}'; return false;"
							class="add-button" /></td>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>


</body>

</html>