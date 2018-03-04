/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DomeinController;
import java.util.Scanner;

/**
 *
 * @author jasperdesmet
 */
public class main {

    public static void main(String[] args) {
        DomeinController domeinController = new DomeinController();
        Scanner input = new Scanner(System.in);
        int plaats;
        int aantalSpelers, aantalStamleden;
        String[] namen;

        System.out.printf("Welkom bij stenen tijdperk. "
                + "%nWat wil je doen:%n"
                + "1. Nieuw spel starten%n"
                + "2. Spel hervaten%n"
                + "3. Highscores bekijken%n"
                + "Typ je keuze: ");
        switch (input.nextInt()) {
            case 1:
                System.out.print("Met hoeveel wil je spelen: ");
                aantalSpelers = input.nextInt();
                namen = new String[aantalSpelers];
                for (int i = 0; i < aantalSpelers; i++) {
                    System.out.printf("Geef naam van speler %d: ", i + 1);
                    namen[i] = input.next();
                }
                domeinController.startSpel(aantalSpelers, namen);
                System.out.println(domeinController.geefSpelbord());

                while (!domeinController.alleStamledenGeplaatst()) {
                    System.out.println(domeinController.geefSpelerAanZet());
                    System.out.println(domeinController.geefInfoBeschikbarePlaatsen());
                    /*do {
                        System.out.print("Waar wil je je stamleden plaatsen (typ \"?\" voor beschikbare plaatsen): ");
                        plaats = plaatsCode(input.next());
                        if ("?".equals(plaats)) {
                            System.out.println(domeinController.geefInfoBeschikbarePlaatsen());
                        }
                    } while ("?".equals(plaats));*/
                    do  {
                        System.out.print("Waar wil je je stamleden plaatsen: ");
                        plaats = plaatsCode(input.next());
                        System.out.print("Hoeveel stamleden wil je plaatsen: ");
                        aantalStamleden = input.nextInt();
                    }while(!domeinController.plaatsIsValid(plaats, aantalStamleden));
                    domeinController.plaatsStamleden(plaats, aantalStamleden);
                }
            default:
                System.out.println("Dit is geen geldige input");
                break;
        }

    }

    public static int plaatsCode(String plaats) {
        switch (plaats.toLowerCase()) {
            case "akker":
                return 0;
            case "hut":
                return 1;
            case "jacht":
                return 2;
            case "gereedschapsmaker":
                return 3;
            case "bos":
                return 4;
            case "leemgroeve":
                return 5;
            case "steengroeve":
                return 6;
            case "rivier":
                return 7;
        }
        return 9;
    }
}
