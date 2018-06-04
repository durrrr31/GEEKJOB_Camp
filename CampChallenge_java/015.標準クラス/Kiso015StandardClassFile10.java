
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
public class Kiso015StandardClassFile10 {
    
    
    public static void main(String[] args){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        Date now = new Date();
        
//        System.out.println(sdf.format(now.getTime()));
        System.out.println("7と4を比べて大きいほうは"+ Math.max(7, 4) + "です。");
        
        try{
            File classkadai = new File("abc");

            FileWriter fw = new FileWriter("abc");
            
//            FileReader fr1 = new FileReader(fw);
//            BufferedReader br1 = new BufferedReader(fr1);

            fw.write("Mathクラスの二つの数の大きいほうを選択する処理"+"\n");
            fw.write((sdf.format(now.getTime()))+"開始"+"\n");   //開始のログ
            fw.write((sdf.format(now.getTime()))+"終了"+"\n"); 
            
//            FileReader fr1 = new FileReader(classkadai);
//            BufferedReader br1 = new BufferedReader(fr1);
            
//            System.out.println(br1.readLine());
            
            fw.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
