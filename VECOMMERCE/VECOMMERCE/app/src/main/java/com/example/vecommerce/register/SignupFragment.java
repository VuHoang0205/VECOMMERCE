package com.example.vecommerce.register;

import android.view.View;
import android.widget.TextView;

import com.example.vecommerce.R;
import com.example.vecommerce.base.BaseFragment;
import com.example.vecommerce.contants.TransactionUtils;
import com.example.vecommerce.forgotpassword.ForgotFragment;

public class SignupFragment extends BaseFragment {

    public static final String CLASS_NAME = SignupFragment.class.getSimpleName();
    private TextView btnLogin;


    public SignupFragment() {

    }

    @Override
    protected void onInitComponents() {
        btnLogin = getView().findViewById(R.id.link_login);

    }

    @Override
    protected void onClickAction() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackStack();
            }
        });
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_signup;
    }
}
