<%-- 
    Document   : login
    Created on : 2018/07/02, 11:41:18
    Author     : guest1Day
--%>

<%@page import="jums.JumsHelper_EC"%>
<%
    JumsHelper_EC jh = JumsHelper_EC.getInstance();
    HttpSession hs = request.getSession();
    boolean log = false;
    
    //  前のページのURLを受け取ります
    String url = request.getParameter("url");
    
    if(hs.getAttribute("log")!=null){
        log = (Boolean)hs.getAttribute("log");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login Page</title>
    </head>
    <body>
        <%if(log == false){%>
        <form action="Login" method="POST">
            ユーザー名：<input type="text" name="name"><br>
            パスワード：<input type="password" name="password"><br>
            <input type="hidden" name="url" value="<%=url%>">
            <input type="submit" value="ログイン"><br>
        </form>    
        登録をしていない方はこちらから<br>
        <a href="registration.jsp">  新規会員登録<br>
        <%= jh.top()%>
        <%}else {%>
<!--    <%hs.invalidate();%>         セッションを破棄して、ログイン情報を消去します。-->
        ログアウトしました。<br>
        <%= jh.top()%><br>
        <a href="<%=url%>">直前のページへ戻る
        <%}%>
    </body>
</html>