<%-- 
    Document   : 016DataSousa5 soinsubunkai receive
    Created on : 2018/06/05, 14:11:23
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
        int x =Integer.parseInt(request.getParameter("num"));
        
        int y = x; //ｙはfor文内で計算するために置いた  
        out.print(x+"=");    
        
        
                for(int i = 2; i <= x; i++){
                    if(y % i == 0 ){
                        
                        if(y == i){
                            break;
                        }else{
                            out.print(i+"*");
                            y = y/i;
                            i=1;
                        }
                        
                    }
                }
                
                out.print(y);
//                }
       %>
    </body>
</html>
