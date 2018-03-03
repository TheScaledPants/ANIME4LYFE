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
    public void startSpel(int aantalSpelers){
        spel = new Spel(aantalSpelers);
    }
    public String geefSpelerAanZet(){
        return spel.geefSpelerAanZet();
    }
    public String geefSpelbord(){
        return spel.toString();
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
}
