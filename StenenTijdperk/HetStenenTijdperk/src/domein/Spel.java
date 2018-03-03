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
        grondstoffen[1] = new Grondstof(3, "Hout");
        grondstoffen[2] = new Grondstof(4, "Leem");
        grondstoffen[3] = new Grondstof(5, "Steen");
        grondstoffen[4] = new Grondstof(6, "Goud");
        
        //Spelers toevoegen
        for(int i = 1;i <= aantalSpelers; i++){
            spelers.add(new Speler(i));
        }
        bepaalSpelerAanZet(aantalSpelers);
        
        acties.add(new Akker(1));
        acties.add(new Hut(2));
        acties.add(new Jacht(100));
        acties.add(new Gereedschapsmaker(1));
        acties.add(new Grondstofproductie(7, grondstoffen[1]));
        acties.add(new Grondstofproductie(7, grondstoffen[2]));
        acties.add(new Grondstofproductie(7, grondstoffen[3]));
        acties.add(new Grondstofproductie(7, grondstoffen[4]));
        
        //genereren hutkaarten
        Random rand = new Random();
        ArrayList<Grondstof> grondstoffenList = new ArrayList<>();
        
        for(Hutkaart[] stapel : stapels){
            for(int t = 0; t < stapel.length; t++){
                
                grondstoffenList.add(grondstoffen[rand.nextInt(4) + 1]);
                grondstoffenList.add(grondstoffen[rand.nextInt(4) + 1]);
                grondstoffenList.add(grondstoffen[rand.nextInt(4) + 1]);
                
                grondstoffenList.sort((Grondstof o1, Grondstof o2) -> o1.getWaarde()-o2.getWaarde());
                stapel[t] = new Hutkaart(grondstoffenList);
            }
            grondstoffenList.clear();
            stapel[0].Actief();
        }
        
    }
    
    private void bepaalSpelerAanZet(int aantalSpelers){
        Random rand = new Random();
        spelerAanZet = getSpelers().get(rand.nextInt(aantalSpelers));
    }
    
    @Override
    public String toString(){
        int stapelNummer = 1;
        String toString = String.format("%nSpel met %d spelers.%n",spelers.size());;
        for(Speler speler : spelers)
            toString += String.format("%s%n", speler.toString());
        toString += String.format("De actieve hutkaarten zijn%n");
        for(Hutkaart[] stapel : stapels){
            for(Hutkaart hutkaart : stapel)
                    if (hutkaart.getActief())
                        toString += String.format("Stapel %d: %s",stapelNummer, hutkaart.toString());
            stapelNummer++;
        }
        toString += geefSpelerAanZet();
            
        
        return toString;
    }
    public String geefInfoBeschikbarePlaatsen(){
        String uitvoer = "";
        for(Actie plaats : acties){
            if(plaats.geefBeschikbarePlaatsen() > 0){
               uitvoer += plaats.toString(); 
            }     
        }
        return uitvoer;
    }
    public boolean alleStamledenGeplaatst(){
        boolean stamledenGeplaatst = true;
        for(Speler speler : spelers){
            stamledenGeplaatst = speler.alleStamledenGeplaatst() && stamledenGeplaatst;
        }
        return stamledenGeplaatst;
    }
    public String geefSpelerAanZet(){
        return String.format("%nDe speler aan zet is speler %d%n" ,spelerAanZet.getSpelerNummer());
    }
    public ArrayList<Speler> getSpelers() {
        return spelers;
    }

    public Speler getSpelerAanZet() {
        return spelerAanZet;
    }

    public ArrayList<Actie> getActies() {
        return acties;
    }

    public Hutkaart[][] getStapels() {
        return stapels;
    }
}
