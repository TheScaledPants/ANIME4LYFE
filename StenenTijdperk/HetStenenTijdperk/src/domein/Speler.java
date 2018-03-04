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
            score,
            geplaatsteStamleden;
    private String naam;
    private ArrayList<Stamlid> stamleden = new ArrayList<>();
    private Gereedschapsfiche[] gereedschappen = new Gereedschapsfiche[3];
    public Speler(int spelerNummer,String naam){
        this.spelerNummer = spelerNummer;
        this.naam = naam;
        stamleden.add(new Stamlid());
        stamleden.add(new Stamlid());
        stamleden.add(new Stamlid());
        stamleden.add(new Stamlid());
        stamleden.add(new Stamlid()); 
    }
    
    @Override
    public String toString(){
        return String.format("Speler %d %s met score %d en %n"
                + "Hout: %d, Leem: %d, Steen: %d, Goud: %d%n"
                + "Voedsel : %d, voedselproductie: %d per beurt%n"
                + "Stamleden: %d%n",getSpelerNummer(),getNaam(),getScore(),getAantalHout(),getAantalLeem(),getAantalSteen(),getAantalGoud(),getAantalVoedsel(),getVoedselProductie(),stamleden.size());
    }
    public boolean alleStamledenGeplaatst(){
        for(Stamlid stamlid : stamleden){
            if(stamlid.getPlaats() == null)
                return false;
        }
        return true;
    }
    public void plaatsStamleden(Actie plaats, int aantalStamleden){
        for(int i = geplaatsteStamleden; i < aantalStamleden + geplaatsteStamleden; i++){
            stamleden.get(i).plaatsOp(plaats);
            
        }
        geplaatsteStamleden += aantalStamleden;
    }
    public boolean heeftGeenStamledenOpPlaats(Actie plaats){
        for(Stamlid stamlid : stamleden){
            if (stamlid.getPlaats() == plaats){
                return false;
            }
        }
        return true;
    }
    public int geefAantalStamleden() {
        return stamleden.size();
    }
    public int geefBeschikbareStamleden(){
        return geefAantalStamleden() - geplaatsteStamleden;
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
    
    public String getNaam() {
        return naam;
    }
}
