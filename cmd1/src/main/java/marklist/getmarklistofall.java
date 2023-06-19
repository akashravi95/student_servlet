package marklist;

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
 * Servlet implementation class getmarklistofall
 */
@WebServlet("/getmarklistofall")
public class getmarklistofall extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DB_URL = "jdbc:mysql://localhost:3306/cmd_1";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    public getmarklistofall() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text.html");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");  
	        Connection con=DriverManager.getConnection( DB_URL, DB_USER, DB_PASSWORD);
	        Statement stmt=con.createStatement();
	        ResultSet rs=stmt.executeQuery("select * from marklist");
	        out.println("<!DOCTYPE html>\r\n"
	        		+ "<html lang=\"en\">\r\n"
	        		+ "<head>\r\n"
	        		+ "\r\n"
	        		+ "<meta charset=\"utf-8\">\r\n"
	        		+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
	        		+ "\r\n"
	        		+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x\" crossorigin=\"anonymous\">\r\n"
	        		+ "</head>\r\n"
	        		+ "<style>\r\n"
	        		+ "\r\n"
	        		+ "</style>\r\n"
	        		+ "<body>\r\n"
	        		+ "<div class=\"container\">\r\n"
	        		+ "  <a href=\"addmarklist\" class=\"btn btn-primary btn-xs pull-right\"><b>+</b> Add new marklist</a>\r\n"
	        		+ "    <h1>MARKLIST</h1>\r\n"
	        		+ "<table class=\"table table-striped table-bordered mt-5\">\r\n"
	        		+ "<thead  >\r\n"
	        		+ "<tr>\r\n"
	        		+ "    <tr>\r\n"
	        		+ "        <th>Roll No.</th>\r\n"
	        		+ "        <th>Name</th>\r\n"
	        		+ "        <th>English</th>\r\n"
	        		+ "        <th>hindi</th>\r\n"
	        		+ "        <th>malayalam</th>\r\n"
	        		+ "        <th>admission</th>\r\n"
	        		+ "        <th>action</th>\r\n"
	        		+ "        \r\n"
	        		+ "    </tr>  \r\n"
	        		+ "</tr>\r\n"
	        		+ "</thead>");
	        while(rs.next())
	        {
	        	out.println(" <tbody>\r\n"
	        			+ "          <tr>\r\n"
	        			+ "            <td>"+rs.getString("id")+"</td>\r\n"
	        			+ "            <td>"+rs.getString("name")+"</td>\r\n"
	        			+ "            <td>"+rs.getString("english")+"</td>\r\n"
	        			+ "            <td>"+rs.getString("hindi")+"</td>\r\n"
	        			+ "            <td>"+rs.getString("malayalam")+"</td>\r\n"
	        			+ "            <td>"+rs.getString("adm_id")+"</td>\r\n"
	        					+ "            <td><div class=\"container\">\r\n"
	        					+ "    <div class=\"row\">\r\n"
	        					+ "      <div class=\"col-2\">\r\n"
	        					+ "        <button type=\"button\" class=\"btn btn-primary \">_view_</button>\r\n"
	        					+ "      </div>\r\n"
	        					+ "      <div class=\"col-2\">\r\n"
	        					+ "       <a href='updatemark?id="+rs.getString("id")+"'> <button type=\"button\" class=\"btn btn-success\">update</button></a>\r\n"
	        					+ "      </div>\r\n"
	        					+ "      <div class=\"col-2\">\r\n"
	        					+ "       <button type=\"button\" class=\"btn btn-danger\">delete</button></td>\r\n"
	        					+ "      </div>\r\n"
	        					+ "    </div>\r\n"
	        					+ "  </div></td>\r\n"
//	        			+ "            <td><td class=\"text-center\"><a class='btn btn-info btn-xs' href=><span class=\"glyphicon glyphicon-edit\"></span> Edit</a> <a href='deletemark?id="+rs.getString("id")+"' class=\"btn btn-danger btn-xs\"><span class=\"glyphicon glyphicon-remove\"></span> Del</a></td></td>\r\n"
	        			+ "          </tr>\r\n"
	        			+ "       \r\n"
	        			+ "        </tbody>\r\n");
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
