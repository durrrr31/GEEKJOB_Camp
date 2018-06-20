package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Kannri_005fGamen_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            HttpSession s = request.getSession();
            
            if(s.getAttribute("log")  ==  null){
                
            RequestDispatcher rd = request.getRequestDispatcher("/Login_Gamen");
            rd.forward(request,response);
            }
        
      out.write("\n");
      out.write("        <form action=\"./GOODS_INF_REGISTER.jsp\" method=\"post\">\n");
      out.write("                \n");
      out.write("                <p>\n");
      out.write("                    商品情報を追加する\n");
      out.write("                    \n");
      out.write("                    商品名：<input type=\"text\" name=\"GoodsName\">\n");
      out.write("                </p>\n");
      out.write("                <p> \n");
      out.write("                    商品数：<input type=\"number\" name=\"zaikosu\">\n");
      out.write("                </p>\n");
      out.write("                <p>\n");
      out.write("                    <input type=\"submit\" name=\"update\" value=\"情報追加\">\n");
      out.write("                </p>\n");
      out.write("                </form>\n");
      out.write("                \n");
      out.write("                <form action=\"./GOODS_INF_GET.jsp\">\n");
      out.write("                <p>\n");
      out.write("                    更新したい商品名：<input type=\"text\" name=\"Goodsname\">\n");
      out.write("                    商品の在庫数：<input type=\"number\" name=\"zaikosu\">\n");
      out.write("                    <input type=\"submit\" name=\"update\" value=\"更新\">\n");
      out.write("                </p>\n");
      out.write("                </form>\n");
      out.write("        \n");
      out.write("                <form action=\"./Login.jsp\" method=\"post\">\n");
      out.write("                <p>    \n");
      out.write("                    <input type=\"submit\" name=\"logout\" value=\"ログアウト\">\n");
      out.write("                </p>\n");
      out.write("                </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
