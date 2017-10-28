package io.llamas.tarski;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import java.util.ArrayList;
import java.util.Arrays;

import io.llamas.tarski.Adapters.TablaAdapter;
import io.llamas.tarski.CustomClasses.RalewayRegular;
import io.llamas.tarski.CustomClasses.RalewaySemiBold;
import io.llamas.tarski.Model.Celda;
import io.llamas.tarski.Model.Tabla;

import static io.llamas.tarski.Utils.getResourceColor;

public class Ejercicios extends Activity {

    RecyclerView recyclerView;

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

    }

    private void initClickListeners() {

    }

    /**
     * FUNCIONES PRIMARIAS
     */


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
