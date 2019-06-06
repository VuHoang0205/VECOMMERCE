package com.example.vecommerce.login;

import com.example.vecommerce.model.User;
import com.example.vecommerce.model.UserError;

public interface SigninContact {

    interface LoginView {

        void onShowProgress(boolean isShow);

        void onSuccess();

        void onShowErorrMessage(UserError userError);

        void onErrorFirebase(String msg);
    }

    interface LoginPresenter {
        void onLogin(User user);
    }
}
