import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;

public class signout extends HttpServlet {
	public void doPost (HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
			
		final String URL = "jdbc:mysql://localhost/sd_kadai?useUnicode=true&characterEncoding=UTF-8";
		final String USER = "miyasan";
		final String PASSWORD = "0301";
		final String DRIVER = "com.mysql.jdbc.Driver";

		Connection con = null;
		Statement stmt = null;
		PrintWriter out;
		out = res.getWriter();
		
		ServletContext sc = getServletContext();
		
		HttpSession session = req.getSession();

		session.setAttribute("employee_type", "");
		session.setAttribute("employee_id", "");
		session.setAttribute("employee_name", "");
		
		res.sendRedirect("http://localhost:8080/SD/pages/signin.html");
	}
}
