package com.example.vecommerce.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.vecommerce.R;
import com.example.vecommerce.home.HomeFragment;
import com.example.vecommerce.mycart.MyCartFragment;
import com.example.vecommerce.myorder.MyOrderFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView actionbarLogo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        actionbarLogo = findViewById(R.id.action_barLogo);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        navigationView.getMenu().getItem(0).setChecked(true);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        // add fragment
        currentfragment = HOME_FRAGMENT;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_main, new HomeFragment())
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
            if (fragmentList.size() > 1) {
                actionbarLogo.setVisibility(View.GONE);
                getSupportActionBar().setDisplayShowTitleEnabled(true);
                Toast.makeText(this, "fragmentList.size() > 1", Toast.LENGTH_SHORT).show();
            } else {
                currentfragment = HOME_FRAGMENT;
                actionbarLogo.setVisibility(View.VISIBLE);
                getSupportActionBar().setDisplayShowTitleEnabled(false);
                Toast.makeText(this, "fragmentList == 1", Toast.LENGTH_SHORT).show();
            }
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (currentfragment == HOME_FRAGMENT) {
            getMenuInflater().inflate(R.menu.main, menu);

        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            Toast.makeText(this, "action_search Activity", Toast.LENGTH_SHORT).show();
            Log.e(">>>>>", "action_search");
            return true;
        }
        if (id == R.id.action_noti) {
            return true;
        }
        if (id == R.id.action_cart) {
            // add fragment
//            navigateTo(new MyCartFragment(), MyCartFragment.CLASS_NAME);
            navigateTo(new MyCartFragment(), "My Card", CART_FRAGMENT, MyCartFragment.CLASS_NAME);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_mall) {
            // Handle the camera action
            actionbarLogo.setVisibility(View.VISIBLE);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            invalidateOptionsMenu();
            setFragment(new HomeFragment(), HOME_FRAGMENT, HomeFragment.CLASS_NAME);
        } else if (id == R.id.my_order) {
            navigateTo(new MyOrderFragment(), "My Order", ORDER_FRAGMENT, MyOrderFragment.CLASS_NAME);

        } else if (id == R.id.nav_reward) {

        } else if (id == R.id.nav_cart) {
            navigateTo(new MyCartFragment(), "My Card", CART_FRAGMENT, MyCartFragment.CLASS_NAME);

        } else if (id == R.id.nav_wishlist) {

        } else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private static final int HOME_FRAGMENT = 0;
    private static final int CART_FRAGMENT = 1;
    private static final int ORDER_FRAGMENT = 3;
    private static int currentfragment = -1;

    private void navigateTo(Fragment fragment, String title, int fragmentNo, String TAG) {
        invalidateOptionsMenu();
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(title);
        actionbarLogo.setVisibility(View.GONE);
        setFragment(fragment, fragmentNo, TAG);
//        if (currentfragment == CART_FRAGMENT) {
//            navigationView.getMenu().getItem(3).setChecked(true);
//        }

    }

    private void setFragment(Fragment fragment, int fragmentNo, String TAG) {
        if (fragmentNo != currentfragment) {
            currentfragment = fragmentNo;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (fragment instanceof HomeFragment) {
                transaction.replace(R.id.container_main, fragment).setCustomAnimations(R.anim.fade_in, R.anim.fade_out).commit();
            } else {
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                transaction.replace(R.id.container_main, fragment)
                        .addToBackStack(TAG).setCustomAnimations(R.anim.fade_in, R.anim.fade_out).commit();
            }
        }
    }
}
