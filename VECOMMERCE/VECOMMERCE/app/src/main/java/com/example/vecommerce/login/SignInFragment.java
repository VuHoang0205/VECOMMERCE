package com.example.vecommerce.login;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vecommerce.R;
import com.example.vecommerce.base.BaseDialog;
import com.example.vecommerce.base.BaseFragment;
import com.example.vecommerce.base.IOnclickDialog;
import com.example.vecommerce.contants.KeyUtils;
import com.example.vecommerce.databinding.FragmentSigninBinding;
import com.example.vecommerce.forgotpassword.ForgotFragment;
import com.example.vecommerce.model.User;
import com.example.vecommerce.model.UserError;
import com.example.vecommerce.register.SignupFragment;
import com.jpardogo.android.googleprogressbar.library.FoldingCirclesDrawable;
import com.jpardogo.android.googleprogressbar.library.GoogleProgressBar;

import java.io.Serializable;

public class SignInFragment extends BaseFragment<FragmentSigninBinding> implements SigninContact.LoginView {

    private TextView btnRegister;
    private TextView btnForgot;
    private Button btnLogin;
    private GoogleProgressBar progressBar;
    private User user;
    private UserError userError;
    private SigninPresenter signinPresenter;
    private ConstraintLayout constraintLayout;

    public SignInFragment() {

    }

    @Override
    protected void onInitComponents() {
        onHideKeyboard();
        btnRegister = getView().findViewById(R.id.link_signup);
        btnForgot = getView().findViewById(R.id.link_forgot);
        progressBar = getView().findViewById(R.id.google_progress);
        progressBar.setIndeterminateDrawable(new FoldingCirclesDrawable.Builder(getContext()).colors(getResources().getIntArray(R.array.color_list)).build());
        progressBar.setVisibility(View.INVISIBLE);
        btnLogin = getView().findViewById(R.id.btn_login);
        constraintLayout = getView().findViewById(R.id.contraintSignIn);

        user = new User();
        userError = new UserError();
        viewDataBinding.setUser(user);
        viewDataBinding.setUserError(userError);

        signinPresenter = new SigninPresenter(this, getContext());
    }

    @Override
    protected void onClickAction() {
        // Register
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignupFragment signupFragment = new SignupFragment();
                signupFragment.setOtoconFragmentListener(new BaseFragmentListener() {
                    @Override
                    public void onHandlerReult(int status, Bundle extras) {
                        if (status == 1) {
                            user = (User) extras.getSerializable(KeyUtils.USER);
                            viewDataBinding.setUser(user);
                        }
                    }
                });
                addFragmentBackStack(R.id.frameContainer, signupFragment, SignupFragment.CLASS_NAME);
            }
        });

        btnForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ForgotFragment forgotFragment = new ForgotFragment();
                forgotFragment.setOtoconFragmentListener(new BaseFragmentListener() {
                    @Override
                    public void onHandlerReult(int status, Bundle extras) {
                        if (status == 2) {
                            user = (User) extras.getSerializable(KeyUtils.USER);
                            viewDataBinding.setUser(user);
                        }
                    }
                });
                addFragmentBackStack(R.id.frameContainer, forgotFragment, ForgotFragment.CLASS_NAME);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signinPresenter.onLogin(user);
            }
        });
    }

    @Override
    public void onCreateView(FragmentSigninBinding signinBinding) {

    }


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_signin;
    }

    @Override
    public void onShowProgress(boolean isShow) {
        if (progressBar != null) {
            if (isShow) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onSuccess() {
        enableDisableView(constraintLayout, true);
        progressBar.setVisibility(View.GONE);
        new BaseDialog(getActivity()).showDialog(getContext().getString(R.string.title_dialog), getContext().getString(R.string.message_success_dialog), new IOnclickDialog() {
            @Override
            public void onClickButton() {

            }
        });
    }

    @Override
    public void onShowErorrMessage(UserError userError) {
        enableDisableView(constraintLayout, true);
        progressBar.setVisibility(View.GONE);
        viewDataBinding.setUserError(userError);
    }

    @Override
    public void onErrorFirebase(String msg) {
        enableDisableView(constraintLayout, true);
        progressBar.setVisibility(View.GONE);
        new BaseDialog(getActivity()).showDialog(getContext().getString(R.string.title_dialog), msg);
    }
}
