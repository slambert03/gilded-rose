package com.gildedrose;
import com.gildedrose.Shop;

public class ConsoleUI {

    private Shop shop;

    public ConsoleUI(Shop shop){
        this.shop = shop;
    }

    public void DisplayInventory(){
        this.shop.toStringItems();
    }

    public void DisplayBalance(){
        System.out.print(this.shop.getBalance() + "€");
    }

    public void UpdateInventory(){
        this.shop.update();
    }

    public void SellItem(String type, int quality){

    }


}

