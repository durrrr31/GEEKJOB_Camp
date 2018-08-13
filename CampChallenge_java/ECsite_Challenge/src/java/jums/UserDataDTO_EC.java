/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.sql.Date;

/**
 *ユーザー情報を格納するBeansオブジェクトで、型・フィールド名がDBのuser_tと連携している。
 * @author guest1Day
 */
public class UserDataDTO_EC {
    
    private int id;
    private String name;
    private String password;
    private String mail;
    private String address;
    private int total;
    private Date newDate;
    private int deleteFlg;
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
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
    
    public int getTotal(){
        return total;
    }
    public void setTotal(int total){
        this.total = total;
    }
    
    public Date getNewDate(){
        return newDate;
    }
    public void setNewDate(Date newDate){
        this.newDate = newDate;
    }
    
    public int getDeleteFlg(){
        return deleteFlg;
    }
    public void setDeleteFlg(int deleteFlg){
        this.deleteFlg = deleteFlg;
    }
    
    
    
}
