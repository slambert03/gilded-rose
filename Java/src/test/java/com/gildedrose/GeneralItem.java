package com.gildedrose;

public class GeneralItem extends item {

    public final String type = "GENERALITEM";

    public GeneralItem(int quality, int sellin, double base_price) {
        super(quality, sellin, base_price);
    }

    @Override
    public void updateQuality() {
        isSellinEqualZero();
        this.quality--;
        floorQuality();
    }

    @Override
    public String getType() {
        return this.type;
    }
}
