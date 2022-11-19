package com.gildedrose;
import com.gildedrose.Shop;

public class ShopOutPutBoundary {

    private Shop shop;

    public ShopOutPutBoundary(Shop shop){
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
        this.shop.sellItem(type, quality);
    }


}

