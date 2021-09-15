package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signin_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  response.setContentType("text/html; charset=UTF-8");
  String error =	request.getAttribute("error").toString(); 

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"UTF-8\" />\r\n");
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
      out.write("    <title>Document</title>\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("  <body>\r\n");
      out.write("    <form action=\"/SD/servlet/signin\" method=\"POST\">\r\n");
      out.write("      <div\r\n");
      out.write("        class=\"\r\n");
      out.write("          flex flex-col\r\n");
      out.write("          justify-center\r\n");
      out.write("          items-center\r\n");
      out.write("          w-full\r\n");
      out.write("          h-screen\r\n");
      out.write("          bg-gray-100\r\n");
      out.write("        \"\r\n");
      out.write("        >\r\n");
      out.write("\r\n");
      out.write("        <div class=\"flex flex-col w-96 mx-auto gap-2\">\r\n");
      out.write("          <h1\r\n");
      out.write("            class=\"text-center text-2xl md:text-3xl font-medium text-gray-800\"\r\n");
      out.write("          >\r\n");
      out.write("            サインイン\r\n");
      out.write("          </h1>\r\n");
      out.write("\r\n");
      out.write("          \r\n");
      out.write("          <label class=\"pl-2 text-lg text-gray-600 text-red-400\">\r\n");
      out.write("            メールアドレスまたはパスワードが間違っています\r\n");
      out.write("          </label>\r\n");
      out.write("\r\n");
      out.write("          <label for=\"email\" class=\"pl-2 text-gray-600\">\r\n");
      out.write("            メールアドレス\r\n");
      out.write("          </label>\r\n");
      out.write("          <input\r\n");
      out.write("            type=\"text\"\r\n");
      out.write("            id=\"email\"\r\n");
      out.write("            name=\"EMPLOYEE_EMAIL\"\r\n");
      out.write("            class=\"input input-info input-bordered w-full\"\r\n");
      out.write("          />\r\n");
      out.write("\r\n");
      out.write("          <label for=\"password\" class=\"pl-2 text-gray-600\">\r\n");
      out.write("            パスワード\r\n");
      out.write("          </label>\r\n");
      out.write("          <input\r\n");
      out.write("            type=\"password\"\r\n");
      out.write("            id=\"password\"\r\n");
      out.write("            name=\"EMPLOYEE_PASSWORD\"\r\n");
      out.write("            class=\"input input-info input-bordered w-full\"\r\n");
      out.write("          />\r\n");
      out.write("\r\n");
      out.write("          <button\r\n");
      out.write("            class=\"\r\n");
      out.write("              w-full\r\n");
      out.write("              mx-auto\r\n");
      out.write("              text-white\r\n");
      out.write("              bg-blue-500\r\n");
      out.write("              border-0\r\n");
      out.write("              py-3\r\n");
      out.write("              px-8\r\n");
      out.write("              mt-4\r\n");
      out.write("              focus:outline-none\r\n");
      out.write("              hover:bg-blue-600\r\n");
      out.write("              text-lg\r\n");
      out.write("              rounded-full\r\n");
      out.write("            \"\r\n");
      out.write("          >\r\n");
      out.write("            サインイン\r\n");
      out.write("          </button>\r\n");
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
