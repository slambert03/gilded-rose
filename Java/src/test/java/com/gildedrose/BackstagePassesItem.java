package com.gildedrose;

public class BackstagePassesItem extends item{

    public final String type= "BACKSTAGEPASSES";

    public BackstagePassesItem(int quality, int sellin, double base_price) {
        super(quality, sellin, base_price);
    }

    public  BackstagePassesItem(int quality, int sellin, int base_price, int attack, int defense) {
        super(quality, sellin, base_price, attack, defense);
    }

    @Override
    public void updateQuality() {
        if (this.sellin <= 10){
            this.quality++;
        }
        if (this.sellin <= 5){
            this.quality++;
        }
        this.quality++;

        if (this.sellin <= 0)
            this.quality = 0;
        floorQuality();
    }

    @Override
    public String getType() {
        return this.type;
    }
}
