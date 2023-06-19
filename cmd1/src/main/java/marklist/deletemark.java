package marklist;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deletemark
 */
@WebServlet("/deletemark")
public class deletemark extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DB_URL = "jdbc:mysql://localhost:3306/cmd_1";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    public deletemark() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String n=request.getParameter("id"); 
				System.out.println(n);
				response.setContentType("text/html");
		        PrintWriter out=response.getWriter();
		        try {
		        	Class.forName("com.mysql.jdbc.Driver");  
		            Connection con=DriverManager.getConnection( DB_URL, DB_USER, DB_PASSWORD);
		            Statement stmt = con.createStatement();
		            int rowsDeleted = stmt.executeUpdate("delete from marklist where id='"+n+"'");
			
		            response.sendRedirect("getmarklistofall");
			}catch (Exception e) {
				System.out.println(e);
			}

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
