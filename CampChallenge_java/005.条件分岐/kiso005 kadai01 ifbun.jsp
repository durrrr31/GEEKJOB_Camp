<%-- 
    Document   : kiso004 kadai01 ifbun
    Created on : 2018/05/23, 10:20:47
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
            int num = 1;
            
            if(num == 1){
            out.print("１です！");
            }else if(num == 2){
            out.print("プログラミングキャンプ！");
            }else{
            out.print("その他です！");
            }
        %>
    </body>
</html>
