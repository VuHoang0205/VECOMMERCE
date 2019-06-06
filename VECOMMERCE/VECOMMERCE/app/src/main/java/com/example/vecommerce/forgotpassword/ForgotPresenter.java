package com.example.vecommerce.forgotpassword;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.vecommerce.contants.ValidateUtils;
import com.example.vecommerce.login.SignInFragment;
import com.example.vecommerce.model.User;
import com.example.vecommerce.model.UserError;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class ForgotPresenter implements ForgotContact.ForgotPresenter {

    private ForgotFragment view;
    private Context context;
    private User user;
    private UserError userError;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    public ForgotPresenter(ForgotFragment view, Context context) {
        this.context = context;
        this.view = view;
        user = new User();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

    }

    @Override
    public void onForgotPass(User user) {
        view.onShowProgress(true);
        userError = new UserError();
        if (user.getEmail().isEmpty()) {
            userError.setEmail("Trường Email không được bỏ trống");
            userError.isError = true;
            userError.errorEmail = true;
        } else {
            if (!ValidateUtils.isValidEmailId(user.getEmail())) {
                userError.setEmail("Vui lòng nhập đúng định dạng thông tin Email");
                userError.errorEmail = true;
                userError.isError = true;
            }
        }
        if (userError.isError) {
            view.onShowErorrMessage(userError);
            return;
        }
        firebaseAuth.sendPasswordResetEmail(user.getEmail()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    view.onSuccess();
                } else {
                    if (task.getException() instanceof FirebaseNetworkException) {
                        view.onErrorFirebase("Vui lòng kiểm tra lại kết nối mạng của bạn!");
                    }
//                    if (task.getException() instanceof FirebaseAuthException) {
//                        view.onErrorFirebase("Tài khoản hoặc mật khẩu không đúng kiểm tra lại!");
//                    }
                    Log.e(">>>>", task.getException().toString());
                }
            }
        });
    }
}
