package com.gildedrose;

import java.io.*;

public class ListProduct{
    private Product[] listProducts;

    public ListProduct(Product[] ProductsList){
        this.listProducts=ProductsList;
    }

    public void updateQuality(){
        for (int productCounter = 0; productCounter < this.listProducts.length; productCounter++) {
            this.listProducts[productCounter].EndDay();
        }
    }



}
