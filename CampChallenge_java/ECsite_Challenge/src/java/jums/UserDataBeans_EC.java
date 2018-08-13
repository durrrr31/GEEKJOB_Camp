/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

/**
 *フォームから入出力されるデータをBeansオブジェクト
 * DTOからの変換・逆変換をするメソッドも保持する
 * @author guest1Day
 */
public class UserDataBeans_EC {
    
    private String name;
    private String password;
    private String mail;
    private String address;
    
    
    //  インスタンス生成された時に初期値を空文字にする処理
    public UserDataBeans_EC(){
        name ="";
        password ="";
        mail ="";
        address ="";
    }
    
    //  それぞれのset,getメソッド
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    
        //  このUDBにあるフィールドを引数のDTOにセットするメソッドです。
    public void Mapping(UserDataDTO_EC udd){
        
        udd.setName(this.name);
        udd.setPassword(this.password);
        udd.setMail(this.mail);
        udd.setAddress(this.address);
    }
    
}
