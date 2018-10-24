<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
${errorMessage}
</div>
<form action="/LoanForm/pages/request" method="post">
<table>
<tr>
<td> FirstName:</td>
<td><input type="text" name="firstName"></td>
</tr>
<tr>
<td> LastName:</td>
<td><input type="text" name="lastName"></td>
</tr>
<tr>
<td> Address:</td>
<td><input type="text" name="address"></td>
</tr>
<tr>
<td> country:</td>
<td><select name="country"><option value="country">country</option></select></td>
</tr>
<tr>
<td> rent/own:</td>
<td><select name="rent"><option value="rent">rent</option>
<option value="own">own</option></select></td>
</tr>
<tr>
<td> MonthlyRent:</td>
<td><input type="number" name="monthlyRent"></td>
</tr>
<tr>
<td colspan="1" align="center"><input type="submit"> </td>
</tr>
</table>
</form>
</body>
</html>