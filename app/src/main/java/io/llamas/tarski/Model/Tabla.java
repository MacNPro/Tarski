package io.llamas.tarski.Model;

import java.util.ArrayList;
import java.util.Arrays;

import io.llamas.tarski.Utils.StateCelda;

/**
 * Created by MacNPro on 10/28/17.
 */

public class Tabla {

    private ArrayList<ArrayList<Celda>> celdas = new ArrayList<>();

    public Tabla() {

        Celda[] cs1 = {
                new Celda(0, 0, 0),
                new Celda(0, 0, 0),
                new Celda(StateCelda.CUADRADO, StateCelda.ROJO, StateCelda.A),
                new Celda(0, 0, 0),
                new Celda(StateCelda.HEXAGONO, StateCelda.ROJO, StateCelda.E),
                new Celda(0, 0, 0)
        };

        Celda[] cs2 = {
                new Celda(0, 0, 0),
                new Celda(StateCelda.CIRCULO, StateCelda.AZUL, StateCelda.E),
                new Celda(0, 0, 0),
                new Celda(StateCelda.CUADRADO, StateCelda.NARANJA, StateCelda.E),
                new Celda(0, 0, 0),
                new Celda(StateCelda.CIRCULO, StateCelda.VERDE, StateCelda.A)
        };

        Celda[] cs3 = {
                new Celda(0, 0, 0),
                new Celda(StateCelda.CUADRADO, StateCelda.NARANJA, StateCelda.O),
                new Celda(0, 0, 0),
                new Celda(0, 0, 0),
                new Celda(StateCelda.HEXAGONO, StateCelda.NARANJA, StateCelda.O),
                new Celda(0, 0, 0)
        };

        Celda[] cs4 = {
                new Celda(StateCelda.HEXAGONO, StateCelda.ROJO, StateCelda.A),
                new Celda(0, 0, 0),
                new Celda(0, 0, 0),
                new Celda(StateCelda.CIRCULO, StateCelda.AZUL, StateCelda.I),
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
