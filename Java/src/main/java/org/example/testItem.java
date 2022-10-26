package org.example;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class testItem{


    @Test
    public void createNewItemAndReturnHisValues(){
        Item product=new Item(40,40,"test");
        Assert.assertEquals(40,product.getQuality());
        Assert.assertEquals(40,product.getSellIn());
    }
    @Test
    public void createProductAndEndDay(){
        Item product=new Item(40,40, "test");
        product.endDay();
        Assert.assertEquals(39,product.getQuality());
        Assert.assertEquals(39,product.getSellIn());

    }
    @Test
    public void createProductsellIn0(){
        Item product=new Item(10,0,"test");
        product.endDay();
        product.endDay();
        Assert.assertEquals(6,product.getQuality());
        Assert.assertEquals(0,product.getSellIn());
    }

    @Test
    public void createProductQualityKeep0NotLess0(){
        Item product=new Item(2,0,"test");
        product.endDay();
        product.endDay();
        Assert.assertEquals(0,product.getQuality());
        Assert.assertEquals(0,product.getSellIn());
    }

    @Test
    public void createProductQualityKeep0NotLess0sellInDifferent0(){
        Item product=new Item(1,2,"test");
        product.endDay();
        product.endDay();
        Assert.assertEquals(0,product.getQuality());
        Assert.assertEquals(0,product.getSellIn());
    }


    @Test
    public void createProductIncreaseQualityNormal(){
        Item product=new Item(1,2,"test");
        product.increaseQuality(1);
        Assert.assertEquals(2,product.getQuality());
    }

    @Test
    public void createProductIncreaseQualitynotPastFifty(){
        Item product=new Item(50,2,"test");
        product.increaseQuality(1);
        Assert.assertEquals(50,product.getQuality());
    }




    @Test
    public void createAgedBrieincreaseQuality(){
        Item product=new Item(40,40, "Aged Brie");
        product.endDay();
        Assert.assertEquals(41,product.getQuality());
        Assert.assertEquals(39,product.getSellIn());
    }

    @Test
    public void createSulfurasNotLessQuality(){
        Item product=new Item(40,40, "Sulfuras");
        product.endDay();
        Assert.assertEquals(40,product.getQuality());
        Assert.assertEquals(-1,product.getSellIn());

    }

    @Test
    public void createBackStagePassesincreaseQuality2(){
        Item product=new Item(40,10, "Backstage passes");
        product.endDay();
        Assert.assertEquals(42,product.getQuality());
        Assert.assertEquals(9,product.getSellIn());
    }

    @Test
    public void createBackStagePassesincreaseQuality3(){
        Item product=new Item(40,5, "Backstage passes");
        product.endDay();
        Assert.assertEquals(43,product.getQuality());
        Assert.assertEquals(4,product.getSellIn());
    }

    @Test
    public void createBackStagePassesincreaseQuality1(){
        Item product=new Item(40,12, "Backstage passes");
        product.endDay();
        Assert.assertEquals(41,product.getQuality());
        Assert.assertEquals(11,product.getSellIn());
    }

    @Test
    public void createBackStagePassesincreaseQualitySellInPast(){
        Item product=new Item(40,0, "Backstage passes");
        product.endDay();
        Assert.assertEquals(0,product.getQuality());
        Assert.assertEquals(0,product.getSellIn());
    }

    @Test
    public void createConjuredLessen(){
        Item product=new Item(40,20, "Conjured");
        product.endDay();
        Assert.assertEquals(38,product.getQuality());
        Assert.assertEquals(19,product.getSellIn());
    }

}