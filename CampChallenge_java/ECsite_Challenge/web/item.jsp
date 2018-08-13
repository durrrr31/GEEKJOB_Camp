<%-- 
    Document   : item
    Created on : 2018/07/17, 13:34:34
    Author     : guest1Day
--%>

<%@page import="jums.UserDataDTO_EC"%>
<%@page import="jums.JumsHelper_EC"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.ItemDataBeans"%>
<!--商品情報の詳細ページです。-->
<%
    JumsHelper_EC jh = new JumsHelper_EC();
    HttpSession hs = request.getSession();
    
//  idbをインスタンス生成し、セッションから情報を受け取る。
    ItemDataBeans idb = (ItemDataBeans)hs.getAttribute("idb");
    
    String imgStr = "";
    String nameStr = "";
    String urlStr =""; 
    
    
    //  !!!!!!!!!!!!!!!!!!ここでもう一つ分岐が必要かと思われる。
    if(hs.getAttribute("idbDetail")!=null){
        idb = (ItemDataBeans)hs.getAttribute("idbDetail");
    }
    
    int id = Integer.parseInt(request.getParameter("id"));  //  search.jspから送られてくる商品のIDを格納します。
        
    //  idbのgetterを使ってそれぞれ情報を取り出す。
    ArrayList<String> img = idb.getImage();
    ArrayList<String> name = idb.getName();
    ArrayList<String> url = idb.getUrl();
    ArrayList<String> price = idb.getPrice();
    ArrayList<String> description = idb.getDescription();
    

    //  ログインしているかどうかの確認をします。
    boolean log = false;
    
    String User_name="";    //  セッションに保存してある名前を格納するためのString型です。 
    
    if(hs.getAttribute("log")!=null){
        log = (Boolean)hs.getAttribute("log");
        
        UserDataDTO_EC dto = (UserDataDTO_EC)hs.getAttribute("dto");
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
            <%if(log){%>
                <%=jh.logout("top.jsp",User_name)%>
            <%}else{%>
                <%=jh.login("./item.jsp")%>
            <%}%>
        
        <form action="./Add" method="GET">
        <img src="<%=img.get(id)%>">
        商品名：<%=name.get(id)%><br>
        値段：<%=price.get(id)%>円<br>
        <%=description.get(id)%><br>
        <input type="hidden" name="id" value="<%=id%>">
        <input type="submit" name="btnSubmit" value="カートに追加する">
        </form>

    </body>
</html>
