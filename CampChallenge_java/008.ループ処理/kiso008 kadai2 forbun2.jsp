<%-- 
    Document   : kiso008 kadai2 forbun2
    Created on : 2018/05/23, 15:28:19
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String aces = "";
        
        for(int i=1; i <= 30; i++){
        aces = aces + "A";
        }
        out.print(aces);
        %>
    </body>
</html>