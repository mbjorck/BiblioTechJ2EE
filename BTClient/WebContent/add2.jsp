<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="books?action=add2">
		<table cellpadding="2" cellspacing="2">
			<tr>
				<td>ISBN</td>
				<td><input type="text" name="bookISBN" value="<%=request.getParameter("isbn")%>"></td>
			</tr>
			<tr>
				<td>CopyNbr</td>
				<td><input type="text" name="bookCopy" value="<%=request.getParameter("copyNbr")%>"></td>
			</tr>
			<tr>
				<td>UserID</td>
				<td><input type="text" name="userID" value="1"></td>
			</tr>
			<tr>
				<td>LoanDate</td>
				<td><input type="text" name="loanDate" placeholder="Dagens datum"></td>
			</tr>
			<tr>
				<td>ExpiryDate</td>
				<td><input type="text" name="expiryDate"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form>

</body>
</html>