package org.example.Shop;

import org.example.Items.*;

interface ItemRepository {
    public item[] GetInventory();

    public void SaveInventory(item[] items);

    public item FindItem(String type, int quality);

}
