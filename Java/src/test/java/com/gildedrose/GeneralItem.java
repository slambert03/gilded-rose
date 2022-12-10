package com.gildedrose;

public class GeneralItem extends item {

    public final String type = "GENERALITEM";

    public GeneralItem(int quality, int sellin, double base_price) {
        super(quality, sellin, base_price);
    }

    public GeneralItem(int quality, int sellin, int base_price, int attack, int defense) {
        super(quality, sellin, base_price, attack, defense);
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
