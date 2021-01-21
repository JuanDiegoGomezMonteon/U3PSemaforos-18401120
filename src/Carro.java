
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
public class Carro extends Thread {
    int x, y ;
    //1 = izq a derecha, 2 = derecha a iz, 3 = arriba a abajo, 4 = abajo a arriba
    //2 Y 3
    int direccion;
    Semaforos semaforo;
    Locacion locacion;
    int desplazamiento = 5;
    
    public Carro(int x, int y, int direccion, Semaforos s, Locacion l){
        this.x = x;
        this.y = y;
        this.direccion = direccion;
        semaforo = s;
        locacion = l;
    }
    
    
    
    
    
     public void pintar(Graphics2D g){
        g.setColor(Color.RED);
        switch(direccion){
            case 1:
                g.fillRect(x, y, 60, 40);
                g.setColor(Color.WHITE);
                g.fillRect(x+35, y+5, 12, 30);
                g.fillRect(x+50, y+8, 6, 6);
                g.fillRect(x+50, y+28, 6, 6);
                //llantas
                g.setColor(Color.black);
                g.fillRect(x+8, y-5, 10, 4);
                g.fillRect(x+8, y+40, 10, 4);
                g.fillRect(x+35, y-5, 10, 4);
                g.fillRect(x+35, y+40, 10, 4);
                break;
            case 2:
                g.fillRect(x, y, 60, 40);
                g.setColor(Color.WHITE);
                g.fillRect(x+15, y+5, 12, 30);
                g.fillRect(x+4, y+8, 6, 6);
                g.fillRect(x+4, y+28, 6, 6);
                //llantas
                g.setColor(Color.black);
                g.fillRect(x+8, y-5, 10, 4);
                g.fillRect(x+8, y+40, 10, 4);
                g.fillRect(x+35, y-5, 10, 4);
                g.fillRect(x+35, y+40, 10, 4);
                break;
            case 3: 
                g.fillRect(x, y, 40, 60);
                g.setColor(Color.WHITE);
                g.fillRect(x+5, y+35, 30, 12);
                g.fillRect(x+8, y+50, 6, 6);
                g.fillRect(x+28, y+50, 6, 6);
                //llantas
                g.setColor(Color.black);
                g.fillRect(x-5, y+8, 4, 10);
                g.fillRect(x+40, y+8, 4, 10);
                g.fillRect(x-5, y+35, 4, 10);
                g.fillRect(x+40, y+35, 4, 10);
                break;
            case 4: 
                g.fillRect(x, y, 40, 60);
                g.setColor(Color.WHITE);
                g.fillRect(x+5, y+15, 30, 12);
                g.fillRect(x+8, y+4, 6, 6);
                g.fillRect(x+28, y+4, 6, 6);
                //llantas
                g.setColor(Color.black);
                g.fillRect(x-5, y+8, 4, 10);
                g.fillRect(x+40, y+8, 4, 10);
                g.fillRect(x-5, y+35, 4, 10);
                g.fillRect(x+40, y+35, 4, 10);
                break;
        }
    }
    
    public void mover(){
        switch(direccion){
            case 1:
                x+=desplazamiento;
                if(x>850){
                    x=(int) (Math.random()*50+100)*-1;
                }
                break;
            case 2:
                x-=desplazamiento;
                if(x<-100){
                    x=(int) (Math.random()*100+900);
                }
                break;
            case 3:
                y+=desplazamiento;
                if(y>700){
                    y=(int) (Math.random()*50+100)*-1;
                }
                break;
            case 4:
                y-=desplazamiento;
                if(y<-100){
                    y=(int) (Math.random()*100+650);
                }
                break;
        }
    }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        while(true){
            try {
                switch (direccion){
                    case 1:
                        if(x>=190 && x<=200){
                            if(semaforo.color==1){
                                mover();
                            }
                        } else{
                            mover();
                        }
                        locacion.repaint();
                        break;
                    case 2:
                        if(x>=400 && x<=420){
                            if(semaforo.color==1){
                                mover();
                            }
                        } else{
                            mover();
                        }
                        locacion.repaint();
                        break;
                    case 3:
                        if(y>=90 && y<=110){
                            if(semaforo.color==1){
                                mover();
                            }
                        } else{
                            mover();
                        }
                        locacion.repaint();
                        break;
                    case 4:
                        if(y>=30 && y<=310){
                            if(semaforo.color==1){
                                mover();
                            }
                        } else{
                            mover();
                        }
                        locacion.repaint();
                        break;
                }
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Carro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
}
