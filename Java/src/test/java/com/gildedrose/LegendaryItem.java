package com.gildedrose;

public class LegendaryItem extends item{
    public LegendaryItem(int quality, int sellin, double base_price) {
        super(quality, sellin, base_price);
    }

    @Override
    public void updateQuality() {
        floorQuality();
    }

    @Override
    public void updateSellin(){
        floorSellin();
    }
}
