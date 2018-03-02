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
public class Grondstofproductie extends Actie{
    private Grondstof grondstof;
    public Grondstofproductie(int maximumStamleden,Grondstof grondstof) {
        super(maximumStamleden);
        this.grondstof = grondstof;
    }
    
}
