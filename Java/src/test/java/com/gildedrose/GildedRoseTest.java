package com.gildedrose;

import org.example.Shop.*;
import org.example.Items.*;
import org.example.Actions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GildedRoseTest {
    Shop shop;
    item[] items = {
            new GeneralItem(1, 1, 2),
            new GeneralItem(2, 0, 3),
            new GeneralItem(0, 0, 4),
            new AgedBrieItem(1, 2, 6),
            new AgedBrieItem(50, 2, 9),
            new LegendaryItem(80, 3, 2),
            new BackstagePassesItem(9, 9, 6),
            new BackstagePassesItem(5, 5, 4),
            new BackstagePassesItem(9, 1, 3),
            new GeneralItem(9, 1, 10),
            new LegendaryItem(9, 1, 40),
            new ConjuredItem(8, 8, 2),
            new RelicItem(),
    };

    @BeforeEach
    void setup() {
        InMemoryItemRepository itemRepository = new InMemoryItemRepository(this.items);
        itemRepository.SaveInventory(items);
        shop = new Shop(itemRepository);
        new ActionsConsole();
    }

    @Test
    void should_build() {
        assertEquals(shop.getClass(), Shop.class);
    }

    @Test
    void should_haveSellinAndQuality() {
        assertEquals(shop.getItems()[0].getSellin(), 1);
        assertEquals(shop.getItems()[0].getQuality(), 1);
    }

    @Test
    void should_decreaseSellinAndQuality() {
        shop.update();
        assertEquals(shop.getItems()[0].getSellin(), 0);
        assertEquals(shop.getItems()[0].getQuality(), 0);
    }

    @Test
    void should_decreaseQualityTwoTimesFasterWhenSellinEqualZero() {
        shop.update();
        assertEquals(shop.getItems()[1].getSellin(), 0);
        assertEquals(shop.getItems()[1].getQuality(), 0);
    }

    @Test
    void should_QualityCanNotBeNegative() {
        shop.update();
        assertEquals(shop.getItems()[2].getQuality(), 0);
    }

    @Test
    void should_agedBrieObjectIncreaseQuality() {
        shop.update();
        assertEquals(shop.getItems()[3].getQuality(), 2);
    }

    @Test
    void should_anyObjectQualityCantGoOverFifty() {
        shop.update();
        assertEquals(shop.getItems()[4].getQuality(), 50);
    }

    @Test
    void should_legendaryItemHaveSameSellinAndSameQuality() {
        shop.update();
        assertEquals(shop.getItems()[5].getSellin(), 3);
        assertEquals(shop.getItems()[5].getQuality(), 80);
    }

    @Test
    void should_backstagePassesIncreaseQualityBytwoWhenSellinIsLowerThanTen() {
        shop.update();
        assertEquals(shop.getItems()[6].getSellin(), 8);
        assertEquals(shop.getItems()[6].getQuality(), 11);
    }

    @Test
    void should_backstagePassesIncreaseQualityByThreeWhenSellinIsLowerThanFive() {
        shop.update();
        assertEquals(shop.getItems()[7].getSellin(), 4);
        assertEquals(shop.getItems()[7].getQuality(), 8);
    }

    @Test
    void should_backstagePassesSetQualityToZeroWhenSellinEqualZero() {
        shop.update();
        assertEquals(shop.getItems()[8].getSellin(), 0);
        assertEquals(shop.getItems()[8].getQuality(), 0);
    }

    @Test
    void should_saveListeOfItemInMemory() {
        InMemoryItemRepository itemRepository = new InMemoryItemRepository(this.items);
        itemRepository.SaveInventory(items);
        assertEquals(itemRepository.GetInventory(), items);
    }

    @Test
    void should_itemHaveAPrice() {
        assertEquals(shop.getItems()[9].getValue(), 10);
    }

    @Test
    void should_returnASpecificItem() {

        assertEquals(shop.getItems()[10], shop.sellItem("LEGENDARY", 9));
    }

    @Test
    void should_conjuredItemHaveQualityDecreaseTwoTimesFaster() {
        shop.update();
        assertEquals(shop.getItems()[11].getQuality(), 6);
        assertEquals(shop.getItems()[11].getSellin(), 7);
    }

    @Test
    void should_createAuctionHouse() {
        ActionsConsole action = new ActionsConsole().getAction("5", shop);
        assert (action instanceof AuctionHouse);
    }

    @Test
    void should_createEndOfDay() {
        ActionsConsole action = new ActionsConsole().getAction("4", shop);
        assert (action instanceof EndOfDayAction);
    }

    @Test
    void should_createSeeAllArticles() {
        ActionsConsole action = new ActionsConsole().getAction("3", shop);
        assert (action instanceof SeeAllArticlesAction);
    }

    @Test
    void should_createSellAnArticle() {
        ActionsConsole action = new ActionsConsole().getAction("2", shop);
        assert (action instanceof SellAnArticleAction);
    }

    @Test
    void should_createActionDisplayBalanceShop() {
        ActionsConsole action = new ActionsConsole().getAction("1", shop);
        assert (action instanceof DisplayBalanceAction);
    }

    @Test
    void should_RelicItemDoesntUpdate() {
        assertEquals(shop.balance, 0);
        shop.update();
        assertEquals(shop.balance, 100);
    }

    @Test
    void should_createNewShopBalanceZero() {
        DisplayBalanceAction action = new DisplayBalanceAction(shop);
        assertEquals(action.getBalance(), 0);
    }

    @Test
    void should_createAuctionBuyerAndAddAnArticleToPay() {
        BuyerAuction buyer = new BuyerAuction("Simon");
        buyer.AddAnAuctionItemToPay(new AuctionItem(new GeneralItem(10, 10, 10)));
        assertEquals(buyer.getBalanceToPay(), 10);
    }

    @Test
    void should_FindAProductInMemoryItemInventory() {
        GeneralItem ItemToTest = new GeneralItem(1, 1, 2);
        InMemoryItemRepository memoryToItem = new InMemoryItemRepository(items);
        assertEquals(memoryToItem.FindItem(ItemToTest.getName(), ItemToTest.getQuality()).toString(),
                ItemToTest.toString());

    }

    @Test
    void should_NotFindAProductNotInMemoryItemInventory() {
        GeneralItem ItemToTest = new GeneralItem(12, 12, 22);
        InMemoryItemRepository memoryToItem = new InMemoryItemRepository(items);
        assertNull(memoryToItem.FindItem(ItemToTest.getName(), ItemToTest.getQuality()));

    }
    @Test
    void should_ReturnListOfItemInShop() {
        assertEquals(shop.getItems(), items);
    }

    @Test
    void should_returnAuctionPrice(){
        GeneralItem ItemToTest=new GeneralItem(12,12,12);
        InMemoryItemRepository memoryToItem = new InMemoryItemRepository(items);
        AuctionItem auctionItem=new AuctionItem(ItemToTest);
        assertEquals(auctionItem.getAuctionPrice(),12);
    }

    @Test
    void should_outbidAnArticleOutBidOneTime(){
        GeneralItem ItemToTest=new GeneralItem(12,12,12);
        InMemoryItemRepository memoryToItem = new InMemoryItemRepository(items);
        AuctionItem auctionItem=new AuctionItem(ItemToTest);
        assertEquals(auctionItem.getAuctionPrice(),12);
        auctionItem.outbid();
        assertEquals(auctionItem.getAuctionPrice(),12*1.1);


    }

    @Test
    void should_createARelicITemHaveNotToUpdate(){
        RelicItem relicItem=new RelicItem();
        int oldQuality=relicItem.getQuality();
        int oldSellin=relicItem.getSellin();
        assertEquals(relicItem.getQuality(),-1);
        assertEquals(relicItem.getSellin(),-1);
        relicItem.updateQuality();
        assertEquals(relicItem.getQuality(),oldQuality);
        assertEquals(relicItem.getSellin(),oldSellin);

    }

    @Test
    void should_outbidAnArticleOutBidFourTimes(){
        GeneralItem ItemToTest=new GeneralItem(12,12,12);
        InMemoryItemRepository memoryToItem = new InMemoryItemRepository(items);
        AuctionItem auctionItem=new AuctionItem(ItemToTest);
        assertEquals(auctionItem.getAuctionPrice(),12);
        auctionItem.outbid();
        auctionItem.outbid();
        auctionItem.outbid();
        auctionItem.outbid();
        assertEquals(auctionItem.getAuctionPrice(),12*1.1*1.1*1.1);


    }
}
