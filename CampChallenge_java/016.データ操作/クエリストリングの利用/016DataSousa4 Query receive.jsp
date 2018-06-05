<%-- 
    Document   : 016DataSousa4 Query receive
    Created on : 2018/06/05, 13:48:15
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
            
                int type = Integer.parseInt(request.getParameter("type"));
                int count = Integer.parseInt(request.getParameter("count"));
                int total = Integer.parseInt(request.getParameter("total"));
                
            switch(type){
                case 1:
                    out.println("雑貨を"+count+"個購入しました。");
                    break;
                case 2:
                    out.println("生鮮食品を"+count+"個購入しました。");
                    break;
                case 3:
                    out.println("その他の商品を"+count+"個購入しました。");
                    break;
            }
            
                out.println("単価は"+(total/count)+"円です");
                
                if(total < 3000){
                    out.print("残念ながらポイントは貯まりませんでした。");
                }else if(total < 5000){
                    out.print("今回の買い物で"+(total*0.04)+"ポイント貯まりました");
                }else{
                    out.print("今回の買い物で"+(total*0.05)+"ポイント貯まりました");
                }
                
                
                
        
         %>
    </body>
</html>
