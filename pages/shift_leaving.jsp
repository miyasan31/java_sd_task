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

 		SQL.append("SELECT working_shift_id, employee_name ");
 		SQL.append("FROM working_shift, employee ");
 		SQL.append("WHERE working_shift.employee_id = employee.employee_id ");
 		SQL.append("AND working_shift_leaving IS NULL");

 		rs = stmt.executeQuery(SQL.toString());

 		while (rs.next()){
 						map = new HashMap<String,String>();
						map.put("working_shift_id",rs.getString("working_shift_id"));
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
	<title>出勤登録</title>
 </head>
 <body>
	<form action="/SD/servlet/shift_leaving" method="POST">
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
              class="py-2 px-6 bg-blue-200 hover:bg-blue-100 font-bold rounded-full"
            >
              退勤登録
            </a>
            <a
              href="/SD/pages/employee_insert.html"
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
					<div class="flex flex-col gap-4 w-96">
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
							退勤登録
						</h1>

						<select name="WORKING_SHIFT_ID" class="select select-bordered select-info w-full">
								<option selected disabled>選択してください</option>
								<% for (int i = 0; i < list.size(); i++) { %>
										<option value="<%= list.get(i).get("working_shift_id") %>">
											<%= list.get(i).get("employee_name") %>
										</option>
								<% } %>
						</select>

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
