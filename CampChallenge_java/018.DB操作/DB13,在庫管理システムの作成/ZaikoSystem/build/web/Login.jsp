<%-- 
    Document   : Login
    Created on : 2018/06/20, 14:16:50
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession s = request.getSession();
        s.invalidate();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="./Receive_and_to_JSP" method="post">
                
                <p>
                    ログインIDを入力してください
                    <input type="text" name="id">
                </p>
                <p>
                    パスワードを入力してください
                    <input type="number" name="pass">
                </p>
                <p>
                    <input type="submit" name="btnSubmit" value="ログイン">
                </p>
            </form>
    </body>
</html>
