package com.gildedrose;

import java.io.*;

public class GildRose {

    public static void main(String[] args){
        Product product1=new Product(12,38);
        LegendaryProduct product2=new LegendaryProduct(12,38);

        ListProduct productsList=new ListProduct(product1,product2);
        productsList.updateQuality();
    }


}
