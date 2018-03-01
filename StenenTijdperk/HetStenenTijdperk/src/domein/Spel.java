/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jasperdesmet
 */
public class Spel {
    private ArrayList<Grondstof> grondstoffen = new ArrayList<>();
    private ArrayList<Speler> spelers = new ArrayList<>();
    private Speler spelerAanZet;
    private ArrayList<Actie> acties = new ArrayList<>();
    private ArrayList<Stapel> stapels = new ArrayList<>();
    public Spel(int aantalSpelers){
        
        //Grondstoffen toevoegen
        grondstoffen.add(new Grondstof(2, "Voedsel"));
        grondstoffen.add(new Grondstof(3, "Hout"));
        grondstoffen.add(new Grondstof(4, "Leem"));
        grondstoffen.add(new Grondstof(5, "Steen"));
        grondstoffen.add(new Grondstof(6, "Goud"));
        
        //Spelers toevoegen
        for(int i = 1;i > aantalSpelers; i++){
            spelers.add(new Speler(i));
        }
        bepaalSpelerAanZet();
        
        acties.add(new Akker(1));
        acties.add(new Hut(2));
        acties.add(new Jacht(1));
        acties.add(new Gereedschapsmaker(1));
        acties.add(new Grondstofproductie(7));
        acties.add(new Grondstofproductie(7));
        acties.add(new Grondstofproductie(7));
        acties.add(new Grondstofproductie(7));
        
    }
    
    private void bepaalSpelerAanZet(){
        Random rand = new Random();
        spelerAanZet = spelers.get(rand.nextInt(4) + 1);
    }
}
