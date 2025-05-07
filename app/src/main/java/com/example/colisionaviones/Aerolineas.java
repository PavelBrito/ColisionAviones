package com.example.colisionaviones;

public class Aerolineas {
    public static ArrayList<Avion> AerolineasPatito(){
        ArrayList<Avion> aviones = new ArrayList<>();
        aviones.add(new Avion(Direccion.EAST, 0, 0));
        aviones.add(new Avion(Direccion.WEST, 2, 0));
        return aviones;
    }

}
