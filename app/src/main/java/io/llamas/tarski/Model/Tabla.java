package io.llamas.tarski.Model;

import java.util.ArrayList;
import java.util.Arrays;

import io.llamas.tarski.Utils.StateFormas;
import io.llamas.tarski.Utils.StateColores;
import io.llamas.tarski.Utils.StateBocales;

/**
 * Created by MacNPro on 10/28/17.
 */

public class Tabla {

    private ArrayList<ArrayList<Celda>> celdas = new ArrayList<>();

    public Tabla() {

        Celda[] cs1 = {
                new Celda(0, 0, 0),
                new Celda(0, 0, 0),
                new Celda(StateFormas.CUADRADO, StateColores.ROJO, StateBocales.A),
                new Celda(0, 0, 0),
                new Celda(StateFormas.HEXAGONO, StateColores.ROJO, StateBocales.E),
                new Celda(0, 0, 0)
        };

        Celda[] cs2 = {
                new Celda(0, 0, 0),
                new Celda(StateFormas.CIRCULO, StateColores.AZUL, StateBocales.E),
                new Celda(0, 0, 0),
                new Celda(StateFormas.CUADRADO, StateColores.NARANJA, StateBocales.E),
                new Celda(0, 0, 0),
                new Celda(StateFormas.CIRCULO, StateColores.VERDE, StateBocales.A)
        };

        Celda[] cs3 = {
                new Celda(0, 0, 0),
                new Celda(StateFormas.CUADRADO, StateColores.NARANJA, StateBocales.O),
                new Celda(0, 0, 0),
                new Celda(0, 0, 0),
                new Celda(StateFormas.HEXAGONO, StateColores.NARANJA, StateBocales.O),
                new Celda(0, 0, 0)
        };

        Celda[] cs4 = {
                new Celda(StateFormas.HEXAGONO, StateColores.ROJO, StateBocales.A),
                new Celda(0, 0, 0),
                new Celda(0, 0, 0),
                new Celda(StateFormas.CIRCULO, StateColores.AZUL, StateBocales.I),
                new Celda(0, 0, 0),
                new Celda(0, 0, 0)
        };

        celdas.add(new ArrayList<>(Arrays.asList(cs1)));
        celdas.add(new ArrayList<>(Arrays.asList(cs2)));
        celdas.add(new ArrayList<>(Arrays.asList(cs3)));
        celdas.add(new ArrayList<>(Arrays.asList(cs4)));

    }

    public ArrayList<Celda> getArray() {
        ArrayList<Celda> mCeldas = new ArrayList<>();
        for (ArrayList<Celda> celda : celdas) {
            mCeldas.addAll(celda);
        }
        return mCeldas;
    }

}
