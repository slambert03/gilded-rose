package com.gildedrose;

public class EndOfDayAction extends ActionsConsole{
    public EndOfDayAction(Shop shop) {
        super();
    }

    public void action(){
        item[] allItems=this.shop.getItems();
        item actualitem;
        for (int indice=0;indice<allItems.length;indice++){
            actualitem=allItems[indice];
            actualitem.updateQuality();
            actualitem.updateSellin();
        }

        System.out.println("tous les items ont bien été mis à jour");
    }
}
