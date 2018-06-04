
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest1Day
 */
public class Kiso015StandardClassFile11 {
    
    public static void main(String[] args){
        
        try{
        File classkadai = new File("abc");
        FileReader fr1 = new FileReader(classkadai);
            BufferedReader br1 = new BufferedReader(fr1);
            
            System.out.println(br1.readLine());
            System.out.println(br1.readLine());
            System.out.println(br1.readLine());
            
            
            fr1.close();
    
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}