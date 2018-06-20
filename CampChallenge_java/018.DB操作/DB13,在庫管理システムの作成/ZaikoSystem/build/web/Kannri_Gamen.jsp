<%-- 
    Document   : Kannri_Gamen
    Created on : 2018/06/15, 18:10:54
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
            HttpSession s = request.getSession();
            
            if(s.getAttribute("log")  ==  null){
                
            RequestDispatcher rd = request.getRequestDispatcher("/Login_Gamen");
            rd.forward(request,response);
            }
        %>
        <form action="./GOODS_INF_REGISTER.jsp" method="post">
                
                <p>
                    商品情報を追加する
                    
                    商品名：<input type="text" name="GoodsName">
                </p>
                <p> 
                    商品数：<input type="number" name="zaikosu">
                </p>
                <p>
                    <input type="submit" name="update" value="情報追加">
                </p>
                </form>
                
                <form action="./GOODS_INF_UPDATE.jsp">
                <p>
                    更新したい商品名：<input type="text" name="GoodsName">
                </p>
                <p>
                    商品の在庫数：<input type="number" name="zaikosu">
                </p>
                <p>
                    <input type="submit" name="update" value="更新">
                </p>
                </form>
        
                <form action="./GOODS_INF_GET.jsp">
                    <input type="submit" name="select" value="商品情報を表示">
                </form>
        
                <form action="./Login.jsp" method="post">
                <p>    
                    <input type="submit" name="logout" value="ログアウト">
                </p>
                </form>
    </body>
</html>
