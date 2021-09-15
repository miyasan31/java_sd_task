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

 		SQL.append("SELECT shift_id, employee_name, shift_join_schedule, shift_leaving_schedule ");
 		SQL.append("FROM work_shift, employee ");
 		SQL.append("WHERE work_shift.employee_id = employee.employee_id ");
 		SQL.append("ORDER BY work_shift.shift_join_schedule");
     
 		rs = stmt.executeQuery(SQL.toString());

 		while (rs.next()){
				map = new HashMap<String,String>();
				map.put("shift_id",rs.getString("shift_id"));
				map.put("employee_name",rs.getString("employee_name"));
				map.put("shift_join_schedule",rs.getString("shift_join_schedule"));
				map.put("shift_leaving_schedule",rs.getString("shift_leaving_schedule"));
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
    <title>シフト一覧</title>
  </head>
  <body>
    <div class="flex flex-col w-full h-screen">
      <header class="w-full bg-blue-400 py-4 border-b border-gray-200">
        <h1 class="text-center text-4xl font-bold text-white">
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
              class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
            >
              退勤登録
            </a>
            <a
              href="/SD/pages/shift_list.jsp"
              class="py-2 px-6 bg-blue-200 hover:bg-blue-100 font-bold rounded-full"
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

        <main class="flex flex-1 flex-col items-center overflow-scroll">
          <div class="flex-1 overflow-auto w-full">
            <table class="table w-full">
              <thead>
                <tr>
                  <th>従業員氏名</th> 
                  <th>出勤予定日</th> 
                  <th>退勤予定日</th> 
                  <th></th>
                  <th></th>
                </tr>
              </thead> 
              <tbody>
                <% for (int i = 0; i < list.size(); i++) { %>
                  <tr>
                    <th>
                      <%= list.get(i).get("employee_name") %>
                    </th> 
                    <td>
                      <%= list.get(i).get("shift_join_schedule") %>
                    </td> 
                    <td>
                      <%= list.get(i).get("shift_leaving_schedule") %>
                    </td> 
                    <td class="text-center w-24">
                      <form action="/SD/servlet/shift_edit" method="POST">
                        <input 
                          type="hidden"
                          name="SHIFT_ID"
                          value="<%= list.get(i).get("shift_id") %>"
                        />
                        <button class="btn btn-sm btn-info">編集</button>
                      </form>
                    </td>
                    <td class="text-center w-24">
                      <form action="/SD/servlet/shift_delete" method="POST">
                        <input 
                          type="hidden"
                          name="SHIFT_ID"
                          value="<%= list.get(i).get("shift_id") %>"
                        />
                        <button class="btn btn-sm btn-error">削除</button>
                      </form>
                    </td>
                  </tr>
                <% } %>
              </tbody>
            </table>
          </div>
        </main>
      </div>
    </div>
  </body>
</html>
