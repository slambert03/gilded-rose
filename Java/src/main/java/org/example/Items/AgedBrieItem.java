package org.example.Items;

public class AgedBrieItem extends item {

    public final String type = "AGED_BRIE";

    public AgedBrieItem(int quality, int sellin, double base_price) {
        super(quality, sellin, base_price);
        this.Name = "AGED_BRIE";
    }

    @Override
    public void updateQuality() {
        isSellinEqualZero();
        this.quality++;
        ceilingQuality();
        floorQuality();
    }

    @Override
    public String getName() {
        return this.Name;
    }

}
