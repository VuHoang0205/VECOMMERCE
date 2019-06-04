package com.example.vecommerce.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vecommerce.R;
import com.example.vecommerce.base.BaseFragment;
import com.example.vecommerce.contants.TransactionUtils;
import com.example.vecommerce.forgotpassword.ForgotFragment;
import com.example.vecommerce.register.SignupFragment;

public class SignInFragment extends BaseFragment {

    private TextView btnRegister;
    private TextView btnForgot;

    public SignInFragment() {

    }

    @Override
    protected void onInitComponents() {
        TransactionUtils.activity = getActivity();
        btnRegister = getView().findViewById(R.id.link_signup);
        btnForgot = getView().findViewById(R.id.link_forgot);
    }

    @Override
    protected void onClickAction() {
        // Register
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransactionUtils.addFragmentBackStack(R.id.frameContainer, new SignupFragment(), SignupFragment.CLASS_NAME);
            }
        });

        btnForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransactionUtils.addFragmentBackStack(R.id.frameContainer, new ForgotFragment(), ForgotFragment.CLASS_NAME);
            }
        });
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_signin;
    }
}
