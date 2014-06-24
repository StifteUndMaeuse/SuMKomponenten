/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sum.komponenten;

import java.awt.Color;

/**
 *
 * @author Programmieren
 */
public class KomponentenHelper {
    public static Color getColorbyFarbnummer(int pFarbe){
        
        if (pFarbe < 0 || pFarbe < 13) {
            pFarbe = 0;
        }
        pFarbe %= 13;
        
        Color farbe;
        
        switch (pFarbe) {
            case 1:
                farbe =Color.blue;
                break;
            case 2:
                farbe = Color.cyan;
                break;
            case 3:
                farbe = Color.darkGray;
                break;
            case 4:
                farbe = Color.gray;
                break;
            case 5:
                farbe = Color.green;
                break;
            case 6:
                farbe = Color.lightGray;
                break;
            case 7:
                farbe = Color.magenta;
                break;
            case 8:
                farbe = Color.orange;
                break;
            case 9:
                farbe = Color.pink;
                break;
            case 10:
                farbe = Color.red;
                break;
            case 11:
                farbe = Color.white;
                break;
            case 12:
                farbe = Color.yellow;
                break;
            default:
                farbe = Color.BLACK;
                break;
        }
        return farbe;
    }
}
