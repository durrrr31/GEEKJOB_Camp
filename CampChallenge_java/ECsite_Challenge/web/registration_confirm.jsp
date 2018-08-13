<%-- 
    Document   : registration_confirm
    Created on : 2018/07/02, 11:49:44
    Author     : guest1Day
--%>

<%@page import="jums.UserDataBeans_EC"%>
<%
   //  セッションに保存してあるデータを取得します。
    HttpSession hs = request.getSession();
    UserDataBeans_EC udb = (UserDataBeans_EC)hs.getAttribute("udb");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>登録確認</h1>
        名前:<%= udb.getName()%><br>
        パスワード:<%= udb.getPassword()%><br>
        メールアドレス:<%= udb.getMail()%><br>
        住所:<%= udb.getAddress()%><br>
        上記の内容で登録します。よろしいですか？<br>
        <form action="Registration_Complete" method="POST">
            <input type="submit" name="yes" value="はい"><br>
        </form>
        <form action="registration.jsp" method="POST">
            <input type="submit" name="no" value="いいえ"><br>
        </form>
    </body>
</html>
