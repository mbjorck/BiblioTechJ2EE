<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<a href="books?action=login">Logga in</a> ${error }
	<a href="books?action=add">Add Book</a> ${error }

	<a href="books?action=add2">Add Loan</a> ${error }
	<p>Books</p>
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>ISBN</th>
			<th>Title</th>
			<th>BookCopy</th>

			<th>Author</th>
			<th>Option</th>
		</tr>
		<c:forEach var="book" items="${listBooks}">
			<tr>
				<td>${book.id.isbn}</td>
				<td>${book.title}</td>
				<td>${book.id.copyNbr}</td>
				<td>${book.author.authorName}</td>
				
				<td><a href="books?action=delete&isbn=${book.id.isbn }&copyNbr=${book.id.copyNbr }"
					onclick="return confirm('Are you sure?')">Delete</a> | <a href="books?action=add2&isbn=${book.id.isbn }&copyNbr=${book.id.copyNbr }">Låna</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>Loans</p>
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>ISBN</th>
			<th>Copy</th>
			<th>UserID</th>
			<th>LoanDate</th>
			<th>ExpiryDate</th>
			<th>Option</th>
		</tr>

		<c:forEach var="loan" items="${listLoans}">
			<tr>
				<td>${loan.id.bookISBN}</td>
				<td>${loan.id.bookCopy}</td>
				<td>${loan.id.userID}</td>
				<td>${loan.loanDate}</td>
				<td>${loan.expiryDate}</td>
				<td><a href="books?action=returnBook&bookISBN=${loan.id.bookISBN}&bookCopy=${loan.id.bookCopy}&userID=${loan.id.userID}">Lämna tillbaka</a> | <a href="">Edit</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>