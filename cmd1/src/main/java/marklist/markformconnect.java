package marklist;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class markformconnect
 */
@WebServlet("/markformconnect")
public class markformconnect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public markformconnect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		get printwirter
			PrintWriter pw=response.getWriter();
//			set content type
			response.setContentType("text/html");
//			read the valves
	
		String Name =request.getParameter("Name");
		String English =request.getParameter("English");
		String hindi =request.getParameter("hindi");
		String admission =request.getParameter("admission");
		String malayalam =request.getParameter("malayalam");
		 try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cmd_1", "root", "root");
	            
	            PreparedStatement statement = conn.prepareStatement("INSERT INTO marklist (malayalam,english,hindi,name,adm_id) VALUES ('"+malayalam+"','"+English+"','"+hindi+"','"+Name+"','"+admission+"')");
	         int rowCount= statement.executeUpdate();
	         response.sendRedirect("getmarklistofall");
	        } catch (Exception e) {
	        	e.printStackTrace();
	        } 
		
		
	}

}
