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
public class Gereedschapsfiche {
    private int kracht = 0;
    private boolean gebruikt = false;
    public void verhoogKracht(){
        kracht++;
    }
    public int getKracht(){
        return kracht;
    }
    public boolean getGebruikt(){
        return gebruikt;
    }

    public void gebruik() {
        gebruikt = true;
    }
    public void reset(){
        gebruikt = false;
    }
}
