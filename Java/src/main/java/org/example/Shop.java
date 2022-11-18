package org.example;

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

    public String toString(){
        String sentence="";
        for (item itemInItemRepository:this.itemRepository.GetInventory()){
            sentence+=itemInItemRepository.toString2();
        }
        return sentence;
    }

}
