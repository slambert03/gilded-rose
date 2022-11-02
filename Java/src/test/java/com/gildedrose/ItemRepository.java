package com.gildedrose;

interface ItemRepository {
    public item[] GetInventory();
    public void SaveInventory(item[] items);
    public item FindItem(String type, int quality);

}
