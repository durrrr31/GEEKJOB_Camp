<%-- 
    Document   : registration_complete
    Created on : 2018/07/02, 11:50:06
    Author     : guest1Day
--%>

<%@page import="jums.JumsHelper_EC"%>
<%@page import="jums.UserDataBeans_EC"%>
<%
    JumsHelper_EC jh = JumsHelper_EC.getInstance();
    //　リクエストスコープからデータを受け取ります。
    UserDataBeans_EC udb = (UserDataBeans_EC)request.getAttribute("udb");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>登録完了</h1>
        名前:<%= udb.getName()%><br>
        パスワード:<%= udb.getPassword()%><br>
        メールアドレス:<%= udb.getMail()%><br>
        住所:<%= udb.getAddress()%><br>
        上記の内容で登録しました。<br>
        <!--商品ページかトップページに戻る処理（未実装）-->
        <%=jh.top()%><br>
        <%=jh.login("top.jsp")%>
    </body>
</html>
