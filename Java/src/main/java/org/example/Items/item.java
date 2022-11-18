package org.example.Items;

public abstract class item {

    protected int quality;
    protected int sellin;
    protected double base_price;
    protected String Name;

    protected int attack = 0;
    protected int defense = 0;

    public item(int quality, int sellin, double base_price) {
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

    public void updateAttack() {
        this.attack += 1;
    }

    public int getAttack() {
        return this.attack;
    }

    public void updateDefense() {
        this.defense += 1;
    }

    public int getDefense() {
        return this.defense;
    }

    public double getValue() {
        return this.base_price;
    }

    public abstract void updateQuality();

    public String getName() {
        return this.Name;
    }

    public void updateSellin() {
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

    public String toString() {
        return "produit de type " + this.getName() + " de qualité " + this.quality + " et " + this.sellin
                + " jours avant fin de vie du produit";
    }
}
