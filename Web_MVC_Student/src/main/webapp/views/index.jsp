<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<!--To get below lib we need to press Ctrl + (press 2 time)space then select
 (taglib directive) then select http://www.springframework.org/tags/form -->
 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Student Enquiry Form</h2>
<p> 
    <font color="green"> ${msg}</font>
</p>
<!-- action use when we submit the data after what should happen it well tell that  -->
<!-- modelAttribute use to map our java class to Form  -->
<!-- method use to which method we want pass the data  -->

<form:form action="save" modelAttribute="student" method="POST">

<table>
	<tr>
	    <td>Name:</td>
	    <td><form:input path="name"/></td> <!-- Using above path we are binding the form filed to Java filed ex name,id,rollno -->
	<tr>
	<tr>
	    <td>Email:</td>
	    <td><form:input path="email"/></td>
	<tr>
	<tr>
	    <td>Gender:</td>
	    <td>
		    <form:radiobutton path="gender" value ="Male" />Male
		    <form:radiobutton path="gender" value ="Female" />Fe-Male
       </td>
	<tr>
	<%-- The below courses filed is for Hard coded value in newxt filed im loading cousers from service class--%>
	<%-- <tr>
	    <td>Courses:</td>
	    <td>
	    <form:select path="course">
	        <form:option value="">-Select-</form:option>
	        <form:option value="Java">Java</form:option>
	        <form:option value="python">Python</form:option>
	        <form:option value="devpps">DevOps</form:option>   
	        <form:option value="dotnet">Dot-Net</form:option>	        
	    </form:select>
	    </td>
	<tr> --%>
	<tr>
				<td>Course</td>
				<td><form:select path="course">
						<form:option value="">-Select-</form:option>
						<form:options items="${courses}" />
					</form:select></td>
	</tr>

<!--This also hard coded values now we are taking from Service classs-->

	<%-- <tr>
	    <td>Timings:</td>
	    <td>
	    <form:checkbox path="timings" value="mrng"/>Morning
	    <form:checkbox path="timings" value="noon"/>Afternoon
	    <form:checkbox path="timings" value="evening"/>Evening
	    </td>
	<tr> --%>
	<tr>
				<td>Timings</td>
				<td><form:checkboxes items="${prefTimings}" path="timings" /></td>
   </tr>
	
	<tr>
	    <td></td>
	    <td><input type ="submit" value="Save"/></td>
	</tr>
</table>
  

</form:form>
</body>
</html>