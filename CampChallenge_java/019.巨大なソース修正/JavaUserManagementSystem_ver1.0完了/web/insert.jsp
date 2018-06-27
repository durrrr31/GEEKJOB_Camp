<%@page import="JavaBeans.UserDataBeans"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    //  セッションに保存したBeansを取りそれぞれの情報を格納する
    HttpSession hs = request.getSession();
    
    UserDataBeans b = (UserDataBeans)hs.getAttribute("b");
    
    //  Insert.javaでリクエストスコープに入れたacを取り出して格納
    
    int ac = (Integer)(request.getAttribute("ac"));
    
    String name = "";
    int year = 0;
    int month = 0;
    int day = 0;
    String type = "";
    String tell = "";
    String comment = "";
    
    if(b != null){
        name = b.getName();
    
         year = b.getYear();
    
         month = b.getMonth();
    
        day = b.getDay();
    
        type = b.getType();
    
        tell = b.getTell();
    
        comment = b.getComment();
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" value="<%=name%>">
        <br><br>
        生年月日:
        <select name="year">
            <option value="<%=hs.getAttribute("year")%>">----</option>
            <%
            for(int i=1950; i<=2010; i++){
                if(year == i){ %>
                <option value="<%=i%>" selected> <%=i%> </option>
            <% }else{ %>
                <option value="<%=i%>"> <%=i%> </option>
            <%}}%>
            
        </select>年
        <select name="month">
            <option value="">--</option>
            <%
            for(int j = 1; j<=12; j++){ 
                if(month == j){%>
                <option value="<%=j%>" selected><%=j%></option>
            <% }else{ %>
                <option value="<%=j%>"><%=j%></option>
            <% }} %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <%
            for(int k = 1; k<=31; k++){ 
                if(day == k){%>
                <option value="<%=k%>" selected><%=k%></option>
            <% }else {%>
                <option value="<%=k%>"><%=k%></option>
                <%}}%>
        </select>日
        <br><br>

        種別:
        <br>
        <input type="radio" name="type" value="1" <% if(type.equals("1")){out.print("checked");} %>>エンジニア<br>
        <input type="radio" name="type" value="2" <% if(type.equals("2")){out.print("checked");} %>>営業<br>
        <input type="radio" name="type" value="3" <% if(type.equals("3")){out.print("checked");} %>>その他<br>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%=tell%>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%=comment%></textarea><br><br>

        <input type="hidden" name="ac" value="<%=ac%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
