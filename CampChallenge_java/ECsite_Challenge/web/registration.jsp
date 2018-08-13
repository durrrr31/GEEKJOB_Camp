<%-- 
    Document   : registration
    Created on : 2018/07/02, 11:43:04
    Author     : guest1Day
--%>
<%@page import="jums.JumsHelper_EC"%>
<%@page import="jums.UserDataBeans_EC"%>
<%
    JumsHelper_EC jh = JumsHelper_EC.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans_EC udb = new UserDataBeans_EC();
    
    //  フォームの初期値を表示するためのboolean型の宣言をします。falseならば初期値は全てなしとなります。
    
    
    boolean reset = false;
    
    //  resetのセッション情報が空でないならresetはtrueになりudbはセッション情報を取得します。
    if(hs.getAttribute("reset") != null){
        reset = true;
        udb = (UserDataBeans_EC)hs.getAttribute("udb");
    }
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>registration form page</title>
    </head>
    <body>
        <h2>新規会員登録を行います。以下の項目を全て記入してください</h2>
        <form action="Registration_Confirm">
            ユーザー名：<input type="text" name="name" value="<% if(reset){out.print(udb.getName());}%>"><br>
        パスワード：<input type="text" name="password" value="<% if(reset){out.print(udb.getPassword());}%>"><br>
        メールアドレス：<input type="text" name="mail" value="<% if(reset){out.print(udb.getMail());}%>"><br>
        住所：<input type="text" name="address" value="<% if(reset){out.print(udb.getAddress());}%>"><br>
        <input type="submit" name="submit" value="上記の内容で登録"><br>
        </form>
        <%=jh.top()%>
    </body>
</html>
