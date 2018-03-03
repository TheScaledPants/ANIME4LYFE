/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;

/**
 *
 * @author jasperdesmet
 */
public class Speler {

    private final int spelerNummer;
    private int voedselProductie,
            aantalVoedsel,
            aantalGoud,
            aantalSteen,
            aantalLeem,
            aantalHout,
            score;
    private ArrayList<Stamlid> stamleden = new ArrayList<>();
    private Gereedschapsfiche[] gereedschappen = new Gereedschapsfiche[3];
    public Speler(int spelerNummer){
        this.spelerNummer = spelerNummer;
        
        stamleden.add(new Stamlid());
        stamleden.add(new Stamlid());
        stamleden.add(new Stamlid());
        stamleden.add(new Stamlid());
        stamleden.add(new Stamlid()); 
    }
    
    @Override
    public String toString(){
        return String.format("Speler %d met score %d en %n"
                + "Hout: %d, Leem: %d, Steen: %d, Goud: %d%n"
                + "Voedsel : %d, voedselproductie: %d per beurt%n"
                + "Stamleden: %d%n", getSpelerNummer(),getScore(),getAantalHout(),getAantalLeem(),getAantalSteen(),getAantalGoud(),getAantalVoedsel(),getVoedselProductie(),stamleden.size());
    }
    public boolean alleStamledenGeplaatst(){
        for(Stamlid stamlid : stamleden){
            if(stamlid.getPlaats() == null)
                return false;
        }
        return true;
    }
    public int getAantalGoud(){
        return aantalGoud;
    }

    public int getSpelerNummer() {
        return spelerNummer;
    }

    public int getVoedselProductie() {
        return voedselProductie;
    }

    public int getAantalVoedsel() {
        return aantalVoedsel;
    }

    public int getAantalSteen() {
        return aantalSteen;
    }

    public int getAantalLeem() {
        return aantalLeem;
    }

    public int getAantalHout() {
        return aantalHout;
    }

    public int getScore() {
        return score;
    }

}
