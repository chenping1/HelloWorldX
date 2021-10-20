package com.cp.helloworldx.android.architect;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.cp.helloworldx.R;
import com.cp.helloworldx.android.architect.jetpack.hilt.HiltActivity;

public class MainActivity extends AppCompatActivity {
    AppViewModel appViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
     /*   if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }*/

         appViewModel =  ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(AppViewModel.class);
        appViewModel.index = 111;
        ((TextView)findViewById(R.id.tv_title)).setText("value = "+appViewModel.index);
        appViewModel.titleValue.observeForever( new Observer<String>() {
            @Override
            public void onChanged(String s) {
                ((TextView)findViewById(R.id.tv_title)).setText(s + "|" + appViewModel.index);
            }
        });
        String test = "5226-2.9\"圆形茶杯   10.5元         百年理工";

        String test2 = test.replaceAll("\"","22");

        Log.d("TAG",test2);

        LifecycleObserverX observerX = new LifecycleObserverX();

        getLifecycle().addObserver(observerX);

        new AlertDialog.Builder(this)
                .setTitle("多选dialog")
                .setMessage("value = "+appViewModel)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));

            }
        }).create().show();

//        new WorkManagerX(this,null);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
