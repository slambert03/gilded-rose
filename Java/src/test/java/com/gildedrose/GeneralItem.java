package com.gildedrose;

public class GeneralItem extends item {

    public GeneralItem(int quality, int sellin, double base_price) {
        super(quality, sellin, base_price);
    }

    @Override
    public void updateQuality() {
        isSellinEqualZero();
        this.quality--;
        floorQuality();
    }

}
