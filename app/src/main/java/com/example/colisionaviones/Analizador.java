package com.example.colisionaviones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Analizador {
    static HashMap<Integer, Plano> memoria = new HashMap<>();

    public static Plano inicializa(Plano plano) {
        memoria.put(0, plano);
        return plano;
    }

    public static Plano next(int noPaso, Plano plano){
        if (memoria.containsKey(noPaso)){
            return memoria.get(noPaso);
        } else {
            Plano planoNuevo;
            ArrayList<Avion> nuevosAviones = new ArrayList<>();

            // Calcular colision
            ArrayList<Colision> colisiones = new ArrayList<>();

            // Mueve los aviones
            for (Avion avion: plano.aviones) {
                Avion nuevoAvion = new Avion(avion.direccion, avion.x, avion.y);
                switch (avion.direccion){
                    case NORTH:
                        nuevoAvion.y = nuevoAvion.y - 1;
                        break;
                    case SOUTH:
                        nuevoAvion.y = nuevoAvion.y + 1;
                        break;
                    case EAST:
                        nuevoAvion.x = nuevoAvion.x + 1;
                        break;
                    case WEST:
                        nuevoAvion.x = nuevoAvion.x - 1;
                        break;
                }
                // Limita la posición a la grid de 14x14
                nuevoAvion.x = Math.max(0, Math.min(13, nuevoAvion.x));
                nuevoAvion.y = Math.max(0, Math.min(13, nuevoAvion.y));
                nuevosAviones.add(nuevoAvion);
            }

            // Detección de colisiones
            HashMap<String, ArrayList<Avion>> posiciones = new HashMap<>();
            for (Avion avion : nuevosAviones) {
                String key = avion.x + "-" + avion.y;
                if (!posiciones.containsKey(key)) {
                    posiciones.put(key, new ArrayList<>());
                }
                posiciones.get(key).add(avion);
            }
            for (Map.Entry<String, ArrayList<Avion>> entry : posiciones.entrySet()) {
                if (entry.getValue().size() > 1) {
                    String[] partes = entry.getKey().split("-");
                    int x = Integer.parseInt(partes[0]);
                    int y = Integer.parseInt(partes[1]);
                    colisiones.add(new Colision(x, y, entry.getValue())); // Constructor con aviones involucrados
                }
            }

            planoNuevo = new Plano(noPaso, nuevosAviones, colisiones);
            memoria.put(noPaso, planoNuevo);
            return planoNuevo;
        }
    }

    public static Plano prev(int noPaso) {
        return memoria.get(noPaso);
    }
}