package com.example.vecommerce.login;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.vecommerce.contants.ValidateUtils;
import com.example.vecommerce.model.User;
import com.example.vecommerce.model.UserError;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SigninPresenter implements SigninContact.LoginPresenter {
    private SignInFragment view;
    private Context context;
    private User user;
    private UserError userError;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference reference;

    public SigninPresenter(SignInFragment view, Context context) {
        this.context = context;
        this.view = view;
        user = new User();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference();
    }

    @Override
    public void onLogin(User user) {
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

        if (user.getPassword().isEmpty()) {
            userError.setPassword("Trường Password không được bỏ trống");
            userError.isError = true;
            userError.errorPassword = true;
        } else {
            if (!ValidateUtils.isValidPassword(user.getPassword())) {
                userError.setPassword("Vui lòng nhập đúng định dạng thông tin Password");
                userError.isError = true;
                userError.errorPassword = true;
            }
        }

        if (userError.isError) {
            view.onShowErorrMessage(userError);
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(user.getEmail(), user.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.e(">>>>", "isSuccessful");
                } else {
                    if (task.getException() instanceof FirebaseNetworkException) {
                        view.onErrorFirebase("Vui lòng kiểm tra lại kết nối mạng của bạn!");
                    }
                    if (task.getException() instanceof FirebaseAuthException) {
                        view.onErrorFirebase("Tài khoản Gmail này đã tồn tại!");
                    }
                    Log.e(">>>>", task.getException().toString());
                }
            }
        });
    }
}
