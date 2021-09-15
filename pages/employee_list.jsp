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

 		SQL.append("SELECT * ");
 		SQL.append("FROM employee ");
 		SQL.append("ORDER BY employee_type");
     
 		rs = stmt.executeQuery(SQL.toString());

 		while (rs.next()){
				map = new HashMap<String,String>();
				map.put("employee_id",rs.getString("employee_id"));
				map.put("employee_name",rs.getString("employee_name"));
				map.put("employee_name_sub",rs.getString("employee_name_sub"));
				map.put("employee_birthday",rs.getString("employee_birthday"));
				map.put("employee_gender",rs.getString("employee_gender"));
				map.put("employee_email",rs.getString("employee_email"));
				map.put("employee_phone",rs.getString("employee_phone"));
				map.put("employee_zipcode",rs.getString("employee_zipcode"));
				map.put("employee_address",rs.getString("employee_address"));
				map.put("employee_type",rs.getString("employee_type"));
				map.put("company_join",rs.getString("company_join"));
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
    <title>従業員一覧</title>
  </head>
  <body>
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
              class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
            >
              シフト登録
            </a>
            <a
              href="/SD/pages/employee_list.jsp"
              class="py-2 px-6 bg-blue-200 hover:bg-blue-100 font-bold rounded-full"
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
                  <th>従業員氏名（フリガナ）</th> 
                  <th>生年月日</th> 
                  <th>性別</th>
                  <th>電話番号</th> 
                  <th>メールアドレス</th> 
                  <th>従業員タイプ</th> 
                  <th>入社年月日</th> 
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
                      <%= list.get(i).get("employee_name_sub") %>
                    </td> 
                    <td>
                      <%= list.get(i).get("employee_birthday") %>
                    </td> 
                    
                    <% if (list.get(i).get("employee_gender").equals("1")) { %>
                      <td>男</td> 
                    <% } else if (list.get(i).get("employee_type").equals("2")) { %>
                      <td>女</td> 
                    <% } else { %>
                      <td>その他</td> 
                    <% } %>

                    <td>
                      <%= list.get(i).get("employee_phone") %>
                    </td> 
                    <td>
                      <%= list.get(i).get("employee_email") %>
                    </td> 

                    <% if (list.get(i).get("employee_type").equals("1")) { %>
                      <td>店長</td> 
                    <% } else if (list.get(i).get("employee_type").equals("2")) { %>
                      <td>正社員</td> 
                    <% } else { %>
                      <td>アルバイト</td> 
                    <% } %>

                    <td>
                      <%= list.get(i).get("company_join") %>
                    </td> 
                    <td class="text-center w-24">
                      <form action="/SD/servlet/employee_edit" method="POST">
                        <input 
                          type="hidden"
                          name="EMPLOYEE_ID"
                          value="<%= list.get(i).get("employee_id") %>"
                        />
                        <button class="btn btn-sm btn-info">編集</button>
                      </form>
                    </td>
                    <td class="text-center w-24">
                      <form action="/SD/servlet/employee_delete" method="POST">
                        <input 
                          type="hidden"
                          name="EMPLOYEE_ID"
                          value="<%= list.get(i).get("employee_id") %>"
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
