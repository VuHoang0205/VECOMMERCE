package com.example.vecommerce.register;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.vecommerce.R;
import com.example.vecommerce.base.BaseDialog;
import com.example.vecommerce.base.BaseFragment;
import com.example.vecommerce.base.IOnclickDialog;
import com.example.vecommerce.contants.KeyUtils;
import com.example.vecommerce.databinding.FragmentSignupBinding;
import com.example.vecommerce.model.User;
import com.example.vecommerce.model.UserError;
import com.jpardogo.android.googleprogressbar.library.FoldingCirclesDrawable;
import com.jpardogo.android.googleprogressbar.library.GoogleProgressBar;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;

public class SignupFragment extends BaseFragment<FragmentSignupBinding> implements SignupContact.SignUpView {

    public static final String CLASS_NAME = SignupFragment.class.getSimpleName();

    private SignupPresenter signupPresenter;
    private TextView btnLogin;
    private GoogleProgressBar progressBar;
    private Button btnRegister;
    private User user;
    private UserError userError;
    private ConstraintLayout constraintLayout;

    public SignupFragment() {

    }

    @Override
    public void onCreateView(FragmentSignupBinding signupBinding) {
        user = new User();
        userError = new UserError();
        signupBinding.setUser(user);
        signupBinding.setUserError(userError);
    }

    @Override
    protected void onInitComponents() {
        btnLogin = getView().findViewById(R.id.link_login);
        progressBar = getView().findViewById(R.id.google_progress);
        progressBar.setIndeterminateDrawable(new FoldingCirclesDrawable.Builder(getContext()).colors(getResources().getIntArray(R.array.color_list)).build());
        progressBar.setVisibility(View.GONE);
        btnRegister = getView().findViewById(R.id.btn_signup);
        constraintLayout = getView().findViewById(R.id.contraintSignup);

        signupPresenter = new SignupPresenter(this, getContext());

    }

    @Override
    protected void onClickAction() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackStack();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableDisableView(constraintLayout, false);
                signupPresenter.SignUpUser(user);
            }
        });
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_signup;
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
                Bundle bundle = new Bundle();
                bundle.putSerializable(KeyUtils.USER, user);
                baseFragmentListener.onHandlerReult(KeyUtils.SIGN_UP_FRAGMENT, bundle);
                onBackStack();
            }
        });
    }

    @Override
    public void onShowErorrMessage(UserError userError) {
        enableDisableView(constraintLayout, true);
        progressBar.setVisibility(View.GONE);
        new BaseDialog(getActivity()).showDialog(getContext().getString(R.string.title_dialog), getContext().getString(R.string.message_dialog));
        viewDataBinding.setUserError(userError);
    }

    @Override
    public void onErrorFirebase(String msg) {
        enableDisableView(constraintLayout, true);
        progressBar.setVisibility(View.GONE);
        new BaseDialog(getActivity()).showDialog(getContext().getString(R.string.title_dialog), msg);
    }

    public void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getActivity()
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        // check if no view has focus:
        View currentFocusedView = getActivity().getCurrentFocus();
        if (currentFocusedView != null) {
            inputManager.hideSoftInputFromWindow(currentFocusedView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

}
