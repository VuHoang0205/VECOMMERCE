package com.example.vecommerce.productdetail;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.example.vecommerce.R;
import com.example.vecommerce.adapter.productdetail.ProductDetailAdapter;
import com.example.vecommerce.adapter.productdetail.ProductImageAdapter;
import com.example.vecommerce.base.BaseFragment;
import com.example.vecommerce.contants.DataUtils;
import com.example.vecommerce.databinding.FragmentProductDetailBinding;
import com.example.vecommerce.home.HomeFragment;
import com.example.vecommerce.mycart.MyCartFragment;

import java.util.List;

public class ProductdetailFragment extends BaseFragment<FragmentProductDetailBinding> {

    public static final String CLASS_NAME = ProductdetailFragment.class.getSimpleName();

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout viewPagerIndicator;
    private List<Integer> imageList = DataUtils.getImageList();
    private ProductImageAdapter productImageAdapter;
    private FloatingActionButton btnLike;
    private boolean isLike;
    private ViewPager viewPagerDetail;
    private TabLayout tabDetail;
    private LinearLayout linearLayout;

    private ImageView ivBack;

    @Override
    protected void onInitComponents() {

        Log.e(">>>>", "size: " + getActivity().getSupportFragmentManager().getFragments().size());
        toolbar = getView().findViewById(R.id.toolbarProduct);
        ivBack = getView().findViewById(R.id.ivBack);
        viewPager = getView().findViewById(R.id.viewPagerProduct);
        viewPagerIndicator = getView().findViewById(R.id.viewpager_indicator);
        btnLike = getView().findViewById(R.id.btnLike);
        viewPagerDetail = getView().findViewById(R.id.viewpagerDescription);
        tabDetail = getView().findViewById(R.id.tabDescription);
        linearLayout = getView().findViewById(R.id.linearLayoutRating);


        setHasOptionsMenu(true);
        toolbar.inflateMenu(R.menu.main_product_detail);

        productImageAdapter = new ProductImageAdapter(imageList);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(productImageAdapter);
        viewPagerIndicator.setupWithViewPager(viewPager, true);

        // Neu trong fragment su dung viewpager thi phai dung getChildFragmentManager
        viewPagerDetail.setAdapter(new ProductDetailAdapter(getChildFragmentManager()));
        tabDetail.setupWithViewPager(viewPagerDetail);
        viewPagerDetail.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabDetail));
        tabDetail.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerDetail.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // Ratingbar

        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            final int starPosition = i;
            linearLayout.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    settingRatingbar(starPosition);
                }
            });
        }

    }

    private void settingRatingbar(int pos) {
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            ImageView starBtn = (ImageView) linearLayout.getChildAt(i);
            starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
            if (i <= pos) {
                starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffbb00")));
            }
        }
    }

    @Override
    protected void onClickAction() {

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackStack();
            }
        });
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLike) {
                    isLike = false;
                    btnLike.setImageResource(R.drawable.ic_unlike);
                    btnLike.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                } else {
                    isLike = true;
                    btnLike.setImageResource(R.drawable.ic_like);
                    btnLike.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFEE5F5F")));

                }
            }
        });
    }

    @Override
    public void onCreateView(FragmentProductDetailBinding viewDataBinding) {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_product_detail;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search_product) {
            Toast.makeText(getContext(), "action_search Fragment", Toast.LENGTH_SHORT).show();

            return true;
        }

        if (id == R.id.action_cart_product) {
//            addFragmentBackStack(R.id.container_drawer, new MyCartFragment(), MyCartFragment.CLASS_NAME);
            Toast.makeText(getContext(), "action_search Fragment", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

}