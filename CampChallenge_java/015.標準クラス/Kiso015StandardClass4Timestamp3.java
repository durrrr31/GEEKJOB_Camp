
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest1Day
 */
public class Kiso015StandardClass4Timestamp3 {

    public static void main(String[] args){
        
        Date d1 = new Date();
        Date d2 = new Date();
        
        long l1;
        long l2;
        
        Calendar day1 = Calendar.getInstance();
        Calendar day2 = Calendar.getInstance();
        
        day1.set(2015,00,01,00,00,00);
        day2.set(2015,12,31,23,59,59);
        
        d1 = day1.getTime();
        d2 = day2.getTime();
        
       l1 = d1.getTime();
       l2 = d2.getTime();
             
//        SimpleDateFormat sdf;
//        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date day1 = sdf.format("2015/1/1 0:0:0");
//        Date day2 = sdf.format("2015/12/31 23:59:59");
        
        System.out.print(l2 - l1);
        
    }
}
