package com.example.vecommerce.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;

import com.example.vecommerce.R;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;

public class BaseDialog {
    private Activity context;
    public IOnclickDialog iOnclickDialog;

    public BaseDialog(Activity context) {
        this.context = context;
    }

    public void showDialog(String title, String msg, final IOnclickDialog iOnclickDialog) {
        new FancyAlertDialog.Builder(context)
                .setTitle(title)
                .setBackgroundColor(Color.parseColor("#FFFF9800"))  //Don't pass R.color.colorvalue
                .setMessage(msg)
                .setNegativeBtnText("Canel")
                .setPositiveBtnBackground(Color.parseColor("#FF4081"))  //Don't pass R.color.colorvalue
                .setPositiveBtnText("OK")
                .setNegativeBtnBackground(Color.parseColor("#FFA9A7A8"))  //Don't pass R.color.colorvalue
                .setAnimation(Animation.POP)
                .isCancellable(false)
                .setIcon(R.drawable.ic_star_border_black_24dp, Icon.Visible)
                .OnPositiveClicked(new FancyAlertDialogListener() {
                    @Override
                    public void OnClick() {
                        iOnclickDialog.onClickButton();
                    }
                })
                .OnNegativeClicked(new FancyAlertDialogListener() {
                    @Override
                    public void OnClick() {

                    }
                })
                .build();
    }

    public void showDialog(String title, String msg) {
        new FancyAlertDialog.Builder(context)
                .setTitle(title)
                .setBackgroundColor(Color.parseColor("#FFFF9800"))  //Don't pass R.color.colorvalue
                .setMessage(msg)
                .setNegativeBtnText("Canel")
                .setPositiveBtnBackground(Color.parseColor("#FF4081"))  //Don't pass R.color.colorvalue
                .setPositiveBtnText("OK")
                .setNegativeBtnBackground(Color.parseColor("#FFA9A7A8"))  //Don't pass R.color.colorvalue
                .setAnimation(Animation.POP)
                .isCancellable(false)
                .setIcon(R.drawable.ic_star_border_black_24dp, Icon.Visible)
                .OnPositiveClicked(new FancyAlertDialogListener() {
                    @Override
                    public void OnClick() {

                    }
                })
                .OnNegativeClicked(new FancyAlertDialogListener() {
                    @Override
                    public void OnClick() {

                    }
                })
                .build();
    }
}

