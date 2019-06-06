package com.example.vecommerce.login;

import com.example.vecommerce.model.User;

public interface LoginContact {

    interface LoginView {

        void showProgress(boolean isShow);

        void success();

        void showErorrMessage(String title, String message);
    }

    interface LoginPresenter {
        void onLogin(User user);
    }
}
