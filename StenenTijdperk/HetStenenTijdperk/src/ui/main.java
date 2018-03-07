/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DomeinController;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author jasperdesmet
 */
public class main {

    public static DomeinController domeinController = new DomeinController();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int aantalSpelers;
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
                while (!(aantalSpelers > 1 && aantalSpelers < 5)) {
                    System.out.print("Geef een aantal spelers tussen 2 en 4: ");
                    aantalSpelers = input.nextInt();
                }

                namen = new String[aantalSpelers];
                for (int i = 0; i < aantalSpelers; i++) {
                    System.out.printf("Geef naam van speler %d: ", i + 1);
                    namen[i] = input.next();
                }
                domeinController.startSpel(aantalSpelers, namen);
                System.out.println(domeinController.geefSpelbord());

                System.out.println("druk op enter om te beginnen");
                System.in.read();

                plaatsStamleden();

                System.out.println("Iteratie 1 compleet");
                break;
            default:
                System.out.println("Dit is geen geldige input");
                break;
        }

    }

    public static void plaatsStamleden() {
        boolean loop = false;
        int infoPlaats[] = {0, 0}, aantalStamleden = 0;
        while (!domeinController.alleStamledenGeplaatst()) {
            if (!domeinController.alleStamledenGeplaatstSpelerAanZet()) {
                System.out.println(domeinController.geefSpelerAanZet());
                System.out.println(domeinController.geefInfoBeschikbarePlaatsen());
                do {
                    try {
                        infoPlaats = plaatsArray();
                        loop = domeinController.plaatsIsValid(infoPlaats[0], infoPlaats[1]);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } while (!loop);
                loop = false;
                domeinController.plaatsStamleden(infoPlaats[0], infoPlaats[1]);
            }
            domeinController.volgendeSpeler();
        }
    }

    public static int[] plaatsArray() {
        int[] A;
        System.out.print("Waar wil je je stamleden plaatsen: ");
        String plaats = input.next();
        
        switch (plaats.toLowerCase()) {
            case "akker":
                return new int[]{0, 1};
            case "hut":
                return A = new int[]{1, 2};
            case "gereedschapsmaker":
                return A = new int[]{3, 1};
            case "hutkaart":
                System.out.print("Op welke stapel wil je je hutkaar leggen: ");
                switch (input.next()) {
                    case "1":
                        return A = new int[]{8, 1};
                    case "2":
                        return A = new int[]{9, 1};
                    case "3":
                        return A = new int[]{10, 1};
                    case "4":
                        return A = new int[]{11, 1};
                }
            default:
                switch (plaats.toLowerCase()) {
                    case "jacht":
                        System.out.print("Hoeveel stamleden wil je plaatsen: ");
                        return A = new int[]{2, input.nextInt()};
                    case "bos":
                        System.out.print("Hoeveel stamleden wil je plaatsen: ");
                        return A = new int[]{4, input.nextInt()};
                    case "leemgroeve":
                        System.out.print("Hoeveel stamleden wil je plaatsen: ");
                        return A = new int[]{5, input.nextInt()};
                    case "steengroeve":
                        System.out.print("Hoeveel stamleden wil je plaatsen: ");
                        return A = new int[]{6, input.nextInt()};
                    case "rivier":
                        System.out.print("Hoeveel stamleden wil je plaatsen: ");
                        return A = new int[]{7, input.nextInt()};

                }
                
        }
        return A = new int[]{-1, 0};
    }
}
