package org.example.Shop;

import org.example.Items.*;

public class Shop {

    private InMemoryItemRepository itemRepository;
    public float balance = 0;

    public Shop(InMemoryItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public item[] getItems() {
        return this.itemRepository.GetInventory();
    }

    public void update() {
        for (item item : this.itemRepository.GetInventory()) {
            if (item instanceof RelicItem) {
                this.balance += 100;
            } else {
                item.updateSellin();
                item.updateQuality();
            }
        }
    }

    public item sellItem(String type, int quality) {

        return this.itemRepository.FindItem(type, quality);
    }

    public String toString() {
        String sentence = "";
        for (item itemInItemRepository : this.itemRepository.GetInventory()) {

            sentence += itemInItemRepository.toString();
        }
        return sentence;
    }

}
