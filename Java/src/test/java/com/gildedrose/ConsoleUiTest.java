package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleUiTest {


    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    Shop shop;
    ShopOutPutBoundary console;
    item[] items = {
        new LegendaryItem(80,50, 42),
        new GeneralItem(3,13, 7),
        new BackstagePassesItem(25,30, 17),
    };

    @BeforeEach
    void setup() {
        ItemRepository itemRepository = new InMemoryItemRepository();
        itemRepository.SaveInventory(items);
        shop = new Shop(itemRepository);
        System.setOut(new PrintStream(outputStreamCaptor));

        console = new ShopOutPutBoundary(shop);

    }

    @Test
    void givenSystemOutRedirection_whenInvokePrintln_thenOutputCaptorSuccess() {
        System.out.print("Hello Baeldung Readers!!");

        assertEquals("Hello Baeldung Readers!!", outputStreamCaptor.toString()
            .trim());
    }

    @Test
    void should_printAllArticles() {
       console.DisplayInventory();

        assertEquals("[LEGENDARY, 50 sellin & 80 quality for 42.0€], [GENERALITEM, 13 sellin & 3 quality for 7.0€], [BACKSTAGEPASSES, 30 sellin & 25 quality for 17.0€],", outputStreamCaptor.toString()
            .trim());
    }

    @Test
    void should_renderShopBalance(){
        console.DisplayBalance();

        assertEquals("66.0€", outputStreamCaptor.toString()
            .trim());

    }

    @Test
    void should_updateTheShopAndCheckForCorrectValueOnEveryArticles(){
        console.UpdateInventory();
        console.DisplayInventory();

        assertEquals("[LEGENDARY, 50 sellin & 80 quality for 42.0€], [GENERALITEM, 12 sellin & 2 quality for 7.0€], [BACKSTAGEPASSES, 29 sellin & 26 quality for 17.0€],", outputStreamCaptor.toString()
            .trim());
    }

    @Test
    void should_sellAnArticleThenRemoveTheArticleFromTheShop(){
        console.SellItem("LEGENDARY", 80);
        console.DisplayInventory();


        assertEquals("[GENERALITEM, 13 sellin & 3 quality for 7.0€], [BACKSTAGEPASSES, 30 sellin & 25 quality for 17.0€],", outputStreamCaptor.toString()
            .trim());

    }
}
