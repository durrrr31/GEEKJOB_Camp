<%-- 
    Document   : kiso008 kadai1 forbun1
    Created on : 2018/05/23, 15:13:06
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
           long n=1;
        for(int i = 1; i <= 20; i++){
            n = n * 8;
        }
        out.print("8の20乗は"+ n );
        %>
    </body>
</html>
