<%-- 
    Document   : kiso008 kadai4 whilebun
    Created on : 2018/05/23, 16:24:47
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
            double n = 1000;
            while(n >= 100){
                n = n / 2;
            }
            out.print(n);
        %>
    </body>
</html>
