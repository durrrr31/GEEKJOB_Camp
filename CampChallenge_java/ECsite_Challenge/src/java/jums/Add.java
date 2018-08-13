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
public class Add extends HttpServlet {

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
            
            HttpSession hs = request.getSession();
            
            //  ログアウト状態ならばログイン画面に飛ばす処理です。
            if(hs.getAttribute("log")==null){
                request.setAttribute("url","./item.jsp");
                request.getRequestDispatcher("./login.jsp").forward(request,response);
            
            }else{
            
            //  ログイン状態ならば、情報を保存する配列をそれぞれ作成する。
            ArrayList<String> imgCart = new ArrayList<String>();
            ArrayList<String> nameCart = new ArrayList<String>();
            ArrayList<String> priceCart = new ArrayList<String>();
            ArrayList<String> reviewRateCart = new ArrayList<String>();
            
            //  既にセッションにカートの情報が保存してあるならば、それを受け取る処理。
            if(hs.getAttribute("imgCart")!= null){
                nameCart = (ArrayList<String>)hs.getAttribute("nameCart");
                imgCart = (ArrayList<String>)hs.getAttribute("imgCart");
                priceCart = (ArrayList<String>)hs.getAttribute("priceCart");
                reviewRateCart = (ArrayList<String>)hs.getAttribute("revieRateCart");
            }
            
            //  itemページで表示させた商品の番号を読み取る。
            int id = Integer.parseInt(request.getParameter("id"));
            
            //  ItemDataBeansをインスタンス生成し、セッションから前のページからカートに入れた商品の情報を受け取ります。
            ItemDataBeans idb = (ItemDataBeans)hs.getAttribute("idb");
            ArrayList<String> name =        idb.getName();        //  商品名を保存する配列。
            ArrayList<String> image =       idb.getImage();       //  商品画像のURLを保存する配列。
            ArrayList<String> price =       idb.getPrice();       //  商品の値段を保存する配列。
            ArrayList<String> reviewRate =  idb.getReviewRate();  //  商品の評価を保存する配列。
            
            
            //  Beansから受け取った情報から上で受け取ったidの商品情報だけをCartの配列にそれぞれ格納します。
            nameCart.add(name.get(id));
            imgCart.add(image.get(id));
            priceCart.add(price.get(id));
            reviewRateCart.add(reviewRate.get(id));
            
            //  情報を格納したので、配列をそれぞれセッションに保存します。
            
            hs.setAttribute("nameCart",nameCart);
            hs.setAttribute("imgCart",imgCart);
            hs.setAttribute("priceCart", priceCart);
            hs.setAttribute("reviewRateCart",reviewRateCart);
            
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
