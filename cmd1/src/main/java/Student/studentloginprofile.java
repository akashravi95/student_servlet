package Student;

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
import javax.servlet.http.HttpSession;


@WebServlet("/studentloginprofile")
public class studentloginprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DB_URL = "jdbc:mysql://localhost:3306/cmd_1";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    public studentloginprofile() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session=request.getSession(false); 
		 
	        int n=(int) session.getAttribute("id");
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        System.out.println("n");
        try {
        	Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection( DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from student_list where id='"+n+"' " );
            while(rs.next())
            {
           
            
         
            
           
          
         
            out.println("<head>\r\n"
            		+ " \r\n"
            		+ "    <meta charset=\"UTF-8\">\r\n"
            		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
            		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
            		+ "    <title>Document</title>\r\n"
            		+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ\" crossorigin=\"anonymous\">\r\n"
            		+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe\" crossorigin=\"anonymous\"></script>\r\n"
            		+ "<style> \r\n"
            		+ "body {\r\n"
            		+ "  padding: 0;\r\n"
            		+ "  margin: 0;\r\n"
            		+ "  font-family: 'Lato', sans-serif;\r\n"
            		+ "  color: #000;\r\n"
            		+ "}\r\n"
            		+ "\r\n"
            		+ ".student-profile .card {\r\n"
            		+ "  border-radius: 10px;\r\n"
            		+ "}\r\n"
            		+ "\r\n"
            		+ ".student-profile .card .card-header .profile_img {\r\n"
            		+ "  width: 150px;\r\n"
            		+ "  height: 150px;\r\n"
            		+ "  object-fit: cover;\r\n"
            		+ "  margin: 10px auto;\r\n"
            		+ "  border: 10px solid #ccc;\r\n"
            		+ "  border-radius: 50%;\r\n"
            		+ "}\r\n"
            		+ "\r\n"
            		+ ".student-profile .card h3 {\r\n"
            		+ "  font-size: 20px;\r\n"
            		+ "  font-weight: 700;\r\n"
            		+ "}\r\n"
            		+ "\r\n"
            		+ ".student-profile .card p {\r\n"
            		+ "  font-size: 16px;\r\n"
            		+ "  color: #000;\r\n"
            		+ "}\r\n"
            		+ "\r\n"
            		+ ".student-profile .table th,\r\n"
            		+ ".student-profile .table td {\r\n"
            		+ "  font-size: 14px;\r\n"
            		+ "  padding: 5px 10px;\r\n"
            		+ "  color: #000;\r\n"
            		+ "}\r\n"
            		+ ".btn\r\n"
            		+ "{\r\n"
            		+ "    position: relative;\r\n"
            		+ "    left: 45%;\r\n"
            		+ "}\r\n"
            		+ "</style>\r\n"
            		+ "</head>\r\n"
            		+ "\r\n"
            		+ "<body>\r\n"
            		+ "    \r\n"
            		+ "<div class=\"student-profile py-4\">\r\n"
            		+ "    <div class=\"container\">\r\n"
            		+ "      <div class=\"row\">\r\n"
            		+ "        <div class=\"col-lg-12\">\r\n"
            		+ "          <div class=\"card shadow-sm\">\r\n"
            		+ "            <div class=\"card-header bg-transparent text-center\">\r\n"
            		+ "              <img class=\"profile_img\" src=\"https://placeimg.com/640/480/arch/any\" alt=\"\">\r\n"
            		+ "              <h3>"+rs.getString("name")+"</h3>\r\n"
            		+ "            </div>\r\n"
            		+ "            <div class=\"card-body\">\r\n"
            		+ "              <p class=\"mb-0\"><strong class=\"pr-1\">Student ID:</strong>"+ rs.getString("adm_id")+"</p>\r\n"
            		+ "              <p class=\"mb-0\"><strong class=\"pr-1\">branch:</strong>"+ rs.getString("branch")+"</p>\r\n"
            		+ "              \r\n"
            		+ "            </div>\r\n"
            		+ "          </div>\r\n"
            		+ "        </div>\r\n"
            		+ "        <div class=\"col-lg-12 mt-5\">\r\n"
            		+ "          <div class=\"card shadow-sm\">\r\n"
            		+ "            <div class=\"card-header bg-transparent border-0\">\r\n"
            		+ "              <h3 class=\"mb-0\"><i class=\"far fa-clone pr-1\"></i>General Information</h3>\r\n"
            		+ "            </div>\r\n"
            		+ "            <div class=\"card-body pt-0\">\r\n"
            		+ "              <table class=\"table table-bordered\">\r\n"
            		+ "                <tr>\r\n"
            		+ "                  <th width=\"30%\">Name</th>\r\n"
            		+ "                  <td width=\"2%\">:</td>\r\n"
            		+ "                  <td>"+rs.getString("name")+"</td>\r\n"
            		+ "                </tr>\r\n"
            		+ "                <tr>\r\n"
            		+ "                  <th width=\"30%\">Phone number	</th>\r\n"
            		+ "                  <td width=\"2%\">:</td>\r\n"
            		+ "                  <td>"+rs.getString("phone_no")+"</td>\r\n"
            		+ "                </tr>\r\n"
            		+ "                <tr>\r\n"
            		+ "                  <th width=\"30%\">Email id</th>\r\n"
            		+ "                  <td width=\"2%\">:</td>\r\n"
            		+ "                  <td>"+rs.getString("email_id")+"</td>\r\n"
            		+ "                </tr>\r\n"
            		+ "                <tr>\r\n"
            		+ "                  <th width=\"30%\">Date of admission</th>\r\n"
            		+ "                  <td width=\"2%\">:</td>\r\n"
            		+ "                  <td>"+rs.getString("DOA")+"</td>\r\n"
            		+ "                </tr>\r\n"
            		+ "                <tr>\r\n"
            		+ "                  <th width=\"30%\">Date of birth</th>\r\n"
            		+ "                  <td width=\"2%\">:</td>\r\n"
            		+ "                  <td>"+rs.getString("DOB")+"</td>\r\n"
            		+ "                </tr>\r\n"
            		+ "             \r\n"
            		+ "              </table>\r\n"
            		+ "          <td class=\"text-center\"><a class='btn btn-outline-success btn-xs' href= Onestudentmark?id="+rs.getString("id")+"><span class=\"glyphicon glyphicon-edit\"></span> marklist</a>\r\n"
            		+ "            </div>\r\n"
            		+ "          </div>\r\n"
            		+ "        </div>\r\n"
            		+ "      </div>\r\n"
            		+ "    </div>\r\n"
            		+ "  </div>\r\n"
            		+ "\r\n"
            		+ "</body>\r\n"
            		+ "</html>");
            }
        } catch (Exception e) {
				System.out.println(e);
			}
        
     
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
