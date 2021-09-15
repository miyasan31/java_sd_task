package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signout_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

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
      out.write("    <title>サインアウト</title>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("\t\t<form action=\"/SD/servlet/signout\" method=\"POST\">\r\n");
      out.write("      <div class=\"flex flex-col w-full h-screen\">\r\n");
      out.write("        <header class=\"w-full bg-blue-400 py-4 border-b border-gray-200\">\r\n");
      out.write("          <h1 class=\"text-2xl pl-8 font-bold text-white\">\r\n");
      out.write("            カラオケシステム\r\n");
      out.write("          </h1>\r\n");
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
      out.write("                  class=\"py-2 px-6 hover:bg-blue-100 font-bold rounded-full\"\r\n");
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
      out.write("                class=\"py-2 px-6 bg-blue-200 hover:bg-blue-100 font-bold rounded-full\"\r\n");
      out.write("              >\r\n");
      out.write("                サインアウト\r\n");
      out.write("              </a>\r\n");
      out.write("            </div>\r\n");
      out.write("          </nav>\r\n");
      out.write("\r\n");
      out.write("          <main class=\"flex flex-1 flex-col items-center overflow-scroll\">\r\n");
      out.write("            <div class=\"flex flex-col gap-2 w-2/3 max-w-lg\">\r\n");
      out.write("              <h1\r\n");
      out.write("                class=\"\r\n");
      out.write("                  pt-8\r\n");
      out.write("                  text-center\r\n");
      out.write("                  text-2xl\r\n");
      out.write("                  md:text-3xl\r\n");
      out.write("                  font-medium\r\n");
      out.write("                  text-gray-800\r\n");
      out.write("                \"\r\n");
      out.write("              >\r\n");
      out.write("                サインアウト\r\n");
      out.write("              </h1>\r\n");
      out.write("\r\n");
      out.write("              <p class=\"pt-4 text-center text-2xl text-red-400\">サインアウトしますか？</p>\r\n");
      out.write("\r\n");
      out.write("              <button class=\"\r\n");
      out.write("                  w-56\r\n");
      out.write("                  mx-auto\r\n");
      out.write("                  text-white\r\n");
      out.write("                  bg-red-500\r\n");
      out.write("                  border-0\r\n");
      out.write("                  py-3\r\n");
      out.write("                  px-8\r\n");
      out.write("                  mt-2\r\n");
      out.write("                  focus:outline-none\r\n");
      out.write("                  hover:bg-red-600\r\n");
      out.write("                  text-lg\r\n");
      out.write("                  rounded-full\"\r\n");
      out.write("              > サインアウト</button>\r\n");
      out.write("            </div>\r\n");
      out.write("          </main>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </form>\r\n");
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
