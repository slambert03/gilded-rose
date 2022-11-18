package org.example;

import java.util.Scanner;

public class SellAnArticleAction extends ActionsConsole {

    public SellAnArticleAction(Shop shop) {
        this.shop = shop;

    }

    public void action() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("vous avez choisi de vendre un article, veuillez écrire son type:");
        String type = scanner.nextLine();
        System.out.println("merci, veuillez maintenant entrer la quantité que vous souhaitez");
        String quantite = scanner.nextLine();
        int IntQuantite = Integer.parseInt(quantite);

        this.shop.sellItem(type, IntQuantite);
        System.out.println("l'article a bien été vendu en " + IntQuantite + " quantités");
    }
}
