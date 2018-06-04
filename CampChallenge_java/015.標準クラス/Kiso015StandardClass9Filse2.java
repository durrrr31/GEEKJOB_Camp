
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
public class Kiso015StandardClass9Filse2 {
    
    public static void main(String[] args){
        
        try{
            File intro = new File("intro.txt");
            FileReader fw = new FileReader(intro);
            
            BufferedReader br = new BufferedReader(fw);
            
            System.out.println(br.readLine());
//             System.out.println(fw.read());
            
            fw.close();
//            br.close();
            
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}