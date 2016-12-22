/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blatt9;

import java.awt.Point;

/**
 *
 * @author Rocke
 */
public class Test {
    public static void main(String[] args) {
    Graphic g = new Graphic (500 ,500) ; // Groesse der Grafik  
    Rectangle r = new Rectangle(new Point(50, 50), new Point(150, 150));
    g.add(r);
    r.scale(0.5);
    
    }
}
