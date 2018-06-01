/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.blackjack;

import java.util.ArrayList;

/**
 *
 * @author guest1Day
 */
abstract class Human {
    
    protected ArrayList<Integer> myCards = new ArrayList<Integer>();
        
        //手札の合計値を計算するメソッドを作ります。
        //メソッドの戻り値は、手札の合計値です。
        abstract public int open();
            
            
            
//            int Sum = 0;  //手札の合計値
//            
//            for(i =0; i < myCards.size() /*ArrayListの要素数*/  ; i++){
//                    Sum = Sum + myCards.get(i);
//            }
//            return Sum;
        
        
        
        //引いたカードを手札に追加するメソッドです。
        
//        abstract void setCard(Arraylist<Integer> myCard){
//}
        abstract public void setCard(ArrayList<Integer> array);

        
        
        //まだカードを引くべきかを判断するメソッドです。
        //自分の手札の合計値で引くか判断、もう一枚引くなら（true）を戻り値に
        
        abstract public boolean checkSum();//{
////            if(Sum > X    /*もし合計値がⅩより上ならば*/){
////                return false;
////            }else{
////                return true;
////            }
//        }
            
}   
    

