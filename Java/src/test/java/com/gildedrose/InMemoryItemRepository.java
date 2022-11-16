package com.gildedrose;

import java.util.ArrayList;

public class InMemoryItemRepository implements ItemRepository {

    private ArrayList<item> listeItems = new ArrayList<>();

    @Override
    public item[] GetInventory() {
        Object[] obj = listeItems.toArray();
        item[] obj_item = new item[obj.length];
        for(int i=0; i < obj_item.length; i++)
            obj_item[i]=(item) obj[i];
        return obj_item;
    }

    @Override
    public void SaveInventory(item[] items) {
       for (item item:items){
           listeItems.add(item);
       }
    }

    @Override
    public item FindItem(String type, int quality) {

        for (item item:listeItems){
            if (item.getType() == type && item.getQuality() == quality) {
                listeItems.remove(item);
                return item;
            }
        }
        return null;
    }
}
