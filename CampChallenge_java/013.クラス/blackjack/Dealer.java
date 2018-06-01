/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.blackjack;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author guest1Day
 */
public class Dealer extends Human {
    
   ArrayList<Integer> cards = new ArrayList<Integer>();

    Dealer(){
        
        for(int i = 0; i<4 ; i++){
            for(int j=1; j<=13; j++){   //１１以上を１０にして要素追加する
                int num = 0;
                
                if(j > 10){
                    num = 10;
                }else{
                    num = j;
                }
                cards.add(num);
            }
        }
    }
    
    public ArrayList<Integer> deal(){
    ArrayList<Integer> dealing = new ArrayList<Integer>();
        
        for(int i=0; i<2 ;i++){
        Random random = new Random(); //ランダムのインスタンス生成
        
        int size = cards.size();
        int x = random.nextInt(cards.size()-1); //0～51の数字をランダム生成
            
        dealing.add(cards.get(x));
        cards.remove(x);
        }
        return dealing;
    }
    
    public ArrayList<Integer> hit(){
    
        ArrayList<Integer> hitting = new ArrayList<Integer>();
        
        Random random = new Random();
        
        int x = random.nextInt(cards.size()-1);
        
        hitting.add(cards.get(x));
        cards.remove(x);
        
        return hitting;
    }
    
    
    

    @Override
    public int open() {
        int sumD = 0;
        
        for(int i=0; i < myCards.size(); i++){
            sumD = sumD + myCards.get(i);
        }
        return sumD;
    }

    @Override
    public void setCard(ArrayList<Integer> array) {
        
        for(int i=0; i< array.size(); i++){  //配列に格納するのに要素を全て格納
            
            myCards.add(array.get(i));
        }
    }
    

    @Override
    public boolean checkSum() {
        if(open() < 17){
            return true;
        }else{
            return false;
        }
    }
          
//    public ArrayList<Integer> deal extends {
//    
//        ArrayList<Integer> dealing = new ArrayList<Integer>();
//        
//        for(int i=0; i<2 ;i++){
//        Random random = new Random(); //ランダムのインスタンス生成
//        
//        int x = random.nextInt(51-i); //0～51の数字をランダム生成
//            
//        dealing.add(x);
//        }
//        return dealing;
//    }       
//    
//    public ArrayList<Integer> hit{
//    
//        ArrayList<Integer> hitting = new ArrayList<Integer>();
//        
//        Random random = new Random();
//        
//        int x = random.nextInt(cards.size()-1);
//        
//        hitting.add(x);
//        
//        return hitting;
//    
//}
}
