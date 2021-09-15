package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;

public final class shift_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" ");

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
 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <link\r\n");
      out.write("      href=\"https://cdn.jsdelivr.net/npm/tailwindcss@2.1/dist/tailwind.min.css\"\r\n");
      out.write("      rel=\"stylesheet\"\r\n");
      out.write("      type=\"text/css\"\r\n");
      out.write("    />\r\n");
      out.write("    <link\r\n");
      out.write("      href=\"https://cdn.jsdelivr.net/npm/daisyui@1.14.0/dist/full.css\"\r\n");
      out.write("      rel=\"stylesheet\"\r\n");
      out.write("      type=\"text/css\"\r\n");
      out.write("    />\r\n");
      out.write("    <title>シフト一覧</title>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <div class=\"flex flex-col w-full h-screen\">\r\n");
      out.write("      <header class=\"w-full bg-blue-400 py-4 border-b border-gray-200\">\r\n");
      out.write("        <h1 class=\"text-2xl pl-8 font-bold text-white\">\r\n");
      out.write("          カラオケシステム\r\n");
      out.write("        </h1>\r\n");
      out.write("      </header>\r\n");
      out.write("\t\t\t\r\n");
      out.write("      <div class=\"flex flex-1 w-full bg-gray-100\">\r\n");
      out.write("        <nav class=\"w-1/6 min-w-max border-r border-gray-200\">\r\n");
      out.write("          <div class=\"flex flex-col gap-2 p-4\">\r\n");
      out.write("            <a\r\n");
      out.write("              href=\"/SD/pages/index.jsp\"\r\n");
      out.write("              class=\"py-2 px-6 hover:bg-blue-100 font-bold rounded-full\"\r\n");
      out.write("            >\r\n");
      out.write("              ホーム\r\n");
      out.write("            </a>\r\n");
      out.write("            <a\r\n");
      out.write("              href=\"/SD/pages/shift_join.jsp\"\r\n");
      out.write("              class=\"py-2 px-6 hover:bg-blue-100 font-bold rounded-full\"\r\n");
      out.write("            >\r\n");
      out.write("              出勤登録\r\n");
      out.write("            </a>\r\n");
      out.write("            <a\r\n");
      out.write("              href=\"/SD/pages/shift_leaving.jsp\"\r\n");
      out.write("              class=\"py-2 px-6 hover:bg-blue-100 font-bold rounded-full\"\r\n");
      out.write("            >\r\n");
      out.write("              退勤登録\r\n");
      out.write("            </a>\r\n");
      out.write("            <a\r\n");
      out.write("              href=\"/SD/pages/shift_list.jsp\"\r\n");
      out.write("              class=\"py-2 px-6 bg-blue-200 hover:bg-blue-100 font-bold rounded-full\"\r\n");
      out.write("            >\r\n");
      out.write("              シフト一覧\r\n");
      out.write("            </a>\r\n");
      out.write("            <a\r\n");
      out.write("              href=\"/SD/pages/shift_regist.jsp\"\r\n");
      out.write("              class=\"py-2 px-6 hover:bg-blue-100 font-bold rounded-full\"\r\n");
      out.write("            >\r\n");
      out.write("              シフト登録\r\n");
      out.write("            </a>\r\n");
      out.write("            <a\r\n");
      out.write("              href=\"/SD/pages/employee_list.jsp\"\r\n");
      out.write("              class=\"py-2 px-6 hover:bg-blue-100 font-bold rounded-full\"\r\n");
      out.write("            >\r\n");
      out.write("              従業員一覧\r\n");
      out.write("            </a>\r\n");
      out.write("            <a\r\n");
      out.write("              href=\"/SD/pages/employee_regist.html\"\r\n");
      out.write("              class=\"py-2 px-6 hover:bg-blue-100 font-bold rounded-full\"\r\n");
      out.write("            >\r\n");
      out.write("              従業員登録\r\n");
      out.write("            </a>\r\n");
      out.write("            <a\r\n");
      out.write("              href=\"/SD/pages/signin.html\"\r\n");
      out.write("              class=\"py-2 px-6 hover:bg-blue-100 font-bold rounded-full\"\r\n");
      out.write("            >\r\n");
      out.write("              ログアウト\r\n");
      out.write("            </a>\r\n");
      out.write("          </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("        <main class=\"flex flex-1 flex-col items-center overflow-scroll\">\r\n");
      out.write("          <div class=\"flex-1 overflow-auto w-full\">\r\n");
      out.write("            <table class=\"table w-full\">\r\n");
      out.write("              <thead>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <th>従業員氏名</th> \r\n");
      out.write("                  <th>出勤予定日</th> \r\n");
      out.write("                  <th>退勤予定日</th> \r\n");
      out.write("                  <th></th>\r\n");
      out.write("                  <th></th>\r\n");
      out.write("                </tr>\r\n");
      out.write("              </thead> \r\n");
      out.write("              <tbody>\r\n");
      out.write("                ");
 for (int i = 0; i < list.size(); i++) { 
      out.write("\r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <th>\r\n");
      out.write("                      ");
      out.print( list.get(i).get("employee_name") );
      out.write("\r\n");
      out.write("                    </th> \r\n");
      out.write("                    <td>\r\n");
      out.write("                      ");
      out.print( list.get(i).get("shift_join_schedule") );
      out.write("\r\n");
      out.write("                    </td> \r\n");
      out.write("                    <td>\r\n");
      out.write("                      ");
      out.print( list.get(i).get("shift_leaving_schedule") );
      out.write("\r\n");
      out.write("                    </td> \r\n");
      out.write("                    <td class=\"text-center w-24\">\r\n");
      out.write("                      <form action=\"/SD/servlet/shift_edit\" method=\"POST\">\r\n");
      out.write("                        <input \r\n");
      out.write("                          type=\"hidden\"\r\n");
      out.write("                          name=\"SHIFT_ID\"\r\n");
      out.write("                          value=\"");
      out.print( list.get(i).get("shift_id") );
      out.write("\"\r\n");
      out.write("                        />\r\n");
      out.write("                        <button class=\"btn btn-sm btn-info\">編集</button>\r\n");
      out.write("                      </form>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td class=\"text-center w-24\">\r\n");
      out.write("                      <form action=\"/SD/servlet/shift_delete\" method=\"POST\">\r\n");
      out.write("                        <input \r\n");
      out.write("                          type=\"hidden\"\r\n");
      out.write("                          name=\"SHIFT_ID\"\r\n");
      out.write("                          value=\"");
      out.print( list.get(i).get("shift_id") );
      out.write("\"\r\n");
      out.write("                        />\r\n");
      out.write("                        <button class=\"btn btn-sm btn-error\">削除</button>\r\n");
      out.write("                      </form>\r\n");
      out.write("                    </td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                ");
 } 
      out.write("\r\n");
      out.write("              </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("          </div>\r\n");
      out.write("        </main>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
