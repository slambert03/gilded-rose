package com.gildedrose;

public class LegendaryItem extends item{

    public final String type= "LEGENDARY";

    public LegendaryItem(int quality, int sellin, double base_price) {
        super(quality, sellin, base_price);
    }

    @Override
    public void updateQuality() {
        floorQuality();
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void updateSellin(){
        floorSellin();
    }
}
