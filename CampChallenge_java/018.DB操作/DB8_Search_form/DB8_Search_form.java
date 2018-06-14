/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBsousa;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guest1Day
 */
public class DB8_Search_form extends HttpServlet {

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
            
            String name = (request.getParameter("txtName"));  // フォームで入力された情報を受け取る。
            
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
    try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?characterEncoding=UTF-8&serverTimezone=JST","Hassy","0106");
            
            db_st = db_con.prepareStatement("select * from profiles where name like ?");   //  入力された文字と部分一致しているプロフィールのレコードを取得
            db_st.setString(1,"%" + name +"%");
            db_data = db_st.executeQuery();
            
            ArrayList array = new ArrayList();  // jspに渡すための配列のインスタンスを生成
            
            while(db_data.next()){
                
                array.add("profilesID:"+db_data.getInt("profilesID"));
                array.add("name:"+db_data.getString("name"));
                array.add("tel:"+db_data.getString("tel"));
                array.add("age:"+db_data.getInt("age"));
                array.add("birthday:"+db_data.getDate("birthday"));
//                out.print("profilesID:"+ db_data.getInt("profilesID")+"tel:"+ db_data.getString("name")+"tel:"+ db_data.getString("tel")+ "age:" +db_data.getInt("age")+"birthday:"+ db_data.getDate("birthday")+"<br>");
            }
            
            HttpSession hs = request.getSession();  //　セッションを用いてjspに配列を送る。
            
            hs.setAttribute("array",array);
            
            RequestDispatcher rd = request.getRequestDispatcher( "DB8_Search_Form.jsp" );
            
//            rd.forward(request,response);
            
            db_con.close();
            db_st.close();
            db_data.close();
            rd.forward(request,response);

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
