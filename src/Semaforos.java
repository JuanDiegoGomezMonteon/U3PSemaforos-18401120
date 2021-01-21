
import java.awt.Color;
import java.awt.Graphics2D;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
public class Semaforos extends Thread {
    int color;
    Locacion puntero;
    int x,y;
    int verde  = 7000;
    int amarillo = 1500;
    int rojo = 7000;
    
    public Semaforos(boolean es, Locacion l, int posX, int posY){
        x = posX;
        y = posY;
        
        if(es){
            color = 2;
        } else {
            color = 4;
        }
        
        puntero = l;
    }
    
    @Override
    public void run(){
        super.run(); //To change body of generated methods, choose Tools | Templates.
        while(true){
            try {
                
                switch(color){
                    case 1:
                        puntero.repaint();
                        sleep(verde);
                        color = 2;
                        break;
                    case 2:
                        puntero.repaint();
                        sleep(amarillo);
                        color = 3;
                        break;
                    case 3:
                        puntero.repaint();
                        sleep(rojo);
                        color = 4;
                        break;
                    case 4:
                        puntero.repaint();
                        sleep(amarillo);
                        color = 1;
                        break;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Semaforos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void pintar(Graphics2D g){
        
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 60, 147);
        
        //ROJO
        g.setColor(new Color(165,44,2));
        g.fillOval(x+15, y+6, 35, 35);

        //AMARILLO
        g.setColor(new Color(205,190,58));
        g.fillOval(x+15, y+56, 35, 35);
        
        
        //VERDE
        g.setColor(new Color(18,121,5));
        g.fillOval(x+15, y+106, 35, 35);
        
        switch(color){
            case 1:
                g.setColor(new Color(26,255,0));
                g.fillOval(x+15, y+106, 35, 35);
                
                break;
            case 2:
                g.setColor(new Color(255,242,0));
                g.fillOval(x+15, y+56, 35, 35);
                
                break;
            case 3:
                g.setColor(new Color(255,0,0));
                g.fillOval(x+15, y+6, 35, 35);
                
                break;
            case 4:
                g.setColor(new Color(255,242,0));
                g.fillOval(x+15, y+56, 35, 35);
                
                break;
        }
        
    }
}
