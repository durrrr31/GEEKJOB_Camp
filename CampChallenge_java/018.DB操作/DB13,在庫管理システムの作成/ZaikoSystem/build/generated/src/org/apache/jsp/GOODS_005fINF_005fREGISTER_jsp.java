package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class GOODS_005fINF_005fREGISTER_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

        HttpSession s = request.getSession();
            
            if(s.getAttribute("log") == null){
                RequestDispatcher rd = request.getRequestDispatcher("/Login_Gamen");
                rd.forward(request, response);
            }
            request.setCharacterEncoding("UTF-8");
            
                Connection db_con = null;
                PreparedStatement db_st = null;
                ResultSet db_data = null;

            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?characterEncoding=UTF-8&serverTimezone=JST","Hassy","0106");


                db_st = db_con.prepareStatement("insert into goods(goodsName,zaikosu) VALUES(?,?)");
                db_st.setString(1, request.getParameter("GoodsName"));
                db_st.setInt(2, Integer.parseInt(request.getParameter("zaikosu")));
                
                db_st.executeUpdate();
                
                    out.println("登録完了");

                db_con.close();
                db_st.close();
                db_data.close();
                 }catch(SQLException e_con){
                out.println("接続時にエラーが発生しました1："+e_con.toString());
            }catch(Exception e){
                out.println("接続時にエラーが発生しました2："+e.toString());
            }finally{
                if(db_con != null){
                    try{
                    }catch(Exception e_con){
                        out.println("error");
                    }
                }
            }
        
      out.write("\n");
      out.write("        <form action=\"./Kannri_Gamen.jsp\" method=\"post\">\n");
      out.write("        <p>    \n");
      out.write("            <input type=\"submit\" name=\"return\" value=\"前のページに戻る\">\n");
      out.write("        </p>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <form action=\"./Login.jsp\" method=\"post\">\n");
      out.write("        <p>    \n");
      out.write("            <input type=\"submit\" name=\"logout\" value=\"ログアウト\">\n");
      out.write("        </p>\n");
      out.write("        </form>\n");
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
