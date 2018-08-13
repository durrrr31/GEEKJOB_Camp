/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
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
public class BuyComplete extends HttpServlet {

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
            
            //  ログアウト状態ならログイン画面に飛ばす処理。
            HttpSession hs = request.getSession();
            
        if(hs.getAttribute("log")!=null){
                request.getRequestDispatcher("./login.jsp").forward(request,response);
            
            }else{
            int id = Integer.parseInt(request.getParameter("id"));   //  itemページで表示させた商品の番号です。
                
            //  ItemDataBeansをインスタンス生成し、セッションから商品の情報を受け取ります。
            ItemDataBeans idb = (ItemDataBeans)hs.getAttribute("idb");
            
            //  DBに対応したBeans、ItemDataDTOのインスタンス生成。
            ItemDataDTO idd = new ItemDataDTO();
            
            //  iddに受け取った商品コード、配送方法を配列から受け取り、setします。
            ArrayList<String> itemCode = idb.getItemCode();
            ArrayList<String> type = idb.getShipping();
            
            idd.setItemCode(itemCode.get(id));
            idd.setType(Integer.parseInt(type.get(id)));
            
            //  iddにuserIDをsetします。!!!!!!!!!!!!!!!!!!!!!!!未実装です。
            UserDataDTO_EC dto = (UserDataDTO_EC)hs.getAttribute("dto");
            int userID = dto.getId();
            
            idd.setUserID(userID);
            //  ItemDataDAOのinsertメソッドを用いてDBに登録します。
            ItemDataDAO dao = new ItemDataDAO();
            dao.insert(idd);
            
            //  add.jspに遷移させます。
            request.getRequestDispatcher("/add.jsp").forward(request, response);
            }
            
        }catch(Exception e){
            //   ここはコピペしたのでエラーになる可能性があります。error.jspは作っていません。
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
