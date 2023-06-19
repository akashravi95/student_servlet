package teachers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Teachersignupconnet
 */
@WebServlet("/Teachersignupconnet")
public class Teachersignupconnet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teachersignupconnet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String mail=request.getParameter("mail");
		String phone=request.getParameter("phone");
		String tech=request.getParameter("tech");
		String branch=request.getParameter("branch");
		String employid=request.getParameter("employid");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		 try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cmd_1", "root", "root");
	            
	            PreparedStatement statement = conn.prepareStatement("INSERT INTO teachers_list (T_id, name, phone, mailid, branch, employ_id,username,password) VALUES ('"+tech+"','"+name+"','"+phone+"','"+mail+"','"+branch+"','"+employid+"','"+username+"','"+password+"')");
	         int rowCount= statement.executeUpdate();
	         response.sendRedirect("teachersall");
	        } catch (Exception e) {
	        	e.printStackTrace();
	        } 
	     
		}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
