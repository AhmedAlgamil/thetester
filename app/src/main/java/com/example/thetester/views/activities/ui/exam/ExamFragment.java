package com.example.thetester.views.activities.ui.exam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.thetester.R;
import com.example.thetester.helper.HelperMethod;
import com.example.thetester.views.fragments.RecyclerExamFragment;


public class ExamFragment extends Fragment {

    private ExamViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(ExamViewModel.class);
        View root = inflater.inflate(R.layout.fragment_screen_adding, container, false);
        HelperMethod.replaceFragment(getActivity().getSupportFragmentManager(),R.id.frame_screen_adding,new RecyclerExamFragment());
        return root;
    }
}
