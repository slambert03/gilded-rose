package com.gildedrose;

public class GeneralItem extends item {

    public GeneralItem(int quality, int sellin) {
        super(quality, sellin);
    }

    @Override
    public void updateQuality() {
        isSellinEqualZero();
        this.quality--;
        floorQuality();
    }

}
