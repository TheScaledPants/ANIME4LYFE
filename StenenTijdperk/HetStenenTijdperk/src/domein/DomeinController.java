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
    public void startSpel(String[] namen){
        spel = new Spel(namen);
    }
    public void plaatsStamleden(int plaats, int aantalStamleden){
        spel.plaatsStamleden(plaats,aantalStamleden);
    }
    public String geefSpelerAanZetPlaatsen(){
        return spel.geefSpelerAanZetPlaatsen();
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
    public int geefAantalSpelers(){
        return spel.geefAantalSpelers();
    }
    
    public boolean alleActiesUitgevoerdSpelerAanZet() {
        return spel.alleActiesUitgevoerdSpelerAanZet();
    }

    public String geefInfoActiesSpelerAanZet() {
        return spel.geefInfoActiesSpelerAanZet();
    }

    public boolean ActieIsValid(int plaats) {
        return spel.actieIsValid(plaats);
    }

    public void doeActie(int plaats) {
        spel.doeActie(plaats);
    }
    public void doeActie(int plaats,int geworpenOgen) {
        spel.doeActie(plaats, geworpenOgen);
    }

    public int geefStamledenOpPlaatsSpelerAanZet(int plaats) {
        return spel.geefStamledenOpPlaatsSpelerAanZet(plaats);
    }

    public String geefInfoSpelerAanZet() {
        return spel.geefInfoSpelerAanZet();
    }

    public void verzetNaarStartSpeler() {
        spel.verzetNaarStartSpeler();
    }

    public boolean spelerAanZetHeeftOngebruiktGereedschap() {
        return spel.spelerAanZetHeeftOngebruiktGereedschap();
    }

    public String geefInfoOngebruikteGereedschapsfichesSpelerAanZet() {
        return spel.geefInfoOngebruikteGereedschapsfichesSpelerAanZet();
    }

    public void gereedschapsficheIsValid(int gereedschapsfiche) {
        spel.gereedschapsficheIsValid(gereedschapsfiche);
    }
    public int gebruikGereedschapfiche(int gereedschapsfiche){
        return spel.gebruikGereedschapfiche(gereedschapsfiche);
    }

    public boolean eindeSpel() {
        return spel.getEindeSpel();
    }

    public void nieuweRonde() {
        spel.nieuweRonde();
    }

    public void voedselProductie() {
        spel.voedselProductie();
    }

    public boolean HeeftGenoegVoedselspelerAanZet() {
        return spel.HeeftGenoegVoedselspelerAanZet();
    }

    public void voedStamledenSpelerAanZet() {
        spel.voedStamledenSpelerAanZet();
    }

    public void voedStamledenSpelerAanZet(int methode) {
        spel.voedStamledenSpelerAanZet(methode);
    }

    public boolean heeftGenoegGrondstoffenSpelerAanZet() {
        return spel.heeftGenoegGrondstoffenSpelerAanZet();
    }

    public int[] geefGrondstoffenSpelerAanZet() {
        return spel.geefGrondstoffenSpelerAanZet();
    }

    public int nodigVoedselSpelerAanZet() {
        return spel.nodigVoedselSpelerAanZet();
    }

    public void voedStamledenSpelerAanZet(int[] grondstoffen) {
        spel.voedStamledenSpelerAanZet(grondstoffen);
    }

    public String bepaalWinnaar() {
        return "dsaf";
    }
}
