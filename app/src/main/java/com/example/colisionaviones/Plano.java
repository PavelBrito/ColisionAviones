package com.example.colisionaviones;
import android.util.Log;

import java.util.ArrayList;


public class Plano {
    public ArrayList<Avion> aviones;
public ArrayList<Colision> colisiones;
public int col;
public int row;
public int noPaso;

    public static final int TAMANO_GRID = 14;
    Plano(int noPaso, ArrayList<Avion> aviones, ArrayList<Colision> colisiones) {

        this.noPaso = noPaso;
        this.aviones = aviones;
        this.colisiones = colisiones;

        int tmpX = 0;
        int tmpY = 0;
        for (Avion avion: aviones) {
            if (avion.x > tmpX) {
                tmpX = avion.x;
            }
            if (avion.y > tmpX) {
                tmpY = avion.y;
            }
        }
        col=TAMANO_GRID;//col = tmpX; //También hice este cambio para adaptar el tamaño del Grid.
        row=TAMANO_GRID;//row = tmpY;

        Log.i("Aviones max de columna", String.valueOf(col));
        Log.i("Aviones max de renglon", String.valueOf(row));
    }

    public Plano next() {
        Log.i("Pavel", String.valueOf(noPaso));
        noPaso += 1;
        return Analizador.next(noPaso, this);
    }

    public Plano prev() {
        // Tu vas a implementar
        noPaso -= 1;
        return null;
    }

    public int getNumeroColisiones() {
        return colisiones.toArray().length;
    }

    public int getNumeroAviones() {
        return aviones.toArray().length;
    }

}
