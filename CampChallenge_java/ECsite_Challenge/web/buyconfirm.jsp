<%-- 
    Document   : buyconfirm
    Created on : 2018/07/30, 15:15:42
    Author     : guest1Day
--%>
<%@page import="java.util.ArrayList"%>
<%
    HttpSession hs = request.getSession();
    
    ArrayList<String> imgCart = new ArrayList<String>();
    ArrayList<String> nameCart = new ArrayList<String>();
    ArrayList<String> priceCart = new ArrayList<String>();
    ArrayList<String> reviewRateCart = new ArrayList<String>();
    
    //  カートの中身の情報をセッションから受け取ります。
    nameCart = (ArrayList<String>)hs.getAttribute("nameCart");
    imgCart = (ArrayList<String>)hs.getAttribute("imgCart");
    priceCart = (ArrayList<String>)hs.getAttribute("priceCart");
    reviewRateCart = (ArrayList<String>)hs.getAttribute("revieRateCart");
    
    //  合計金額を算出します。
    int total = 0;  //  合計金額を格納するtotalの宣言。
    for(String x:priceCart){
        total = total + Integer.parseInt(x);
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
        <%for(int i=0;i<nameCart.size();i++){%>
            <img src="<%=imgCart.get(i)%>">
                <%=nameCart.get(i)%>
                価格：<%=priceCart.get(i)%>
                <%=reviewRateCart.get(i)%>
        <%}%>
        <br>
        <form action="./BuyComplete" method="post">
           合計金額：%=total%>円<br>
           発送方法<br>
           <input type="radio" name="shipping" value="">！！！！！！！！！！！！！！発送方法の詳細がまだできていません<br>
           <input type="submit" name="btnSubmit">上記の内容で購入します！
        </form>
        <a href="cart.jsp">まだ買い足りない！カートに戻るときはこちら！
    </body>
</html>
