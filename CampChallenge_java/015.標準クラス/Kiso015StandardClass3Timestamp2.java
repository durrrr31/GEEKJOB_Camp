
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest1Day
 */
public class Kiso015StandardClass3Timestamp2 {
    


    public static void main(String[] args){
        
//        Date time = new Date((((46*365)+307)*24+10)*60*60*1000L);
        Date time = new Date();
        
        Calendar c = Calendar.getInstance();
            
            c.set(2016,10,4,10,0,0);
            time = c.getTime();

        System.out.println(time.getTime());
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
        System.out.println(sdf.format(time.getTime()));
    }
}