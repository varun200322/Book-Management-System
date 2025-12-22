<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Management System</title>
</head>
	<title>Book Management System</title>
	<meta name = "viewport" content = "width=device-width, intital-scale=1"/>
	<link href = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel = "stylesheet">
	<script src = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
<body>
	<%@page import = "com.book.dao.BookDao" %>
	<jsp:useBean id= "book" class = "com.book.entity.Book" scope = "session"/>
	<jsp:setProperty name = "book" property = "*"/>
	<div class = "container mt-3">
		<%
			BookDao.saveBook(book);
		    out.println("<p class=\"h4 text-success\">Book Added Successfully</p>");
		%>
		<ul class = "nav">
			<li class = "nav-item">
				<a class = "nav-link" href = "addBook.jsp">Add New Book</a>
				
			</li>
		</ul>
	</div>
</body>
</html>