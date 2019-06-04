package com.example.vecommerce.forgotpassword;

import android.view.View;
import android.widget.TextView;

import com.example.vecommerce.R;
import com.example.vecommerce.base.BaseFragment;
import com.example.vecommerce.contants.TransactionUtils;
import com.example.vecommerce.register.SignupFragment;

public class ForgotFragment extends BaseFragment {

    public static final String CLASS_NAME = ForgotFragment.class.getSimpleName();

    private TextView btnLogin;

    public ForgotFragment() {

    }

    @Override
    protected void onInitComponents() {
        TransactionUtils.activity = getActivity();
        btnLogin = getView().findViewById(R.id.tvGoBack);
    }

    @Override
    protected void onClickAction() {
        // Register
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackStack();
            }
        });
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_forgot_password;
    }
}
