package com.example.activirty21;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class friendAdapter extends RecyclerView.Adapter<friendAdapter.friendViewHolder> {

    public static class friendViewHolder extends RecyclerView.ViewHolder{

        public TextView nombre, hobby;

        public friendViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.nombre);
            hobby = itemView.findViewById(R.id.hobby);

        }
    }

    private ArrayList<String> amigos;
    private View.OnClickListener listener;

    public friendAdapter(ArrayList<String> amigos, View.OnClickListener listener){

        this.amigos = amigos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public friendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        Button b = v.findViewById(R.id.botoncito);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.wtf("STUDENT ADAPTER", "CLICKEADO");
            }
        });

        v.setOnClickListener(listener);

        friendViewHolder svh = new friendViewHolder(v);
        return svh;

    }

    @Override
    public void onBindViewHolder(@NonNull friendViewHolder holder, int position) {

        holder.nombre.setText((amigos.get(position)));
        holder.hobby.setText(amigos.get(position));

    }

    @Override
    public int getItemCount() {
        return amigos.size();
    }


}
