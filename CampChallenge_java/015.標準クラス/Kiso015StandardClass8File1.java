
import java.io.File;
import java.io.FileWriter;
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
public class Kiso015StandardClass8File1 {
    
    public static void main(String[] args){
        
        try{
            File intro = new File("intro.txt");

            FileWriter fw = new FileWriter(intro);

            fw.write("初めまして、橋本龍一です。");
//            fw.write("23歳");

            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}


