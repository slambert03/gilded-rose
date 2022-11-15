package com.gildedrose;

import com.spun.util.parser.VelocityList;

import java.util.Scanner;

public class ConsoleUI {
    public ConsoleUI(Shop shop){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Si vous souhaitez voir le solde du magasin, tapez 1");
        System.out.println("Si vous souhaitez vendre un article, tapez 2");
        System.out.println("Si vous souhaitez voir les articles en stock, tapez 3");
        System.out.println("Si vous souhaitez mettre à jour tous les articles, tapez 4");
        String toDo=scanner.nextLine();
        new ActionsConsole().getAction(toDo,shop).action();// create a new shop before get in old shop in the main class
    }


}
