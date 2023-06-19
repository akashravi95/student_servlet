package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DB_URL = "jdbc:mysql://localhost:3306/cmd_1";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
//    private static final String LOGIN_QUERY = "SELECT * FROM admin WHERE user_id = AND password = ?";
  
    public login() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("var1");
        String password = request.getParameter("var2");
        
        try
        {Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection( DB_URL, DB_USER, DB_PASSWORD);
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM admin WHERE user_id = '"+username+"' AND password = '"+password+"'");  
        
       
            
          
          
            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("Adminprofile");
            } else {
                request.setAttribute("errorMessage", "Invalid username or password");
                RequestDispatcher dispatcher = request.getRequestDispatcher("home.html");
                dispatcher.forward(request, response);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
