package com.example.vecommerce.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.inputmethod.InputMethodManager;

import com.example.vecommerce.contants.KeyboardUtils;


public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment {

    public T viewDataBinding;

    protected abstract void onInitComponents();

    protected abstract void onClickAction();

    public abstract void onCreateView(T viewDataBinding);

    protected abstract @LayoutRes
    int getLayoutRes();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (viewDataBinding == null) {
            viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
            onCreateView(viewDataBinding);
            return viewDataBinding.getRoot();
        }
        return viewDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onInitComponents();
        onClickAction();
    }

    public void onBackStack() {
        getActivity().getSupportFragmentManager().popBackStack();
    }

    public void replaceAddBackStack(int id, Fragment fragment, String tag) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(id, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

    public void replaceFragment(int id, Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(id, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
    }

    public void addFragmentBackStack(int id, Fragment fragment, String tag) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.add(id, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

    public void addFragment(int id, Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(id, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
    }

    public void addFragment(int id, Fragment fragment, Bundle bundle) {
        fragment.setArguments(bundle);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(id, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
    }

    public void onHideKeyboard() {
        KeyboardUtils.hiddenKeyBoard(getActivity());
    }

    public static void enableDisableView(View view, boolean enabled) {
        view.setEnabled(enabled);
        if ( view instanceof ViewGroup ) {
            ViewGroup group = (ViewGroup)view;

            for ( int idx = 0 ; idx < group.getChildCount() ; idx++ ) {
                enableDisableView(group.getChildAt(idx), enabled);
            }
        }
    }

    public interface BaseFragmentListener {
        public void onHandlerReult(int status, Bundle extras);
    }

    public BaseFragmentListener baseFragmentListener;

    public void setOtoconFragmentListener(BaseFragmentListener baseFragmentListener) {
        this.baseFragmentListener = baseFragmentListener;
    }
    public void callParentMethod(){
        getActivity().onBackPressed();
    }
}
