<%-- 
    Document   : add
    Created on : 2018/07/20, 15:40:06
    Author     : guest1Day
--%>
<%@page import="jums.JumsHelper_EC"%>
<%
    JumsHelper_EC helper = new JumsHelper_EC();
    HttpSession hs = request.getSession();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        商品をカートに追加しました。<br>
        <%=helper.top()%><br>
        <a href="cart.jsp">カートを見る
    </body>
</html>
