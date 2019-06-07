package com.example.vecommerce.home;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;


import com.example.vecommerce.R;
import com.example.vecommerce.adapter.Categoies;
import com.example.vecommerce.adapter.CategorieAdapter;
import com.example.vecommerce.adapter.SliderAdapter;
import com.example.vecommerce.adapter.SliderModel;
import com.example.vecommerce.base.BaseFragment;
import com.example.vecommerce.contants.DataUtils;
import com.example.vecommerce.databinding.FragmentHomeBinding;


import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends BaseFragment<FragmentHomeBinding> {

    public static final String CLASS_NAME = HomeFragment.class.getSimpleName();
    private RecyclerView recyclerView;
    private CategorieAdapter categorieAdapter;
    private List<Categoies> categoies = DataUtils.getCategories();

    private ViewPager viewPager;
    private List<SliderModel> sliderList = DataUtils.getSliderList();
    private SliderAdapter sliderAdapter;

    private int currentPage = 2;
    private Timer timer;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onInitComponents() {
        recyclerView = getView().findViewById(R.id.recyclerCategory);
        viewPager = getView().findViewById(R.id.viewPager);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        categorieAdapter = new CategorieAdapter(categoies);
        recyclerView.setAdapter(categorieAdapter);

        // pager
        sliderAdapter = new SliderAdapter(sliderList);

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
                if (event.getAction()==MotionEvent.ACTION_UP){
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

    private void stopBanner(){
        timer.cancel();
    }
}
