<%-- 
    Document   : top
    Created on : 2018/07/02, 11:35:21
    Author     : guest1Day
--%>

<%@page import="jums.UserDataDTO_EC"%>
<%@page import="jums.JumsHelper_EC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    JumsHelper_EC jh = JumsHelper_EC.getInstance();
    HttpSession hs = request.getSession();
    boolean log = false;
    
    String name="";    //  セッションに保存してある名前を格納するためのString型です。 
    
    if(hs.getAttribute("log")!=null){
        log = (Boolean)hs.getAttribute("log");
        
        UserDataDTO_EC dto = (UserDataDTO_EC)hs.getAttribute("dto");
        name = dto.getName();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="top.css">
        <title>top page</title>
    </head>
    <body>
        <h1>ECサイトへようこそ！</h1><br>
        
        <%if(log){%>
            <%=jh.logout("top.jsp",name)%>
        <%}else{%>
            <%=jh.login("top.jsp")%>
        <%}%>
        
        <%if(log){%>
            <%=jh.mydata()%>
        <%}%>
        <form action="Search" method="GET">
            <br><br>商品キーワードから探す<br><input type="text" name="query"><br>
            <input type="submit" name="submitBTN" value="検索">
        </form>
    </body>
</html>
