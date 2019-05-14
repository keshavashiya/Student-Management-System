<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<form action="UploadData" method="post" enctype="multipart/form-data">
<table>
<tr>
<td>Username:</td>
<td> <input type="text" placeholder="Username" name="user" /></td>
</tr>

<tr>
<td>File: </td>
<td><input type="file" name="fileName" /> </td>
</tr>

<tr>
<td><input type="submit"value="Upload"  /></td>
<td><a href="Retrieve.jsp">click here </a></td>
</tr>
</table>


</form>
	
</body>
</html>