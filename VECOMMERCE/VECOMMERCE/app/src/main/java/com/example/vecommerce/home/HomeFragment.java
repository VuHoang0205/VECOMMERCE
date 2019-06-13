package com.example.vecommerce.home;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;


import com.example.vecommerce.R;
import com.example.vecommerce.adapter.Categoies;
import com.example.vecommerce.adapter.CategorieAdapter;
import com.example.vecommerce.adapter.GridProductAdapter;
import com.example.vecommerce.adapter.IRecyclerviewItemOnlick;
import com.example.vecommerce.adapter.ProductHorizontalAdapter;
import com.example.vecommerce.adapter.ProductHorizontalModel;
import com.example.vecommerce.adapter.SliderAdapter;
import com.example.vecommerce.adapter.SliderModel;
import com.example.vecommerce.base.BaseFragment;
import com.example.vecommerce.contants.DataUtils;
import com.example.vecommerce.databinding.FragmentHomeBinding;
import com.example.vecommerce.productdetail.ProductdetailFragment;


import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends BaseFragment<FragmentHomeBinding> implements IRecyclerviewItemOnlick {

    public static final String CLASS_NAME = HomeFragment.class.getSimpleName();

    private RecyclerView recyclerView;
    private CategorieAdapter categorieAdapter;
    private List<Categoies> categoies = DataUtils.getCategories();

    private RecyclerView recyclerViewHorizontal;
    private ProductHorizontalAdapter productHorizontalAdapter;
    private List<ProductHorizontalModel> productList = DataUtils.getProductList();

    private RecyclerView gridRecyclerView;
    private GridProductAdapter gridProductAdapter;
    private List<ProductHorizontalModel> productGridList = DataUtils.getProductList();

    private ViewPager viewPager;
    private List<SliderModel> sliderList = DataUtils.getSliderList();
    private SliderAdapter sliderAdapter;


    private int currentPage = 2;
    private Timer timer;

    private ConstraintLayout tripLayout;
    private ImageView tripImage;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onInitComponents() {
        setHasOptionsMenu(true);
        recyclerView = getView().findViewById(R.id.recyclerCategory);
        viewPager = getView().findViewById(R.id.viewPager);
        recyclerViewHorizontal = getView().findViewById(R.id.rcvHorizontal);
        gridRecyclerView = getView().findViewById(R.id.grid_product);

        // Trip
        tripImage = getView().findViewById(R.id.trip_image);
        tripLayout = getView().findViewById(R.id.mtrip_layout);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        categorieAdapter = new CategorieAdapter(categoies, this);
        recyclerView.setAdapter(categorieAdapter);

        recyclerViewHorizontal.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        productHorizontalAdapter = new ProductHorizontalAdapter(productList);
        recyclerViewHorizontal.setAdapter(productHorizontalAdapter);

        // pager
        sliderAdapter = new SliderAdapter(sliderList);

        //trip
        tripImage.setImageResource(R.drawable.trip_banner);
        tripLayout.setBackgroundColor(Color.BLACK);

        // grid
        gridRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        gridProductAdapter = new GridProductAdapter(productGridList);
        gridRecyclerView.setAdapter(gridProductAdapter);


        viewPager.setCurrentItem(currentPage);

        // Config xem trc cac slider sau 1 phan
        viewPager.setClipToPadding(false);
        viewPager.setPageMargin(20);
        viewPager.setAdapter(sliderAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                currentPage = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (i == ViewPager.SCROLL_STATE_IDLE) {
                    pageLooper();
                }
            }
        });

        startBanner();

        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pageLooper();
                stopBanner();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    startBanner();
                }
                return false;
            }
        });
    }

    @Override
    protected void onClickAction() {

    }

    @Override
    public void onCreateView(FragmentHomeBinding viewDataBinding) {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    private void pageLooper() {
        if (currentPage == sliderList.size() - 2) {
            currentPage = 2;
            viewPager.setCurrentItem(currentPage, false);
        }
        if (currentPage == 1) {
            currentPage = sliderList.size() - 3;
            viewPager.setCurrentItem(currentPage, false);
        }
    }

    private void startBanner() {
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage > sliderList.size()) {
                    currentPage = 1;
                }
                viewPager.setCurrentItem(currentPage++, false);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 2500, 1500);
    }

    private void stopBanner() {
        timer.cancel();
    }

    @Override
    public void onClickItem(Bundle bundle) {
       addFragmentBackStack(R.id.container_drawer, new ProductdetailFragment(), HomeFragment.CLASS_NAME);
//        startActivity(new Intent(getActivity(), Main2Activity.class));
    }
}
