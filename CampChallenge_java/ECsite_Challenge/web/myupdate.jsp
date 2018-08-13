<%-- 
    Document   : myupdate
    Created on : 2018/08/03, 14:54:15
    Author     : guest1Day
--%>

<%@page import="jums.UserDataDTO_EC"%>
<%
    HttpSession hs = request.getSession();
    
    UserDataDTO_EC dto = new UserDataDTO_EC();
    
    //  logがあるならばdtoにセッションから情報を取り出し、格納する。
    if(hs.getAttribute("log")!=null){

        dto = (UserDataDTO_EC)hs.getAttribute("dto");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>ユーザー情報の更新をします。以下の項目を全て記入してください</h2>
        <form action="./Myupdate" method="post">
            ユーザー名：<input type="text" name="name" value="<%=dto.getName()%>"><br>
            パスワード：<input type="password" name="password" value="<%=dto.getPassword()%>"><br>
            メールアドレス：<input type="text" name="mail" value="<%=dto.getMail()%>"><br>
            住所：<input type="text" name="address" value="<%=dto.getAddress()%>"><br>
            <input type="submit" name="submit" value="上記の内容で更新"><br>
        </form>
    </body>
</html>
