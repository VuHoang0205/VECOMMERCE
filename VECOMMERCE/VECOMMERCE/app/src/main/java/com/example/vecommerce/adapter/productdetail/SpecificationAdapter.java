package com.example.vecommerce.adapter.productdetail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vecommerce.R;
import com.example.vecommerce.adapter.Categoies;
import com.example.vecommerce.adapter.IRecyclerviewItemOnlick;

import java.util.List;

public class SpecificationAdapter extends RecyclerView.Adapter<SpecificationAdapter.ViewHolder> {

    List<ProductSpecificationModel> specificationModels;

    public SpecificationAdapter(List<ProductSpecificationModel> specificationModels) {
        this.specificationModels = specificationModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_product_description, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ProductSpecificationModel specificationModel = specificationModels.get(i);
        viewHolder.name.setText(specificationModel.getFeatureName());
        viewHolder.value.setText(specificationModel.getFeatureValue());


    }

    @Override
    public int getItemCount() {
        return specificationModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView value;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textView);
            value = itemView.findViewById(R.id.textView1);
        }
    }
}

