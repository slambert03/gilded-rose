package org.example;

import org.example.Actions.*;
import org.example.Items.*;
import org.example.Shop.*;

public class Main {
    public static void main(String[] args) {
        item[] items = new item[] {
                new GeneralItem(1, 1, 2),
                new AgedBrieItem(1, 2, 6),
                new LegendaryItem(80, 3, 2),
                new BackstagePassesItem(9, 9, 6),
                new ConjuredItem(8, 8, 2)
        };

        InMemoryItemRepository itemRepository = new InMemoryItemRepository(items);
        itemRepository.SaveInventory(items);
        Shop shop = new Shop(itemRepository);

        new ConsoleUI(shop);

    }
}
