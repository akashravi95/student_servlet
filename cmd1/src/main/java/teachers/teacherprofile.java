package teachers;

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

/**
 * Servlet implementation class teacherprofile
 */
@WebServlet("/teacherprofile")
public class teacherprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DB_URL = "jdbc:mysql://localhost:3306/cmd_1";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    public teacherprofile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username1 = request.getParameter("u1");
        String password = request.getParameter("u2");
        
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection( DB_URL, DB_USER, DB_PASSWORD);
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM teachers_list WHERE username= '"+username1+"' AND password = '"+password+"'");  
        
       
            
          
          
            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("id", rs.getInt("id"));
                response.sendRedirect("teachersprofile");
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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
