package com.example.vecommerce.adapter.productdetail;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.vecommerce.home.HomeFragment;
import com.example.vecommerce.productdetail.ProductDescriptionFragment;
import com.example.vecommerce.productdetail.ProductSpecificationFragment;
import com.example.vecommerce.productdetail.ProductTempFragment;

public class ProductDetailAdapter extends FragmentPagerAdapter {

    private String title[] = {"Description", "Specification", "Orther Detail"};

    public ProductDetailAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                Log.e("vu", "ProductDescriptionFragment");
                return new ProductDescriptionFragment();
            case 1:
                Log.e("vu", "ProductSpecificationFragment");
                return new ProductSpecificationFragment();
            case 2:
                Log.e("vu", "ProductTempFragment");
                return new ProductTempFragment();
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public int getCount() {
        return 3;
    }
}
