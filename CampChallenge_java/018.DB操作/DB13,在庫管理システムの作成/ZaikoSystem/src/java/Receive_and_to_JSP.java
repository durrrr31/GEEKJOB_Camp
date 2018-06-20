/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guest1Day
 */
public class Receive_and_to_JSP extends HttpServlet {

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
                
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;

            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?characterEncoding=UTF-8&serverTimezone=JST","Hassy","0106");
                
                db_st = db_con.prepareStatement("select * from user_inf where  userId = ? and userPass = ?");
                
                String id = request.getParameter("id");                         //　　id にフォームで入力したidを代入
                int pass = Integer.parseInt(request.getParameter("pass"));      //    pass にフォームで入力したpassをint型にして代入
                
                db_st.setString(1,id);                  
                db_st.setInt(2,pass);
                
                db_data = db_st.executeQuery();
                
                //    db_dataがnullならばログイン画面に戻る処理を、違う場合はセッションを作成し、JSPに飛ばす処理
                
                HttpSession s = request.getSession();       //  ログイン情報を格納するためのセッション生成
                
                if(db_data.next()){
                    
                    s.setAttribute("log","in");
                    RequestDispatcher rd = request.getRequestDispatcher("/Kannri_Gamen.jsp");
                    rd.forward(request,response);
                    
                
                }else{
                    RequestDispatcher rd = request.getRequestDispatcher("/Login_Gamen.jsp");
                    rd.forward(request,response);
                }



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
