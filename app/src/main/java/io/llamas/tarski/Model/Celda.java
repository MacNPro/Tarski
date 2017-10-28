package io.llamas.tarski.Model;

/**
 * Created by MacNPro on 10/28/17.
 */

public class Celda {

    private int forma;
    private int color;
    private int bocal;

    public Celda() {
    }

    public Celda(int forma, int color, int bocal) {
        this.forma = forma;
        this.color = color;
        this.bocal = bocal;
    }

    public int getForma() {
        return forma;
    }

    public void setForma(int forma) {
        this.forma = forma;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getBocal() {
        return bocal;
    }

    public void setBocal(int bocal) {
        this.bocal = bocal;
    }

}
