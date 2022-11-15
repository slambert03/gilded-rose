package com.gildedrose;

public class Shop {

    private ItemRepository itemRepository;
    public float balance=0;
    public Shop(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public item[] getItems() {
       return this.itemRepository.GetInventory();
    }

    public void update(){
        for (item item:this.itemRepository.GetInventory()
             ) {
            item.updateSellin();
            item.updateQuality();
        }
    }

    public item sellItem(String type, int quality){
       return this.itemRepository.FindItem(type, quality);
    }
}
