package com.example.vecommerce.register;

import com.example.vecommerce.model.User;
import com.example.vecommerce.model.UserError;

public interface SignupContact {

    interface SignUpView {

        void onShowProgress(boolean isShow);

        void onSuccess();

        void onShowErorrMessage(UserError userError);

        void onErrorFirebase(String msg);

    }

    interface SignUpPresenter {
        void SignUpUser(User user);
    }
}
