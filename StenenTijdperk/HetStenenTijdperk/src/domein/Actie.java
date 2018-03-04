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
public abstract class Actie {
    
    protected int maximumStamleden;
    protected int aantalBezettePlaatsen;
    public Actie(int maximumStamleden){
        this.maximumStamleden = maximumStamleden;
    }
    public int geefBeschikbarePlaatsen(){
      return maximumStamleden - aantalBezettePlaatsen;  
    }
    public void verhoogBezettePlaatsen(int aantalStamleden){
       aantalBezettePlaatsen += aantalStamleden;
    }   
}
