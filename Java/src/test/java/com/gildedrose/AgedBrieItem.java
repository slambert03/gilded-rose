package com.gildedrose;

public class AgedBrieItem extends item {

    public final String type = "AGED_BRIE";

    public AgedBrieItem(int quality, int sellin, double base_price) {
        super(quality, sellin, base_price);
    }

    public  AgedBrieItem(int quality, int sellin, int base_price, int attack, int defense) {
        super(quality, sellin, base_price, attack, defense);
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
