<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.HashMap" %>
<%@ page import = "java.util.ArrayList" %>
<%
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");

  String employee_id = (String)session.getAttribute("employee_id");
  if (employee_id.equals("")) response.sendRedirect("http://localhost:8080/SD/pages/signin.html");
  String employee_type = (String)session.getAttribute("employee_type");
  String employee_name = (String)session.getAttribute("employee_name");

 	String USER = "miyasan";
 	String PASSWORD = "0301";
 	String URL = "jdbc:mysql://localhost/sd_kadai";
 	String DRIVER = "com.mysql.jdbc.Driver";

 	Connection con = null;
 	Statement stmt = null;
 	StringBuffer SQL = null;
 	ResultSet rs = null;
 	StringBuffer ERMSG = null;

	 
	String join_check_result = ""; 
	String attendance_id = ""; 

 	try {
 		Class.forName(DRIVER).newInstance();

 		con = DriverManager.getConnection(URL,USER,PASSWORD);

 		stmt = con.createStatement();

 		SQL = new StringBuffer();

 		SQL.append("SELECT attendance_id, employee_name ");
 		SQL.append("FROM attendance, employee ");
 		SQL.append("WHERE attendance.employee_id = employee.employee_id ");
		SQL.append("AND attendance.employee_id = '");
		SQL.append(employee_id);
		SQL.append("' ");
 		SQL.append("AND attendance_leaving IS NULL ");

 		rs = stmt.executeQuery(SQL.toString());

 		if (rs.next()) {
			join_check_result = rs.getString("employee_name");
			attendance_id = rs.getString("attendance_id");
		}

	} catch (ClassNotFoundException e) {
		ERMSG = new StringBuffer();
		ERMSG.append(e.getMessage());
	} catch (SQLException e) {
		ERMSG = new StringBuffer();
		ERMSG.append(e.getMessage());
	} catch (Exception e) {
		ERMSG = new StringBuffer();
		ERMSG.append(e.getMessage());
	} finally {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			ERMSG = new StringBuffer();
			ERMSG.append(e.getMessage());
		}
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link
			href="https://cdn.jsdelivr.net/npm/tailwindcss@2.1/dist/tailwind.min.css"
			rel="stylesheet"
			type="text/css"
		/>
		<link
			href="https://cdn.jsdelivr.net/npm/daisyui@1.14.0/dist/full.css"
			rel="stylesheet"
			type="text/css"
		/>
		<title>退勤登録</title>
	</head>
	<body>
		<form action="/SD/servlet/shift_leaving" method="POST">
			<div class="flex flex-col w-full h-screen">
				<header class="w-full bg-blue-400 py-4 border-b border-gray-200">
					<h1 class="text-2xl pl-8 font-bold text-white">
						カラオケシステム
					</h1>
				</header>
				
				<div class="flex flex-1 w-full bg-gray-100">
					<nav class="w-1/6 min-w-max border-r border-gray-200">
						<div class="flex flex-col gap-2 p-4">
							<a
								href="/SD/pages/index.jsp"
								class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
							>
								ホーム
							</a>
							<a
								href="/SD/pages/shift_join.jsp"
								class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
							>
								出勤登録
							</a>
							<a
								href="/SD/pages/shift_leaving.jsp"
								class="py-2 px-6 bg-blue-200 hover:bg-blue-100 font-bold rounded-full"
							>
								退勤登録
							</a>
							<a
								href="/SD/pages/shift_list.jsp"
								class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
							>
								シフト一覧
							</a>
							<a
								href="/SD/pages/shift_regist.jsp"
								class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
							>
								シフト登録
							</a>
							<a
								href="/SD/pages/employee_list.jsp"
								class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
							>
								従業員一覧
							</a>

							<% if (employee_type.equals("1") || employee_type.equals("2")) { %>
								<a
									href="/SD/pages/employee_regist.jsp"
									class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
								>
									従業員登録
								</a>
							<% } %>

              <hr class="text-gray-300">
              
              <a
                href="/SD/pages/signout.jsp"
                class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
              >
                サインアウト
              </a>
						</div>
					</nav>

					<main class="flex flex-1 flex-col items-center overflow-scroll">
						<div class="flex flex-col gap-2 w-2/3 max-w-sm">
							<h1
								class="
									pt-8
									text-center
									text-2xl
									md:text-3xl
									font-medium
									text-gray-800
								"
							>
								退勤登録
							</h1>
							
							<% if (join_check_result.equals("")) { %>
								<p class="pt-4 text-center text-lg text-red-400">出勤していません</p>
							<% } else { %>
								<label
									for="employee_id"
									class="pl-1 text-gray-600"
									>従業員氏名</label
								>
								<input 
									type="text"
									value="<%= join_check_result %>"
									disabled
									class="input input-info input-bordered w-full"
								/>

								<input 
									type="hidden"
									name="ATTENDANCE_ID"
									value="<%= attendance_id %>"
								/>

								<button class="
										w-full
										mx-auto
										text-white
										bg-blue-500
										border-0
										py-3
										px-8
										mt-2
										focus:outline-none
										hover:bg-blue-600
										text-lg
										rounded-full"
									>退勤</button>
							<% } %>

						</div>
					</main>
				</div>
			</div>
		</form>
	</body>
</html>
