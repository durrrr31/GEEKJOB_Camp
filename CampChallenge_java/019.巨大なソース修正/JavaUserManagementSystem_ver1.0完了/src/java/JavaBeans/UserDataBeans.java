/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

/**
 *
 * @author guest1Day
 */
public class UserDataBeans {
    
    private String name;
    private int year;
    private int month;
    private int day;
    private String type;
    private String tell;
    private String comment;
    
    //  上記の情報を保存するJavaBeansを作成します。
    
    // nameのJavaBeans
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    // yearのJavaBeans
    public int getYear(){
        return year;
    }
    public void setYear(String year){
            //  year は form入力された後はString型なので、int型にしてからsetします。
        this.year = Integer.parseInt(year);
    }
    
    // monthのJavaBeans
    public int getMonth(){
        return month;
    }
    public void setMonth(String month){
        this.month = Integer.parseInt(month);
    }
    
    // dayのJavaBeans
    public int getDay(){
        return day;
    }
    public void setDay(String day){
        this.day = Integer.parseInt(day);
    }
    
    // typeのJavaBeans
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    
    // tellのJavaBeans
    public String getTell(){
        return tell;
    }
    public void setTell(String tell){
        this.tell = tell;
    }
    
    // commentのJavaBeans
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    
    
}
