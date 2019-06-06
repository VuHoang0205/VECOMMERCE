package com.example.vecommerce.register;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.vecommerce.contants.ValidateUtils;
import com.example.vecommerce.model.User;
import com.example.vecommerce.model.UserError;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import static com.example.vecommerce.contants.KeyUtils.TABLE_NAME_USER;

public class SignupPresenter implements SignupContact.SignUpPresenter {
    private SignupFragment view;
    private Context context;
    private UserError userError;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public SignupPresenter(SignupFragment view, Context context) {
        this.context = context;
        this.view = view;
        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void SignUpUser(final User mUser) {
        userError = new UserError();
        view.onShowProgress(true);

        if (mUser.getName().isEmpty()) {
            userError.setName("Trường Name không được bỏ trống");
            userError.isError = true;
            userError.errorName = true;
        }

        if (mUser.getAddress().isEmpty()) {
            userError.setAddress("Trường Address không được bỏ trống");
            userError.isError = true;
            userError.errorAddress = true;
        }

        if (mUser.getEmail().isEmpty()) {
            userError.setEmail("Trường Email không được bỏ trống");
            userError.isError = true;
            userError.errorEmail = true;
        } else {
            if (!ValidateUtils.isValidEmailId(mUser.getEmail())) {
                userError.setEmail("Vui lòng nhập đúng định dạng thông tin Email");
                userError.errorEmail = true;
                userError.isError = true;
            }
        }

        if (mUser.getMobileNumber().isEmpty()) {
            userError.setMobileNumber("Trường Mobile Number không được bỏ trống");
            userError.isError = true;
            userError.errorMobileNumber = true;
        }

        if (mUser.getPassword().isEmpty()) {
            userError.setPassword("Trường Password không được bỏ trống");
            userError.isError = true;
            userError.errorPassword = true;
        } else {
            if (!ValidateUtils.isValidPassword(mUser.getPassword())) {
                userError.setPassword("Vui lòng nhập đúng định dạng thông tin Password");
                userError.isError = true;
                userError.errorPassword = true;
            }
        }
        if (mUser.getRePassword().isEmpty()) {
            userError.setRePassword("Trường Re-Password không được bỏ trống");
            userError.errorRepassowrd = true;
        } else {
            if (!mUser.getPassword().equals(mUser.getRePassword())) {
                userError.setRePassword("Trường Re-Password không giống Password ");
                userError.isError = true;
                userError.errorRepassowrd = true;
            }
        }
        if (userError.isError) {
            view.onShowErorrMessage(userError);
            return;
        }
        firebaseAuth.createUserWithEmailAndPassword(mUser.getEmail(), mUser.getPassword())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            sendVerifyEmail(mUser);
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

    private void sendVerifyEmail(final User mUser) {
        if (firebaseAuth.getCurrentUser() != null) {
            final FirebaseUser user = firebaseAuth.getCurrentUser();
            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        view.onSuccess();
                        db.collection(TABLE_NAME_USER).document(mUser.getEmail())
                                .set(mUser).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                view.onErrorFirebase("Vui lòng kiểm tra lại kết nối mạng của bạn!");
                            }
                        });


                    }
                    if (task.getException() instanceof FirebaseNetworkException) {
                        view.onErrorFirebase("Vui lòng kiểm tra lại kết nối mạng của bạn!");
                    }
//                    if (task.getException() instanceof FirebaseAuthException) {
//                        view.onErrorFirebase("Tài khoản Gmail này đã tồn tại!");
//                    }
                }
            });
        }
    }
}
