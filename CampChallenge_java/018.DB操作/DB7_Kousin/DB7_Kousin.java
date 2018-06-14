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

/**
 *
 * @author guest1Day
 */
public class DB7_Kousin extends HttpServlet {

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
            
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
    try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?characterEncoding=UTF-8&serverTimezone=JST","Hassy","0106");
            
            db_st = db_con.prepareStatement("update profiles set name='鈴木　一郎',tel='515-1515-15151',age=44,birthday='1973-10-22' where profilesID = 1");
            db_st.executeUpdate();
            
            db_st = db_con.prepareStatement("update profiles set name=?,tel=?,age=?,birthday=? where profilesID = 2");
            db_st.setString(1,"松井　秀喜");
            db_st.setString(2,"555-5555-5555");
            db_st.setInt(3,44);
            
            String birthday ="1974-06-12";
            Date sqlbirthday = Date.valueOf(birthday);
            db_st.setDate(4,sqlbirthday);
            db_st.executeUpdate();
            
            db_st = db_con.prepareStatement("update profiles set name=?,tel=?,age=?,birthday=? where profilesID = 4");
            db_st.setString(1,"ダルビッシュ　有");
            db_st.setString(2,"111-1111-1111");
            db_st.setInt(3,31);
            
            String birthday2 ="1986-08-16";
            Date sqlbirthday2 = Date.valueOf(birthday2);
            db_st.setDate(4,sqlbirthday2);
            db_st.executeUpdate();
            
            
            
            db_st = db_con.prepareStatement("select * from profiles");
            db_data = db_st.executeQuery();
            
            while(db_data.next()){
                out.print("profilesID:"+ db_data.getInt("profilesID")+"tel:"+ db_data.getString("name")+"tel:"+ db_data.getString("tel")+ "age:" +db_data.getInt("age")+"birthday:"+ db_data.getDate("birthday")+"<br>");
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
