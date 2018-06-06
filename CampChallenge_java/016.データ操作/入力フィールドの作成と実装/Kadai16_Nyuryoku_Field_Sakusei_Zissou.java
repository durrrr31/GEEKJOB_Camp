/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kadai2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guest1Day
 */
@WebServlet(name = "Kadai16_Nyuryoku_Field_Sakusei_Zissou", urlPatterns = {"/Kadai16_Nyuryoku_Field_Sakusei_Zissou"})
public class Kadai16_Nyuryoku_Field_Sakusei_Zissou extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            request.setCharacterEncoding("UTF-8");
            
               out.println(request.getParameter("txtName"));
               out.println(request.getParameter("rdoGender"));  
               out.println(request.getParameter("hobby"));
                
                // 以下はセッションに保存する作業
            HttpSession hs = request.getSession();
            
                hs.setAttribute("name",request.getParameter("txtName") );
                hs.setAttribute("gender",request.getParameter("rdoGender") );
                hs.setAttribute("hobby",request.getParameter("hobby") );
                
//            Cookie Cname = new Cookie("name",request.getParameter("txtName"));
//            Cookie Cgender = new Cookie("gender",request.getParameter("rdoGender"));
//            Cookie Chobby = new Cookie("hobby",request.getParameter("hobby"));
//            
//            response.addCookie(Cname);
//            response.addCookie(Cgender);
//            response.addCookie(Chobby);
            
//             out.print(Cname[0].getValue());
//                out.print(request.getParameter("rdoGender"));
//                out.print(request.getParameter("hobby"));
            
            // このクッキーの情報をJSPのほうに送りたい
//           RequestDispatcher rd = request.getRequestDispatcher("/016Kadai_Nyuryoku_Field_Sakusei_Zissou_Submit.jsp");
//           rd.forward(request,response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
