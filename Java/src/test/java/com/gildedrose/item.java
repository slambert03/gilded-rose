package com.gildedrose;

public abstract class item {

    protected int quality;
    protected int sellin;

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
