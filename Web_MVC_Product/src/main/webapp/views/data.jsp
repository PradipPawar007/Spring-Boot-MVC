<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 --%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Frank's App</title>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
</head>
<body>
    <a href="/">+ Add New Product</a>
	<table border="1">
		<thead>
		    <tr>
		        <th>SR.No</th>
		        <th>Product Name</th>
		        <th>Product Price</th>
		        <th>Quantity</th>
		    </tr>
     </thead>
		<tbody>
              <c:forEach items="${products}" var="product" varStatus="index">
                     <tr>
                         <td>${index.count}</td>
                         <td>${product.name}</td>
                         <td>${product.price}</td>
                         <td>${product.qty}</td>
                     </tr>
             </c:forEach> 
		</tbody>
	</table>
</body>
</html>