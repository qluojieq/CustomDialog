package com.qluojieq.customdialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by shiliushuo-1 on 16/8/13.
 */

public class CustomDialog extends DialogFragment {
    public interface DialogFragmentClickImpl {
        void doPositiveClick();

        void doNegativeClick();
    }



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity())
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("开始")
                .setMessage("开始")
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                DialogFragmentClickImpl impl = (DialogFragmentClickImpl) getActivity();
                                impl.doPositiveClick();
                            }
                        }
                )
                .setNegativeButton(android.R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                DialogFragmentClickImpl impl = (DialogFragmentClickImpl) getActivity();
                                impl.doNegativeClick();
                            }
                        }
                )
                .create();
        Window window = alertDialog.getWindow();
        window.setGravity(Gravity.BOTTOM);  //此处可以设置dialog显示的位置
        window.setBackgroundDrawableResource(R.color.colorAccent);
        window.setWindowAnimations(R.style.mystyle);  //添加动画
        WindowManager.LayoutParams layoutParams =  window.getAttributes();
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        window.setAttributes(layoutParams);
        return alertDialog;
    }
}
