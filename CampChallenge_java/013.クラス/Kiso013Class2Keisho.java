/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest1Day
 */
public class Kiso013Class2Keisho {
    
}
class Keisho extends Hyouji{
    public void Clear(){
        setNameMoney("",0);
    }
}

class Main2{
public static void main(String[] args){
        Keisho keisho = new Keisho();
            keisho.Clear();
            keisho.hyouji();
}
}