<%-- 
    Document   : GOODS_INF_REGISTER
    Created on : 2018/06/20, 13:36:25
    Author     : guest1Day
--%>

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
        HttpSession s = request.getSession();
            
            if(s.getAttribute("log") == null){
                RequestDispatcher rd = request.getRequestDispatcher("/Login_Gamen");
                rd.forward(request, response);
            }
            request.setCharacterEncoding("UTF-8");
            
                Connection db_con = null;
                PreparedStatement db_st = null;

            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?characterEncoding=UTF-8&serverTimezone=JST","Hassy","0106");


                db_st = db_con.prepareStatement("insert into goods(goodsName,zaikosu) VALUES(?,?)");
                db_st.setString(1, request.getParameter("GoodsName"));
                db_st.setInt(2, Integer.parseInt(request.getParameter("zaikosu")));
                
                db_st.executeUpdate();
                
                    out.println("登録完了");

                db_con.close();
                db_st.close();
                 }catch(SQLException e_con){
                out.println("接続時にエラーが発生しました1："+e_con.toString());
            }catch(Exception e){
                out.println("接続時にエラーが発生しました2："+e.toString());
            }finally{
                if(db_con != null){
                    try{
                    }catch(Exception e_con){
                        out.println("error");
                    }
                }
            }
        %>
        <form action="./Kannri_Gamen.jsp" method="post">
        <p>    
            <input type="submit" name="return" value="前のページに戻る">
        </p>
        </form>

        <form action="./Login.jsp" method="post">
        <p>    
            <input type="submit" name="logout" value="ログアウト">
        </p>
        </form>
    </body>
</html>
