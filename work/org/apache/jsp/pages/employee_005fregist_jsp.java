package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

public final class employee_005fregist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");

  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");
	
  String employee_id = (String)session.getAttribute("employee_id");
  if (employee_id.equals("")) response.sendRedirect("http://localhost:8080/SD/pages/signin.html");
  String employee_type = (String)session.getAttribute("employee_type");
  String employee_name = (String)session.getAttribute("employee_name");
  
  ServletContext sc = getServletContext();
  if (employee_type.equals("3")) sc.getRequestDispatcher("/pages/index.jsp").forward(request, response);


      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("  <head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
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
      out.write("    <title>従業員登録</title>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <form action=\"/SD/servlet/employee_regist\" method=\"POST\">\r\n");
      out.write("      <div class=\"flex flex-col w-full h-screen scroll-none\">\r\n");
      out.write("        <header class=\"w-full bg-blue-400 py-4 border-b border-gray-200\">\r\n");
      out.write("          <h1 class=\"text-2xl pl-8 font-bold text-white\">カラオケシステム</h1>\r\n");
      out.write("        </header>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"flex flex-1 w-full bg-gray-100\">\r\n");
      out.write("          <nav class=\"w-1/6 min-w-max border-r border-gray-200\">\r\n");
      out.write("            <div class=\"flex flex-col gap-2 p-4\">\r\n");
      out.write("              <a\r\n");
      out.write("                href=\"/SD/pages/index.jsp\"\r\n");
      out.write("                class=\"py-2 px-6 hover:bg-blue-100 font-bold rounded-full\"\r\n");
      out.write("              >\r\n");
      out.write("                ホーム\r\n");
      out.write("              </a>\r\n");
      out.write("              <a\r\n");
      out.write("                href=\"/SD/pages/shift_join.jsp\"\r\n");
      out.write("                class=\"py-2 px-6 hover:bg-blue-100 font-bold rounded-full\"\r\n");
      out.write("              >\r\n");
      out.write("                出勤登録\r\n");
      out.write("              </a>\r\n");
      out.write("              <a\r\n");
      out.write("                href=\"/SD/pages/shift_leaving.jsp\"\r\n");
      out.write("                class=\"py-2 px-6 hover:bg-blue-100 font-bold rounded-full\"\r\n");
      out.write("              >\r\n");
      out.write("                退勤登録\r\n");
      out.write("              </a>\r\n");
      out.write("              <a\r\n");
      out.write("                href=\"/SD/pages/shift_list.jsp\"\r\n");
      out.write("                class=\"py-2 px-6 hover:bg-blue-100 font-bold rounded-full\"\r\n");
      out.write("              >\r\n");
      out.write("                シフト一覧\r\n");
      out.write("              </a>\r\n");
      out.write("              <a\r\n");
      out.write("                href=\"/SD/pages/shift_regist.jsp\"\r\n");
      out.write("                class=\"py-2 px-6 hover:bg-blue-100 font-bold rounded-full\"\r\n");
      out.write("              >\r\n");
      out.write("                シフト登録\r\n");
      out.write("              </a>\r\n");
      out.write("              <a\r\n");
      out.write("                href=\"/SD/pages/employee_list.jsp\"\r\n");
      out.write("                class=\"py-2 px-6 hover:bg-blue-100 font-bold rounded-full\"\r\n");
      out.write("              >\r\n");
      out.write("                従業員一覧\r\n");
      out.write("              </a>\r\n");
      out.write("\r\n");
      out.write("              ");
 if (employee_type.equals("1") || employee_type.equals("2")) { 
      out.write("\r\n");
      out.write("                <a\r\n");
      out.write("                  href=\"/SD/pages/employee_regist.jsp\"\r\n");
      out.write("                  class=\"py-2 px-6 bg-blue-200 hover:bg-blue-100 font-bold rounded-full\"\r\n");
      out.write("                >\r\n");
      out.write("                  従業員登録\r\n");
      out.write("                </a>\r\n");
      out.write("              ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("              <hr class=\"text-gray-300\">\r\n");
      out.write("              \r\n");
      out.write("              <a\r\n");
      out.write("                href=\"/SD/pages/signout.jsp\"\r\n");
      out.write("                class=\"py-2 px-6 hover:bg-blue-100 font-bold rounded-full\"\r\n");
      out.write("              >\r\n");
      out.write("                サインアウト\r\n");
      out.write("              </a>\r\n");
      out.write("            </div>\r\n");
      out.write("          </nav>\r\n");
      out.write("\r\n");
      out.write("          <main class=\"flex flex-1 flex-col items-center pb-40 overflow-scroll\">\r\n");
      out.write("            <div class=\"flex flex-col gap-2 w-2/3 max-w-lg\">\r\n");
      out.write("              <h1\r\n");
      out.write("                class=\"\r\n");
      out.write("                  pt-8\r\n");
      out.write("                  text-center text-2xl\r\n");
      out.write("                  md:text-3xl\r\n");
      out.write("                  font-medium\r\n");
      out.write("                  text-gray-800\r\n");
      out.write("                \"\r\n");
      out.write("              >\r\n");
      out.write("                従業員登録\r\n");
      out.write("              </h1>\r\n");
      out.write("\r\n");
      out.write("              <label for=\"employee_name\" class=\"pl-1 text-gray-600\"\r\n");
      out.write("                >従業員氏名</label\r\n");
      out.write("              >\r\n");
      out.write("              <input\r\n");
      out.write("                id=\"employee_name\"\r\n");
      out.write("                type=\"text\"\r\n");
      out.write("                name=\"EMPLOYEE_NAME\"\r\n");
      out.write("                value=\"\"\r\n");
      out.write("                class=\"input input-info input-bordered w-full\"\r\n");
      out.write("              />\r\n");
      out.write("\r\n");
      out.write("              <label for=\"employee_name_sub\" class=\"pl-1 text-gray-600\"\r\n");
      out.write("                >従業員氏名（カナ）</label\r\n");
      out.write("              >\r\n");
      out.write("              <input\r\n");
      out.write("                id=\"employee_name_sub\"\r\n");
      out.write("                type=\"text\"\r\n");
      out.write("                name=\"EMPLOYEE_NAME_SUB\"\r\n");
      out.write("                value=\"\"\r\n");
      out.write("                class=\"input input-info input-bordered w-full\"\r\n");
      out.write("              />\r\n");
      out.write("\r\n");
      out.write("              <label for=\"birthday_year\" class=\"pl-1 text-gray-600\"\r\n");
      out.write("                >生年月日</label\r\n");
      out.write("              >\r\n");
      out.write("              <div class=\"flex items-center\">\r\n");
      out.write("                <input\r\n");
      out.write("                  id=\"birthday_year\"\r\n");
      out.write("                  type=\"number\"\r\n");
      out.write("                  name=\"BIRTHDAY_YEAR\"\r\n");
      out.write("                  value=\"\"\r\n");
      out.write("                  class=\"input input-info input-bordered w-full\"\r\n");
      out.write("                />\r\n");
      out.write("                <label for=\"birthday_year\" class=\"px-2 text-gray-600\">年</label>\r\n");
      out.write("\r\n");
      out.write("                <input\r\n");
      out.write("                  id=\"birthday_month\"\r\n");
      out.write("                  type=\"number\"\r\n");
      out.write("                  name=\"BIRTHDAY_MONTH\"\r\n");
      out.write("                  value=\"\"\r\n");
      out.write("                  class=\"input input-info input-bordered w-full\"\r\n");
      out.write("                />\r\n");
      out.write("                <label for=\"birthday_month\" class=\"px-2 text-gray-600\"\r\n");
      out.write("                  >月</label\r\n");
      out.write("                >\r\n");
      out.write("\r\n");
      out.write("                <input\r\n");
      out.write("                  id=\"birthday_day\"\r\n");
      out.write("                  type=\"number\"\r\n");
      out.write("                  name=\"BIRTHDAY_DAY\"\r\n");
      out.write("                  value=\"\"\r\n");
      out.write("                  class=\"input input-info input-bordered w-full\"\r\n");
      out.write("                />\r\n");
      out.write("                <label for=\"birthday_day\" class=\"px-2 text-gray-600\">日</label>\r\n");
      out.write("              </div>\r\n");
      out.write("\r\n");
      out.write("              <label for=\"employee_gender\" class=\"pl-1 text-gray-600\"\r\n");
      out.write("                >性別</label\r\n");
      out.write("              >\r\n");
      out.write("              <select\r\n");
      out.write("                id=\"employee_gender\"\r\n");
      out.write("                name=\"EMPLOYEE_GENDER\"\r\n");
      out.write("                class=\"select select-info select-bordered w-full\"\r\n");
      out.write("              >\r\n");
      out.write("                <option selected disabled>性別を選択してください</option>\r\n");
      out.write("                <option value=\"1\">男</option>\r\n");
      out.write("                <option value=\"2\">女</option>\r\n");
      out.write("                <option value=\"3\">その他</option>\r\n");
      out.write("              </select>\r\n");
      out.write("\r\n");
      out.write("              <label for=\"employee_zipcode\" class=\"pl-1 text-gray-600\"\r\n");
      out.write("                >郵便番号</label\r\n");
      out.write("              >\r\n");
      out.write("              <input\r\n");
      out.write("                id=\"employee_zipcode\"\r\n");
      out.write("                type=\"number\"\r\n");
      out.write("                name=\"EMPLOYEE_ZIPCODE\"\r\n");
      out.write("                value=\"\"\r\n");
      out.write("                class=\"input input-info input-bordered w-full\"\r\n");
      out.write("              />\r\n");
      out.write("\r\n");
      out.write("              <label for=\"employee_address\" class=\"pl-1 text-gray-600\"\r\n");
      out.write("                >住所</label\r\n");
      out.write("              >\r\n");
      out.write("              <input\r\n");
      out.write("                id=\"employee_address\"\r\n");
      out.write("                type=\"text\"\r\n");
      out.write("                name=\"EMPLOYEE_ADDRESS\"\r\n");
      out.write("                value=\"\"\r\n");
      out.write("                class=\"input input-info input-bordered w-full\"\r\n");
      out.write("              />\r\n");
      out.write("\r\n");
      out.write("              <label for=\"employee_phone\" class=\"pl-1 text-gray-600\"\r\n");
      out.write("                >電話番号</label\r\n");
      out.write("              >\r\n");
      out.write("              <input\r\n");
      out.write("                id=\"employee_phone\"\r\n");
      out.write("                type=\"text\"\r\n");
      out.write("                name=\"EMPLOYEE_PHONE\"\r\n");
      out.write("                value=\"\"\r\n");
      out.write("                class=\"input input-info input-bordered w-full\"\r\n");
      out.write("              />\r\n");
      out.write("\r\n");
      out.write("              <label for=\"employee_email\" class=\"pl-1 text-gray-600\"\r\n");
      out.write("                >メールアドレス</label\r\n");
      out.write("              >\r\n");
      out.write("              <input\r\n");
      out.write("                id=\"employee_email\"\r\n");
      out.write("                type=\"email\"\r\n");
      out.write("                name=\"EMPLOYEE_EMAIL\"\r\n");
      out.write("                value=\"\"\r\n");
      out.write("                class=\"input input-info input-bordered w-full\"\r\n");
      out.write("              />\r\n");
      out.write("\r\n");
      out.write("              <label for=\"employee_password\" class=\"pl-1 text-gray-600\"\r\n");
      out.write("                >パスワード</label\r\n");
      out.write("              >\r\n");
      out.write("              <input\r\n");
      out.write("                id=\"employee_password\"\r\n");
      out.write("                type=\"password\"\r\n");
      out.write("                name=\"EMPLOYEE_PASSWORD\"\r\n");
      out.write("                value=\"\"\r\n");
      out.write("                class=\"input input-info input-bordered w-full\"\r\n");
      out.write("              />\r\n");
      out.write("\r\n");
      out.write("              <label for=\"employee_type\" class=\"pl-1 text-gray-600\"\r\n");
      out.write("                >従業員タイプ</label\r\n");
      out.write("              >\r\n");
      out.write("              <select\r\n");
      out.write("                id=\"employee_type\"\r\n");
      out.write("                name=\"EMPLOYEE_TYPE\"\r\n");
      out.write("                class=\"select select-info select-bordered w-full\"\r\n");
      out.write("              >\r\n");
      out.write("                <option selected disabled>\r\n");
      out.write("                  従業員タイプを選択してください\r\n");
      out.write("                </option>\r\n");
      out.write("                <option value=\"1\">店長</option>\r\n");
      out.write("                <option value=\"2\">正社員</option>\r\n");
      out.write("                <option value=\"3\">アルバイト</option>\r\n");
      out.write("              </select>\r\n");
      out.write("\r\n");
      out.write("              <label for=\"birthday_year\" class=\"pl-1 text-gray-600\"\r\n");
      out.write("                >入社年月日</label\r\n");
      out.write("              >\r\n");
      out.write("              <div class=\"flex items-center\">\r\n");
      out.write("                <input\r\n");
      out.write("                  id=\"company_join_yaer\"\r\n");
      out.write("                  type=\"number\"\r\n");
      out.write("                  name=\"COMPANY_JOIN_YEAR\"\r\n");
      out.write("                  value=\"\"\r\n");
      out.write("                  class=\"input input-info input-bordered w-full\"\r\n");
      out.write("                />\r\n");
      out.write("                <label for=\"company_join_yaer\" class=\"px-2 text-gray-600\"\r\n");
      out.write("                  >年</label\r\n");
      out.write("                >\r\n");
      out.write("\r\n");
      out.write("                <input\r\n");
      out.write("                  id=\"company_join_month\"\r\n");
      out.write("                  type=\"number\"\r\n");
      out.write("                  name=\"COMPANY_JOIN_MONTH\"\r\n");
      out.write("                  value=\"\"\r\n");
      out.write("                  class=\"input input-info input-bordered w-full\"\r\n");
      out.write("                />\r\n");
      out.write("                <label for=\"company_join_month\" class=\"px-2 text-gray-600\"\r\n");
      out.write("                  >月</label\r\n");
      out.write("                >\r\n");
      out.write("\r\n");
      out.write("                <input\r\n");
      out.write("                  id=\"company_join_day\"\r\n");
      out.write("                  type=\"number\"\r\n");
      out.write("                  name=\"COMPANY_JOIN_DAY\"\r\n");
      out.write("                  value=\"\"\r\n");
      out.write("                  class=\"input input-info input-bordered w-full\"\r\n");
      out.write("                />\r\n");
      out.write("                <label for=\"company_join_day\" class=\"px-2 text-gray-600\"\r\n");
      out.write("                  >日</label\r\n");
      out.write("                >\r\n");
      out.write("              </div>\r\n");
      out.write("\r\n");
      out.write("              <button\r\n");
      out.write("                class=\"\r\n");
      out.write("                  w-full\r\n");
      out.write("                  mx-auto\r\n");
      out.write("                  text-white\r\n");
      out.write("                  bg-blue-500\r\n");
      out.write("                  border-0\r\n");
      out.write("                  py-3\r\n");
      out.write("                  px-8\r\n");
      out.write("                  mt-4\r\n");
      out.write("                  focus:outline-none\r\n");
      out.write("                  hover:bg-blue-600\r\n");
      out.write("                  text-lg\r\n");
      out.write("                  rounded-full\r\n");
      out.write("                \"\r\n");
      out.write("              >\r\n");
      out.write("                登録\r\n");
      out.write("              </button>\r\n");
      out.write("            </div>\r\n");
      out.write("          </main>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </form>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("  .scroll-none {\r\n");
      out.write("    overflow-y: scroll;\r\n");
      out.write("    -ms-overflow-style: none; /* IE, Edge 対応 */\r\n");
      out.write("    scrollbar-width: none; /* Firefox 対応 */\r\n");
      out.write("  }\r\n");
      out.write("  .scroll-none::-webkit-scrollbar {\r\n");
      out.write("    /* Chrome, Safari 対応 */\r\n");
      out.write("    display: none;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  input[type=\"number\"]::-webkit-outer-spin-button,\r\n");
      out.write("  input[type=\"number\"]::-webkit-inner-spin-button {\r\n");
      out.write("    -webkit-appearance: none;\r\n");
      out.write("    margin: 0;\r\n");
      out.write("  }\r\n");
      out.write("  input[type=\"number\"] {\r\n");
      out.write("    -moz-appearance: textfield;\r\n");
      out.write("  }\r\n");
      out.write("</style>\r\n");
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
