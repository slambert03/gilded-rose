package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class AuctionHouse extends ActionsConsole {
    private Shop shop;
    private ArrayList<BuyerAuction> buyers = new ArrayList<>();

    public AuctionHouse(Shop shop) {
        this.shop = shop;
    }

    public void searchAllBuyers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qui est le premier acheteur? Veuillez entrer son nom");
        String nextBuyerName = scanner.nextLine();

        while (nextBuyerName != "") {
            this.buyers.add(new BuyerAuction(nextBuyerName));
            System.out.println("Quel est le nom du prochain acheteur");
            nextBuyerName = scanner.nextLine();
        }
    }

    public void launchAuctionsByArticle(item item) {
        AuctionItem auctionItem = new AuctionItem(item);

        Scanner scanner = new Scanner(System.in);
        displayAllBuyers();
        System.out.println("Pour ce nouvel article, le prix est fixé à " + auctionItem.getAuctionPrice()
                + " unités, qui souhaite se prononcer?, si personne ne veut se prononcer merci d'écrire -1");

        int counterNumberAuctions = 0;
        String BuyerNumberString = "";
        int BuyerNumberInt;
        BuyerAuction buyerFinal = null;
        while (counterNumberAuctions <= 3) {
            BuyerNumberString = scanner.nextLine();
            BuyerNumberInt = Integer.parseInt(BuyerNumberString);
            if (BuyerNumberInt == -1) {
                break;
            } else {
                auctionItem.outbid();
                buyerFinal = buyers.get(BuyerNumberInt);
                counterNumberAuctions += 1;
            }
            System.out.println("veuillez entrer le numéro de la prochaine personne qui souhaite enchérir (entre 0 et "
                    + ((this.buyers.size()) - 1) + "), son prix est maintenant " + auctionItem.getAuctionPrice());
        }
        if (buyerFinal != null) {
            buyerFinal.AddAnAuctionItemToPay(auctionItem);
            shop.sellItem(item.getType(), item.getQuality());
        }

        System.out
                .println("Merci pour la vente de l'article " + item.getType() + " à l'acheteur " + buyerFinal.getName()
                        + " le solde qu'il doit payer est désormais " + buyerFinal.getBalanceToPay() + " unités");
        System.out.println("___________________________________________");

    }

    public void action() {
        searchAllBuyers();
        for (item itemToSell : this.shop.getItems()) {
            launchAuctionsByArticle(itemToSell);
        }
        System.out.println("Cette session d'enchères est terminée");
    }

    public void displayAllBuyers() {
        int buyersNumbers = this.buyers.size();

        for (int indice = 0; indice < buyersNumbers; indice++) {
            System.out.println("acheteur " + indice + " => nom: " + this.buyers.get(indice).getName());
        }
    }

}
