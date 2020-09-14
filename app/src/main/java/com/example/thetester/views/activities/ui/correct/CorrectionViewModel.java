package com.example.thetester.views.activities.ui.correct;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CorrectionViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CorrectionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}