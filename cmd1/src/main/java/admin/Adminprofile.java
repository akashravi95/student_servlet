package admin;

import java.io.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Adminprofile
 */
@WebServlet("/Adminprofile")
public class Adminprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminprofile() {
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
	        out.println("<head>\r\n"
	        		+ "    <meta charset=\"UTF-8\">\r\n"
	        		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
	        		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
	        		+ "    <title>Document</title>\r\n"
	        		+ "        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ\" crossorigin=\"anonymous\">\r\n"
	        		+ "<style>\r\n"
	        		+ "    body#LoginForm{ background-image:url(\"https://hdwallsource.com/img/2014/9/blur-26347-27038-hd-wallpapers.jpg\"); background-repeat:no-repeat; background-position:center; background-size:cover; padding:10px;}\r\n"
	        		+ ".col-md-3\r\n"
	        		+ "{\r\n"
	        		+ "    position: relative;\r\n"
	        		+ "    top: 150px;\r\n"
	        		+ "}\r\n"
	        		+ "</style>\r\n"
	        		+ "</head>\r\n"
	        		+ "<body id=\"LoginForm\">\r\n"
	        		+ "    <div class=\"container-fluid\">\r\n"
	        		+ "        <div class=\"row\">\r\n"
	        		+ "      <div class=\"col-md-3\"><div class=\"card w-75 mb-3 container\">\r\n"
	        		+ "        <div class=\"card-body\">\r\n"
	        		+ "          <h5 class=\"card-title\"> Students<br> data</h5>\r\n"
	        		+ " 			<img src=\"https://cdn-icons-png.flaticon.com/512/201/201818.png\" width=\"70%\"alt=\"\">								\r\n"
	        		+ "          <p class=\"card-text\">view all students </p>\r\n"
	        		+ "          <a href=\"studentsalldata\" class=\"btn btn-primary\">click  </a>\r\n"
	        		+ "        </div>\r\n"
	        		+ "      </div></div>\r\n"
	        		+ "      <div class=\"col-md-3\"><div class=\"card w-75 mb-3 container\">\r\n"
	        		+ "        <div class=\"card-body\">\r\n"
	        		+ "          <h5 class=\"card-title\">Teachers <br>data</h5>\r\n"
	        		+ " 			<img src=\"https://cdn-icons-png.flaticon.com/512/194/194936.png\" width=\"70%\"alt=\"\">								\r\n"
	        		+ "          <p class=\"card-text\">view all teachers </p>\r\n"
	        		+ "          <a href=\"teachersall\" class=\"btn btn-primary\">click</a>\r\n"
	        		+ "        </div>\r\n"
	        		+ "      </div></div>\r\n"
	        		+ "      <div class=\"col-md-3\"><div class=\"card w-75 mb-3 container\">\r\n"
	        		+ "        <div class=\"card-body\">\r\n"
	        		+ "          <h5 class=\"card-title\">Marklist <br>student</h5>\r\n"
	        		+ " 			<img src=\"https://icon-library.com/images/results-icon-png/results-icon-png-3.jpg\" width=\"70%\"alt=\"\">								\r\n"
	        		+ "          <p class=\"card-text\">view marks of student </p>\r\n"
	        		+ "          <a href=\"getmarklistofall\" class=\"btn btn-primary\">Marksheet</a>\r\n"
	        		+ "        </div>\r\n"
	        		+ "      </div></div>\r\n"
	        		+ "\r\n"
	        		+ "        </div>\r\n"
	        		+ "    </div>\r\n"
	        		+ "</body>\r\n"
	        		+ "</html>");
	}



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		
	}

}
