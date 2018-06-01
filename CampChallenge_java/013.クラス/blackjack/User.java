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
public class User extends Human {
    
    ArrayList<Integer> myCards  = new ArrayList<Integer>();

    @Override
    public int open() {
        int sumU = 0;
        
        for(int i=0; i < myCards.size(); i++){
            sumU = sumU + myCards.get(i);
        }
        return sumU;        
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
    
}

