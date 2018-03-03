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
public class Jacht extends Actie{
    
    public Jacht(int maximumStamleden) {
        super(maximumStamleden);
    }
    @Override
    public int geefBeschikbarePlaatsen(){
        return 100;
    }
    public String toString(){
        return String.format("Jacht hier mogen zoveel stamleden als men wil%n");
    }
}
