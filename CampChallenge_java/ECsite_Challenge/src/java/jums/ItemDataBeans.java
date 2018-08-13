/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package jums;

import java.util.ArrayList;

/**  Searchで検索した商品の詳細情報を保存するためのJavaBeansです。ArrayListでデータを格納します。
 *
 * @author guest1Day
 */
public class ItemDataBeans {
    
    private ArrayList<String> name = new ArrayList<String>();        //  商品名を保存する配列。
    private ArrayList<String> url = new ArrayList<String>();         //  商品の詳細ページのURLを保存する配列。
    private ArrayList<String> image = new ArrayList<String>();       //  商品画像のURLを保存する配列。
    private ArrayList<String> price = new ArrayList<String>();       //  商品の値段を保存する配列。
    private ArrayList<String> shipping = new ArrayList<String>();    //  発送方法の番号を保存する配列。
    private ArrayList<String> itemCode = new ArrayList<String>();    //  商品コードを保存する配列。
    private ArrayList<String> reviewRate = new ArrayList<String>();  //  商品の評価を保存する配列。
    private ArrayList<String> reviewCount = new ArrayList<String>(); //  商品の評価の件数を保存する配列。
    private ArrayList<String> description = new ArrayList<String>(); //  商品の詳細情報を保存する配列。
    

    //  上で作成したフィールドのgetter,setterメソッドをそれぞれ作成します。
    public ArrayList<String> getName(){
        return name;
    }
    public void setName(String name){
        this.name.add(name);
    }

    public ArrayList<String> getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url.add(url);
    }

    public ArrayList<String> getImage(){
        return image;
    }
    public void setImage(String image){
        this.image.add(image);
    }   

    public ArrayList<String> getPrice(){
        return price;
    }
    public void setPrice(String price){
        this.price.add(price);
    }

    public ArrayList<String> getShipping(){
        return shipping;
    }
    public void setShipping(String shipping){
        this.shipping.add(shipping);
    }
    
    public ArrayList<String> getItemCode(){
    return itemCode;
    }
    public void setItemCode(String itemCode){
        this.itemCode.add(itemCode);
    }
    
    public ArrayList<String> getReviewRate(){
    return reviewRate;
    }
    public void setReviewRate(String reviewRate){
        this.reviewRate.add(reviewRate);
    }
    
    public ArrayList<String> getReviewCount(){
    return reviewCount;
    }
    public void setReviewCount(String reviewCount){
        this.reviewCount.add(reviewCount);
    }
    
    public ArrayList<String> getDescription(){
    return description;
    }
    public void setDescription(String description){
        this.description.add(description);
    }
    
}