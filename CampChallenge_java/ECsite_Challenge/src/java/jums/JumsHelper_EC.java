/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import javax.servlet.http.HttpSession;

/**
 *画面系の処理や表示を簡略化するヘルパークラスです
 * @author guest1Day
 */
public class JumsHelper_EC{
    
     //トップへのリンクを定数として設定
    private final String topURL = "top.jsp";   //  urlは未記入です
    private final String loginURL = "login.jsp";  //  urlは未記入です
    private final String cartURL = "cart.jsp";   //!!!!!!!!!!!!!!!!!!!!  まだ作成していません
    
    public static JumsHelper_EC getInstance(){
        return new JumsHelper_EC();
    }
    
    //トップへのリンクを返却
    public String top(){
        return "<a href=\""+topURL+"\"><img src=\"./籠夢市場ロゴ.jpg\"></a>";
    }
    
    


// ログインページへのリンクを返却  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!上手く動作しないので、JSP側で直接表示する事にします。
    
    
//    public String login(boolean log,String url,String name){    //  引数は「ログがtrueかfalseか」と「前のページのurl」と「会員者の名前」
//        
//        String html; //  returnで返すhtml文の宣言
//        
//        if(log){  // ログイン状態ならばログアウトと買い物かごをリンクする処理、そうでなければログインページをリンクする処理
//        
//           html = "ようこそ、"+name+"さん！<br><form action=\"login.jsp\" method=\"POST\">" 
//                   + "<input type=\"hidden\" name=\"url\" value=<%=url%>>"
//                   + "<a href=\""+cartURL+"\">カートを見る</a>";
//           return html;
//        }else{      //  ログアウトしている時の処理・ログインページへのリンクを貼る
//           html = "<form action=\"login.jsp\" method=\"POST\">"
//           + "<input type=\"hidden\" name=\"url\" value=<%=url%>>" + "<input type=\"submit\" name=\"submitBTN\" value=\"ログインページへ\">" + "</form>";
//           return html;
//        }
//
////        return "<a href=\""+loginURL+"\">ログアウト</a>";  //  ログイン状態の時に表示する　ログアウトと、買い物かごへのリンクを貼る
//    }
    
    
    //  loginのヘルパーメソッドです。
    public String login(String url){
        String html = "<form action=\"login.jsp\" method=\"POST\">"
           + "<input type=\"hidden\" name=\"url\" value="+url+">" + "<input type=\"submit\" name=\"submitBTN\" value=\"ログインページへ\">" + "</form>";
           return html;
    }
    //  logoutのヘルパーメソッドです。ログアウトボタンと、カートページに飛ぶURLリンクが表示されます。
    public String logout(String url,String name){
        String html = "ようこそ、"+name+"さん！<br>"
                   + "<a href=\"login.jsp\">ログアウト<br>" 
                   + "<input type=\"hidden\" name=\"url\" value="+url+">"
                   + "<a href=\""+cartURL+"\">カートを見る</a>";
           return html;
    }
    
    //  JSPで会員情報ページに飛ばすリンクを貼るメソッドです。
    public String mydata(){
        String html = "<a href=\"mydata.jsp\">会員情報の確認はこちら";
        
        return html;
    }
}
