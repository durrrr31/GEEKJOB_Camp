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
public class DB11_Form_Update_Receive extends HttpServlet {

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
                
                db_st = db_con.prepareStatement("update profiles set name=?,tel=?,age=?,birthday=? where profilesID = ?");
                
                int updateId = Integer.parseInt(request.getParameter("id"));      //  更新するidの番号をint型にしてupdateIDに代入
                int updateAge = Integer.parseInt(request.getParameter("age"));    //  ageも同様に
                String birthday = request.getParameter("birthday");               //  birthdayに入力された情報をString型で代入    
                Date sqlUpdateBirthday = Date.valueOf(birthday);                  //  sql用date型にして sqlUpdateBirthdayに代入
                
                db_st.setString(1,request.getParameter("name"));        //手に入れた情報を?に入れていきます。
                db_st.setString(2,request.getParameter("tel"));
                db_st.setInt(3, updateAge);
                db_st.setDate(4,sqlUpdateBirthday);
                db_st.setInt(5,updateId);
                
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
