package org.example.Shop;

import org.example.Items.*;

public class InMemoryItemRepository implements ItemRepository {

    protected item[] listeItems;

    public InMemoryItemRepository(item[] listeItems) {
        this.listeItems = listeItems;
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
        for (item item : listeItems) {
            if (item.getName() == type && item.getQuality() == quality) {
                System.out.println(item.toString());
                return item;
            }
        }
        return null;
    }

    public String toString() {
        String sentence = "";
        for (item item : this.listeItems) {
            sentence += item.toString();
        }
        return sentence;
    }
}
