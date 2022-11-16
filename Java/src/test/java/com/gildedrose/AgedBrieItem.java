package com.gildedrose;

public class AgedBrieItem extends item {

    public final String type = "AGED_BRIE";

    public AgedBrieItem(int quality, int sellin, double base_price) {
        super(quality, sellin, base_price);
    }

    @Override
    public void updateQuality() {
        isSellinEqualZero();
        this.quality++;
        ceilingQuality();
        floorQuality();
    }

    @Override
    public String getType() {
        return this.type;
    }
}
