package marklist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addmarklist
 */
@WebServlet("/addmarklist")
public class addmarklist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addmarklist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<!DOCTYPE html>\r\n"
        		+ "<html>\r\n"
        		+ "  <head>\r\n"
        		+ "    <title>MARKS SHEET USING HTML TABLES</title>\r\n"
        		+ "    <meta charset=\"UTF-8\">\r\n"
        		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
        		+ "    <meta name=\"Keywords\" content=\"html, css, html tables, table\">\r\n"
        		+ "    <meta name=\"Description\" content=\"html table\">\r\n"
        		+ "    <!-- add icon -->\r\n"
        		+ "    <link rel=\"icon\" href=\"/favicon.ico\" type=\"image/x-icon\">\r\n"
        		+ "        <link href='http://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>\r\n"
        		+ "<style>body{\r\n"
        		+ "    background-color: #c5cae9;\r\n"
        		+ "    padding: 25px;\r\n"
        		+ "  }\r\n"
        		+ "  \r\n"
        		+ "  .container{\r\n"
        		+ "    width: 1200px;\r\n"
        		+ "    height: 440px;\r\n"
        		+ "    margin: 0 auto;\r\n"
        		+ "    padding-left: 32px;\r\n"
        		+ "    padding-right: 32px;\r\n"
        		+ "    padding-top: 40px;\r\n"
        		+ "    border-radius: 12px;\r\n"
        		+ "    background-color: #868686;\r\n"
        		+ "    font-family: Lato;\r\n"
        		+ "  }\r\n"
        		+ "  \r\n"
        		+ "  .container h2{\r\n"
        		+ "    text-align: center;\r\n"
        		+ "  }\r\n"
        		+ "  \r\n"
        		+ "  table{\r\n"
        		+ "    width: 30%;\r\n"
        		+ "    margin: 0 auto;\r\n"
        		+ "  }\r\n"
        		+ "  \r\n"
        		+ "  td, th {\r\n"
        		+ "    padding: 12px;\r\n"
        		+ "    border: 2px dotted;\r\n"
        		+ "  }\r\n"
        		+ "  </style>\r\n"
        		+ "  </head>\r\n"
        		+ "  <body>\r\n"
        		+ "    <div class=\"container\">\r\n"
        		+ "      <h2>HTML TABLE</h2>\r\n"
        		+ "      <form action=\"markformconnect\" method=\"post\">\r\n"
        		+ "      <table  >\r\n"
        		+ "        <thead>\r\n"
        		+ "          <tr>\r\n"
        		+ "            <th>Name</th>\r\n"
        		+ "            <th>English</th>\r\n"
        		+ "            <th>hindi</th>\r\n"
        		+ "            <th>malayalam</th>\r\n"
        		+ "            <th>admission</th>\r\n"
        		+ "            <th>action</th>\r\n"
        		+ "            \r\n"
        		+ "          <tr>  \r\n"
        		+ "        </thead>\r\n"
        		+ "        <tbody>\r\n"
        		+ "          <tr>\r\n"
        		+ "            <td><input type=\"text\" name=\"Name\"  ></td>\r\n"
        		+ "            <td><input type=\"text\" name=\"English\"></td>\r\n"
        		+ "            <td><input type=\"text\" name=\"hindi\"></td>\r\n"
        		+ "            <td><input type=\"text\" name=\"malayalam\"></td>\r\n"
        		+ "            <td><input type=\"text\" name=\"admission\"></td>\r\n"
        		+ "            <td><button type=\"submit\" >submit</button></td>\r\n"
        		+ "          </tr>\r\n"
        		+ "       \r\n"
        		+ "        </tbody>\r\n"
        		+ "       \r\n"
        		+ "      </table>\r\n"
        		+ "    </form>\r\n"
        		+ "    </div>\r\n"
        		+ "  </body>\r\n"
        		+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
