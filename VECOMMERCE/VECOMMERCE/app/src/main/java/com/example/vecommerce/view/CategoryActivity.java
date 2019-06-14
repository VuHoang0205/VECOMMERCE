package com.example.vecommerce.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

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
import com.example.vecommerce.home.HomeFragment;
import com.example.vecommerce.mycart.MyCartFragment;
import com.example.vecommerce.myorder.MyOrderFragment;
import com.example.vecommerce.productdetail.ProductdetailFragment;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class CategoryActivity extends AppCompatActivity implements BaseFragment.BaseFragmentListener {

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

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        onInitComponents();
        onClickAction();

    }

    @SuppressLint("ClickableViewAccessibility")
    protected void onInitComponents() {

        toolbar = findViewById(R.id.mToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.viewPager);
        recyclerViewHorizontal = findViewById(R.id.rcvHorizontal);
        gridRecyclerView = findViewById(R.id.grid_product);

        // Trip
        tripImage = findViewById(R.id.trip_image);
        tripLayout = findViewById(R.id.mtrip_layout);


        recyclerViewHorizontal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        productHorizontalAdapter = new ProductHorizontalAdapter(productList);
        productHorizontalAdapter.setListener(this);
        recyclerViewHorizontal.setAdapter(productHorizontalAdapter);

        // pager
        sliderAdapter = new SliderAdapter(sliderList);

        //trip
        tripImage.setImageResource(R.drawable.trip_banner);
        tripLayout.setBackgroundColor(Color.BLACK);

        // grid
        gridRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        gridProductAdapter = new GridProductAdapter(productGridList);
        gridProductAdapter.setListener(this);
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


    private void onClickAction() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_category, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search_product) {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void addFragment(Fragment fragment, String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.cotainer_category, fragment).addToBackStack(tag).commit();
    }

    @Override
    public void onHandlerReult(int status, Bundle extras) {
        addFragment(new ProductdetailFragment(), ProductdetailFragment.CLASS_NAME);
    }
}
