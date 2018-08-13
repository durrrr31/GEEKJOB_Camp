/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guest1Day
 */
public class Login extends HttpServlet {

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
            request.setCharacterEncoding("UTF-8");
            
            //  SQL用Beans　DTOにjspで入力したid,passを格納します。
            UserDataDTO_EC dto = new UserDataDTO_EC();
            
            dto.setName(request.getParameter("name"));
            dto.setPassword(request.getParameter("password"));
            
            // DAOのselectメソッドを用いて検索します。
            UserDataDAO_EC dao = new UserDataDAO_EC();
            
            ArrayList array = dao.select(dto);  // arrayに検索結果を格納しました。
            
            // arrayから情報を受け取り、DTOにsetします。
            
            int userID = (Integer)array.get(0);
            String name= (String)array.get(1);
            String password= (String)array.get(2);
            String mail= (String)array.get(3);
            String address= (String)array.get(4);
            int total= (Integer)array.get(5);
            Date Datetime = (Date)array.get(6);
            int deleteFlg = (Integer)array.get(7);
            
            dto.setId(userID);
            dto.setName(name);
            dto.setPassword(password);
            dto.setMail(mail);
            dto.setAddress(address);
            dto.setTotal(total);
            dto.setNewDate(Datetime);
            dto.setDeleteFlg(deleteFlg);
            
            // dtoをセッションに保存します。
            HttpSession hs = request.getSession();
            hs.setAttribute("dto", dto);
            //  arrayからログを受け取って、セッションにログインしてるか保存します！！！！！！！未実装
            hs.setAttribute("log", (boolean)array.get(8));
            
            
            String url = "";  //  遷移先のurlを入れるためのString型。
            
            //  hiddenにあったurlを受け取り、リクエストディスパッチャーで元のページへと飛ばします。
            if(request.getAttribute("url")!=null){
                url = (String)request.getAttribute("url");
            }else if(request.getParameter("url").equals("null")){
                url = "top.jsp";
            }else{
                url = request.getParameter("url");
            }
            
            request.getRequestDispatcher(url).forward(request,response);
            
        }catch(Exception e){
            //   ここはコピペしたのでエラーになる可能性があります。error.jspは作っていません。
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("./login.jsp").forward(request, response);
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
