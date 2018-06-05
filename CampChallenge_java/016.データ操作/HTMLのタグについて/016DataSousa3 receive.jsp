<%-- 
    Document   : 016DataSousa3 receive
    Created on : 2018/06/05, 11:30:51
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
            request.setCharacterEncoding("UTF-8");
            
                out.print(request.getParameter("name"));
                out.print(request.getParameter("gender"));
                out.print(request.getParameter("special"));
                out.print(request.getParameter("course"));
        
         %>
    </body>
</html>
