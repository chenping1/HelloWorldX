package com.cp.helloworldx.android.architect;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.cp.helloworldx.R;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);
                AppViewModel appViewModel =  ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(AppViewModel.class);
        ((TextView)findViewById(R.id.tv_title)).setText("value = "+appViewModel.index);
        appViewModel.titleValue.setValue("333");
    }

/*    public static void showConfirmDialog(Context context, String content, MaterialDialog.SingleButtonCallback callback) {
        new MaterialDialog.Builder(context)
                .content(content)
                .positiveText("确认")
                .negativeText("取消")
                .negativeColor(AppResourceMgr.getColor(context,R.color.dialog_negative_color))
                .onPositive(callback)
                .show();
    }*/
}
