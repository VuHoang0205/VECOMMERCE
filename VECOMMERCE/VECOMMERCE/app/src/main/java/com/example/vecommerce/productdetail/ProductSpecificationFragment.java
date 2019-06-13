package com.example.vecommerce.productdetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.vecommerce.R;
import com.example.vecommerce.adapter.productdetail.ProductSpecificationModel;
import com.example.vecommerce.adapter.productdetail.SpecificationAdapter;
import com.example.vecommerce.base.BaseFragment;
import com.example.vecommerce.contants.DataUtils;
import com.example.vecommerce.databinding.FragmentProductSpectificationBinding;

import java.util.List;

public class ProductSpecificationFragment extends BaseFragment<FragmentProductSpectificationBinding> {

    private RecyclerView recyclerView;
    private List<ProductSpecificationModel> specificationModels = DataUtils.getProductSpecfiition();
    private SpecificationAdapter specificationAdapter;

    @Override
    protected void onInitComponents() {
        recyclerView = getView().findViewById(R.id.recycleSpecification);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        specificationAdapter = new SpecificationAdapter(specificationModels);
        recyclerView.setAdapter(specificationAdapter);

        Log.e("vu", "data: " + specificationAdapter.getItemCount());

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("vu", "onActivityCreated: " + specificationAdapter.getItemCount());

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("vu", "onStart: " + specificationAdapter.getItemCount());

    }



    @Override
    protected void onClickAction() {

    }

    @Override
    public void onCreateView(FragmentProductSpectificationBinding viewDataBinding) {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_product_spectification;
    }
}
