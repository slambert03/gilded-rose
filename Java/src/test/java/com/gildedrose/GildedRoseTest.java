package com.gildedrose;
import com.gildedrose.Shop;
import com.gildedrose.item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    Shop shop;
    item[] items = {new item(1,1)};

    @BeforeEach
    void setup() {
        shop = new Shop(items);
    }

    @Test
    void should_build() {
        assertEquals(shop.getClass(), Shop.class);
    }

    @Test
    void should_haveItems(){
        assertEquals(shop.getItems().length, 1);
    }

    @Test
    void should_haveSellinAndQuality(){
        assertEquals(shop.getItems()[0].getSellin(), 1);
        assertEquals(shop.getItems()[0].getQuality(), 1);
    }

    @Test
    void should_decreaseSellinAndQuality(){
        shop.update();
        assertEquals(shop.getItems()[0].getSellin(), 0);
        assertEquals(shop.getItems()[0].getQuality(), 0);
    }

}
