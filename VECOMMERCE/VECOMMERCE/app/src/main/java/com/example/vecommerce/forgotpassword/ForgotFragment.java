package com.example.vecommerce.forgotpassword;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.example.vecommerce.R;
import com.example.vecommerce.base.BaseFragment;
import com.example.vecommerce.databinding.FragmentForgotPasswordBinding;

public class ForgotFragment extends BaseFragment<FragmentForgotPasswordBinding> {

    public static final String CLASS_NAME = ForgotFragment.class.getSimpleName();

    private TextView btnLogin;

    public ForgotFragment() {

    }

    @Override
    protected void onInitComponents() {
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
        getView().findViewById(R.id.relativelayout).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        hideKeyboard();
                        Log.e(">>>>", "Onclick rel");
                    }
                }
        );
    }

    @Override
    public void onCreateView(FragmentForgotPasswordBinding forgotPasswordBinding) {

    }


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_forgot_password;
    }

    public void hideKeyboard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
