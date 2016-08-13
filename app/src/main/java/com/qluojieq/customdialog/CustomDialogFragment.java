package com.qluojieq.customdialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by shiliushuo-1 on 16/8/13.
 */

public class CustomDialogFragment extends DialogFragment {

    //单例模式
    public static CustomDialogFragment newInstance(int style) {
        CustomDialogFragment dialogFragment = new CustomDialogFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("style", style);
        dialogFragment.setArguments(bundle);
        return dialogFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL,R.style.Dialog_FS);
    }
//
    @Override
    public void onStart() {
        super.onStart();
        Window win = getDialog().getWindow();
//        // 一定要设置Background，如果不设置，window属性设置无效//
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics( dm );
        WindowManager.LayoutParams params = win.getAttributes();
        params.gravity = Gravity.BOTTOM;
        // 使用ViewGroup.LayoutParams，以便Dialog 宽度充满整个屏幕
        params.width =  ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        win.setAttributes(params);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        getDialog().setTitle(退出微信);//添加标题
//        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题
        View view = inflater.inflate(R.layout.dialog_fragment, container);

        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText("退出微信");
        TextView message = (TextView) view.findViewById(R.id.message);
        message.setText("是否退出微信，退出微信之后不能受到消息。是否退出微信，退出微信之后不能受到消息。" +
                "是否退出微信，退出微信之后不能受到消息。是否退出微信，退出微信之后不能受到消息。");
        view.findViewById(R.id.no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        view.findViewById(R.id.yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return view;
    }
}
