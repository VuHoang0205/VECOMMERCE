package com.example.vecommerce.adapter.cartitem;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vecommerce.R;
import com.example.vecommerce.model.CartModel;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<CartModel> cartModelList;

    public CartAdapter(List<CartModel> cartModelList) {
        this.cartModelList = cartModelList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case CartModel.CARD_ITEM:
                View cartView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cart_layout, viewGroup, false);
                return new ViewHolderCartItem(cartView);
            case CartModel.TOTAL_AMOUNT:
                View totalView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_total_amount_layout, viewGroup, false);
                return new ViewHolderTotalItem(totalView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        CartModel cartModel = cartModelList.get(i);
        if (cartModel.getType() == CartModel.CARD_ITEM) {
            int res = cartModel.getPrductImage();
            String title = cartModel.getProductTitle();
            int feeCoupen = cartModel.getFeeCoupen();
            String productPrice = cartModel.getProductPrice();
            String cuttedPrice = cartModel.getCuttedPrice();
            int offerApllied = cartModel.getOffersApplies();
            ((ViewHolderCartItem) viewHolder).setItemDetail(res, title, feeCoupen, productPrice, cuttedPrice, offerApllied);
        } else {
            String totalItems = cartModel.getTotalItem();
            String totalPrice = cartModel.getProductTitle();
            String deliveryPrice = cartModel.getDeliveryPrice();
            String totalAmount = cartModel.getTotalAmount();
            String saveAmount = cartModel.getSaveAmount();
            ((ViewHolderTotalItem) viewHolder).setTotalItem(totalItems, deliveryPrice, deliveryPrice, totalAmount, saveAmount);
        }
    }


    @Override
    public int getItemCount() {
        return cartModelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (cartModelList.get(position).getType()) {
            case 0:
                return CartModel.CARD_ITEM;
            case 1:
                return CartModel.TOTAL_AMOUNT;
            default:
                return -1;
        }
    }

    class ViewHolderCartItem extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private ImageView feeCouponicon;
        private TextView productTitle;
        private TextView freeCoupens;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView offersApplies;
        private TextView coupensApplies;
        private TextView productQuantity;


        ViewHolderCartItem(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.iv_avatar_cart);
            feeCouponicon = itemView.findViewById(R.id.icon_fee);
            productTitle = itemView.findViewById(R.id.tv_name_cart);
            freeCoupens = itemView.findViewById(R.id.tv_bonus_cart);
            productPrice = itemView.findViewById(R.id.tv_price_cart);
            cuttedPrice = itemView.findViewById(R.id.product_price_cutted_cart);
            offersApplies = itemView.findViewById(R.id.tv_bonus_price_cart);
            coupensApplies = itemView.findViewById(R.id.tv_coupn_price_cart);
            productQuantity = itemView.findViewById(R.id.tv_quantity_cart);

        }

        private void setItemDetail(int res, String title, int feeCoupen, String mProductPrice, String mCuttedPrice, int mOffersAplies) {
            productImage.setImageResource(res);
            productTitle.setText(title);
            if (feeCoupen > 0) {
                feeCouponicon.setVisibility(View.VISIBLE);
                freeCoupens.setVisibility(View.VISIBLE);
                if (feeCoupen == 1) {
                    freeCoupens.setText("Free:" + feeCoupen + "Coupen");
                } else {
                    freeCoupens.setText("Free:" + feeCoupen + "Coupes");
                }
            } else {
                feeCouponicon.setVisibility(View.GONE);
                freeCoupens.setVisibility(View.GONE);
            }
            productPrice.setText(mProductPrice);
            cuttedPrice.setText(mCuttedPrice);
            if (mOffersAplies > 0) {
                offersApplies.setVisibility(View.VISIBLE);
                offersApplies.setText(offersApplies + "Offers applied");
            } else {
                offersApplies.setVisibility(View.GONE);
            }

        }

    }

    class ViewHolderTotalItem extends RecyclerView.ViewHolder {

        private TextView totalItems;
        private TextView totalPrice;
        private TextView deliveryPrice;
        private TextView totalAmount;
        private TextView saveAmount;


        ViewHolderTotalItem(@NonNull View itemView) {
            super(itemView);
            totalItems = itemView.findViewById(R.id.total_item);
            totalPrice = itemView.findViewById(R.id.total_price);
            deliveryPrice = itemView.findViewById(R.id.delivery);
            totalAmount = itemView.findViewById(R.id.total_amount);
            saveAmount = itemView.findViewById(R.id.saveItem);


        }

        private void setTotalItem(String item, String price, String delivery, String amount, String mSaveAmount) {
            totalItems.setText(item);
            totalPrice.setText(price);
            deliveryPrice.setText(delivery);
            totalAmount.setText(amount);
            saveAmount.setText(mSaveAmount);
        }
    }
}
