package com.example.vecommerce.productdetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.example.vecommerce.R;
import com.example.vecommerce.base.BaseFragment;
import com.example.vecommerce.databinding.FragmentProductDescriptionBinding;

public class ProductDescriptionFragment extends BaseFragment<FragmentProductDescriptionBinding> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(">>>>>>", "onCreate ProductDescriptionFragment");
    }

    @Override
    protected void onInitComponents() {

    }

    @Override
    protected void onClickAction() {

    }

    @Override
    public void onCreateView(FragmentProductDescriptionBinding viewDataBinding) {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_product_description;
    }
}
