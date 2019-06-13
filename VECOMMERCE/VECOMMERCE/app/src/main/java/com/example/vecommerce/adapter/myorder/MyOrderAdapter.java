package com.example.vecommerce.adapter.myorder;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vecommerce.R;
import com.example.vecommerce.base.BaseFragment;
import com.example.vecommerce.contants.KeyUtils;
import com.example.vecommerce.model.MyOrderModel;

import java.util.List;

import static com.example.vecommerce.contants.KeyUtils.ORDER_DETAIL_FRAGMENT;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.Viewholder> {

    private List<MyOrderModel> myOrderModels;

    private BaseFragment.BaseFragmentListener listener;

    public MyOrderAdapter(List<MyOrderModel> myOrderModels) {
        this.myOrderModels = myOrderModels;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_myoder_layout, viewGroup, false);
        return new Viewholder(view);
    }

    public void setListener(BaseFragment.BaseFragmentListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int i) {
        MyOrderModel orderModel = myOrderModels.get(i);
        viewholder.setData(orderModel.getProductImage(), orderModel.getProductTitle(), orderModel.getDeliveryStatus(), orderModel.getRating());
        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onHandlerReult(ORDER_DETAIL_FRAGMENT, null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myOrderModels.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productTitle;
        private TextView deliveryStatus;
        private ImageView indicator;
        private LinearLayout ratingContainer;

        Viewholder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.product_image_myoder);
            productTitle = itemView.findViewById(R.id.tv_title_order);
            deliveryStatus = itemView.findViewById(R.id.tv_bonus_order);
            indicator = itemView.findViewById(R.id.indicator_order);
            ratingContainer = itemView.findViewById(R.id.rating_container);
        }

        private void setData(int res, String title, String delivery, int rating) {
            productImage.setImageResource(res);
            productTitle.setText(title);
            deliveryStatus.setText(delivery);
            if (delivery.equals(KeyUtils.CANNEL)) {
                indicator.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            } else {
                indicator.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            }
            // Ratingbar
            settingRatingbar(rating - 1);
            for (int i = 0; i < ratingContainer.getChildCount(); i++) {
                final int starPosition = i;
                ratingContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        settingRatingbar(starPosition);
                    }
                });
            }

        }

        private void settingRatingbar(int pos) {
            for (int i = 0; i < ratingContainer.getChildCount(); i++) {
                ImageView starBtn = (ImageView) ratingContainer.getChildAt(i);
                starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
                if (i <= pos) {
                    starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffbb00")));
                }
            }
        }

    }
}
