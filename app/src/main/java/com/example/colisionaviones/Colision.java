package com.example.colisionaviones;

import java.util.List;

public class Colision {

    int x;
    int y;
    List<Avion> avionesInvolucrados;

    public Colision(int x, int y, List<Avion> avionesInvolucrados) {
        this.x = x;
        this.y = y;
        this.avionesInvolucrados = avionesInvolucrados;
    }

    public int getImage() {
        return R.mipmap.collision;
    }
}