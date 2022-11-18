package org.example;

public class InMemoryItemRepository implements ItemRepository {

    protected item[] listeItems;

    public InMemoryItemRepository(item[] listeItems){
        this.listeItems=listeItems;
    }
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

    public String toString(){
        String sentence="";
        for(item item:this.listeItems) {
            sentence+=item.toString2();
        }
        return sentence;
    }
}
