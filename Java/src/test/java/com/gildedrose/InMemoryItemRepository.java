package com.gildedrose;

public class InMemoryItemRepository implements ItemRepository {

    protected item[] listeItems;

    @Override
    public item[] GetInventory() {
        return listeItems;
    }

    @Override
    public void SaveInventory(item[] items) {
       this.listeItems = items;
    }

    @Override
    public item FindItem(String type, int quality) {
        for (item item:listeItems){
            if (item.getType() == type && item.getQuality() == quality) {
                return item;
            }
        }
        return null;
    }
}
