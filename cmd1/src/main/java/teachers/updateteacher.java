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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class updateteacher
 */
@WebServlet("/updateteacher")
public class updateteacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DB_URL = "jdbc:mysql://localhost:3306/cmd_1";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root"; 
    public updateteacher() {
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
            while (rs.next()) {
            	 HttpSession session = request.getSession();
                 session.setAttribute("id", rs.getString("id"));
            	out.println("<!DOCTYPE html>\r\n"
            			+ "<!---Coding By CodingLab | www.codinglabweb.com--->\r\n"
            			+ "<html lang=\"en\">\r\n"
            			+ "  <head>\r\n"
            			+ "    <meta charset=\"UTF-8\" />\r\n"
            			+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n"
            			+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />\r\n"
            			+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ\" crossorigin=\"anonymous\">\r\n"
            			+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe\" crossorigin=\"anonymous\"></script>\r\n"
            			+ "   <style>\r\n"
            			+ "    /* Import Google font - Poppins */\r\n"
            			+ "@import url(\"https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap\");\r\n"
            			+ "* {\r\n"
            			+ "  margin: 0;\r\n"
            			+ "  padding: 0;\r\n"
            			+ "  box-sizing: border-box;\r\n"
            			+ "  font-family: \"Poppins\", sans-serif;\r\n"
            			+ "}\r\n"
            			+ "body {\r\n"
            			+ "  min-height: 100vh;\r\n"
            			+ "  display: flex;\r\n"
            			+ "  align-items: center;\r\n"
            			+ "  justify-content: center;\r\n"
            			+ "  padding: 20px;\r\n"
            			+ "  background: rgb(130, 106, 251);\r\n"
            			+ "}\r\n"
            			+ ".container {\r\n"
            			+ "  position: relative;\r\n"
            			+ "  max-width: 700px;\r\n"
            			+ "  width: 100%;\r\n"
            			+ "  background: #fff;\r\n"
            			+ "  padding: 25px;\r\n"
            			+ "  border-radius: 8px;\r\n"
            			+ "  box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);\r\n"
            			+ "}\r\n"
            			+ ".container header {\r\n"
            			+ "  font-size: 1.5rem;\r\n"
            			+ "  color: #333;\r\n"
            			+ "  font-weight: 500;\r\n"
            			+ "  text-align: center;\r\n"
            			+ "}\r\n"
            			+ ".container .form {\r\n"
            			+ "  margin-top: 30px;\r\n"
            			+ "}\r\n"
            			+ ".form .input-box {\r\n"
            			+ "  width: 100%;\r\n"
            			+ "  margin-top: 20px;\r\n"
            			+ "}\r\n"
            			+ ".input-box label {\r\n"
            			+ "  color: #333;\r\n"
            			+ "}\r\n"
            			+ ".form :where(.input-box input, .select-box) {\r\n"
            			+ "  position: relative;\r\n"
            			+ "  height: 50px;\r\n"
            			+ "  width: 100%;\r\n"
            			+ "  outline: none;\r\n"
            			+ "  font-size: 1rem;\r\n"
            			+ "  color: #707070;\r\n"
            			+ "  margin-top: 8px;\r\n"
            			+ "  border: 1px solid #ddd;\r\n"
            			+ "  border-radius: 6px;\r\n"
            			+ "  padding: 0 15px;\r\n"
            			+ "}\r\n"
            			+ ".input-box input:focus {\r\n"
            			+ "  box-shadow: 0 1px 0 rgba(0, 0, 0, 0.1);\r\n"
            			+ "}\r\n"
            			+ ".form .column {\r\n"
            			+ "  display: flex;\r\n"
            			+ "  column-gap: 15px;\r\n"
            			+ "}\r\n"
            			+ ".form .gender-box {\r\n"
            			+ "  margin-top: 20px;\r\n"
            			+ "}\r\n"
            			+ ".gender-box h3 {\r\n"
            			+ "  color: #333;\r\n"
            			+ "  font-size: 1rem;\r\n"
            			+ "  font-weight: 400;\r\n"
            			+ "  margin-bottom: 8px;\r\n"
            			+ "}\r\n"
            			+ ".form :where(.gender-option, .gender) {\r\n"
            			+ "  display: flex;\r\n"
            			+ "  align-items: center;\r\n"
            			+ "  column-gap: 50px;\r\n"
            			+ "  flex-wrap: wrap;\r\n"
            			+ "}\r\n"
            			+ ".form .gender {\r\n"
            			+ "  column-gap: 5px;\r\n"
            			+ "}\r\n"
            			+ ".gender input {\r\n"
            			+ "  accent-color: rgb(130, 106, 251);\r\n"
            			+ "}\r\n"
            			+ ".form :where(.gender input, .gender label) {\r\n"
            			+ "  cursor: pointer;\r\n"
            			+ "}\r\n"
            			+ ".gender label {\r\n"
            			+ "  color: #707070;\r\n"
            			+ "}\r\n"
            			+ ".address :where(input, .select-box) {\r\n"
            			+ "  margin-top: 15px;\r\n"
            			+ "}\r\n"
            			+ ".select-box select {\r\n"
            			+ "  height: 100%;\r\n"
            			+ "  width: 100%;\r\n"
            			+ "  outline: none;\r\n"
            			+ "  border: none;\r\n"
            			+ "  color: #707070;\r\n"
            			+ "  font-size: 1rem;\r\n"
            			+ "}\r\n"
            			+ ".form button {\r\n"
            			+ "  height: 55px;\r\n"
            			+ "  width: 100%;\r\n"
            			+ "  color: #fff;\r\n"
            			+ "  font-size: 1rem;\r\n"
            			+ "  font-weight: 400;\r\n"
            			+ "  margin-top: 30px;\r\n"
            			+ "  border: none;\r\n"
            			+ "  cursor: pointer;\r\n"
            			+ "  transition: all 0.2s ease;\r\n"
            			+ "  background: rgb(130, 106, 251);\r\n"
            			+ "}\r\n"
            			+ ".form button:hover {\r\n"
            			+ "  background: rgb(88, 56, 250);\r\n"
            			+ "}\r\n"
            			+ "/*Responsive*/\r\n"
            			+ "@media screen and (max-width: 500px) {\r\n"
            			+ "  .form .column {\r\n"
            			+ "    flex-wrap: wrap;\r\n"
            			+ "  }\r\n"
            			+ "  .form :where(.gender-option, .gender) {\r\n"
            			+ "    row-gap: 15px;\r\n"
            			+ "  }\r\n"
            			+ "}\r\n"
            			+ "   </style>\r\n"
            			+ "  </head>\r\n"
            			+ "  <body>\r\n"
            			+ "    <section class=\"container\">\r\n"
            			+ "      <header>Registration Form</header>\r\n"
            			+ "      <form action=\"updatestudentconnection\" class=\"form\" method=\"post\">\r\n"
            			+ "        <div class=\"input-box\">\r\n"
            			+ "          <label>Full Name</label>\r\n"
            			+ "          <input type=\"text\" name=\"name\" value="+rs.getString("name")+"  required />\r\n"
            			+ "        </div>\r\n"
            			+ "\r\n"
            			+ "        <div class=\"input-box\">\r\n"
            			+ "          <label>Email Address</label>\r\n"
            			+ "          <input type=\"text\" name=\"mail\" value="+rs.getString("mailid")+" required />\r\n"
            			+ "        </div>\r\n"
            			+ "\r\n"
            			+ "        <div class=\"column\">\r\n"
            			+ "          <div class=\"input-box\">\r\n"
            			+ "            <label>Phone Number</label>\r\n"
            			+ "            <input type=\"number\" name=\"phone\" value="+rs.getString("phone")+" required />\r\n"
            			+ "          </div>\r\n"
            			+ "          <div class=\"input-box\">\r\n"
            			+ "            <label>tech id</label>\r\n"
            			+ "            <input type=\"text\" name=\"tech\" value="+rs.getString("T_id")+" required />\r\n"
            			+ "          </div>\r\n"
            			+ "        </div>\r\n"
            			+ "        <div class=\"column\">\r\n"
            			+ "          <div class=\"input-box\">\r\n"
            			+ "            <label>branch</label>\r\n"
            			+ "            <input type=\"text\" name=\"branch\" value="+rs.getString("branch")+" required />\r\n"
            			+ "          </div>\r\n"
            			+ "          <div class=\"input-box\">\r\n"
            			+ "            <label>employid</label>\r\n"
            			+ "            <input type=\"text\" name=\"employid\" value="+rs.getString("employ_id")+" required />\r\n"
            			+ "          </div>\r\n"
            			+ "        </div>\r\n"
            			+ "        <div class=\"column\">\r\n"
            			+ "          <div class=\"input-box\">\r\n"
            			+ "            <label>username</label>\r\n"
            			+ "            <input type=\"text\" name=\"username\" value="+rs.getString("username")+" required />\r\n"
            			+ "          </div>\r\n"
            			+ "          <div class=\"input-box\">\r\n"
            			+ "            <label>password</label>\r\n"
            			+ "            <input type=\"text\" name=\"password\" value="+rs.getString("password")+" required />\r\n"
            			+ "          </div>\r\n"
            			+ "        \r\n"
            			+ "        \r\n"
            			+ "       \r\n"
            			+ "       \r\n"
            			+ "        </div>\r\n"
            			+ "  <a href='updatestudentconnection?id="+rs.getString("id")+"'><button type=\"submit\" class=\"btn btn-success\">Success</button></a>\r\n"
            			+ "      </form>\r\n"
            			+ "    </section>\r\n"
            			+ "  </body>\r\n"
            			+ "</html>");
            }
        }catch (Exception e) {
			System.out.println(e);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
