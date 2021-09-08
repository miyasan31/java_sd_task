import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class signin extends HttpServlet {
	public void doPost (
			HttpServletRequest req,
			HttpServletResponse res )
		throws ServletException , IOException {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html; charset=UTF-8");
			
		final String URL = "jdbc:mysql://localhost/sd_kadai?useUnicode=true&characterEncoding=UTF-8";
		final String USER = "miyasan";
		final String PASSWORD = "0301";
		final String DRIVER = "com.mysql.jdbc.Driver";

		Connection con = null;
		Statement stmt = null;
		PrintWriter out;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		out = res.getWriter();
		
		String employee_email = req.getParameter("EMPLOYEE_EMAIL");
		String employee_password = req.getParameter("EMPLOYEE_PASSWORD");
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			stmt = con.createStatement();

			StringBuffer query = new StringBuffer();
			query.append("select * from employee where ");
			query.append("employee_email = '");
			query.append(employee_email);
			query.append("' ");
			query.append("AND ");
			query.append("employee_password = '");
			query.append(employee_password);
			query.append("'");

			ResultSet rs = stmt.executeQuery(query.toString());
			
			if (rs.next()) {
				req.setAttribute("employee_email", rs.getString("employee_email"));
				req.setAttribute("employee_password", rs.getString("employee_password"));

        ServletContext sc = getServletContext();
        sc.getRequestDispatcher("/pages/index.jsp").forward(req, res);
			} else {
				req.setAttribute("error", "error");

				ServletContext sc = getServletContext();
        sc.getRequestDispatcher("/pages/signin.jsp").forward(req, res);
      }
			
			
		} catch (SQLException ex) {
			out.println(" ---- SQL Exception ----");
			out.println(" ---- Error Message ----");
			while (ex != null) {
				out.println(ex.getMessage());
				ex = ex.getNextException();
			}
		} catch (Exception ex) {
			ex.printStackTrace(out);
		}
	}
}
