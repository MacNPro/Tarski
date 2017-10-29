package io.llamas.tarski;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import io.llamas.tarski.Adapters.TablaAdapter;
import io.llamas.tarski.CustomClasses.RalewayBold;
import io.llamas.tarski.Model.Celda;
import io.llamas.tarski.Model.Tabla;

import static io.llamas.tarski.Utils.STATECELDA;


public class Ejercicios extends Activity {

    ImageView iconColor;
    RecyclerView recyclerView;
    EditText input;
    TextView iconText;

    Tabla tabla = new Tabla();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios);

        initViews();
        initActivity();
        initClickListeners();

    }

    /**
     * FUNCIONES INIT
     */

    private void initActivity() {

        setLayoutManager(recyclerView);
        recyclerView.setAdapter(new TablaAdapter(this, tabla.getArray()));

    }

    private void initViews() {

        recyclerView = findViewById(R.id.recyclerView);
        input = findViewById(R.id.input);
        iconColor = (ImageView) findViewById(R.id.iconColor);
        iconText = (RalewayBold) findViewById(R.id.iconText);

    }

    private void initClickListeners() {

        findViewById(R.id.regresar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.checar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = input.getText().toString();
                String msg = verificarSentencia(txt);

                if (msg.equals("Válido")) {
                    if (evaluarSentencia(txt)) {
                        Toast.makeText(Ejercicios.this, "Verdadero", Toast.LENGTH_SHORT).show();
                        iconColor.setImageResource(R.drawable.circulo_verde);
                        iconText.setText("T");
                    } else {
                        Toast.makeText(Ejercicios.this, "Falso", Toast.LENGTH_SHORT).show();
                        iconColor.setImageResource(R.drawable.circulo_rojo);
                        iconText.setText("F");
                    }
                } else {
                    Toast.makeText(Ejercicios.this, msg, Toast.LENGTH_SHORT).show();
                    iconColor.setImageResource(R.drawable.circulo_rojo);
                    iconText.setText("!");
                }

            }
        });

    }

    /**
     * FUNCIONES PRIMARIAS
     */

    private String verificarSentencia(String s) {

        String[] sentenciaArr = s.toLowerCase().split(" ");
        int size = sentenciaArr.length;

        if (size > 0)
            if (!sentenciaArr[0].contains("toda") && !sentenciaArr[0].contains("alguna")) // Cuantificador
                return "El cuantificador no es correcto, utiliza Toda / Alguna";

        if (size > 1)
            if (!sentenciaArr[1].contains("x")) // Variable
                return "La variable no es correcta, utiliza \"x\"";

        if (size > 2)
            if (!sentenciaArr[2].contains("es")) // Es
                return "Sentenica mal formada, utiliza \"es\" despues de \"x\"";

        if (size > 3)
            if (!Arrays.asList(STATECELDA).contains(sentenciaArr[3])) // Primera Propiedad
                return "Propiedad invalida";

        if (size > 4)
            if (!sentenciaArr[4].contains("y") && !sentenciaArr[4].contains("o")) // && - ||
                return "Sentencia mal formada, utiliza y/o";

        if (size > 5)
            if (!Arrays.asList(STATECELDA).contains(sentenciaArr[5])) // Segunda Propiedad
                return "Propiedad invalida";

        if (size > 6)
            if (!sentenciaArr[6].contains("y") && !sentenciaArr[6].contains("o")) // && - ||
                return "Sentencia mal formada, utiliza y/o";

        if (size > 7)
            if (!Arrays.asList(STATECELDA).contains(sentenciaArr[7])) // Tercera Propiedad
                return "Propiedad invalida";

        if (size == 4 || size == 6 || size == 8)
            return "Válido";
        else
            return "Sentencia incompleta";

    }

    private boolean evaluarSentencia(String s) {

        String[] sentenciaArr = s.toLowerCase().split(" ");
        int size = sentenciaArr.length;
        int total = 0;
        int count = 0;

        if (size == 4) {

            int indexP1 = Arrays.asList(STATECELDA).indexOf(sentenciaArr[3]);

            for (Celda celda : tabla.getArray()) {

                boolean tieneP1 = celda.getForma() == indexP1 || celda.getColor() == indexP1 || celda.getBocal() == indexP1;

                if (tieneP1)
                    count++;

                if (celda.getForma() != 0 || celda.getColor() != 0 || celda.getBocal() != 0)
                    total++;

            }

        }


        if (size == 6) {

            int indexP1 = Arrays.asList(STATECELDA).indexOf(sentenciaArr[3]);
            int indexP2 = Arrays.asList(STATECELDA).indexOf(sentenciaArr[5]);

            for (Celda celda : tabla.getArray()) {

                boolean tieneP1 = celda.getForma() == indexP1 || celda.getColor() == indexP1 || celda.getBocal() == indexP1;
                boolean tieneP2 = celda.getForma() == indexP2 || celda.getColor() == indexP2 || celda.getBocal() == indexP2;

                if (sentenciaArr[4].equals("y")) {
                    if (tieneP1 && tieneP2)
                        count++;
                } else {
                    if (tieneP1 || tieneP2)
                        count++;
                }

                if (celda.getForma() != 0 || celda.getColor() != 0 || celda.getBocal() != 0)
                    total++;
            }

        }

        if (size == 8) {

            int indexP1 = Arrays.asList(STATECELDA).indexOf(sentenciaArr[3]);
            int indexP2 = Arrays.asList(STATECELDA).indexOf(sentenciaArr[5]);
            int indexP3 = Arrays.asList(STATECELDA).indexOf(sentenciaArr[7]);

            int i = 0;
            for (Celda celda : tabla.getArray()) {

                i++;

                boolean propiedadesSumadas;
                boolean tieneP1 = celda.getForma() == indexP1 || celda.getColor() == indexP1 || celda.getBocal() == indexP1;
                boolean tieneP2 = celda.getForma() == indexP2 || celda.getColor() == indexP2 || celda.getBocal() == indexP2;
                boolean tieneP3 = celda.getForma() == indexP3 || celda.getColor() == indexP3 || celda.getBocal() == indexP3;

                if (sentenciaArr[4].equals("y")) {
                    propiedadesSumadas = tieneP1 && tieneP2;
                } else {
                    propiedadesSumadas = tieneP1 || tieneP2;
                }

                if (sentenciaArr[6].equals("y")) {
                    if (propiedadesSumadas && tieneP3)
                        count++;
                } else {
                    if (propiedadesSumadas || tieneP3)
                        count++;
                }

                print("Celda: " + count);

                if (celda.getForma() != 0 || celda.getColor() != 0 || celda.getBocal() != 0)
                    total++;
            }

        }

        print("Total: " + total + " Cuenta: " + count);
        if (sentenciaArr[0].equals("toda")) {
            return total == count;
        } else {
            return count > 0;
        }

    }


    /**
     * FUNCIONES SECUNDARIAS
     */

    public void setLayoutManager(RecyclerView rv) {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 6);
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);
    }

    private int getScreenHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private float getDimensiones() {
        return getResources().getDisplayMetrics().density;
    }

    private void print(String text) {
        Log.d(this.getClass().getSimpleName(), text);
    }

    /**
     * FUNCIONES HOUSEKEEPING
     */
}
