package com.example.task9.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.task9.R;

public class AdvertViewHolder extends RecyclerView.ViewHolder {

    private TextView name,desc;

    public AdvertViewHolder(View itemView){
        super(itemView);
        name=itemView.findViewById(R.id.textViewName);
        desc= itemView.findViewById(R.id.textViewDescription);
    }

    void bind(int idValue, String nameValue, String descriptionValue){
        name.setText(nameValue);
        desc.setText(descriptionValue);
    }

    public static AdvertViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item_view, parent, false);
        return new AdvertViewHolder(view);
    }

}
