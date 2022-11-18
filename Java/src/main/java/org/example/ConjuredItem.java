package org.example;

public class ConjuredItem extends item {
    public final String type = "CONJURED";

    public ConjuredItem(int quality, int sellin, double base_price) {
        super(quality, sellin, base_price);
        this.attack = 1;
        this.defense = 1;
    }

    @Override
    public void updateQuality() {
        isSellinEqualZero();
        this.quality--;
        this.quality--;
        floorQuality();
    }

    @Override
    public String getName() {
        return this.Name;
    }
}
