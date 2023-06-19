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
 * Servlet implementation class Teacher
 */
@WebServlet("/Teacher")
public class Teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DB_URL = "jdbc:mysql://localhost:3306/cmd_1";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    public Teacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n=request.getParameter("id"); 
		System.out.println(n);
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        try {
        	Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection( DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from teachers_list where id='"+n+"'");
            while(rs.next())
            {
		
        out.println("<!DOCTYPE html>\r\n"
        		+ "<html lang=\"en\">\r\n"
        		+ "<head>\r\n"
        		+ "    <meta charset=\"UTF-8\">\r\n"
        		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
        		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
        		+ "    <title>Document</title>\r\n"
        		+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ\" crossorigin=\"anonymous\">\r\n"
        		+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe\" crossorigin=\"anonymous\"></script>\r\n"
        		+ "<style>\r\n"
        		+ "    body {\r\n"
        		+ "    font-family: Arial, sans-serif;\r\n"
        		+ "    padding: 20px;\r\n"
        		+ "    background: #180835;\r\n"
        		+ "    display: flex;\r\n"
        		+ "    flex-direction: column;\r\n"
        		+ "    justify-content: center;\r\n"
        		+ "    align-items: center;\r\n"
        		+ "  }\r\n"
        		+ "  html, body {\r\n"
        		+ "    height: 100%;\r\n"
        		+ "  }\r\n"
        		+ ".card {\r\n"
        		+ "    display: flex;\r\n"
        		+ "    flex-direction: row;\r\n"
        		+ "    justify-content: space-between;\r\n"
        		+ "    align-items: center;\r\n"
        		+ "    border-radius: 30px;\r\n"
        		+ "    padding: 10px;\r\n"
        		+ "    box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.2);\r\n"
        		+ "    width: 70%;\r\n"
        		+ "    height: 480px;\r\n"
        		+ "    background: #12c2e9;  /* fallback for old browsers */\r\n"
        		+ "background: -webkit-linear-gradient(to right, #f64f59, #c471ed, #12c2e9);  /* Chrome 10-25, Safari 5.1-6 */\r\n"
        		+ "background: linear-gradient(to right, #f64f59, #c471ed, #12c2e9); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "  .left-container {\r\n"
        		+ "    background: #000000; \r\n"
        		+ "background: -webkit-linear-gradient(to right, #434343, #000000);\r\n"
        		+ "background: linear-gradient(to right, #434343, #000000); \r\n"
        		+ "    flex: 1;\r\n"
        		+ "    max-width: 30%;\r\n"
        		+ "    display: flex;\r\n"
        		+ "    flex-direction: column;\r\n"
        		+ "    align-items: center;\r\n"
        		+ "    height:430px;\r\n"
        		+ "    padding: 10px;\r\n"
        		+ "    margin: 30px;\r\n"
        		+ "    border-radius: 20px;\r\n"
        		+ "    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);\r\n"
        		+ "  }\r\n"
        		+ "  \r\n"
        		+ "  .right-container {\r\n"
        		+ "    background: #000000; \r\n"
        		+ "    background: -webkit-linear-gradient(to left, #434343, #000000);\r\n"
        		+ "    background: linear-gradient(to left, #434343, #000000); \r\n"
        		+ "    flex: 1;\r\n"
        		+ "    max-width:70%;\r\n"
        		+ "    height:430px;\r\n"
        		+ "    padding: 10px;\r\n"
        		+ "    margin: 20px;\r\n"
        		+ "    border-radius:30px;\r\n"
        		+ "    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);\r\n"
        		+ "  }\r\n"
        		+ "  @media only screen and (max-width: 860px) {\r\n"
        		+ "    .card\r\n"
        		+ "     {\r\n"
        		+ "     flex-direction: column;\r\n"
        		+ "     margin: 10px;\r\n"
        		+ "     height: auto;\r\n"
        		+ "     width: 90%;\r\n"
        		+ "    }\r\n"
        		+ "    .left-container{\r\n"
        		+ "        flex: 1;\r\n"
        		+ "        max-width:100%; \r\n"
        		+ "    }\r\n"
        		+ "  }\r\n"
        		+ "  @media only screen and (max-width: 600px) {\r\n"
        		+ "    .card\r\n"
        		+ "     {\r\n"
        		+ "     flex-direction: column;\r\n"
        		+ "     margin: 10px;\r\n"
        		+ "    }\r\n"
        		+ "    .left-container{\r\n"
        		+ "        flex: 1;\r\n"
        		+ "        max-width:100%; \r\n"
        		+ "    }\r\n"
        		+ "  }\r\n"
        		+ "  img {\r\n"
        		+ "    width: 200px;\r\n"
        		+ "    height: 200px;\r\n"
        		+ "    max-width: 200px;\r\n"
        		+ "    border-radius: 50%;\r\n"
        		+ "    margin: 10px;\r\n"
        		+ "    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);\r\n"
        		+ "  }\r\n"
        		+ "  \r\n"
        		+ "  h2 {\r\n"
        		+ "    font-size: 24px;\r\n"
        		+ "    margin-bottom: 5px;\r\n"
        		+ "  }\r\n"
        		+ "  h3 {\r\n"
        		+ "    text-align: center;\r\n"
        		+ "    font-size: 24px;\r\n"
        		+ "    margin-bottom: 5px;\r\n"
        		+ "  }\r\n"
        		+ "  .gradienttext{\r\n"
        		+ "    background-image: linear-gradient(to right, #ee00ff 0%, #fbff00 100%);\r\n"
        		+ "    color: transparent;\r\n"
        		+ "    -webkit-background-clip: text;\r\n"
        		+ "  }\r\n"
        		+ "  p {\r\n"
        		+ "    font-size: 18px;\r\n"
        		+ "    margin-bottom: 20px;\r\n"
        		+ "    color:aliceblue\r\n"
        		+ "  }\r\n"
        		+ "  \r\n"
        		+ "  table {\r\n"
        		+ "    display: flex;\r\n"
        		+ "    flex-direction: column;\r\n"
        		+ "    justify-content: center;\r\n"
        		+ "    align-items: center;\r\n"
        		+ "    width: 100%;\r\n"
        		+ "    height: 280px;\r\n"
        		+ "    border-collapse: collapse;\r\n"
        		+ "  }\r\n"
        		+ "  \r\n"
        		+ "  td {\r\n"
        		+ "    \r\n"
        		+ "    padding: 10px;\r\n"
        		+ "    border: none;\r\n"
        		+ "    border-radius: 20px;\r\n"
        		+ "    color: white;\r\n"
        		+ "  }\r\n"
        		+ "  \r\n"
        		+ "  td:first-child {\r\n"
        		+ "    font-weight: bold;\r\n"
        		+ "  }\r\n"
        		+ "  .credit a {\r\n"
        		+ "  text-decoration: none;\r\n"
        		+ "  color: #fff;\r\n"
        		+ "  font-weight: 800;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".credit {\r\n"
        		+ "    color: #fff;\r\n"
        		+ "  text-align: center;\r\n"
        		+ "  margin-top: 10px;\r\n"
        		+ "  font-family: Verdana,Geneva,Tahoma,sans-serif;\r\n"
        		+ "}\r\n"
        		+ "</style>\r\n"
        		+ "</head>\r\n"
        		+ "<body>\r\n"
        		+ "    \r\n"
        		+ "<div class=\"card\">\r\n"
        		+ "    <div class=\"left-container\">\r\n"
        		+ "      <img src=\"https://cdn.pixabay.com/photo/2015/01/08/18/29/entrepreneur-593358__480.jpg\" alt=\"Profile Image\">\r\n"
        		+ "      <h2 class=\"gradienttext\">"+rs.getString("name")+"'</h2>\r\n"
        		+ "      <p>teacher</p>\r\n"
        		+ "    </div>\r\n"
        		+ "    <div class=\"right-container\">\r\n"
        		+ "      <h3 class=\"gradienttext\">Profile Details</h3>\r\n"
        		+ "      <table>\r\n"
        		+ "          <tr>\r\n"
        		+ "              <td>Name :</td>\r\n"
        		+ "              <td>"+rs.getString("name")+"</td>\r\n"
        		+ "            </tr>\r\n"
        		+ "        <tr>\r\n"
        		+ "          <td>employid</td>\r\n"
        		+ "          <td>"+rs.getString("employ_id")+"</td>\r\n"
        		+ "        </tr>\r\n"
        		+ "        <tr>\r\n"
        		+ "          <td>Mobile :</td>\r\n"
        		+ "          <td>"+rs.getString("phone")+"</td>\r\n"
        		+ "        </tr>\r\n"
        		+ "        <tr>\r\n"
        		+ "          <td>Email :</td>\r\n"
        		+ "          <td>"+rs.getString("mailid")+"</td>\r\n"
        		+ "        </tr>\r\n"
        		+ "        <tr>\r\n"
        		+ "          <td>branch :</td>\r\n"
        		+ "          <td>"+rs.getString("branch")+"</td>\r\n"
        		+ "        </tr>\r\n"
        		+ "      </table>\r\n"
        		+ "      <a href=\"studentsalldata\" class=\"btn btn-primary btn-xs pull-right\"> view students</a><a href=\"getmarklistofall\" class=\"btn btn-primary btn-xs pull-right\"> marklist</a>\r\n"
        	
        		+ "    </div>\r\n"
        		+ "  </div>\r\n"
        		+ "   \r\n"
        		+ "</Table>\r\n"
        		+ "</body>\r\n"
        		+ "</html>");
            }
        }
        catch (Exception e) {
			System.out.println(e);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
