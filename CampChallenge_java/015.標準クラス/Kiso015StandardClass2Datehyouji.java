
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest1Day
 */
public class Kiso015StandardClass2Datehyouji {
    public static void main(String[] args){
            
        Calendar c = Calendar.getInstance();
        c.set(1988,5,21,1,23,45);

        int Y = c.get(Calendar.YEAR);
        int M = c.get(Calendar.MONTH);
        int D =(c.get(Calendar.DAY_OF_MONTH));
        int H =(c.get(Calendar.HOUR_OF_DAY));
        int m =(c.get(Calendar.MINUTE));
        int S =(c.get(Calendar.SECOND));
        
        System.out.print(Y+"年"+M+"月"+D+"日"+H+"時"+m+"分"+S+"秒");

    }
}