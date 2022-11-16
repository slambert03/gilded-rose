package com.gildedrose;

public class Shop {

    private ItemRepository itemRepository;

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

    public void toStringItems() {
        for (item item:this.itemRepository.GetInventory()){
            System.out.print("["+ item.toString() + "], ");
        }
    }

    public double getBalance() {
        double balance = 0;
        for (item item:this.itemRepository.GetInventory()){
            balance += item.base_price;
        }
        return balance;
    }
}
