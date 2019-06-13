package com.example.vecommerce.myorder;


import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.vecommerce.R;
import com.example.vecommerce.base.BaseFragment;
import com.example.vecommerce.databinding.FragmentOrderDetailBinding;
import com.example.vecommerce.home.HomeFragment;

public class OrderDetailFragment extends BaseFragment<FragmentOrderDetailBinding> {

    public static final String CLASS_NAME = HomeFragment.class.getSimpleName();

    private Toolbar toolbar;

    @Override
    protected void onInitComponents() {
        toolbar = getView().findViewById(R.id.mtoolbar);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onClickAction() {

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
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
