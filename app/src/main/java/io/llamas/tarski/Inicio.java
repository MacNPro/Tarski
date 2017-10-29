package io.llamas.tarski;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.xmlpull.v1.XmlPullParser;

import io.llamas.tarski.CustomClasses.RalewayRegular;
import io.llamas.tarski.CustomClasses.RalewaySemiBold;

import static io.llamas.tarski.Utils.getResourceColor;

public class Inicio extends FragmentActivity {

    View espacio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        initViews();
        initActivity();
        initClickListeners();

    }

    /**
     * FUNCIONES INIT
     */

    private void initActivity() {

        Glide.with(this).load("https://image.ibb.co/gxeLo6/Screen_Shot_2017_10_28_at_3_31_13_PM.png").dontAnimate().into((ImageView) findViewById(R.id.portada));
        espacio.getLayoutParams().height = getScreenHeight();

        procesarTexto("<titulo>El Mundo de Tarski\n" +
                "#_\n" +
                "<texto>El mundo de Tarski es una aproximación educativa basada en ordenador al estudio de la lógica de primer orden. En esta aplicación aprenderás los conceptos básicos de la lógica de primer orden. Además, podrás crear tus sentencias y la aplicación regresará el valor de verdad de dicha sentencia. Al final, se encuentra un quiz para evaluar tus conocimientos.\n" +
                "#_\n" +
                "<titulo>Cuantificador Universal\n" +
                "#_\n" +
                "<texto>Sea Q(x) un predicado y D el dominio de Q. Una afirmación universal es una declaración de la forma: \n" +
                "#_\n" +
                "<img>https://image.ibb.co/cMUvo6/Captura_de_pantalla_2017_10_28_a_la_s_17_24_45.png\n" +
                "#_\n" +
                "<titulo>Cuantificador Existencial\n" +
                "#_\n" +
                "<texto>Sea Q(x) un predicado con dominio D. Una afirmación existencial es una declaración de la forma: \n" +
                "#_\n" +
                "<img>https://image.ibb.co/m3TMT6/Captura_de_pantalla_2017_10_28_a_la_s_17_24_35.png\n" +
                "#_\n" +
                "<titulo>¿Cuál es la diferencia entre los cuantificadores?\n" +
                "#_\n" +
                "<texto>Una afirmación universal sólo es verdadera si y sólo si Q(x) es verdadera para todo elemento x que está en el dominio. Mientras que, una afirmación existencial es verdadera si existe en el dominio al menos un valor de x para el cual Q(x) es verdadera.\n" +
                "#_\n" +
                "<img>https://image.ibb.co/fUpEWR/hola.jpg\n" +
                "#_\n" +
                "<titulo>Ejemplo - Mundo de Tarski\n" +
                "#_\n" +
                "<img>https://image.ibb.co/gxeLo6/Screen_Shot_2017_10_28_at_3_31_13_PM.png\n" +
                "#_\n" +
                "<texto_centrado>∀ = Toda\n" +
                "∃ = Alguna\n" +
                "#_\n" +
                "<texto>1- ∀x, círculo(t) V rojo(t)\n" +
                "El ejemplo anterior se traduce como: “Toda x es círculo o roja”. Esta sentencia tiene valor de falso por que existen x que no son ni círculo ni roja.\n" +
                "#_\n" +
                "<texto>2- ∃x, cuadrado(t) ^ rojo(t)\n" +
                "El ejemplo anterior se traduce como: “Alguna x es cuadrada y roja”. Esta sentencia tiene valor de verdadero pues existe al menos una x que efectivamente es cuadrada y roja.\n" +
                "#_\n" +
                "<texto>3- ∀x cuadrado(t) ^ rojo(t)\n" +
                "El ejemplo anterior se traduce como: “Toda x es cuadrada y roja”. Esta sentencia tiene valor de falso pues no todas las x son cuadradas y rojas.\n" +
                "#_\n" +
                "<titulo>¿Cómo escribir las sentencias?\n" +
                "#_\n" +
                "<texto>En la siguiente sección podrás crear tus sentencias a partir de una matriz mostrada y nuestra aplicación regresará su valor de verdad. Cada sentencia debe comenzar por un cuantificador(Toda, Alguna) , después, la variable x que nos servirá para representar las figuras de la matriz, la palabra: “es” y por último, las variables separadas por una conjunción o disyunción(Y o O). Las posibles variables son:\n" +
                "#_\n" +
                "<img>https://image.ibb.co/dtu9y6/22906536_602202680125256_1436334019_o.jpg\n" +
                "#_\n" +
                "<texto_centrado>Ejemplos\n" +
                "#_\n" +
                "<texto_centrado>Toda x es círculo y roja y A\n" +
                "Toda x es hexágono o verde o U\n" +
                "Alguna x es verde o O\n" +
                "Alguna x es cuadrado\n");

    }

    private void initViews() {

        espacio = findViewById(R.id.espacio);

    }

    private void initClickListeners() {

        findViewById(R.id.empezar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Inicio.this, Ejercicios.class);
                startActivity(i);
            }
        });

    }

    /**
     * FUNCIONES PRIMARIAS
     */

    private void procesarTexto(String texto) {

        int index = 0;
        int total = texto.split("\n#_\n").length;
        LinearLayout container = (LinearLayout) findViewById(R.id.contenido);

        for (String elemento : texto.split("\n#_\n")) {
            if (elemento.contains("<titulo>")) {

                elemento = elemento.replace("<titulo>", "");

                TextView titulo = new RalewaySemiBold(this, attributeSet("titulo"));
                titulo.setText(elemento);
                titulo.setTextColor(getResourceColor(this, R.color.texto_basico));
                titulo.setLayoutParams(getParams());

                container.addView(titulo);

            } else if (elemento.contains("<texto>")) {

                elemento = elemento.replace("<texto>", "");

                TextView titulo = new RalewaySemiBold(this, attributeSet("texto"));
                titulo.setText(elemento);
                titulo.setTextColor(getResourceColor(this, R.color.texto_basico));
                titulo.setLayoutParams(getParams());

                container.addView(titulo);

            } else if (elemento.contains("<texto_centrado>")) {

                elemento = elemento.replace("<texto_centrado>", "");

                TextView titulo = new RalewaySemiBold(this, attributeSet("texto_centrado"));
                titulo.setText(elemento);
                titulo.setTextColor(getResourceColor(this, R.color.texto_basico));
                titulo.setLayoutParams(getParams());

                container.addView(titulo);

            } else if (elemento.contains("<img>")) {

                elemento = elemento.replace("<img>", "");

                ImageView img = new ImageView(this);
                img.setLayoutParams(getParams());
                img.setScaleType(ImageView.ScaleType.CENTER_CROP);
                img.setAdjustViewBounds(true);
                Glide.with(this)
                        .load(elemento)
                        .error(R.drawable.error)
                        .dontAnimate()
                        .into(img);

                container.addView(img);

            } else {

                TextView textoDefault = new RalewayRegular(this, attributeSet("texto"));
                textoDefault.setText(String.format("Error: %s", elemento));
                textoDefault.setLayoutParams(getParams());

                container.addView(textoDefault);

            }

            print("" + index);
            index++;

        }
    }

    /**
     * FUNCIONES SECUNDARIAS
     */

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

    private LinearLayout.LayoutParams getParams() {

        int hori = Math.round(16 * getDimensiones());
        int vert = Math.round(32 * getDimensiones());

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(hori, vert, hori, 0);

        return params;
    }

    public AttributeSet attributeSet(String type) {

        XmlPullParser parser;

        switch (type) {

            case "titulo":
                parser = getResources().getXml(R.xml.titulo_style);
                break;

            case "texto_centrado":
                parser = getResources().getXml(R.xml.texto_centrado_style);
                break;

            case "texto":
                parser = getResources().getXml(R.xml.texto_style);
                break;

            default:
                parser = getResources().getXml(R.xml.texto_style);
                break;

        }

        try {
            parser.next();
            parser.nextTag();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Xml.asAttributeSet(parser);
    }

    /**
     * FUNCIONES HOUSEKEEPING
     */

}
