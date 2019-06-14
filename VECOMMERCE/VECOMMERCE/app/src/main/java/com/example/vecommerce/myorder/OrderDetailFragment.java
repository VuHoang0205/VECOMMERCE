package com.example.vecommerce.myorder;

import android.view.View;

import com.example.vecommerce.R;
import com.example.vecommerce.base.BaseFragment;
import com.example.vecommerce.databinding.FragmentOrderDetailBinding;
import com.example.vecommerce.home.HomeFragment;

public class OrderDetailFragment extends BaseFragment<FragmentOrderDetailBinding> {

    public static final String CLASS_NAME = HomeFragment.class.getSimpleName();

    @Override
    protected void onInitComponents() {

    }

    @Override
    protected void onClickAction() {
        getView().findViewById(R.id.ivBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackStack();
            }
        });

    }

    @Override
    public void onCreateView(FragmentOrderDetailBinding viewDataBinding) {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_order_detail;
    }
}
