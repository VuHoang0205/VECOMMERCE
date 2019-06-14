package com.example.vecommerce.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vecommerce.R;
import com.example.vecommerce.base.BaseFragment;

import java.util.List;

public class ProductHorizontalAdapter extends RecyclerView.Adapter<ProductHorizontalAdapter.ViewHolder> {

    List<ProductHorizontalModel> products;

    private BaseFragment.BaseFragmentListener listener;

    public ProductHorizontalAdapter(List<ProductHorizontalModel> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_srcoll_item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ProductHorizontalModel product = products.get(i);
        viewHolder.image.setImageResource(product.getProductIamge());
        viewHolder.title.setText(product.getProductTitle());
        viewHolder.description.setText(product.getProductDescription());
        viewHolder.price.setText(product.getProductPrice());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(listener!=null){
                   listener.onHandlerReult(1,null);
               }
            }
        });
    }

    public void setListener(BaseFragment.BaseFragmentListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        TextView description;
        TextView price;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.product_image);
            title = itemView.findViewById(R.id.product_title);
            description = itemView.findViewById(R.id.product_description);
            price = itemView.findViewById(R.id.product_price);
        }
    }
}

