package com.example.vecommerce.contants;

import android.databinding.BindingAdapter;
import android.support.design.widget.TextInputLayout;

public class BindingUtils {

    @BindingAdapter("app:setErrors")
    public static void setErrors(TextInputLayout textInputLayout, String error) {
        textInputLayout.setError(error);
    }
}
