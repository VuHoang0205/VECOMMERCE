package com.example.vecommerce.forgotpassword;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.vecommerce.R;
import com.example.vecommerce.base.BaseDialog;
import com.example.vecommerce.base.BaseFragment;
import com.example.vecommerce.base.IOnclickDialog;
import com.example.vecommerce.contants.KeyUtils;
import com.example.vecommerce.databinding.FragmentForgotPasswordBinding;
import com.example.vecommerce.model.User;
import com.example.vecommerce.model.UserError;
import com.jpardogo.android.googleprogressbar.library.FoldingCirclesDrawable;
import com.jpardogo.android.googleprogressbar.library.GoogleProgressBar;

public class ForgotFragment extends BaseFragment<FragmentForgotPasswordBinding> implements ForgotContact.ForgotView {

    public static final String CLASS_NAME = ForgotFragment.class.getSimpleName();

    private TextView btnLogin;

    private Button btnForgot;

    private GoogleProgressBar progressBar;

    private ForgotPresenter forgotPresenter;
    private UserError userError;
    private User user;

    public ForgotFragment() {

    }

    @Override
    protected void onInitComponents() {
        btnLogin = getView().findViewById(R.id.tvGoBack);
        progressBar = getView().findViewById(R.id.google_progress);
        progressBar.setIndeterminateDrawable(new FoldingCirclesDrawable.Builder(getContext()).colors(getResources().getIntArray(R.array.color_list)).build());
        progressBar.setVisibility(View.GONE);
        btnForgot = getView().findViewById(R.id.btnReset);

        forgotPresenter = new ForgotPresenter(this, getContext());

        user = new User();
        userError = new UserError();
        viewDataBinding.setUser(user);
        viewDataBinding.setUserError(userError);
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

        btnForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPresenter.onForgotPass(user);
            }
        });
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
//        enableDisableView(constraintLayout, true);
        progressBar.setVisibility(View.GONE);
        new BaseDialog(getActivity()).showDialog(getContext().getString(R.string.title_dialog), getContext().getString(R.string.message_success_dialog_reset), new IOnclickDialog() {
            @Override
            public void onClickButton() {
                Bundle bundle = new Bundle();
                bundle.putSerializable(KeyUtils.USER, user);
                baseFragmentListener.onHandlerReult(KeyUtils.FORGOT_FRAGMENT, bundle);
                onBackStack();
            }
        });
    }

    @Override
    public void onShowErorrMessage(UserError userError) {
        progressBar.setVisibility(View.GONE);
        viewDataBinding.setUserError(userError);
    }

    @Override
    public void onErrorFirebase(String msg) {
//        enableDisableView(constraintLayout, true);
        progressBar.setVisibility(View.GONE);
        new BaseDialog(getActivity()).showDialog(getContext().getString(R.string.title_dialog), msg);
    }
}
