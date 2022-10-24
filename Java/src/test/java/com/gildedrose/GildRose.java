package com.gildedrose;

import java.io.*;

public class GildRose {
    Product[] products;

    public GildRose(Product[] products){
        this.products = products;
    }
    public void main(String[] args){
        updateQuality();
    }

    public void updateQuality(){
        for (int productCounter = 0; productCounter < this.products.length; productCounter++) {
           this.products[productCounter].EndDay();
        }
    }
}
