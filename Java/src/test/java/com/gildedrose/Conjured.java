public class Conjured extends Product{
    public Conjured(int sellIn, int quality){
        this.sellIn=sellIn;
        this.quality=quality;
    }

    public void EndDay(){
        if (this.sellIn==0){
            this.quality=this.sellIn=0;
        }
        else {
            if (this.quality-2>=0){
                this.quality-=2;
                this.sellIn-=1;
            }
            else {
                this.quality=0;
                this.sellIn--;
            }
        }
    }

    public String toString(){
        return "le produit Conjured a un nombre de jours avant péremption de "+this.sellIn+" et une qualité de "+this.quality;
    }
}
