package org.example;

public class Item {
    private int quality;
    private int sellIn;
    private String name;
    public Item(int quality,int sellIn,String name){
        this.quality=quality;
        this.sellIn=sellIn;
        this.name=name;
        if (this.name=="Sulfuras"){
            this.sellIn=-1;
        }
    }
    public void endDay() {
        if (this.name=="Conjured"){
            if (this.sellIn==0){this.quality=this.sellIn=0;}
            else if((this.sellIn>=0) && (this.quality)-2>0){this.quality-=2;this.sellIn--;}
        }
        else if (this.name=="Backstage passes"){
            if (this.sellIn==0){this.quality=this.sellIn=0;}
            else if (this.sellIn<=5){this.quality+=3;this.sellIn--;}
            else if (this.sellIn<=10){this.quality+=2;this.sellIn--;}
            else {this.quality++;this.sellIn--;}
        }
        else if (this.name=="Sulfuras"){}//do nothing
        else if (this.name == "Aged Brie") {this.quality++;this.sellIn--;        }
        else {
            if (this.sellIn == 0) {
                if (this.quality >= 2) {this.quality -= 2;}
                else {this.quality = 0;}
            }
            else {
                if (this.quality >= 1) { this.quality--;this.sellIn--;}
                else {
                    this.quality = 0;
                    this.sellIn--;
                }
        }
    }
    }

    public void increaseQuality(int increaser){
        if (this.quality+increaser<=50){
            this.quality+=increaser;

        }
        else {this.quality=50;}
    }

    public int getSellIn(){return this.sellIn;}
    public int getQuality(){return this.quality;}
}