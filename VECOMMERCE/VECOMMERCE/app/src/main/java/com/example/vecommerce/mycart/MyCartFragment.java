package com.example.vecommerce.mycart;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.example.vecommerce.R;
import com.example.vecommerce.adapter.cartitem.CartAdapter;
import com.example.vecommerce.base.BaseFragment;
import com.example.vecommerce.contants.DataUtils;
import com.example.vecommerce.databinding.FragmentMyCartBinding;
import com.example.vecommerce.home.HomeFragment;
import com.example.vecommerce.model.CartModel;

import java.util.List;

public class MyCartFragment extends BaseFragment<FragmentMyCartBinding> {

    public static final String CLASS_NAME = MyCartFragment.class.getSimpleName();


    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private List<CartModel> cartModelList = DataUtils.getModelCart();

    @Override
    protected void onInitComponents() {
        Log.e(">>>>", "size: " + getActivity().getSupportFragmentManager().getFragments().size());
        recyclerView = getView().findViewById(R.id.recyclerCart);
        cartAdapter = new CartAdapter(cartModelList);
        recyclerView.setAdapter(cartAdapter);
    }

    @Override
    protected void onClickAction() {

    }

    @Override
    public void onCreateView(FragmentMyCartBinding viewDataBinding) {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_my_cart;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }
}
