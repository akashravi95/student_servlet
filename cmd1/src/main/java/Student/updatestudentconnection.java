package Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/updatestudentconnection")
public class updatestudentconnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DB_URL = "jdbc:mysql://localhost:3306/cmd_1";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    public updatestudentconnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);  
        String n=(String)session.getAttribute("id"); 
        System.out.println(n);
		response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
		String adm=request.getParameter("adm");
		String name=request.getParameter("name");
		String branch=request.getParameter("branch");
		String dom=request.getParameter("dom");
		String mail=request.getParameter("mail");
		String phone=request.getParameter("phone");
		String birth=request.getParameter("birth");
		 
		System.out.println(n);
		System.out.println(adm);
        try {
        	Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection( DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement pstmt = con.prepareStatement(" UPDATE  student_list SET adm_id='"+adm+"', name='"+name+"', phone_no='"+phone+"', email_id='"+mail+"', branch='"+branch+"', DOA='"+dom+"',  DOB= '"+birth+"' where id='"+n+"'");
  int i =pstmt.executeUpdate();
            
        }
           catch (Exception e) {
			System.out.println(e);
		} 
	}

            
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
}
}