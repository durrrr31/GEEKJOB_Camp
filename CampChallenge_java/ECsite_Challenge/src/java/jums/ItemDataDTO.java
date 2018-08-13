/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.sql.Date;

/**
 *  商品情報を格納するBeansオブジェクトで、DBのbuy_tと型・フィールド名が連携している。
 * @author guest1Day
 */
public class ItemDataDTO {
    
    private int userID;       //  userID
    private String itemCode;  //  商品コード
    private int type;         //  配送方法のint型
    private Date buyDate;     //  Date型の購入日時
    
    public int getUserID(){
        return userID;
    }
    public void setUserID(int userID){
        this.userID = userID;
    }
    
    public String getItemCode(){
        return itemCode; 
    }
    public void setItemCode(String itemCode){
        this.itemCode = itemCode;
    }
    
    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type = type;
    }
    
    public Date getBuyDate(){
        return buyDate;
    }
    public void setBuyDate(Date buyDate){
        this.buyDate = buyDate;
    }
}
