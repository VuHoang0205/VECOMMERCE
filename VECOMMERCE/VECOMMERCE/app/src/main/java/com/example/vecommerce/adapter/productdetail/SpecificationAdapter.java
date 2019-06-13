package com.example.vecommerce.adapter.productdetail;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        switch (getItemViewType(i)) {
            case ProductSpecificationModel.SPECIFICATION_TITLE:
                TextView title = new TextView(viewGroup.getContext());
                title.setTypeface(null, Typeface.BOLD);
                title.setTextColor(Color.BLACK);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(setDp(16, viewGroup.getContext()), setDp(16, viewGroup.getContext()), setDp(16, viewGroup.getContext()), setDp(16, viewGroup.getContext()));
                title.setLayoutParams(layoutParams);
                return new ViewHolder(title);
            case ProductSpecificationModel.SPECIFICATION_BODY:
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_product_description, viewGroup, false);
                return new ViewHolder(view);
            default:
                return null;
        }
    }

    private int setDp(int i, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, i, context.getResources().getDisplayMetrics());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case ProductSpecificationModel.SPECIFICATION_TITLE:
                viewHolder.setTitle(specificationModels.get(i).getTitle());

                break;
            case ProductSpecificationModel.SPECIFICATION_BODY:
                ProductSpecificationModel specificationModel = specificationModels.get(i);
                viewHolder.name.setText(specificationModel.getFeatureName());
                viewHolder.value.setText(specificationModel.getFeatureValue());
                break;
            default:
                return;
        }

    }

    @Override
    public int getItemViewType(int position) {
        switch (specificationModels.get(position).getType()) {
            case 0:
                return ProductSpecificationModel.SPECIFICATION_TITLE;
            case 1:
                return ProductSpecificationModel.SPECIFICATION_BODY;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return specificationModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView value;
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textView);
            value = itemView.findViewById(R.id.textView1);

        }
        private void setTitle(String text){
            title = (TextView) itemView;
            title.setText(text);
        }
    }
}

