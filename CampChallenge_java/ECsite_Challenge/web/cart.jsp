<%-- 
    Document   : cart
    Created on : 2018/07/26, 14:47:10
    Author     : guest1Day
--%>
<%@page import="java.util.ArrayList"%>
<%
    HttpSession hs = request.getSession();
    
    ArrayList<String> imgCart = new ArrayList<String>();
    ArrayList<String> nameCart = new ArrayList<String>();
    ArrayList<String> priceCart = new ArrayList<String>();
    ArrayList<String> reviewRateCart = new ArrayList<String>();
    
    boolean cart = false;  //  カートの中身があるか判別するboolean型の宣言です。falseならばカートの中身が無いという事を示します。
    
    //  imgCartの中身が無ければ他も無いので、これだけ確認する
    if(hs.getAttribute("imgCart")!=null){
        cart = true;
    }
    //  cartがtrueならばカートの中身が存在するので、セッションから配列に情報を格納する。
    if(cart){
        nameCart = (ArrayList<String>)hs.getAttribute("nameCart");
        imgCart = (ArrayList<String>)hs.getAttribute("imgCart");
        priceCart = (ArrayList<String>)hs.getAttribute("priceCart");
        reviewRateCart = (ArrayList<String>)hs.getAttribute("reviewRateCart");
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
        <%if(cart){
            for(int i=0;i<nameCart.size();i++){%>
                <img src="<%=imgCart.get(i)%>">
                <%=nameCart.get(i)%>
                価格：<%=priceCart.get(i)%>
                <%=reviewRateCart.get(i)%>
                <a href="item.jsp?num=<%=i%>">詳細ページへ！<br>
                <a href="buyconfirm.jsp">カートの中身を購入する！
          <%}
          }else{%>
              カートに商品はありません。
        <%}%>
    </body>
</html>
