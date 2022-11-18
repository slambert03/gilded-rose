package org.example;

public class LegendaryItem extends item {

    public final String type = "LEGENDARY";

    public LegendaryItem(int quality, int sellin, double base_price) {
        super(quality, sellin, base_price);
        this.attack = 1;
        this.defense = 1;
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
    public void updateSellin() {
        floorSellin();
    }
}
