<%@page import="JavaBeans.UserDataBeans"%>
<%@page import="jums.JumsHelper"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans b =  (UserDataBeans)hs.getAttribute("b");
    
    // acを受け取る処理
    Object acObj = request.getAttribute("ac");
    String acStr = acObj.toString();
    int ac = new Integer(acStr);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <!--入力が不完全の場合の処理-->
    <% if(b.getName().equals("")){ %>
        名前を入力されていません<br>
        <% }
        if(b.getYear() == 0){ %>
        生年月日の年が入力されていません<br>
        <% }
        if(b.getMonth() == 0){ %>
        生年月日の月が入力されていません<br>
        <% }
        if(b.getDay() == 0){ %>
        生年月日の日が入力されていません<br>
        <% }
        if(b.getType() == ""){ %>
        種別が選択されていません
        <% }
        if(b.getTell() == ""){ %>
        電話番号が入力されていません<br>
        <% }
        if(b.getComment() == ""){ %>
        自己紹介欄が入力されていません<br>
        <% }

//        入力漏れがない事を確認し登録確認画面を表示する
        if(!b.getName().equals("") && b.getYear() != 0 && b.getMonth() != 0 && b.getDay() != 0 && !b.getType().equals("") && !b.getTell().equals("") && b.getComment() != ""){ %>
        <h1>登録確認</h1>
        名前:<% out.print(b.getName()); %><br>
        生年月日:<% out.print(b.getYear() +"年"+b.getMonth() +"月"+ b.getDay() +"日"); %><br>
        種別:<%= b.getType()%><br>
        電話番号:<%= b.getTell()%><br>
        自己紹介:<%= b.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="submit" name="yes" value="はい">
    <% } %>
        <form action="insert" method="POST">
            <input type="hidden" name="ac" value="<%=ac%>">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    

