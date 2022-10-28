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
}
