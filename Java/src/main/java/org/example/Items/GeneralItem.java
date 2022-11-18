package org.example.Items;

public class GeneralItem extends item {

    public final String Name = "GENERALITEM";

    public GeneralItem(int quality, int sellin, double base_price) {
        super(quality, sellin, base_price);
        this.attack = 1;
        this.defense = 1;
    }

    @Override
    public void updateQuality() {
        isSellinEqualZero();
        this.quality--;
        floorQuality();
    }

    @Override
    public String getName() {
        return this.Name;
    }

}
