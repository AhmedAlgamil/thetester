package com.example.thetester.views.activities.ui.correct;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.thetester.R;

public class CorrectionFragment extends Fragment {

    private CorrectionViewModel correctionViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        correctionViewModel =
                ViewModelProviders.of(this).get(CorrectionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_correction, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        correctionViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}