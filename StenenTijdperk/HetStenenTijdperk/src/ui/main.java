/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.Speler;

/**
 *
 * @author jasperdesmet
 */
public class main {
    public static void main(String[] args){
        Speler speler = new Speler(1);
        System.out.println(speler.toString());
    }
}
