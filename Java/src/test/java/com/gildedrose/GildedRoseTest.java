package com.gildedrose;
import com.gildedrose.Shop;
import com.gildedrose.item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        new LegendaryItem(9,1, 40, 2, 5),
        new GeneralItem(0,0, 4, 1, 2),
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
    void should_itemHaveAPrice(){
        assertEquals(shop.getItems()[9].getValue(), 10);
    }

    @Test
    void should_returnASpecificItem(){
       assertEquals(shop.getItems()[10], shop.sellItem("LEGENDARY",9));
    }

    @Test
    void should_conjuredItemHaveQualityDecreaseTwoTimesFaster(){
        shop.update();
        assertEquals(shop.getItems()[11].getQuality(), 6);
        assertEquals(shop.getItems()[11].getSellin(), 7);
    }

    @Test
    void should_CreateEnchereThenTheThirdWinAndThePriceShouldIncrease30Pourcent(){
        Enchere enchere = new Enchere(shop.getItems()[11], shop);
        enchere.newEnchere();
        enchere.newEnchere();
        enchere.newEnchere();

        assertEquals(enchere.getPrice(), 2.6620000000000004);
    }

    @Test
    void should_legendaryAndGeneralItemHaveAttackAttribute(){
        assertEquals(shop.getItems()[12].getAttack(), 2);
        assertEquals(shop.getItems()[12].getDefense(), 5);


        assertEquals(shop.getItems()[13].getAttack(), 1);
        assertEquals(shop.getItems()[13].getDefense(), 2);
    }




    }

