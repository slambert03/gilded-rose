public class AgedBrie {

    private Product implementProduct;

    public AgedBrie (Product implementProduct){
        this.implementProduct=implementProduct;
    }

    public void increaseQualityProduct(){
        if (this.implementProduct.getSellIn()<=5){this.implementProduct.IncreaseQuality(3);}
        else if (this.implementProduct.getSellIn()<=10){this.implementProduct.IncreaseQuality(2);}
        else if (this.implementProduct.getSellIn()==0){this.implementProduct.IncreaseQuality(-1*this.implementProduct.getQuality());}
        else {this.implementProduct.IncreaseQuality(1);}
    }

}