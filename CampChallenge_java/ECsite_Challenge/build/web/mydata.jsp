<%-- 
    Document   : mydata
    Created on : 2018/08/02, 13:31:51
    Author     : guest1Day
--%>

<%@page import="jums.UserDataDTO_EC"%>
<%
    HttpSession hs = request.getSession();
    //  ユーザー情報を取り出します。
    boolean log = false;
    
    String User_name="";    //  セッションに保存してある名前を格納するためのString型です。 
    
    UserDataDTO_EC dto = new UserDataDTO_EC();
    
    //  logがあるならばdtoにセッションから情報を取り出し、格納する。
    if(hs.getAttribute("log")!=null){
        log = (Boolean)hs.getAttribute("log");
        
        dto = (UserDataDTO_EC)hs.getAttribute("dto");
        User_name = dto.getName();
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ユーザー情報<br>
        名前：<%=dto.getName()%><br>
        メールアドレス：<%=dto.getMail()%><br>
        住所：<%=dto.getAddress()%><br>
        合計購入金額：<%=dto.getTotal()%><br>
        登録日時：<%=dto.getNewDate()%><br><br><br>
        
        <a href="myhistory.jsp">購入履歴を閲覧<br><br><br>
            
        <a href="myupdate.jsp">登録情報を更新<br><br><br>
            
        <a href="mydelete.jsp">アカウントの削除<br><br><br>
        
    </body>
</html>
