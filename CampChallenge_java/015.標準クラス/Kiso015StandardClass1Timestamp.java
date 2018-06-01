
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
public class Kiso015StandardClass1Timestamp {
    
    public static void main(String[] args){
        
        Date kadai = new Date();
        Calendar c = Calendar.getInstance();
        c.set(2016,0,1,0,0,0);
        
        kadai = c.getTime();
        
        System.out.print(kadai.getTime());
    }
    
}
