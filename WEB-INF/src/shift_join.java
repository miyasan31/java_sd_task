import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import java.text.*;

public class shift_join extends HttpServlet {
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

		StringBuffer query = new StringBuffer();

		String employee_id = req.getParameter("EMPLOYEE_ID");
		
		SimpleDateFormat date_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String join_date_time = date_time.format(new Date());

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			stmt = con.createStatement();

			StringBuffer sb = new StringBuffer();

			sb.append("<html>");
				sb.append("<head>");
					sb.append("<title>出勤登録</title>");
					sb.append("<link href='https://cdn.jsdelivr.net/npm/tailwindcss@2.1/dist/tailwind.min.css' rel='stylesheet' type='text/css' />");
					sb.append("<link href='https://cdn.jsdelivr.net/npm/daisyui@0.26.3/dist/full.css' rel='stylesheet' type='text/css' />");
				sb.append("</head>");
				sb.append("<body>");
					sb.append("<div class='h-screen w-full'>");
						sb.append("<div class='text-2xl text-center bg-primary py-5 font-bold text-white'>出勤登録</div>");
						sb.append("<div class='px-5'>");

							query = new StringBuffer();

							query.append("INSERT INTO attendance ");
							query.append("(employee_id, attendance_join) ");
							query.append("VALUES('");
							query.append(employee_id);
							query.append("','");
							query.append(join_date_time);
							query.append("')");

							stmt.executeUpdate(query.toString());

							sb.append("<div class='text-secondary text-lg text-center py-3 bg-white'>出勤登録完了</div>");
							sb.append("<div class='flex justify-center pt-5'>");
								sb.append("<a href='/SD/pages/shift_join.jsp' class='btn btn-link'>ホームに戻る</a>");
							sb.append("</div>");
						sb.append("</div>");
					sb.append("</div>");
				sb.append("</body>");
			sb.append("</html>");

			out.println(sb.toString());
			stmt.close();
			con.close();
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
