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
    //private ArrayList<Grondstof> grondstoffen = new ArrayList<>();
    private Grondstof[] grondstoffen = new Grondstof[5];
    private ArrayList<Speler> spelers = new ArrayList<>();
    private Speler spelerAanZet;
    private ArrayList<Actie> acties = new ArrayList<>();
    private Hutkaart[][] stapels = new Hutkaart[4][7];
    public Spel(int aantalSpelers){
        
        //Grondstoffen toevoegen
        grondstoffen[0] = new Grondstof(2, "Voedsel");
        grondstoffen[1] = new Grondstof(2, "Hout");
        grondstoffen[2] = new Grondstof(2, "Leem");
        grondstoffen[3] = new Grondstof(2, "Steen");
        grondstoffen[4] = new Grondstof(2, "Goud");
        
        //Spelers toevoegen
        for(int i = 1;i > aantalSpelers; i++){
            spelers.add(new Speler(i));
        }
        bepaalSpelerAanZet();
        
        acties.add(new Akker(1));
        acties.add(new Hut(2));
        acties.add(new Jacht(1));
        acties.add(new Gereedschapsmaker(1));
        acties.add(new Grondstofproductie(7, grondstoffen[1]));
        acties.add(new Grondstofproductie(7, grondstoffen[2]));
        acties.add(new Grondstofproductie(7, grondstoffen[3]));
        acties.add(new Grondstofproductie(7, grondstoffen[4]));
        
    }
    
    private void bepaalSpelerAanZet(){
        Random rand = new Random();
        spelerAanZet = spelers.get(rand.nextInt(4) + 1);
    }
}
