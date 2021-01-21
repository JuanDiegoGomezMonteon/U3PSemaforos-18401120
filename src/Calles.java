
import java.awt.Color;
import java.awt.Graphics2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
public class Calles {
    public void pintar(Graphics2D g){
        //CALLE HORIZONTAL
        g.setColor(Color.GRAY);
        g.fillRect(0, 150, 700, 150);
        
        
        g.setColor(Color.YELLOW);
        g.fillRect(0, 220, 700, 10);
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 289, 700, 10);
        g.fillRect(0, 151, 700, 10);
        
        //CALLE VERTICAL
        g.setColor(Color.GRAY);
        g.fillRect(260, 0, 150, 500);
        
        g.setColor(Color.YELLOW);
        g.fillRect(340, 0, 10, 150);
        g.fillRect(340, 300, 10, 500);
        
        g.setColor(Color.WHITE);
        g.fillRect(261, 0, 10, 150);
        g.fillRect(399, 0, 10, 150);
        
        g.fillRect(261, 300, 10, 300);
        g.fillRect(399, 300, 10, 300);
        
        
        
    }
}
