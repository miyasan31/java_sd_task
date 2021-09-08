import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class employee_insert extends HttpServlet {
	
	public void doPost (
		HttpServletRequest req,
		HttpServletResponse res )
		throws ServletException , IOException {

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

		String employee_name = req.getParameter("EMPLOYEE_NAME");
		String employee_name_sub = req.getParameter("EMPLOYEE_NAME_SUB");
		String birthday_year = req.getParameter("BIRTHDAY_YEAR");
		String birthday_month = req.getParameter("BIRTHDAY_MONTH");
		String birthday_day = req.getParameter("BIRTHDAY_DAY");
		String employee_gender = req.getParameter("EMPLOYEE_GENDER");
		String employee_zipcode = req.getParameter("EMPLOYEE_ZIPCODE");
		String employee_address = req.getParameter("EMPLOYEE_ADDRESS");
		String employee_phone = req.getParameter("EMPLOYEE_PHONE");
		String employee_email = req.getParameter("EMPLOYEE_EMAIL");
		String employee_password = req.getParameter("EMPLOYEE_PASSWORD");
		String employee_type = req.getParameter("EMPLOYEE_TYPE");
		String company_join_year = req.getParameter("COMPANY_JOIN_YEAR");
		String company_join_month = req.getParameter("COMPANY_JOIN_MONTH");
		String company_join_day = req.getParameter("COMPANY_JOIN_DAY");

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			stmt = con.createStatement();

			StringBuffer query = new StringBuffer();
			query.append("select * from employee where employee_email ='");
			query.append(employee_email);
			query.append("'");
			ResultSet rs = stmt.executeQuery(query.toString());

			StringBuffer sb = new StringBuffer();
			sb.append("<html>");
				sb.append("<head>");
					sb.append("<title>従業員登録</title>");
					sb.append("<link href='https://cdn.jsdelivr.net/npm/tailwindcss@2.1/dist/tailwind.min.css' rel='stylesheet' type='text/css' />");
					sb.append("<link href='https://cdn.jsdelivr.net/npm/daisyui@0.26.3/dist/full.css' rel='stylesheet' type='text/css' />");
				sb.append("</head>");
				sb.append("<body>");
					sb.append("<div class='h-screen w-full'>");
						sb.append("<div class='text-2xl text-center bg-primary py-5 font-bold text-white'>従業員登録</div>");
						sb.append("<div class='px-5'>");
							if (rs.next()) {
								sb.append("<div class='text-secondary text-lg text-center py-3 bg-white'>従業員登録</div>");
								sb.append("<div class='text-center'>" + employee_email + "はすでに登録されています</div>");
							} else {
								query = new StringBuffer();
								query.append("INSERT INTO employee");
								query.append("(employee_name, employee_name_sub, employee_birthday, employee_gender, employee_zipcode, employee_address, ");
								query.append("employee_phone, employee_email, employee_password, employee_type, company_join) ");
								query.append("values('");
								query.append(employee_name);
								query.append("','");
								query.append(employee_name_sub);
								query.append("','");
								query.append(birthday_year + "-" + birthday_month + "-" + birthday_day);
								query.append("','");
								query.append(employee_gender);
								query.append("','");
								query.append(employee_zipcode);
								query.append("','");
								query.append(employee_address);
								query.append("','");
								query.append(employee_phone);
								query.append("','");
								query.append(employee_email);
								query.append("','");
								query.append(employee_password);
								query.append("','");
								query.append(employee_type);
								query.append("','");
								query.append(company_join_year + "-" + company_join_month + "-" + company_join_day);
								query.append("')");
								stmt.executeUpdate(query.toString());
								sb.append("<div class='text-secondary text-lg text-center py-3 bg-white'>従業員登録完了</div>");
							}
							sb.append("<div class='flex justify-center pt-5'>");
								sb.append("<a href='/SD/pages/employee_insert.html' class='btn btn-link'>登録に戻る</a>");
								sb.append("<a href='/SD/pages/index.jsp' class='btn btn-link'>ホームに戻る</a>");
							sb.append("</div>");
						sb.append("</div>");
					sb.append("</div>");
				sb.append("</body>");
			sb.append("</html>");
			out.println(sb.toString());
			stmt.close();
			con.close();
		}
		catch (SQLException ex) {
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
