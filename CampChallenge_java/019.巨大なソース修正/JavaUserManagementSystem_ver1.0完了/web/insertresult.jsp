<%@page import="JavaBeans.UserDataBeans"%>
<%@page import="jums.JumsHelper"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans b = (UserDataBeans)hs.getAttribute("b");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        名前:<%= b.getName()%><br>
        生年月日:<%= b.getYear()+"年"+b.getMonth()+"月"+b.getDay()+"日"%><br>
        種別:<%= b.getType()%><br>
        電話番号:<%= b.getTell()%><br>
        自己紹介:<%= b.getComment()%><br>
        以上の内容で登録しました。<br>
        <br>
        <% hs.invalidate();%>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
