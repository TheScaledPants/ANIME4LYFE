/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

/**
 *
 * @author jasperdesmet
 */
public class DomeinController {
    private Spel spel;
    public void startSpel(int aantalSpelers,String[] namen){
        spel = new Spel(aantalSpelers,namen);
    }
    public void plaatsStamleden(int plaats, int aantalStamleden){
        spel.plaatsStamleden(plaats,aantalStamleden);
    }
    public String geefSpelerAanZet(){
        return spel.geefSpelerAanZet();
    }
    public String geefSpelbord(){
        return spel.toString();
    }
    public boolean plaatsIsValid(int plaats,int aantalStamleden){
        return spel.plaatsIsValid(plaats, aantalStamleden);
    }
    public boolean isEindeSpel(){
        //Todo iteratie 2
        return false;
    }
    public boolean alleStamledenGeplaatst(){
        return spel.alleStamledenGeplaatst();
    }
    public String geefInfoBeschikbarePlaatsen(){
        return spel.geefInfoBeschikbarePlaatsen();
    }

    public boolean alleStamledenGeplaatstSpelerAanZet() {
        return spel.alleStamledenGeplaatstSpelerAanZet();
    }

    public void volgendeSpeler() {
        spel.volgendeSpeler();
    }
}
