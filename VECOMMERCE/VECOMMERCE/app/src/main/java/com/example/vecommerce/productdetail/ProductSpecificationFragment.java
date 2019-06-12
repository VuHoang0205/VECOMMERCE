package com.example.vecommerce.productdetail;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
