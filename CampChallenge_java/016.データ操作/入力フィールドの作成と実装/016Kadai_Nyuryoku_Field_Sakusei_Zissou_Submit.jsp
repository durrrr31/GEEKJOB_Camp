<%
    // クッキーを持ってくる
    
//    Cookie[] cookie = request.getCookies();
//    <%out.print(Cname[0].getValue());"
//    String name = cookie[0].getValue();
    
HttpSession hs = request.getSession();


    String name = "";
    String gender = "";
    String hobby = "";
    
    if(hs.getAttribute("name") != null){
        name = (String)hs.getAttribute("name");
        gender = (String)hs.getAttribute("gender");
        hobby = (String)hs.getAttribute("hobby");
    }

%>
<%-- 
    Document   : 016Kadai_Nyuryoku_Field_Sakusei_Zissou_Submit
    Created on : 2018/06/06, 13:47:31
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
        <form action="./Kadai16_Nyuryoku_Field_Sakusei_Zissou" method="post">
            
                <p>
                    名前を入力してください
                    <input type="text" name="txtName" <%if(name !="") {out.print("value=" + name);}%>>
                </p>
                <p>
                    性別はどちらですか？
                    <input type="radio" name="rdoGender"value="男" <%if(gender.equals("男")){out.print("checked");}%>>男
                    <input type="radio" name="rdoGender"value="女" <%if(gender.equals("女")){out.print("checked");}%>>女
                </p> 
                <p>
                    <textarea name="hobby"><% if(hobby.equals("")){out.print("趣味を入力してください");}else{out.print(hobby);}%></textarea>
                </p>
                <p>
                    <input type="submit" name="btnSubmit" value="送信">
                </p>
            </form>
    </body>
</html>
<!--a-->