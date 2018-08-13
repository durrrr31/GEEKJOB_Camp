<%-- 
    Document   : myupdate_complete
    Created on : 2018/08/03, 15:12:55
    Author     : guest1Day
--%>

<%@page import="jums.JumsHelper_EC"%>
<%
    JumsHelper_EC jh = new JumsHelper_EC();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>更新完了</h1>
        <%=jh.top()%><br>
        <a href="mydata.jsp">マイページへ戻る
    </body>
</html>
