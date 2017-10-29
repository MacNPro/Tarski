package io.llamas.tarski;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.Arrays;

import io.llamas.tarski.Adapters.TablaAdapter;
import io.llamas.tarski.CustomClasses.RalewayBold;
import io.llamas.tarski.CustomClasses.RalewayRegular;
import io.llamas.tarski.CustomClasses.RalewaySemiBold;
import io.llamas.tarski.Model.Celda;
import io.llamas.tarski.Model.Tabla;

import static io.llamas.tarski.Utils.TODAS;
import static io.llamas.tarski.Utils.getResourceColor;

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

        findViewById(R.id.checar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = input.getText().toString();
                String msg = verificarSentencia(txt);
                Toast.makeText(Ejercicios.this, msg, Toast.LENGTH_SHORT).show();

                if (msg.equals("Válido")) {
                    String[] sentenciaArr = txt.toLowerCase().split(" ");
                    if (sentenciaArr[0].equals("toda")) {
                        todaX(txt);
                    } else {
                        algunaX(txt);
                    }
                } else {
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

        s = s.toLowerCase();
        String[] sentenciaArr = s.split(" ");
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
            if (!Arrays.asList(TODAS).contains(sentenciaArr[3])) // Primera Propiedad
                return "Propiedad invalida";

        if (size > 4)
            if (!sentenciaArr[4].contains("y") && !sentenciaArr[4].contains("o")) // && - ||
                return "Sentencia mal formada, utiliza y/o";

        if (size > 5)
            if (!Arrays.asList(TODAS).contains(sentenciaArr[5])) // Segunda Propiedad
                return "Propiedad invalida";

        if (size > 6)
            if (!sentenciaArr[6].contains("y") && !sentenciaArr[6].contains("o")) // && - ||
                return "Sentencia mal formada, utiliza y/o";

        if (size > 7)
            if (!Arrays.asList(TODAS).contains(sentenciaArr[7])) // Tercera Propiedad
                return "Propiedad invalida";

        if (size == 4 || size == 6 || size == 8)
            return "Válido";
        else
            return "Sentencia incompleta";

    }

    private void todaX(String s) {

    }

    private void algunaX(String s) {

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
