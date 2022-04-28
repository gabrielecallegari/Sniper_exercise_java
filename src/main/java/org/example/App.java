package org.example;

import javax.swing.*;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Thread th;
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Grafica a=new Grafica("Nave pirata");
                addClock(a);
                th.start();
            }
        });
    }
    public static void addClock(Grafica grafica){
        Immagine img=new Immagine();
        th=new Thread(()->{
            while(true) {
                try {
                    grafica.setDisegno(img.getPosPirata(),img.getPosUfficiale());
                    grafica.repaint();
                    Thread.sleep(1500);
                } catch (Exception e) {

                }
            }
        });
    }

}
