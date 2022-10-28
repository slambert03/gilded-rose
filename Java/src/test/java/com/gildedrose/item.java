package com.gildedrose;

public abstract class item {

    protected int quality;
    protected int sellin;
    protected double base_price;

    public item(int quality, int sellin, double base_price){
        this.quality = quality;
        this.sellin = sellin;
        this.base_price = base_price;
    }

    public int getSellin() {
        return this.sellin;
    }

    public int getQuality() {
        return this.quality;
    }

    public double getValue() {
        return this.base_price;
    }

    public abstract void updateQuality();

    public void updateSellin(){
        this.sellin--;
        floorSellin();
    };

    public void ceilingQuality() {
        if (this.quality >= 50)
            this.quality = 50;
    }

    void floorQuality() {
        if (this.quality <= 0)
            this.quality = 0;
    }

    void isSellinEqualZero() {
        if (this.sellin <= 0)
            this.quality--;
    }



    void floorSellin() {
        if (this.sellin <= 0)
            this.sellin = 0;
    }
}
