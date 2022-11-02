package com.gildedrose;
import com.gildedrose.Shop;
import com.gildedrose.item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    Shop shop;
    item[] items = {
        new GeneralItem(1,1, 2),
        new GeneralItem(2,0, 3),
        new GeneralItem(0,0, 4),
        new AgedBrieItem(1,2, 6),
        new AgedBrieItem(50,2, 9),
        new LegendaryItem(80,3, 2),
        new BackstagePassesItem(9,9, 6),
        new BackstagePassesItem(5,5, 4),
        new BackstagePassesItem(9,1, 3),
        new GeneralItem(9,1, 10),
        new LegendaryItem(9,1, 40),
        new ConjuredItem(8,8, 2),
    };

    @BeforeEach
    void setup() {
        ItemRepository itemRepository = new InMemoryItemRepository();
        itemRepository.SaveInventory(items);
        shop = new Shop(itemRepository);
    }

    @Test
    void should_build() {
        assertEquals(shop.getClass(), Shop.class);
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

    @Test
    void should_decreaseQualityTwoTimesFasterWhenSellinEqualZero(){
        shop.update();
        assertEquals(shop.getItems()[1].getSellin(), 0);
        assertEquals(shop.getItems()[1].getQuality(), 0);
    }

    @Test
    void should_QualityCanNotBeNegative(){
        shop.update();
        assertEquals(shop.getItems()[2].getQuality(), 0);
    }

    @Test
    void should_agedBrieObjectIncreaseQuality(){
        shop.update();
        assertEquals(shop.getItems()[3].getQuality(), 2);
    }

    @Test
    void should_anyObjectQualityCantGoOverFifty(){
        shop.update();
        assertEquals(shop.getItems()[4].getQuality(), 50);
    }

    @Test
    void should_legendaryItemHaveSameSellinAndSameQuality(){
        shop.update();
        assertEquals(shop.getItems()[5].getSellin(), 3);
        assertEquals(shop.getItems()[5].getQuality(), 80);
    }

    @Test
    void should_backstagePassesIncreaseQualityBytwoWhenSellinIsLowerThanTen(){
        shop.update();
        assertEquals(shop.getItems()[6].getSellin(), 8);
        assertEquals(shop.getItems()[6].getQuality(), 11);
    }

    @Test
    void should_backstagePassesIncreaseQualityByThreeWhenSellinIsLowerThanFive(){
        shop.update();
        assertEquals(shop.getItems()[7].getSellin(), 4);
        assertEquals(shop.getItems()[7].getQuality(), 8);
    }

    @Test
    void should_backstagePassesSetQualityToZeroWhenSellinEqualZero(){
        shop.update();
        assertEquals(shop.getItems()[8].getSellin(), 0);
        assertEquals(shop.getItems()[8].getQuality(), 0);
    }

    @Test
    void should_saveListeOfItemInMemory(){
       ItemRepository itemRepository = new InMemoryItemRepository();
       itemRepository.SaveInventory(items);
       assertEquals(itemRepository.GetInventory(), items);
    }

    @Test
    void should_itemHaveAPrice(){
        assertEquals(shop.getItems()[9].getValue(), 10);
    }

    @Test
    void should_returnASpecificItem(){
       assertEquals(shop.getItems()[10], shop.findItem("LEGENDARY",9));
    }

    @Test
    void should_conjuredItemHaveQualityDecreaseTwoTimesFaster(){
        shop.update();
        assertEquals(shop.getItems()[11].getQuality(), 6);
        assertEquals(shop.getItems()[11].getSellin(), 7);
    }

    }
