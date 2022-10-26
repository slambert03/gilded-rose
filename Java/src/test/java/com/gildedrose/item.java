package com.gildedrose;

public class item {

    private int quality;
    private int sellin;

    public item(int quality, int sellin){
        this.quality = quality;
        this.sellin = sellin;
    }

    public int getSellin() {
        return sellin;
    }

    public int getQuality() {
        return quality;
    }
}
