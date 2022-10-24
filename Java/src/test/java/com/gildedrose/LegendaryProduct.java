public class LegendaryProduct extends Product{


    public LegendaryProduct(int quality,int sellIn){
        super(sellIn, quality);
    }

    public IncreaseQuality(int newQuality){
        if ((this.quality+newQuality)<=80){
            this.quality+=newQuality;
        }
    }

    public EndDay(){
        // no do anything because the values are not changes
    }
    
}