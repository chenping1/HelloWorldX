package com.cp.helloworldx.android.architect;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class AppViewModel extends AndroidViewModel {
    public int index = 2;
    public MutableLiveData<String>  titleValue = new MutableLiveData<>();

    public AppViewModel(@NonNull Application application) {
        super(application);
    }
}
