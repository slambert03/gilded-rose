package org.example.Items;

public class RelicItem extends item {
    public final String type = "RELIC";

    public RelicItem() {
        super(-1, -1, 100);
        this.Name = "RELIC";
    }

    @Override
    public void updateQuality() {
        // not to nothing because that product have not to update
    }

}
