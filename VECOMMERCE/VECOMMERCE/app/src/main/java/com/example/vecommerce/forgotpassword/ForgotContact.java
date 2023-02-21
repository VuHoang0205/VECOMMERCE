package com.example.vecommerce.forgotpassword;

import com.example.vecommerce.model.User;
import com.example.vecommerce.model.UserError;

public interface ForgotContact {

    interface ForgotView {


        
        void onShowProgress(boolean isShow);

        void onSuccess();

        void onShowErorrMessage(UserError userError);

        void onErrorFirebase(String msg);
    }

    interface ForgotPresenter {
        void onForgotPass(User user);
    }
}
