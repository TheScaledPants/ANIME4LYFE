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
public class Hutkaart extends Actie{
    private Grondstof[] kosten = new Grondstof[3];
    boolean actief;
    public Hutkaart(ArrayList<Grondstof> kosten) {
        super(1);
        this.kosten[0] = kosten.get(0);
        this.kosten[1] = kosten.get(1);
        this.kosten[2] = kosten.get(2);
        actief = false;
    }
    public void Actief(){
        actief = !actief;
    }
    public boolean getActief(){
        return actief;
    }
    @Override
    public String toString(){
        int beschikbaar = this.geefBeschikbarePlaatsen();
        return String.format("Hutkaart met waarde: %d kosten 1: %s 2: %s 3: %s en %d vrije %s%n",berekenWaarde(),kosten[0].getNaam(),kosten[1].getNaam(),kosten[2].getNaam(),beschikbaar,beschikbaar == 0 ? "plaats" : "plaatsen");
    }
    
    public int berekenWaarde(){
        return kosten[0].getWaarde() + kosten[1].getWaarde() + kosten[2].getWaarde();
    }
}
