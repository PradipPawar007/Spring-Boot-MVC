<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>PRODUCT-INFO</h2>
<p>
   <font color="green">${msg}</font>
</p>
<form:form action="save" modelAttribute="product" method="POST">
<table>
<tr>
    <td>Name:</td>
    <td><form:input type="text"  path="name"/></td>
</tr>
<tr>
    <td>Price:</td>
    <td><form:input type="number"  path="price"/></td>
</tr>
<tr>
    <td>Quantity:</td>
    <td><form:input type="number"  path="qty"/></td>
</tr>

<tr>
    <td><input type="submit" value="Save"></td>
</tr>

</table>
</form:form>
<a href="products">View Products</a>
</body>
</html>