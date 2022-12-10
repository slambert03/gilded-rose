package com.gildedrose;

public class LegendaryItem extends item{

    public final String type= "LEGENDARY";

    public LegendaryItem(int quality, int sellin, double base_price) {
        super(quality, sellin, base_price);
    }

    public LegendaryItem(int quality, int sellin, int base_price, int attack, int defense) {
        super(quality, sellin, base_price, attack, defense);
    }

    @Override
    public void updateQuality() {
        floorQuality();
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void updateSellin(){
        floorSellin();
    }
}
