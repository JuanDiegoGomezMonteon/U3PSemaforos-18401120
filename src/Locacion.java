
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
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
public class Locacion extends Canvas {
    Calles calle;
    Semaforos sem1;
    Semaforos sem2;
    Carro[] carro = new Carro[4];
    
    
    public Locacion(){
         calle = new Calles();
         
         sem1 = new Semaforos(true,this,200,5);
         sem2 = new Semaforos(false,this,410,300);
         sem1.start();
         sem2.start();
         
        carro[0] = new Carro(10,240,1,sem2,this);
        carro[1] = new Carro(540,173,2,sem2,this);
        carro[2] = new Carro(290,-100,3,sem1,this);
        carro[3] = new Carro(358,500,4,sem1,this);
        
        for(int i=0; i<carro.length;i++){
            carro[i].start();
        }
         
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        this.setBackground(Color.GREEN);
        
        Graphics2D g2 = (Graphics2D) g;
        
        calle.pintar(g2);
        sem1.pintar(g2);
        sem2.pintar(g2);
        
        for(int i=0; i<carro.length; i++){
            carro[i].pintar(g2);
        }
    }
}
