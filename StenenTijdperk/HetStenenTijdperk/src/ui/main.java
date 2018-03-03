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
        
        System.out.printf("Welkom bij stenen tijdperk. "
                + "%nWat wil je doen:%n"
                + "1. Nieuw spel starten%n"
                + "2. Spel hervaten%n"
                + "3. Highscores bekijken%n"
                + "Typ je keuze: ");
        switch(input.nextInt()){
            case 1:
                System.out.print("Met hoeveel wil je spelen: ");
                domeinController.startSpel(input.nextInt());
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
