/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import base.DBManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpSession;

/**
 *  DBに会員情報を登録する際に用いるメソッドを集めたクラスです。
 * @author guest1Day
 */
public class UserDataDAO_EC {
    
    
    //  dbに新規会員登録情報をinsertするメソッド　引数として情報の格納されているBeansを渡す
    public void insert(UserDataDTO_EC ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name,password,mail,address,newDate) VALUES(?,?,?,?,?)");

            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            st.setString(3, ud.getMail());
            st.setString(4, ud.getAddress());
            st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
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
    
    public ArrayList select(UserDataDTO_EC ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        ResultSet data = null;
        
//        HttpSession hs = request.getSession();  //  エラーが出ます
        
        // データを保管するためのArrayListを作る。
        
        ArrayList array = new ArrayList();
        
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("SELECT * FROM user_t WHERE name=? AND password=?");

            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            
            data = st.executeQuery();
            
            boolean log = true;   //  arrayに格納するためのlogin情報、trueならばログイン
            
            //  arrayにSELECTした情報を格納します。
            if(data.next()){
                array.add(data.getInt("userID"));       //  0
                array.add(data.getString("name"));      //  1
                array.add(data.getString("password"));  //  2
                array.add(data.getString("mail"));      //  3
                array.add(data.getString("address"));   //  4
                array.add(data.getInt("total"));        //  5
                array.add(data.getDate("newDate"));    //  6
                array.add(data.getInt("deleteFlg"));    //  7
                //  logをtrueにしてログイン状態とする。
                array.add(log);                         //  8
            }
            System.out.println("insert completed");
            
            return array;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
            
            //  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!ログインページに戻る処理を実装します。(未実装)
        }finally{
            if(con != null){
                con.close();
            }
        }
        
        
    }
    
    //  DBに会員情報を更新するメソッドです。
    public void update(UserDataDTO_EC ud)throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("UPDATE user_t SET name=?,password=?,mail=?,address=?,newDate=?");

            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            st.setString(3, ud.getMail());
            st.setString(4, ud.getAddress());
            st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            
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
