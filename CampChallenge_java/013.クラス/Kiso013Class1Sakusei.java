/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest1Day
 */
class Hyouji{
        private String name ="";
        private int money = 0;
        
        public void setNameMoney(String n, int m){
            this.name = n;
            this.money = m;
        }
        public void hyouji(){
            System.out.print(name);
            System.out.print(money+"円");
        }
    }
class Main{
public static void main(String[] args){
        Hyouji hyouji = new Hyouji();
            
        hyouji.setNameMoney("おにぎり", 120);
            
        hyouji.hyouji();
}
}