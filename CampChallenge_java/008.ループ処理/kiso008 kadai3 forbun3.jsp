<%-- 
    Document   : kiso008 kadai3 ifbun3
    Created on : 2018/05/23, 15:49:34
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
        int Sum=0;
        for(int i=0; i <=100 ; i++){
            Sum = Sum + i;
        }
        out.print(Sum);
        %>
    </body>
</html>
