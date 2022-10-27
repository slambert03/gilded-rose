package com.gildedrose;

public class AgedBrieItem extends item {
    public AgedBrieItem(int quality, int sellin) {
        super(quality, sellin);
    }

    @Override
    public void updateQuality() {
        isSellinEqualZero();
        this.quality++;
        ceilingQuality();
        floorQuality();
    }

}
