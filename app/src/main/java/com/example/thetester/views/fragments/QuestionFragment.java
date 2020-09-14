package com.example.thetester.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thetester.R;
import com.example.thetester.adapter.RecycelerAdapter;
import com.example.thetester.viewHolders.RecyclerViewHolder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuestionFragment extends Fragment {

    @BindView(R.id.recycler_questions)
    RecyclerView recyclerQuestions;
    @BindView(R.id.fab_ok_add_questions)
    FloatingActionButton fabOkAddQuestions;
    String number;
    List<String> QuestionNumber;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        ButterKnife.bind(this,view);
        QuestionNumber = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            number = i + "";
            QuestionNumber.add(number);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerQuestions.setLayoutManager(linearLayoutManager);
        recyclerQuestions.setHasFixedSize(true);
        recyclerQuestions.setAdapter(new RecycelerAdapter(QuestionNumber, (AppCompatActivity) getActivity()));
        return view;
    }

    @OnClick(R.id.fab_ok_add_questions)
    public void onClick() {
    }
}
