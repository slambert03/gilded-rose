package com.gildedrose;

public class Shop {

    private item[] listeItems;

    public Shop(ItemRepository itemRepository){
        this.listeItems = itemRepository.GetInventory();
    }

    public item[] getItems() {
       return this.listeItems;
    }

    public void update(){
        for (item item:listeItems
             ) {
            item.updateSellin();
            item.updateQuality();
        }
    }

    item findItem(String type, int quality){
        for (item item:listeItems){
                if (item.getType() == type && item.getQuality() == quality) {
                    return item;
                }
           }
        return null;
    }
}
