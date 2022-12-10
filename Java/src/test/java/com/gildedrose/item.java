package com.gildedrose;

public abstract class item {

    protected int quality;
    protected int sellin;
    protected double base_price;
    protected int attack;
    protected int defense;

    public item(int quality, int sellin, double base_price, int attack, int defense) {
        this.quality = quality;
        this.sellin = sellin;
        this.base_price = base_price;
        this.attack = attack;
        this.defense = defense;
    }


    public item(int quality, int sellin, double base_price){
        this.quality = quality;
        this.sellin = sellin;
        this.base_price = base_price;
        this.attack = 0;
        this.defense = 0;
    }

    public int getSellin() {
        return this.sellin;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getQuality() {
        return this.quality;
    }

    public double getValue() {
        return this.base_price;
    }

    public abstract void updateQuality();

    public abstract String getType();

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

    @Override
    public String toString() {
        return this.getType() + ", " + this.sellin + " sellin & " + this.quality + " quality for " + this.base_price + "€";
    }
}
