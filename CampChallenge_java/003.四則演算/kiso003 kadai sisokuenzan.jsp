<%-- 
    Document   : kiso003 kadai sisokuenzan
    Created on : 2018/05/21, 16:55:16
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
       final int A = 200;
       int x=10;
       
       int tasu = A + x;
       int hiku = A - x;
       int kake = A * x;
       int waru = A / x;
       
       out.print("A=200,x=10とする<br>");
       
       out.print("和は" +tasu+"<br>");
       out.print("差は" +hiku+"<br>");
       out.print("積は" +kake+"<br>");
       out.print("商は" +waru+"<br>");
       %>
    </body>
</html>
