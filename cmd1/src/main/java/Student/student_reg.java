package Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class student_reg
 */
@WebServlet("/student_reg")
public class student_reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public student_reg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		   
		
//	get printwirter
		PrintWriter pw=res.getWriter();
//		set content type
		res.setContentType("text/html");
//		read the valves
		String adm=req.getParameter("adm");
		String name=req.getParameter("name");
		String branch=req.getParameter("branch");
		String dom=req.getParameter("dom");
		String mail=req.getParameter("mail");
		String phone=req.getParameter("phone");
		String birth=req.getParameter("birth");
	
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cmd_1", "root", "root");
            
            PreparedStatement statement = conn.prepareStatement("INSERT INTO student_list (adm_id, name, phone_no, email_id, branch, DOA,  DOB) VALUES ('"+adm+"','"+name+"','"+phone+"','"+mail+"','"+branch+"','"+dom+"','"+birth+"')");
         int rowCount= statement.executeUpdate();
         res.sendRedirect("studentsalldata");
        } catch (Exception e) {
        	e.printStackTrace();
        } 
     
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
