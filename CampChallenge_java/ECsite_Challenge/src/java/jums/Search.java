/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.JsonArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import static com.mysql.cj.xdevapi.Type.JSON;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guest1Day
 */
public class Search extends HttpServlet {

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
            
            String query = request.getParameter("query");   //  フォームで入力された単語をqueryに格納します。
            
            //   queryにURLエンコーディングを行います。
            String URLquery = URLEncoder.encode(query,"UTF-8");
            //  URLクラスをインスタンス生成。接続するURLを繋げ、その後に取得したqueryを検索キーワードにします。
            URL url = new URL("https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch?appid=dj00aiZpPXBzbm40MElmeFBPMyZzPWNvbnN1bWVyc2VjcmV0Jng9OWI-&hits=10&query="+URLquery);
            
            //  HttpURLConnectionをインスタンス化します。
            HttpURLConnection urlconn = (HttpURLConnection) url.openConnection();
            //  メソッドはGETを用います。
            urlconn.setRequestMethod("GET");
            urlconn.setInstanceFollowRedirects(false);
            urlconn.connect();
            
            //  BufferedReaderのインスタンス生成。urlconnのgetInputStreameメソッドでサーバーから受け取ったレスポンスをbrに読み込む。
            BufferedReader br = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
            
            String recieve = "";    //  BufferedReaderからデータを受け取るためのString型
            String result = "";  //  結果を保存するためのString型
            
            //  br.readLine()がnullになるまでresultに情報を格納し続けます。これによって全ての情報をresultに格納します。
            while((recieve = br.readLine()) != null){
                result = result + recieve;
            }
            
            //  ObjectMapperのインスタンス生成。
            ObjectMapper mapper = new ObjectMapper();
            
            //  JsonNode jnにmapperのreadTreeメソッドでresultをTree状のJsonとして格納します。
            JsonNode jn = mapper.readTree(result);
            
            //  BufferedReader,HttpURLConnectionはもう必要ないので、閉じます。
            br.close();
            urlconn.disconnect();
            
            
            
            //  商品情報をItemDataBeansに格納します。
            ItemDataBeans idb = new ItemDataBeans();
            
            //  商品名の情報を格納します。
            for(int i=0; i<10; i++){
                idb.setName(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Name").asText());
            }
            
            //  商品の詳細ページのURLを格納します。!!!!!!!!!このページはYahooのURLページに遷移してしまうので修正する。
            for(int i=0; i<10; i++){
                idb.setUrl(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Url").asText());
            }
            
            //  商品画像のURL情報を格納します。
            for(int i=0; i<10; i++){
                idb.setImage(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Image").get("Medium").asText());
            }
            
            //  商品の値段を格納します。
            for(int i=0; i<10; i++){
                idb.setPrice(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Price").get("_value").asText());
            }
            
            //  商品の配送方法のタイプ（数）を格納します。
            for(int i=0; i<10; i++){
                idb.setShipping(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Shipping").get("Code").asText());
            }
                
            //  商品の商品コードを格納します。
            for(int i=0; i<10; i++){
                idb.setItemCode(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Code").asText());    
            }
            
            //  商品の評価（星１～星５）の平均値を格納します。
            for(int i=0; i<10; i++){
                idb.setReviewRate(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Review").get("Rate").asText());    
            }
            
            //  商品の評価の件数を格納します。
            for(int i=0; i<10; i++){
                idb.setReviewCount(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Review").get("Count").asText());    
            }
            
            //  商品の詳細情報を格納します。
            for(int i=0; i<10; i++){
                idb.setDescription(jn.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Description").asText());
            }


            
            
              //  idb をセッションに保存します。
            HttpSession hs = request.getSession(); 
            hs.setAttribute("idb",idb);
            
            //  search.jspにページ遷移します。
            request.getRequestDispatcher("/search.jsp").forward(request,response);
            
        }catch (Exception e){
            System.out.println(e.toString());
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
