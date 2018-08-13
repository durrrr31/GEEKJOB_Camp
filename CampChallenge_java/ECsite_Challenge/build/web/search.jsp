<%-- 
    Document   : search
    Created on : 2018/07/17, 10:47:53
    Author     : guest1Day
--%>

<%@page import="jums.JumsHelper_EC"%>
<%@page import="jums.UserDataDTO_EC"%>
<%@page import="jums.ItemDataBeans"%>
<%@page import="java.util.ArrayList"%>
<!--searchで受け取った情報を表示するJSPです。-->
<%
    JumsHelper_EC jh = new JumsHelper_EC();
    //  Sessionに入れた情報を受け取るためにSessionのインスタンス生成。
    HttpSession hs = request.getSession();
    
    //  idbをインスタンス生成し、セッションから情報を受け取る。
    ItemDataBeans idb = (ItemDataBeans)hs.getAttribute("idb");
    
    //  idbのgetterを使ってそれぞれ情報を取り出す。
    ArrayList<String> img = idb.getImage();
    ArrayList<String> name = idb.getName();
    ArrayList<String> url = idb.getUrl();
    ArrayList<String> price = idb.getPrice();
    
    
    //  ログインしているかどうかの確認をします。
    boolean log = false;
    
    String nameStr="";    //  セッションに保存してある名前を格納するためのString型です。 
    
    if(hs.getAttribute("log")!=null){
        log = (Boolean)hs.getAttribute("log");
        
        UserDataDTO_EC dto = (UserDataDTO_EC)hs.getAttribute("dto");
        nameStr = dto.getName();
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
                <%=jh.logout("top.jsp",nameStr)%>
            <%}else{%>
                <%=jh.login("./search.jsp")%>
            <%}%>
        
        <h1>検索結果はこちら！上位10件の商品情報を表示しています。</h1><br>
            <%for(int i=0; i<10; i++){%>
                <img src="<%=img.get(i)%>">
                <a href="item.jsp?id=<%=i%>"><%=name.get(i)%>
            価格：<%=price.get(i)%>
                <br>
            <%}%>
    </body>
</html>
