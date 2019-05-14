package com.impetus;



import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.impetus.Database;

/**
 * Servlet implementation class UploadData
 */

/*
 * 
 * create table upload_data(username varchar2(45),file_name varchar2(50),file_path varchar2(50));
 */
public class UploadData extends HttpServlet {
	
	private final String UPLOAD_DIR = "E:\\ManagementSystem\\ImageStoreWithJsp\\WebContent\\test";


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = "";
		if(ServletFileUpload.isMultipartContent(request))
		{
			try
			{
				List<FileItem> multiparts=new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				for(FileItem item:multiparts)
				{
				if(item.isFormField())
				{
					if(item.getFieldName().equals("user"))
						username=item.getString();
				}
				
				else
				{
					String name = new File(item.getName()).getName();
					System.out.println(name);
					item.write(new File(UPLOAD_DIR + File.separator+name));
					
					HttpSession session = request.getSession();
					addFileEntry(username, name, UPLOAD_DIR + File.separator+name);
					
					
				}
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('File uploaded successfully');");
				out.println("window.location.href='First.jsp';");
				out.println("</script>");
				}
				
				
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
				
			}
			
			
		}
	}
	public void addFileEntry(String user, String fileName,String filePath)
	{
		Connection con = Database.getConnection();
		try
		{
			PreparedStatement ps = con.prepareStatement("insert into upload_data(username,file_name,file_path) values(?,?,?)");
			ps.setString(1, user);
			ps.setString(2, fileName);
			ps.setString(3, filePath);
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
