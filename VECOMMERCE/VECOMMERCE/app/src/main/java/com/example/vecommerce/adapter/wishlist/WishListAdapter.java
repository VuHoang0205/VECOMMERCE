package com.example.vecommerce.adapter.wishlist;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vecommerce.R;
import com.example.vecommerce.base.BaseFragment;
import com.example.vecommerce.contants.KeyUtils;
import com.example.vecommerce.model.MyOrderModel;
import com.example.vecommerce.model.WishListModel;

import java.util.List;

import static com.example.vecommerce.contants.KeyUtils.ORDER_DETAIL_FRAGMENT;

public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.Viewholder> {

    private List<WishListModel> wishListModels;

    private BaseFragment.BaseFragmentListener listener;

    public WishListAdapter(List<WishListModel> myOrderModels) {
        this.wishListModels = myOrderModels;
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
//        MyOrderModel orderModel = wishListModels.get(i);
//        viewholder.setData(orderModel.getProductImage(), orderModel.getProductTitle(), orderModel.getDeliveryStatus(), orderModel.getRating());
//        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listener.onHandlerReult(ORDER_DETAIL_FRAGMENT, null);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return wishListModels.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productTitle;
        private TextView feeCoupen;
        private ImageView coupenIcon;
        private TextView totalRatings;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView paymentMethod;
        private ImageButton delete;

        Viewholder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.wish_list_image);
            productTitle = itemView.findViewById(R.id.wish_list_title);
            feeCoupen = itemView.findViewById(R.id.wish_list_bonuscart);
            coupenIcon = itemView.findViewById(R.id.wish_list_fee);
            totalRatings = itemView.findViewById(R.id.wish_list_totalranting);
            productPrice = itemView.findViewById(R.id.wish_list_product_price);
            cuttedPrice = itemView.findViewById(R.id.wish_list_price_cutted);
            paymentMethod = itemView.findViewById(R.id.wish_list_payment_method);
            delete = itemView.findViewById(R.id.wish_list_delete);

        }
    }
}
