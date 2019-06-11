package com.example.vecommerce.adapter.productdetail;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.vecommerce.home.HomeFragment;
import com.example.vecommerce.productdetail.ProductDescriptionFragment;
import com.example.vecommerce.productdetail.ProductSpecificationFragment;

public class ProductDetailAdapter extends FragmentPagerAdapter {

    private String title[] = {"Description", "Specification", "Orther Detail"};

    public ProductDetailAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new ProductDescriptionFragment();
            case 1:
                return new ProductSpecificationFragment();
            case 2:
                return new ProductDescriptionFragment();
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
