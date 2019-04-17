<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="books?action=login"> ${error }
		<table cellpadding="2" cellspacing="2">
			<h1>BiblioTech<br>//Logga in</h1>
			<tr>
				<td><input type="text" name="userID" placeholder="Användar ID"></td>
			</tr>
			<tr>
				<td><input type="password" name="userPassword" placeholder="Lösenord"></td>
			</tr>
			<tr>
				
				<td><a href="books?action=index"> <button>Logga in</button></a></td>
				
			</tr>
		</table>
	</form>
</body>
</html>