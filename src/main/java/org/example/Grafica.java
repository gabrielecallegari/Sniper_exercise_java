package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Grafica extends JFrame{
    int xMouse,yMouse;
    int xImage, yImage;
    int array[][]={{321,558},{428,567},{650,456},{496,124},{213,498}};
    int puntieggio=0;
    int posPirata,posUfficiale;
    boolean presoPirata=false;
    boolean presoUfficiale=false;

    String punti="Punti:0";
    Grafica(String title){
        this.setTitle(title);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(this.getImageX(),this.getImageY()+30);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                xMouse=e.getX();
                yMouse=e.getY();
            if(xMouse>=array[posPirata][0] && xMouse<=array[posPirata][0]+30 && yMouse>array[posPirata][1]-60 && yMouse<array[posPirata][1]){
                    puntieggio+=5;
                    presoPirata=true;
                    repaint();
                }else{
                    if(xMouse>=array[posUfficiale][0] && xMouse<=array[posUfficiale][0]+30 && yMouse>array[posUfficiale][1]-60 && yMouse<array[posUfficiale][1]){
                        puntieggio-=10;
                        presoUfficiale=true;
                        repaint();
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }


    public void paint(Graphics g ) {
        super.paint(g);
        disegnoBarca(g);
        if(presoPirata==true){
            presoPirata=false;
            g.setColor(Color.green);
            g.fillRect(array[posPirata][0]-5,array[posPirata][1]-65,40,70);
        }
        if(presoUfficiale==true){
            presoUfficiale=false;
            g.setColor(Color.red);
            g.fillRect(array[posUfficiale][0]-5,array[posUfficiale][1]-65,40,70);
        }
        disegnoPirata(g,posPirata);
        disegnoPoliziotto(g,posUfficiale);

        g.setColor(Color.black);
        g.fillRect(0,0,90,60);
        g.setColor(Color.white);
        punti="Punti:"+Integer.toString(puntieggio);
        g.drawString(punti,30,50);
    }

    private int getImageX(){
        ClassLoader cl = this.getClass().getClassLoader();
        InputStream url = cl.getResourceAsStream("nave_pirata.jpg");
        BufferedImage img= null;
        try {
            img = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return img.getWidth();
    }

    private int getImageY(){
        ClassLoader cl = this.getClass().getClassLoader();
        InputStream url = cl.getResourceAsStream("nave_pirata.jpg");
        BufferedImage img= null;
        try {
            img = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return img.getHeight();
    }


    private void disegnoBarca(Graphics g){
        ClassLoader cl = this.getClass().getClassLoader();
        InputStream url = cl.getResourceAsStream("nave_pirata.jpg");
        BufferedImage img= null;
        try {
            img = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        xImage=img.getWidth();
        yImage=img.getHeight();
        g.drawImage(img, 0,30, xImage,yImage, null);
        g.setColor(Color.blue);
        g.fillRect(0,yImage-yImage/12,xImage,yImage);

    }

    public void setDisegno(int posPirata, int posUfficiale){
        this.posPirata=posPirata;
        this.posUfficiale=posUfficiale;
    }
    private void disegnoPirata(Graphics g, int pos){
        ClassLoader cl = this.getClass().getClassLoader();
        InputStream url = cl.getResourceAsStream("pirata.jpg");
        BufferedImage img= null;
        try {
            img = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        g.drawImage(img,array[pos][0],array[pos][1]-60,30,60,null);
    }
    private void disegnoPoliziotto(Graphics g, int pos){
        ClassLoader cl = this.getClass().getClassLoader();
        InputStream url = cl.getResourceAsStream("poliziotto.jpg");
        BufferedImage img= null;
        try {
            img = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        g.drawImage(img,array[pos][0],array[pos][1]-60,30,60,null);
    }



}
