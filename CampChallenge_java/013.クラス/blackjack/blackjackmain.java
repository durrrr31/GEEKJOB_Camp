/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.blackjack;

/**
 *
 * @author guest1Day
 */
public class blackjackmain {
    
    public static void main(String[] args){
        
        Dealer d = new Dealer();
        User u = new User();
        
        System.out.println("ブラックジャックを始めます。まずはプレイヤーにハンドを配ります。");
      
            u.setCard(d.deal());
        
            for(int i=1; i < 100; i++){
                if(u.checkSum() == true){
                    
                    System.out.println("ユーザーのハンドは"+ u.open());
                    System.out.println("ユーザーはもう１枚引きます");
                    u.setCard(d.hit());
                }else{
                break;  
                }
            }
        
        System.out.println("ユーザーのハンドは"+ u.open());
        System.out.println("ディーラーの番です。");
            
            d.setCard(d.deal());
            
            for(int i=1; i < 100; i++){
                if(d.checkSum() == true){
                    
                    System.out.println("ディーラーのハンドは"+ d.open());
                    System.out.println("ディーラーはもう１枚引きます");
                    d.setCard(d.hit());
                }else{
                break;  
                }
        System.out.println("ディーラーのハンドは"+ d.open());
        
        if(u.open() > d.open()){
            System.out.println("ユーザーの勝ち！");
        }else if(u.open() == d.open()){
            System.out.println("引き分け！");
        }else{
            System.out.println("ディーラーの勝ち！");
        }
            
    }
}
}