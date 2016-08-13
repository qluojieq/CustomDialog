package com.qluojieq.customdialog;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;

import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by shiliushuo-1 on 16/8/13.
 */

public class Utils {

    public static void alertDialog(final Activity context) {
        AlertDialog dialog = new AlertDialog.Builder(context).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "" + i, Toast.LENGTH_SHORT).show();
            }
        })
                .setTitle("title").setMessage("message").create();

        Window dialogWindow = dialog.getWindow();
        dialogWindow.setBackgroundDrawableResource(R.color.colorAccent);
        dialogWindow.setGravity(Gravity.BOTTOM);
        dialogWindow.setWindowAnimations(R.style.mystyle);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialogWindow.setAttributes(lp);


//        DisplayMetrics dm = new DisplayMetrics();
//        Window window = dialog.getWindow();
//        context.getWindowManager().getDefaultDisplay().getMetrics( dm );
//        WindowManager.LayoutParams params = window.getAttributes();
//        params.windowAnimations = R.style.mystyle;
//        params.gravity = Gravity.BOTTOM;
//        // 使用ViewGroup.LayoutParams，以便Dialog 宽度充满整个屏幕
//        params.width =  ViewGroup.LayoutParams.MATCH_PARENT;
//        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//        window.setAttributes(params);
        dialog.show();

//        WindowManager windowManager = context.getWindowManager();
//        Display display = windowManager.getDefaultDisplay();
//        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
//        lp.width = (int)(display.getWidth()); //设置宽度
//        window.setAttributes(lp);
    }

    public static void alertDialogFragment(Activity context) {

        FragmentTransaction ft = context.getFragmentManager().beginTransaction();
        Fragment fragment = context.getFragmentManager().findFragmentByTag("123");
        if (null != fragment) {
            ft.remove(fragment);
        }

        CustomDialog dialogFragment = new CustomDialog();

        dialogFragment.show(ft, "123");
    }

    public static void dialogFragment(Activity context) {
        FragmentTransaction ft = context.getFragmentManager().beginTransaction();
        Fragment fragment = context.getFragmentManager().findFragmentByTag("234");
        if (null != fragment) {
            ft.remove(fragment);
        }
        CustomDialogFragment dialogFragment = CustomDialogFragment.newInstance(0);
        dialogFragment.show(ft, "234");
    }

}
