package com.example.vecommerce.contants;

import com.example.vecommerce.R;
import com.example.vecommerce.adapter.Categoies;
import com.example.vecommerce.adapter.ProductHorizontalModel;
import com.example.vecommerce.adapter.SliderModel;

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
}
