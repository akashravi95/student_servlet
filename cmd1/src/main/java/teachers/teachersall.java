package teachers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class teachersall
 */
@WebServlet("/teachersall")
public class teachersall extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DB_URL = "jdbc:mysql://localhost:3306/cmd_1";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    public teachersall() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text.html");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");  
	        Connection con=DriverManager.getConnection( DB_URL, DB_USER, DB_PASSWORD);
	        Statement stmt=con.createStatement();
	        ResultSet rs=stmt.executeQuery("select * from teachers_list");
	        
	        out.println("<!DOCTYPE html>\r\n"
	        		+ "<html lang=\"en\">\r\n"
	        		+ "<head>\r\n"
	        		+ "    <meta charset=\"UTF-8\">\r\n"
	        		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
	        		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
	        		+ "    <title>Document</title>\r\n"
	        		+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ\" crossorigin=\"anonymous\">\r\n"
	        		+ "\r\n"
	        		+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe\" crossorigin=\"anonymous\"></script>\r\n"
	        		+ "<style>\r\n"
	        		+ "    .custab{\r\n"
	        		+ "    border: 1px solid #ccc;\r\n"
	        		+ "    padding: 5px;\r\n"
	        		+ "    margin: 5% 0;\r\n"
	        		+ "    box-shadow: 3px 3px 2px #ccc;\r\n"
	        		+ "    transition: 0.5s;\r\n"
	        		+ "    }\r\n"
	        		+ ".custab:hover{\r\n"
	        		+ "    box-shadow: 3px 3px 0px transparent;\r\n"
	        		+ "    transition: 0.5s;\r\n"
	        		+ "    }\r\n"
	        		
	        		+ "</style>\r\n"
	        		+ "</head>\r\n"
	        		+ "<body>\r\n"
	        		+ "    <div class=\"container\">\r\n"
	        		+ "        <div class=\"row col-md-12 col-md-offset-2 custyle\">\r\n"
	        		+ "            <a href=\"Teacherssignup\" class=\"btn btn-primary btn-xs pull-right\"><b>+</b> Add new teachers</a>\r\n"
	        		+ "        <table class=\"table table-striped custab table-bordered\">\r\n"
	        		+ "        <thead>\r\n"
	        		+ "       \r\n"
	        		+ "            <tr>\r\n"
	        		+ "                <th>ID</th>\r\n"
	        		+ "                <th>name</th>\r\n"
	        		+ "                <th>Branch</th>\r\n"
	        		+ "                <th class=\"text-center\">Action</th>\r\n"
	        		+ "            </tr>\r\n"
	        		+ "        </thead>");
	        while(rs.next())
	        {
	        	out.println(" <tr>\r\n"
	        			+ "                    <td>"+rs.getString("T_id")+"</td>\r\n"
	        			+ "                    <td>"+rs.getString("name")+"</td>\r\n"
	        			+ "                    <td>"+rs.getString("branch")+"</td>\r\n"
	        			+ "                    <td class=\"text-center\"><a class='btn btn-info btn-xs' href='Teacher?id="+rs.getString("id")+"'><span class=\"glyphicon glyphicon-edit\"></span> visit</a>&nbsp;&nbsp;<a href='updateteacher?id="+rs.getString("id")+"' class=\"btn btn-success btn-xs\"><span class=\"glyphicon glyphicon-remove\"></span> update</a>&nbsp;&nbsp;<a href='Teacherprofiledelete?id="+rs.getString("id")+"' class=\"btn btn-danger btn-xs\"><span class=\"glyphicon glyphicon-remove\"></span> Del</a></td>\r\n"
	        			+ "                </tr>"); }
	        			
		}catch (Exception e) {
		System.out.println(e);
		}
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
