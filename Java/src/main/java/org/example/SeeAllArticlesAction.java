package org.example;

public class SeeAllArticlesAction extends ActionsConsole{
    public SeeAllArticlesAction(Shop shop) {
        super();
    }

    public void action(){
        item[] allItems=this.shop.getItems();
        item actualitem;
        for (int indice=0;indice<allItems.length;indice++){
            actualitem=allItems[indice];
            System.out.println(actualitem.toString());
        }
    }
}
