/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import base.DBManager;
import java.sql.*;

/**
 *  DBに購入商品情報を登録するためのメソッドが集まっているクラスです。
 * @author guest1Day
 */
public class ItemDataDAO {
    
    //  dbに購入した商品の情報をinsertするためのメソッド　引数として情報の格納されているBeansを渡す。
    public void insert(ItemDataDTO idd) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("INSERT INTO buy_t(userID,itemCode,type,buyDate) VALUES(?,?,?,?)");
            
            st.setInt(1,idd.getUserID());
            st.setString(2, idd.getItemCode());
            st.setInt(3,idd.getType());
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    
    
    
}
