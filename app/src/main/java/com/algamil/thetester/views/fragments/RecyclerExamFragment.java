package com.algamil.thetester.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.algamil.thetester.R;
import com.algamil.thetester.helper.HelperMethod;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecyclerExamFragment extends Fragment {

    @BindView(R.id.recycler_view_exams)
    RecyclerView recyclerViewExams;
    @BindView(R.id.fab_add_exam)
    FloatingActionButton fabAddExam;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exam, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.fab_add_exam)
    public void onClick() {
        HelperMethod.replaceFragment(getActivity().getSupportFragmentManager(),R.id.frame_screen_adding,new AddExamFragment());
    }
}
