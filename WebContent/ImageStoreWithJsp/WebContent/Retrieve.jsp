<%@ page language="java" pageEncoding="ISO-8859-1" import="java.sql.*,com.impetus.*,java.io.*"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<%!OutputStream o=null; %>
<%

Connection con=Database.getConnection();
PreparedStatement ps=con.prepareStatement("select file_name from upload_data");
ResultSet rs=ps.executeQuery();
String path="";

while(rs.next())
{
		path=rs.getString("file_name");%>
		<center><img src="<%="http://localhost:8080/ImageStoreWithJsp/test/"+path %>" height="120" width="120"/></center>

	<% 	System.out.println(path);
				

}
ps.close();
con.close();
 



%>







</body>
</html>