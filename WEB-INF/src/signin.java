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


public class signin extends HttpServlet {
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

		String employee_email = req.getParameter("EMPLOYEE_EMAIL");
		String employee_password = req.getParameter("EMPLOYEE_PASSWORD");
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			stmt = con.createStatement();

			StringBuffer query = new StringBuffer();

			query.append("SELECT * FROM employee WHERE ");
			query.append("employee_email = '");
			query.append(employee_email);
			query.append("' ");
			query.append("AND ");
			query.append("employee_password = '");
			query.append(employee_password);
			query.append("'");

			ResultSet rs = stmt.executeQuery(query.toString());
			
      ServletContext sc = getServletContext();

			HttpSession session = req.getSession(false);
			
			if (rs.next()) {
				session.setAttribute("employee_id", rs.getString("employee_id"));
				session.setAttribute("employee_name", rs.getString("employee_name"));
				session.setAttribute("employee_type", rs.getString("employee_type"));
        sc.getRequestDispatcher("/pages/index.jsp").forward(req, res);
			} else {
				req.setAttribute("error", "error");
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
