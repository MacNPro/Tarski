package io.llamas.tarski;

import android.content.Context;
import android.support.v4.content.ContextCompat;

/**
 * Created by MacNPro on 7/6/17.
 */

public class Utils {

    public static class StateCelda {

        public static final int NONE = 0;
        public static final int CUADRADO = 1;
        public static final int HEXAGONO = 2;
        public static final int CIRCULO = 3;
        public static final int ROJO = 4;
        public static final int VERDE = 5;
        public static final int NARANJA = 6;
        public static final int AZUL = 7;
        public static final int A = 8;
        public static final int E = 9;
        public static final int I = 10;
        public static final int O = 11;
        public static final int U = 12;

    }

    public static String[] STATECELDA = {
            "NONE",
            "cuadrado",
            "hexagono",
            "circulo",
            "rojo",
            "verde",
            "naranja",
            "azul",
            "a",
            "e",
            "i",
            "o",
            "u"
    };

    public static int[] STATECUADRADOS = {
            0,
            0,
            0,
            0,
            R.drawable.cuadrado_rojo,
            R.drawable.cuadrado_verde,
            R.drawable.cuadrado_naranja,
            R.drawable.cuadrado_azul
    };

    public static int[] STATECIRCULOS = {
            0,
            0,
            0,
            0,
            R.drawable.circulo_rojo,
            R.drawable.circulo_verde,
            R.drawable.circulo_naranja,
            R.drawable.circulo_azul
    };

    public static int[] STATEHEXAGONO = {
            0,
            0,
            0,
            0,
            R.drawable.medalla_rojo,
            R.drawable.medalla_verde,
            R.drawable.medalla_naranja,
            R.drawable.medalla_azul,
    };

    public static String[] BOCALES = {
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "A",
            "E",
            "I",
            "O",
            "U"
    };

    public static String[] COLORS_INDEX = {
            "naranja",
            "amarillo",
            "verde",
            "fosfo",
            "cyan",
            "azul",
            "azul_rey",
            "morado",
            "purpura",
            "rosa",
            "rojo",
    };

    public static int[] COLORS = {
            R.color.naranja,
            R.color.amarillo,
            R.color.verde,
            R.color.fosfo,
            R.color.cyan,
            R.color.azul,
            R.color.azul_rey,
            R.color.morado,
            R.color.purpura,
            R.color.rosa,
            R.color.rojo,
    };

    public static int[] MEDALLAS = {
            R.drawable.medalla_naranja,
            R.drawable.medalla_amarillo,
            R.drawable.medalla_verde,
            R.drawable.medalla_fosfo,
            R.drawable.medalla_cyan,
            R.drawable.medalla_azul,
            R.drawable.medalla_azul_rey,
            R.drawable.medalla_morado,
            R.drawable.medalla_purpura,
            R.drawable.medalla_rosa,
            R.drawable.medalla_rojo,
    };

    public static int[] TARJETAS_GRADIENT = {
            R.drawable.tarjeta_gradient_naranja,
            R.drawable.tarjeta_gradient_amarillo,
            R.drawable.tarjeta_gradient_verde,
            R.drawable.tarjeta_gradient_fosfo,
            R.drawable.tarjeta_gradient_cyan,
            R.drawable.tarjeta_gradient_azul,
            R.drawable.tarjeta_gradient_azul_rey,
            R.drawable.tarjeta_gradient_morado,
            R.drawable.tarjeta_gradient_purpura,
            R.drawable.tarjeta_gradient_rosa,
            R.drawable.tarjeta_gradient_rojo,
    };

    public static int[] TARJETAS_GRADIENT_TOP = {
            R.drawable.tarjeta_top_naranja,
            R.drawable.tarjeta_top_amarillo,
            R.drawable.tarjeta_top_verde,
            R.drawable.tarjeta_top_fosfo,
            R.drawable.tarjeta_top_cyan,
            R.drawable.tarjeta_top_azul,
            R.drawable.tarjeta_top_azul_rey,
            R.drawable.tarjeta_top_morado,
            R.drawable.tarjeta_top_purpura,
            R.drawable.tarjeta_top_rosa,
            R.drawable.tarjeta_top_rojo,
    };

    public static int[] CIRCULOS_GRADIENT = {
            R.drawable.circulo_gradient_naranja,
            R.drawable.circulo_gradient_amarillo,
            R.drawable.circulo_gradient_verde,
            R.drawable.circulo_gradient_fosfo,
            R.drawable.circulo_gradient_cyan,
            R.drawable.circulo_gradient_azul,
            R.drawable.circulo_gradient_azul_rey,
            R.drawable.circulo_gradient_morado,
            R.drawable.circulo_gradient_purpura,
            R.drawable.circulo_gradient_rosa,
            R.drawable.circulo_gradient_rojo,
    };

    public static int[] CIRCULOS = {
            R.drawable.circulo_naranja,
            R.drawable.circulo_amarillo,
            R.drawable.circulo_verde,
            R.drawable.circulo_fosfo,
            R.drawable.circulo_cyan,
            R.drawable.circulo_azul,
            R.drawable.circulo_azul_rey,
            R.drawable.circulo_morado,
            R.drawable.circulo_purpura,
            R.drawable.circulo_rosa,
            R.drawable.circulo_rojo,
    };

    public static int[] TARJETAS = {
            R.drawable.tarjeta_naranja,
            R.drawable.tarjeta_amarillo,
            R.drawable.tarjeta_verde,
            R.drawable.tarjeta_fosfo,
            R.drawable.tarjeta_cyan,
            R.drawable.tarjeta_azul,
            R.drawable.tarjeta_azul_rey,
            R.drawable.tarjeta_morado,
            R.drawable.tarjeta_purpura,
            R.drawable.tarjeta_rosa,
            R.drawable.tarjeta_rojo,
    };

    public static int getResourceColor(Context c, int res) {
        return ContextCompat.getColor(c, res);
    }

}
