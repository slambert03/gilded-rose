package com.gildedrose;

public class LegendaryItem extends item{
    public LegendaryItem(int quality, int sellin) {
        super(quality, sellin);
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
