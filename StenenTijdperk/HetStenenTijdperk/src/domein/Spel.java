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
    
    //Constructor
    public Spel(int aantalSpelers, String[] namen){
        
        //Grondstoffen toevoegen
        grondstoffen[0] = new Grondstof(2, "Voedsel");
        grondstoffen[1] = new Grondstof(3, "Hout");
        grondstoffen[2] = new Grondstof(4, "Leem");
        grondstoffen[3] = new Grondstof(5, "Steen");
        grondstoffen[4] = new Grondstof(6, "Goud");
        
        //Spelers toevoegen
        for(int i = 1;i <= aantalSpelers; i++){
            spelers.add(new Speler(i,namen[i - 1]));
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
        spelerAanZet = spelers.get(rand.nextInt(aantalSpelers));
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
        for(Speler speler : spelers){
            if(!alleStamledenGeplaatstSpeler(speler)){
                return false;
            }
        }
        return true;
    }
    public String geefSpelerAanZet(){
        return String.format("%nDe speler aan zet is %s%n" ,spelerAanZet.getNaam());
    }
    public void plaatsStamleden(int plaats, int aantalStamleden){
        acties.get(plaats).verhoogBezettePlaatsen(aantalStamleden);
        spelerAanZet.plaatsStamleden(acties.get(plaats),aantalStamleden);
    }
    public Speler getSpelerAanZet() {
        return spelerAanZet;
    }

    public boolean plaatsIsValid(int plaats, int aantalStamleden) {
        if(!(acties.get(plaats).geefBeschikbarePlaatsen() >= aantalStamleden))
            throw new IllegalArgumentException("Fout: Er zijn niet genoeg plaatsen voor het aantal stamleden");
        if(!(spelerAanZet.geefBeschikbareStamleden() >= aantalStamleden))
            throw new IllegalArgumentException("Fout: je hebt niet zoveel stamleden");
        if(!(spelerAanZet.heeftGeenStamledenOpPlaats(acties.get(plaats))))
            throw new IllegalArgumentException("Fout: je hebt in een vorige beurt al stamleden geplaats op deze plaats");
        if (plaats == 9)
            throw new IllegalArgumentException("Fout: Dit is geen geldige plaats");
        return acties.get(plaats).geefBeschikbarePlaatsen() >= aantalStamleden && spelerAanZet.geefBeschikbareStamleden() >= aantalStamleden && spelerAanZet.heeftGeenStamledenOpPlaats(acties.get(plaats)); 
    }

    public boolean alleStamledenGeplaatstSpeler(Speler speler) {
        return speler.geefBeschikbareStamleden() == 0;
    }

    public void volgendeSpeler() {
        spelerAanZet = spelers.get(spelerAanZet.getSpelerNummer() % spelers.size());
    }

    public boolean alleStamledenGeplaatstSpelerAanZet() {
        return alleStamledenGeplaatstSpeler(spelerAanZet);
    }
}
