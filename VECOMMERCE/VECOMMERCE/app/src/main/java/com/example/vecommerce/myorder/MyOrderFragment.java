package com.example.vecommerce.myorder;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.example.vecommerce.R;
import com.example.vecommerce.adapter.cartitem.CartAdapter;
import com.example.vecommerce.adapter.myorder.MyOrderAdapter;
import com.example.vecommerce.base.BaseFragment;
import com.example.vecommerce.contants.DataUtils;
import com.example.vecommerce.contants.KeyUtils;
import com.example.vecommerce.databinding.FragmentMyCartBinding;
import com.example.vecommerce.databinding.FragmentMyOrderBinding;
import com.example.vecommerce.home.HomeFragment;
import com.example.vecommerce.model.CartModel;
import com.example.vecommerce.model.MyOrderModel;
import com.example.vecommerce.myorder.OrderDetailFragment;

import java.util.List;

public class MyOrderFragment extends BaseFragment<FragmentMyOrderBinding> implements BaseFragment.BaseFragmentListener {

    public static final String CLASS_NAME = HomeFragment.class.getSimpleName();


    private RecyclerView recyclerView;
    private MyOrderAdapter myOrderAdapter;
    private List<MyOrderModel> orderModelList = DataUtils.getMyorderModel();

    @Override
    protected void onInitComponents() {
        setHasOptionsMenu(true);
        recyclerView = getView().findViewById(R.id.recyclerCart);
        myOrderAdapter = new MyOrderAdapter(orderModelList);
        myOrderAdapter.setListener(this);
        recyclerView.setAdapter(myOrderAdapter);
    }

    @Override
    protected void onClickAction() {

    }

    @Override
    public void onCreateView(FragmentMyOrderBinding viewDataBinding) {
        
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_my_order;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }

    @Override
    public void onHandlerReult(int status, Bundle extras) {
        if (status == KeyUtils.ORDER_DETAIL_FRAGMENT) {
            addFragmentBackStack(R.id.drawer_layout, new OrderDetailFragment(), OrderDetailFragment.CLASS_NAME);
        }
    }
}
