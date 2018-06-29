package jums;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class ResultDetail extends HttpServlet {

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
        try{
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更
            
            //DTOオブジェクトにマッピング。DB専用のパラメータに変換
            UserDataDTO searchData = new UserDataDTO();
            
            //  クリックされた名前と同じIDの情報を検索する。
            int id = Integer.parseInt(request.getParameter("id"));  // 　idの番号を取得
            searchData.setUserID(id);   //  上で取得したid番号のユーザーをデータベースから検索する。
            
            //  searchDataの結果をresultDataに格納する
            UserDataDTO resultData = UserDataDAO .getInstance().searchByID(searchData);
            
            UserDataDTO udd = resultData;
    // Beansに情報を格納する
    UserDataBeans udb = new UserDataBeans();
    
    //  Date型のbirthdayをyear,month,dayに分解する　ObjectクラスをStringクラスにしてintに
    String yearStr = udb.getYearBirthday(udd.getBirthday()).toString();
    int year = new Integer(yearStr);
    
    String monthStr = udb.getMonthBirthday(udd.getBirthday()).toString();
    int month = new Integer(monthStr);
    
    String dayStr = udb.getDayBirthday(udd.getBirthday()).toString();
    int day = new Integer(dayStr);
    //  これをudbにsetする
    udb.setName(udd.getName());
    udb.setYear(String.valueOf(year));
    udb.setMonth(String.valueOf(month));
    udb.setDay(String.valueOf(day));
    udb.setType(String.valueOf(udd.getType()));
    udb.setTell(udd.getTell());
    udb.setComment(udd.getComment());
    //  UserIDを格納
    udb.setUserID(id);
        // セッションを作成
    HttpSession hs = request.getSession();
        // セッションにudbを格納
    hs.setAttribute("Data",udb);
            
            //  結果をリクエストスコープに格納する
            request.setAttribute("resultData", resultData);
            
            //  結果をセッションに格納する
            
            hs.setAttribute("resultData",resultData);
            
            //  resultdetail.jspに飛ばす
            request.getRequestDispatcher("/resultdetail.jsp").forward(request, response);  
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
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
//        request.getParameter("id");
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
