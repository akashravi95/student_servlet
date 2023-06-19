package Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/studentloginconnection")
public class studentloginconnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DB_URL = "jdbc:mysql://localhost:3306/cmd_1";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    int flag=0;
    public studentloginconnection() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("name1");
        String password = request.getParameter("pass2");
System.out.println(username);
System.out.println(password);
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection( DB_URL, DB_USER, DB_PASSWORD);
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT id FROM student_list WHERE adm_id = '"+username+"' AND DOB = '"+password+"'");  
        while(rs.next())
        {

			flag=rs.getInt("id");
		System.out.println(flag);
		}
       
		if(flag>0)
		{
			  HttpSession session=request.getSession();  
		        session.setAttribute("id",flag);
			response.sendRedirect("studentloginprofile");
            } else {
            	
                request.setAttribute("errorMessage", "Invalid username or password");
                RequestDispatcher dispatcher = request.getRequestDispatcher("home.html");
                dispatcher.forward(request, response);
            }
		
        } 
        catch (Exception e) {
        	System.out.println(e);
		
		}
		
	}

}
