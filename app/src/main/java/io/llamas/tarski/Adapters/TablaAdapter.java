package io.llamas.tarski.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import io.llamas.tarski.CustomClasses.RalewayBold;
import io.llamas.tarski.Model.Celda;
import io.llamas.tarski.R;
import io.llamas.tarski.Utils;

import static io.llamas.tarski.Utils.BOCALES;
import static io.llamas.tarski.Utils.STATECIRCULOS;
import static io.llamas.tarski.Utils.STATECUADRADOS;
import static io.llamas.tarski.Utils.STATEHEXAGONO;

public class TablaAdapter extends RecyclerView.Adapter<TablaAdapter.ViewHolder> {

    private List<Celda> celdas;
    private Context context;
    private double density;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView texto;
        ImageView forma;

        ViewHolder(View v) {
            super(v);

            forma = (ImageView) v.findViewById(R.id.forma);
            texto = (RalewayBold) v.findViewById(R.id.texto);

        }

    }

    public TablaAdapter(Context context, List<Celda> cursos) {
        this.celdas = cursos;
        this.context = context;
        this.density = context.getResources().getDisplayMetrics().density;
    }

    @Override
    public TablaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_celda, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Celda c = celdas.get(position);

        if (c.getColor() != Utils.StateCelda.NONE) {

            if (c.getForma() == Utils.StateCelda.CUADRADO) {

                holder.forma.setImageResource(STATECUADRADOS[c.getColor()]);

            } else if (c.getForma() == Utils.StateCelda.HEXAGONO) {

                holder.forma.setImageResource(STATEHEXAGONO[c.getColor()]);

            } else {

                holder.forma.setImageResource(STATECIRCULOS[c.getColor()]);

            }

            holder.texto.setText(BOCALES[c.getBocal()]);

        }

    }

    @Override
    public int getItemCount() {
        return celdas.size();
    }

    void print(String text) {
        Log.d(this.getClass().getSimpleName(), text);
    }

    private void setMargin(View view, int position) {

        int space6 = (int) Math.round(6 * density);
        int space12 = (int) Math.round(12 * density);

        boolean esPrimero = position == 0;
        boolean esSegundo = position == 1;
        boolean esUltimo = position == celdas.size() - 1;
        boolean esPenultimo = position == celdas.size() - 2;
        boolean esIzquierda = position % 2 == 0;
        boolean esDerecha = position % 2 == 1;

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                (int) Math.round(180 * density)
        );

        if (esPenultimo && esIzquierda) {
            params.setMargins(space12, space6, space6, space12);
            view.setLayoutParams(params);
        } else if (esUltimo && esIzquierda) {
            params.setMargins(space12, space6, space6, space12);
            view.setLayoutParams(params);
        } else if (esUltimo && esDerecha) {
            params.setMargins(space6, space6, space12, space12);
            view.setLayoutParams(params);
        } else if (esPrimero) {
            params.setMargins(space12, space12, space6, space6);
            view.setLayoutParams(params);
        } else if (esSegundo) {
            params.setMargins(space6, space12, space12, space6);
            view.setLayoutParams(params);
        } else if (esIzquierda) {
            params.setMargins(space12, space6, space6, space6);
            view.setLayoutParams(params);
        } else if (esDerecha) {
            params.setMargins(space6, space6, space12, space6);
            view.setLayoutParams(params);
        }
    }

}


