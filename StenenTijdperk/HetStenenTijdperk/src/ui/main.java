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
    public static void main(String[] args){
        DomeinController domeinController = new DomeinController();
        Scanner input = new Scanner(System.in);
        String invoer;
        int aantalSpelers;
        String[] namen;
        
        System.out.printf("Welkom bij stenen tijdperk. "
                + "%nWat wil je doen:%n"
                + "1. Nieuw spel starten%n"
                + "2. Spel hervaten%n"
                + "3. Highscores bekijken%n"
                + "Typ je keuze: ");
        switch(input.nextInt()){
            case 1:
                System.out.print("Met hoeveel wil je spelen: ");
                aantalSpelers = input.nextInt();
                namen = new String[aantalSpelers];
                for(int i = 0;i < aantalSpelers;i++){
                    System.out.printf("Geef naam van speler %d: ", i + 1);
                    namen[i] = input.next();
                }
                domeinController.startSpel(aantalSpelers,namen);
                System.out.println(domeinController.geefSpelbord());

                while(!domeinController.alleStamledenGeplaatst()){
                    System.out.print("Waar wil je je stamleden plaatsen (typ \"?\" voor beschikbare plaatsen): ");
                    do{
                        invoer = input.next();
                        if("?".equals(invoer)){
                            System.out.println(domeinController.geefInfoBeschikbarePlaatsen());
                        }
                    }while(!"?".equals(invoer));
                }
            default:
                System.out.println("Dit is geen geldige input");
                break;
        }            
        
        

    }
}
