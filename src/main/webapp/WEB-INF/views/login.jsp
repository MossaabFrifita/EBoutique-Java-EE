<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-commerce</title>
</head>
<body>
<form action="j_spring_security_check" method="POST">
	<table>
		<tr>
			<td>LOGIN :</td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>PASSWORD :</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td><input type="submit" value="LOG IN"></td>
		</tr>			
	</table>
</form>
</body>
</html>