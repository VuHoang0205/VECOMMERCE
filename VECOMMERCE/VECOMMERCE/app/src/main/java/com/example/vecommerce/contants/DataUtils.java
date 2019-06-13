package com.example.vecommerce.contants;

import com.example.vecommerce.R;
import com.example.vecommerce.adapter.Categoies;
import com.example.vecommerce.adapter.ProductHorizontalModel;
import com.example.vecommerce.adapter.SliderModel;
import com.example.vecommerce.adapter.productdetail.ProductSpecificationModel;
import com.example.vecommerce.model.CartModel;
import com.example.vecommerce.model.MyOrderModel;
import com.example.vecommerce.productdetail.ProductSpecificationFragment;

import java.util.ArrayList;
import java.util.List;

public class DataUtils {

    public static List<Categoies> getCategories() {
        List<Categoies> categoies = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            categoies.add(new Categoies());
        }
        return categoies;
    }

    public static List<SliderModel> getSliderList() {
        List<SliderModel> sliderList = new ArrayList<>();
        sliderList.add(new SliderModel(R.drawable.banner1));
        sliderList.add(new SliderModel(R.drawable.banner2));
        sliderList.add(new SliderModel(R.drawable.banner3));
        sliderList.add(new SliderModel(R.drawable.banner4));
        sliderList.add(new SliderModel(R.drawable.banner5));
        sliderList.add(new SliderModel(R.drawable.banner6));
        sliderList.add(new SliderModel(R.drawable.banner7));
        sliderList.add(new SliderModel(R.drawable.banner8));
        sliderList.add(new SliderModel(R.drawable.banner9));
        return sliderList;
    }

    public static List<ProductHorizontalModel> getProductList() {
        List<ProductHorizontalModel> productList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            productList.add(new ProductHorizontalModel(R.drawable.image_xoami, "Xoami 8 Lite", "Siêu phẩm 2019", "4950"));

        }
        return productList;
    }

    public static List<Integer> getImageList() {
        List<Integer> productList = new ArrayList<>();
        productList.add(R.drawable.image_xoami);
        productList.add(R.drawable.image_xoami);
        productList.add(R.drawable.image_xoami);
        productList.add(R.drawable.image_xoami);
        productList.add(R.drawable.image_xoami);
        return productList;
    }

    public static List<ProductSpecificationModel> getProductSpecfiition() {
        List<ProductSpecificationModel> productList = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            if (i % 5 == 0) {
                productList.add(new ProductSpecificationModel(0, "Gerenal"));
            } else {
                productList.add(new ProductSpecificationModel(1, "RAM", "4GB"));
            }
        }
        return productList;
    }

    public static List<CartModel> getModelCart() {
        List<CartModel> productList = new ArrayList<>();
        for (int i = 1; i < 16; i++) {
            if (i % 5 == 0) {
                productList.add(new CartModel(1, "Price (3 item)", "RS 169999/-", "Free", "Rs 5999/-"));
            } else {
                productList.add(new CartModel(0, R.drawable.image_xoami, "Xoami 8 Lite", 2, "Rs 49999/-", "Rs 59999/-", 1, 0, 0));
            }
        }
        return productList;
    }

    public static List<MyOrderModel> getMyorderModel() {
        List<MyOrderModel> productList = new ArrayList<>();
        for (int i = 1; i < 16; i++) {
            if (i % 5 == 0) {
                productList.add(new MyOrderModel(R.drawable.image_xoami, 3, "Xoami 8 Lite", KeyUtils.CANNEL));

            } else {
                productList.add(new MyOrderModel(R.drawable.image_xoami, 4, "Xoami 8 Lite", "Delivered on Mon, 28th JAN 2013"));
            }
        }
        return productList;
    }
}
