package com.cp.helloworldx.android.architect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cp.helloworldx.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }

//        new WorkManagerX(this,null);
    }
}
