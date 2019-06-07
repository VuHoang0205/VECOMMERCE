package com.example.vecommerce.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vecommerce.R;

import java.util.List;

public class CategorieAdapter extends RecyclerView.Adapter<CategorieAdapter.ViewHolder> {

    List<Categoies> categoies;

    public CategorieAdapter(List<Categoies> categoies) {
        this.categoies = categoies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_category, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Categoies categoie = categoies.get(i);

    }

    @Override
    public int getItemCount() {
        return categoies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.ivIcon);
            name = itemView.findViewById(R.id.tvName);
        }
    }
}

