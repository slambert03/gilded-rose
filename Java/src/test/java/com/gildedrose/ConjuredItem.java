package com.gildedrose;

public class ConjuredItem extends item {
    public final String type = "CONJURED";

    public ConjuredItem(int quality, int sellin, double base_price) {
        super(quality, sellin, base_price);
    }

    @Override
    public void updateQuality() {
        isSellinEqualZero();
        this.quality--;
        this.quality--;
        floorQuality();
    }

    @Override
    public String getType() {
        return type;
    }
}
