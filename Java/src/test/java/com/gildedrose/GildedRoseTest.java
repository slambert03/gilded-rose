package com.gildedrose;
import com.gildedrose.Shop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    Shop shop;

    @BeforeEach
    void setup() {
        shop = new Shop();
    }

    @Test
    void should_build() {
        assertEquals(shop.getClass(), Shop.class);
    }

    @Test
    void should_create_item(){
        shop.createItem();
    }
}
