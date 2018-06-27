package jums;

import JavaBeans.UserDataBeans;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insertresultと対応するサーブレット
 * フォームから入力された値をセッション経由で受け取り、データベースにinsertする
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertResult extends HttpServlet {

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
        
        //セッションスタート
        HttpSession session = request.getSession();
        UserDataBeans b = (UserDataBeans)session.getAttribute("b");
        
        try{
            //　直リンク防止の処理です
            String accesschk = request.getParameter("ac");
            
            //  ObjectクラスのacをIntegerクラスに変換
            Object acObj = request.getParameter("ac");
            String acStr = acObj.toString();
            int ac = new Integer(acStr);
            
            if(accesschk ==null || ac!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            //ユーザー情報に対応したJavaBeansオブジェクトに格納していく
            //　bのインスタンスを生成し情報を取得するように変える処理は未実装
            UserDataDTO userdata = new UserDataDTO();
            userdata.setName(b.getName());
            // 生年月日の情報を入力します。　未実装
            
            //  カレンダー型のインスタンスを生成し、birthdayをset
            Calendar birthday = Calendar.getInstance();
            birthday.set(b.getYear(),b.getMonth(),b.getDay(),0,0,0);
            //  Date型のインスタンスを生成し、格納する処理
            Date birthdayDate = new Date();

            birthdayDate = birthday.getTime();
            userdata.setBirthday(birthdayDate);
            
            //  Type,Tell,Commentも同様に格納する処理
            userdata.setType(Integer.parseInt(b.getType()));
            userdata.setTell((String)b.getTell());
            userdata.setComment((String)b.getComment());
            
//            userdata.setType(Integer.parseInt((String)session.getAttribute("type")));
//            userdata.setTell((String)session.getAttribute("tell"));
//            userdata.setComment((String)session.getAttribute("comment"));
            
            //DBへデータの挿入
            UserDataDAO .getInstance().insert(userdata);
            
            request.getRequestDispatcher("/insertresult.jsp").forward(request, response);
        }catch(Exception e){
            //データ挿入に失敗したらエラーページにエラー文を渡して表示
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
