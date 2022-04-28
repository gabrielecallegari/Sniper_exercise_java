package org.example;

import java.util.Random;

public class Immagine {

    Random random=new Random();
    private int posPirata;
    Immagine(){}

    public int getPosPirata() {
        posPirata=random.nextInt(5);
        return posPirata;
    }

    public int getPosUfficiale() {
        int p=posPirata;
        int posUff=0;
        do{
            posUff=random.nextInt(5);
        }while(posUff==p);
        return posUff;
    }

    @Override
    public String toString(){
        return "Posizione pirata:"+Integer.toString(this.getPosPirata())+" Posizione ufficiale:"+Integer.toString(this.getPosUfficiale());
    }
}
