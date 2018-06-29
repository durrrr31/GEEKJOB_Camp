<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataBeans udb = (UserDataBeans)request.getAttribute("udb");
    
    //  誕生日を〇年〇月〇日という形式でbirthdayに格納します。
    String birthday = udb.getYear() +"年"+udb.getMonth() +"月"+udb.getDay()+"日";
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <h1>変更結果</h1><br>
        名前:<%= udb.getName()%><br>
        生年月日:<%=birthday%><br>
        種別:<%= udb.getType()%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        以上の内容で更新しました。<br>
    </body>
    <%=jh.home()%>
    </body>
</html>
