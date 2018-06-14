<%-- 
    Document   : DB_Search_Form
    Created on : 2018/06/13, 12:57:21
    Author     : guest1Day
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HttpSession hs = request.getSession();
            ArrayList array = (ArrayList)hs.getAttribute("array");  
            
            array = (ArrayList)hs.getAttribute("array");
            
            for(int i=0;i < array.size();i++){
                out.println(array.get(i));
            }
            
            
            
            
        %>
    </body>
</html>
