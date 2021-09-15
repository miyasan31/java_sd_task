<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.HashMap" %>
<%@ page import = "java.util.ArrayList" %>

 <%
 	request.setCharacterEncoding("UTF-8");
 	response.setCharacterEncoding("UTF-8");

 	Connection con = null;
 	Statement stmt = null;
 	StringBuffer SQL = null;
 	ResultSet rs = null;

 	String USER = "miyasan";
 	String PASSWORD = "0301";
 	String URL = "jdbc:mysql://localhost/sd_kadai";
 	String DRIVER = "com.mysql.jdbc.Driver";

 	StringBuffer ERMSG = null;

 	HashMap<String,String> map = null;

 	ArrayList<HashMap> list = null;
 	list = new ArrayList<HashMap>();

 	try{
 		Class.forName(DRIVER).newInstance();

 		con = DriverManager.getConnection(URL,USER,PASSWORD);

 		stmt = con.createStatement();

 		SQL = new StringBuffer();

 		SQL.append("SELECT employee_id, employee_name FROM employee");

 		rs = stmt.executeQuery(SQL.toString());

 		while (rs.next()){
				map = new HashMap<String,String>();
				map.put("employee_id",rs.getString("employee_id"));
				map.put("employee_name",rs.getString("employee_name"));
				list.add(map);
			}
 		}

 		catch(ClassNotFoundException e){
			ERMSG = new StringBuffer();
			ERMSG.append(e.getMessage());
 		}
 		catch(SQLException e){
			ERMSG = new StringBuffer();
			ERMSG.append(e.getMessage());
 		}
 		catch(Exception e){
			ERMSG = new StringBuffer();
			ERMSG.append(e.getMessage());
 		}

 		finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(con != null){
					con.close();
				}
			}
			catch(SQLException e){
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
	<title>シフト登録</title>
 </head>
 <body>
	<form action="/SD/servlet/shift_regist" method="POST">
    <div class="flex flex-col w-full h-screen">
      <header class="w-full bg-blue-400 py-4 border-b border-gray-200">
        <h1 class="text-center text-4xl font-bold text-white">
          カラオケシステム
        </h1>
      </header>
      <div class="flex flex-1 w-full bg-gray-100">
        <nav class="w-1/5 border-r border-gray-200">
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
              class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
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
              class="py-2 px-6 bg-blue-200 hover:bg-blue-100 font-bold rounded-full"
            >
              シフト登録
            </a>
						<a
							href="/SD/pages/employee_list.jsp"
							class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
						>
							従業員一覧
						</a>
            <a
              href="/SD/pages/employee_regist.html"
              class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
            >
              従業員登録
            </a>
            <a
              href="/SD/pages/signin.html"
              class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
            >
              ログアウト
            </a>
          </div>
        </nav>

        <main class="w-4/5 flex flex-col justify-center items-center">
					<div class="flex flex-col gap-2 w-96">
						<h1
							class="
								text-center
								sm:text-3xl
								text-2xl
								font-medium
								title-font
								text-gray-800
							"
						>
							シフト登録
						</h1>

						<label
							for="shift_join_year"
							class="pl-1 text-gray-600"
							>従業員氏名</label
						>
						<select name="EMPLOYEE_ID" class="select select-bordered select-info w-full">
								<option selected disabled>選択してください</option>
								<% for (int i = 0; i < list.size(); i++) { %>
										<option value="<%= list.get(i).get("employee_id") %>">
											<%= list.get(i).get("employee_name") %>
										</option>
								<% } %>
						</select>
						
						<label
							for="shift_join_ymd"
							class="pl-1 text-gray-600"
							>出勤予定日</label
						>
						<input
							type="date"
							id="shift_join_ymd"
							name="SHIFT_JOIN_YMD"
							value=""
							class="input input-info input-bordered w-full"
						/>
						
						<label
							for="shift_join_hour"
							class="pl-1 text-gray-600"
							>出勤予定時刻</label
						>
						<div class="flex items-center">
							<input
								type="number"
								id="shift_join_hour"
								name="SHIFT_JOIN_HOUR"
								value=""
								class="input input-info input-bordered w-full"
							/>
							<label
								for="shift_join_hour"
								class="px-2 text-gray-600"
								>時</label
							>

							<input
								type="number"
								id="shift_join_minute"
								name="SHIFT_JOIN_MINUTE"
								value=""
								class="input input-info input-bordered w-full"
							/>
							<label
								for="shift_join_minute"
								class="px-2 text-gray-600"
								>分</label
							>
						</div>

						<label
							for="shift_leaving_ymd"
							class="pl-1 text-gray-600"
							>退勤予定日</label
						>
						<input
							type="date"
							id="shift_leaving_ymd"
							name="SHIFT_LEAVING_YMD"
							value=""
							class="input input-info input-bordered w-full"
						/>

						
						<label
							for="shift_leaving_hour"
							class="pl-1 text-gray-600"
							>退勤予定時刻</label
						>
						<div class="flex items-center">
							<input
								type="number"
								id="shift_leaving_hour"
								name="SHIFT_LEAVING_HOUR"
								value=""
								class="input input-info input-bordered w-full"
							/>
							<label
								for="shift_leaving_hour"
								class="px-2 text-gray-600"
								>時</label
							>

							<input
								type="number"
								id="shift_leaving_minute"
								name="SHIFT_LEAVING_MINUTE"
								value=""
								class="input input-info input-bordered w-full"
							/>
							<label
								for="shift_leaving_minute"
								class="px-2 text-gray-600"
								>分</label
							>
						</div>



						<button class="
								w-full
								mx-auto
								text-white
								bg-blue-500
								border-0
								py-2
								px-8
								mt-2
								focus:outline-none
								hover:bg-blue-600
								text-lg
								rounded-full"
							>送信</button>
					</div>
        </main>
      </div>
    </div>
	</form>
 </body>
</html>