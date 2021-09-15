package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;

public final class shift_005fjoin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write(" <head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t<link\r\n");
      out.write("\t\thref=\"https://cdn.jsdelivr.net/npm/tailwindcss@2.1/dist/tailwind.min.css\"\r\n");
      out.write("\t\trel=\"stylesheet\"\r\n");
      out.write("\t\ttype=\"text/css\"\r\n");
      out.write("\t/>\r\n");
      out.write("\t<link\r\n");
      out.write("\t\thref=\"https://cdn.jsdelivr.net/npm/daisyui@1.14.0/dist/full.css\"\r\n");
      out.write("\t\trel=\"stylesheet\"\r\n");
      out.write("\t\ttype=\"text/css\"\r\n");
      out.write("\t/>\r\n");
      out.write("\t<title>出勤登録</title>\r\n");
      out.write(" </head>\r\n");
      out.write(" <body>\r\n");
      out.write("\t<form action=\"/SD/servlet/shift_join\" method=\"POST\">\r\n");
      out.write("    <div class=\"flex flex-col w-full h-screen\">\r\n");
      out.write("      <header class=\"w-full bg-blue-400 py-4 border-b border-gray-200\">\r\n");
      out.write("        <h1 class=\"text-center text-4xl font-bold text-white\">\r\n");
      out.write("          カラオケシステム\r\n");
      out.write("        </h1>\r\n");
      out.write("      </header>\r\n");
      out.write("      <div class=\"flex flex-1 w-full bg-gray-100\">\r\n");
      out.write("        <nav class=\"w-1/5 border-r border-gray-200\">\r\n");
      out.write("          <div class=\"flex flex-col gap-2 p-4\">\r\n");
      out.write("            <a\r\n");
      out.write("              href=\"/SD/pages/index.jsp\"\r\n");
      out.write("              class=\"py-2 px-6 hover:bg-blue-100 font-bold rounded-full\"\r\n");
      out.write("            >\r\n");
      out.write("              ホーム\r\n");
      out.write("            </a>\r\n");
      out.write("            <a\r\n");
      out.write("              href=\"/SD/pages/shift_join.jsp\"\r\n");
      out.write("              class=\"py-2 px-6 bg-blue-200 hover:bg-blue-100 font-bold rounded-full\"\r\n");
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
      out.write("              class=\"py-2 px-6 hover:bg-blue-100 font-bold rounded-full\"\r\n");
      out.write("            >\r\n");
      out.write("              シフト一覧\r\n");
      out.write("            </a>\r\n");
      out.write("            <a\r\n");
      out.write("              href=\"/SD/pages/shift_regist.jsp\"\r\n");
      out.write("              class=\"py-2 px-6 hover:bg-blue-100 font-bold rounded-full\"\r\n");
      out.write("            >\r\n");
      out.write("              シフト登録\r\n");
      out.write("            </a>\r\n");
      out.write("\t\t\t\t\t\t<a\r\n");
      out.write("\t\t\t\t\t\t\thref=\"/SD/pages/employee_list.jsp\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"py-2 px-6 hover:bg-blue-100 font-bold rounded-full\"\r\n");
      out.write("\t\t\t\t\t\t>\r\n");
      out.write("\t\t\t\t\t\t\t従業員一覧\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
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
      out.write("        <main class=\"w-4/5 flex flex-col justify-center items-center\">\r\n");
      out.write("\t\t\t\t\t<div class=\"flex flex-col gap-2 w-96\">\r\n");
      out.write("\t\t\t\t\t\t<h1\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"\r\n");
      out.write("\t\t\t\t\t\t\t\ttext-center\r\n");
      out.write("\t\t\t\t\t\t\t\tsm:text-3xl\r\n");
      out.write("\t\t\t\t\t\t\t\ttext-2xl\r\n");
      out.write("\t\t\t\t\t\t\t\tfont-medium\r\n");
      out.write("\t\t\t\t\t\t\t\ttitle-font\r\n");
      out.write("\t\t\t\t\t\t\t\ttext-gray-800\r\n");
      out.write("\t\t\t\t\t\t\t\"\r\n");
      out.write("\t\t\t\t\t\t>\r\n");
      out.write("\t\t\t\t\t\t\t出勤登録\r\n");
      out.write("\t\t\t\t\t\t</h1>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<label\r\n");
      out.write("\t\t\t\t\t\t\tfor=\"shift_join_year\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"pl-1 text-gray-600\"\r\n");
      out.write("\t\t\t\t\t\t\t>従業員氏名</label\r\n");
      out.write("\t\t\t\t\t\t>\r\n");
      out.write("\t\t\t\t\t\t<select name=\"EMPLOYEE_ID\" class=\"select select-bordered select-info w-full\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option selected disabled>選択してください</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
 for (int i = 0; i < list.size(); i++) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"");
      out.print( list.get(i).get("employee_id") );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");
      out.print( list.get(i).get("employee_name") );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<button class=\"\r\n");
      out.write("\t\t\t\t\t\t\t\tw-full\r\n");
      out.write("\t\t\t\t\t\t\t\tmx-auto\r\n");
      out.write("\t\t\t\t\t\t\t\ttext-white\r\n");
      out.write("\t\t\t\t\t\t\t\tbg-blue-500\r\n");
      out.write("\t\t\t\t\t\t\t\tborder-0\r\n");
      out.write("\t\t\t\t\t\t\t\tpy-2\r\n");
      out.write("\t\t\t\t\t\t\t\tpx-8\r\n");
      out.write("\t\t\t\t\t\t\t\tmt-2\r\n");
      out.write("\t\t\t\t\t\t\t\tfocus:outline-none\r\n");
      out.write("\t\t\t\t\t\t\t\thover:bg-blue-600\r\n");
      out.write("\t\t\t\t\t\t\t\ttext-lg\r\n");
      out.write("\t\t\t\t\t\t\t\trounded-full\"\r\n");
      out.write("\t\t\t\t\t\t\t>送信</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("        </main>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\t</form>\r\n");
      out.write(" </body>\r\n");
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
