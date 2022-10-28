package com.gildedrose;

public class BackstagePassesItem extends item{
    public BackstagePassesItem(int quality, int sellin, double base_price) {
        super(quality, sellin, base_price);
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
}
