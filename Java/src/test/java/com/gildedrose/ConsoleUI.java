package com.gildedrose;
import com.gildedrose.Shop;

public class ConsoleUI {

    private Shop shop;
    private item[] inventory;
    private double balance;

    public ConsoleUI(Shop shop, double balance){
        this.shop = shop;
        this.balance = 100;
    }

    public void DisplayInventory(){
        System.out.println("Votre inventory : ");
        System.out.println(this.inventory);
    }

    public void DisplayBalance(){
        System.out.println("Vous avez "+ this.balance + " €");
    }

    public void UpdateInventory(){
        this.shop.update();

        System.out.println("Inventory updated");
    }

    public void SellItem(String type, int quality){
        item sellItem = shop.sellItem(type, quality);
        if (sellItem.base_price < this.balance){
            this.balance -= sellItem.base_price;
            this.inventory[this.inventory.length] = sellItem;
        }
    }

    public static void main(String[] args) {

        Shop shop;
        item[] items = {
            new GeneralItem(1,1, 2),
            new GeneralItem(2,0, 3),
            new GeneralItem(0,0, 4),
            new AgedBrieItem(1,2, 6),
            new AgedBrieItem(50,2, 9),
            new LegendaryItem(80,3, 2),
            new BackstagePassesItem(9,9, 6),
            new BackstagePassesItem(5,5, 4),
            new BackstagePassesItem(9,1, 3),
            new GeneralItem(9,1, 10),
            new LegendaryItem(9,1, 40),
            new ConjuredItem(8,8, 2),
        };

        ItemRepository itemRepository = new InMemoryItemRepository();
        itemRepository.SaveInventory(items);
        shop = new Shop(itemRepository);
       ConsoleUI console = new ConsoleUI(shop, 100);
       console.DisplayBalance();
       console.SellItem("LEGENDARY", 9);
       console.DisplayInventory();
       console.DisplayBalance();

    }
}

