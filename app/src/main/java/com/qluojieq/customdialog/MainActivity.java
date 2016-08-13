package com.qluojieq.customdialog;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CustomDialog.DialogFragmentClickImpl {
    Button alertDialog;
    Button alertDialogFragment;
    Button dialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alertDialog = (Button) findViewById(R.id.testButtonAlertDialog);
        alertDialog.setOnClickListener(this);
        alertDialogFragment = (Button) findViewById(R.id.testButtonDialogFragment);
        alertDialogFragment.setOnClickListener(this);
        dialogFragment = (Button) findViewById(R.id.testButtonDialogFragmentC);
        dialogFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.testButtonDialogFragment:
                Utils.alertDialogFragment(MainActivity.this);
                break;
            case R.id.testButtonAlertDialog:
                Utils.alertDialog(MainActivity.this);
                break;
            case R.id.testButtonDialogFragmentC:
                Utils.dialogFragment(MainActivity.this);
                break;
        }

    }

    @Override
    public void doPositiveClick() {
        Toast.makeText(this, "确定", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void doNegativeClick() {
        Toast.makeText(this, "取消", Toast.LENGTH_SHORT).show();

    }
}
