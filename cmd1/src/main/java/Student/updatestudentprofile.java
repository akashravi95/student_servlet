package Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/updatestudentprofile")
public class updatestudentprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DB_URL = "jdbc:mysql://localhost:3306/cmd_1";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root"; 
    
    public updatestudentprofile() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String n=request.getParameter("id"); 
		System.out.println(n);
		
        try {
        	Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection( DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from student_list where id='"+n+"'");
            while (rs.next()) {
            	 HttpSession session = request.getSession();
                 session.setAttribute("id", rs.getString("id"));
            	response.setContentType("text/html");
                PrintWriter out=response.getWriter();
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
            		+ "body{margin-top:20px;\r\n"
            		+ "background-color:#f2f6fc;\r\n"
            		+ "color:#69707a;\r\n"
            		+ "}\r\n"
            		+ ".img-account-profile {\r\n"
            		+ "    height: 10rem;\r\n"
            		+ "}\r\n"
            		+ ".rounded-circle {\r\n"
            		+ "    border-radius: 50% !important;\r\n"
            		+ "}\r\n"
            		+ ".card {\r\n"
            		+ "    box-shadow: 0 0.15rem 1.75rem 0 rgb(33 40 50 / 15%);\r\n"
            		+ "}\r\n"
            		+ ".card .card-header {\r\n"
            		+ "    font-weight: 500;\r\n"
            		+ "}\r\n"
            		+ ".card-header:first-child {\r\n"
            		+ "    border-radius: 0.35rem 0.35rem 0 0;\r\n"
            		+ "}\r\n"
            		+ ".card-header {\r\n"
            		+ "    padding: 1rem 1.35rem;\r\n"
            		+ "    margin-bottom: 0;\r\n"
            		+ "    background-color: rgba(33, 40, 50, 0.03);\r\n"
            		+ "    border-bottom: 1px solid rgba(33, 40, 50, 0.125);\r\n"
            		+ "}\r\n"
            		+ ".form-control, .dataTable-input {\r\n"
            		+ "    display: block;\r\n"
            		+ "    width: 100%;\r\n"
            		+ "    padding: 0.875rem 1.125rem;\r\n"
            		+ "    font-size: 0.875rem;\r\n"
            		+ "    font-weight: 400;\r\n"
            		+ "    line-height: 1;\r\n"
            		+ "    color: #69707a;\r\n"
            		+ "    background-color: #fff;\r\n"
            		+ "    background-clip: padding-box;\r\n"
            		+ "    border: 1px solid #c5ccd6;\r\n"
            		+ "    -webkit-appearance: none;\r\n"
            		+ "    -moz-appearance: none;\r\n"
            		+ "    appearance: none;\r\n"
            		+ "    border-radius: 0.35rem;\r\n"
            		+ "    transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;\r\n"
            		+ "}\r\n"
            		+ "\r\n"
            		+ ".nav-borders .nav-link.active {\r\n"
            		+ "    color: #0061f2;\r\n"
            		+ "    border-bottom-color: #0061f2;\r\n"
            		+ "}\r\n"
            		+ ".nav-borders .nav-link {\r\n"
            		+ "    color: #69707a;\r\n"
            		+ "    border-bottom-width: 0.125rem;\r\n"
            		+ "    border-bottom-style: solid;\r\n"
            		+ "    border-bottom-color: transparent;\r\n"
            		+ "    padding-top: 0.5rem;\r\n"
            		+ "    padding-bottom: 0.5rem;\r\n"
            		+ "    padding-left: 0;\r\n"
            		+ "    padding-right: 0;\r\n"
            		+ "    margin-left: 1rem;\r\n"
            		+ "    margin-right: 1rem;\r\n"
            		+ "}\r\n"
            		+ "</style>\r\n"
            		+ "</head>\r\n"
            		+ "<body>\r\n"
            		+ "  \r\n"
            		+ "    <hr class=\"mt-0 mb-4\">\r\n"
            		+ "    <div class=\"row\">\r\n"
            		+ "      \r\n"
            		+ "        <div class=\"col-xl-8\">\r\n"
            		+ "            <!-- Account details card-->\r\n"
            		+ "            <div class=\"card mb-4\">\r\n"
            		+ "                <div class=\"card-header\">Students Details</div>\r\n"
            		+ "                <div class=\"card-body\">\r\n"
            		+ "                    <form action=\"updatestudentconnection\" method=\"get\">\r\n"
            		+ "                        <!-- Form Group (username)-->\r\n"
            		+ "                        <div class=\"mb-3\">\r\n"
            		+ "                            <label class=\"small mb-1\" for=\"inputUsername\">Admission number</label>\r\n"
            		+ "                            <input class=\"form-control\" id=\"inputUsername\" type=\"text\" value=\""+rs.getString("adm_id")+"\" name='adm' >\r\n"
            		+ "                        </div>\r\n"
            		+ "                        <!-- Form Row-->\r\n"
            		+ "                        <div class=\"row gx-3 mb-3\">\r\n"
            		+ "                            <!-- Form Group (first name)-->\r\n"
            		+ "                            <div class=\"col-md-6\">\r\n"
            		+ "                                <label class=\"small mb-1\" for=\"inputFirstName\">First name</label>\r\n"
            		+ "                                <input class=\"form-control\" id=\"inputFirstName\" type=\"text\" value=\""+rs.getString("name")+"\" name=\"name\">\r\n"
            		+ "                            </div>\r\n"
            		+ "                            <!-- Form Group (last name)-->\r\n"
            		+ "                            <div class=\"col-md-6\">\r\n"
            		+ "                                <label class=\"small mb-1\" for=\"inputLastName\">branch</label>\r\n"
            		+ "                                <input class=\"form-control\" id=\"inputLastName\" type=\"text\" value=\""+rs.getString("branch")+"\" name=\"branch\">\r\n"
            		+ "                            </div>\r\n"
            		+ "                        </div>\r\n"
            		+ "                        <!-- Form Row        -->\r\n"
            		+ "                        <div class=\"row gx-3 mb-3\">\r\n"
            		+ "                            <!-- Form Group (organization name)-->\r\n"
            		+ "                            <div class=\"col-md-6\">\r\n"
            		+ "                                <label class=\"small mb-1\" for=\"inputOrgName\">date of admission</label>\r\n"
            		+ "                                <input class=\"form-control\" id=\"inputOrgName\" type=\"date\" value=\""+rs.getString("DOA")+"\"  name=\"dom\">\r\n"
            		+ "                            </div>\r\n"
            		+ "                            <!-- Form Group (location)-->\r\n"
            		+ "                          \r\n"
            		+ "                        </div>\r\n"
            		+ "                        <!-- Form Group (email address)-->\r\n"
            		+ "                        <div class=\"mb-3\">\r\n"
            		+ "                            <label class=\"small mb-1\" for=\"inputEmailAddress\">Email address</label>\r\n"
            		+ "                            <input class=\"form-control\" id=\"inputEmailAddress\" type=\"email\" value=\""+rs.getString("email_id")+"\" name=\"mail\">\r\n"
            		+ "                        </div>\r\n"
            		+ "                        <!-- Form Row-->\r\n"
            		+ "                        <div class=\"row gx-3 mb-3\">\r\n"
            		+ "                            <!-- Form Group (phone number)-->\r\n"
            		+ "                            <div class=\"col-md-6\">\r\n"
            		+ "                                <label class=\"small mb-1\" for=\"inputPhone\">Phone number</label>\r\n"
            		+ "                                <input class=\"form-control\" id=\"inputPhone\" type=\"tel\" value=\""+rs.getString("phone_no")+"\"  name=\"phone\">\r\n"
            		+ "                            </div>\r\n"
            		+ "                            <!-- Form Group (birthday)-->\r\n"
            		+ "                            <div class=\"col-md-6\">\r\n"
            		+ "                                <label class=\"small mb-1\" for=\"inputBirthday\">date of birth</label>\r\n"
            		+ "                                <input class=\"form-control\" id=\"inputBirthday\" type=\"date\" name=\"birth\" value=\""+rs.getString("DOB")+"\">\r\n"
            		+ "                            </div>\r\n"
            		+ "                        </div>\r\n"
            		+ "                        <!-- Save changes button-->\r\n"
        		+ "                     <button type=\"submit\" class=\"btn btn-dark\">update</button>\r\n"
       
            		+ "                    </form>\r\n"
            		+ "                </div>\r\n"
            		+ "            </div>\r\n"
            		+ "        </div>\r\n"
            		+ "    </div>\r\n"
            		+ "</div>\r\n"
            		+ "</body>\r\n"
            		+ "</html>");
            }
        }catch (Exception e) {
			System.out.println(e);
		}
       
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
