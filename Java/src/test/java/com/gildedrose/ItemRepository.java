package com.gildedrose;

interface ItemRepository {
    public item[] GetInventory();
    public void SaveInventory(item[] items);

}
