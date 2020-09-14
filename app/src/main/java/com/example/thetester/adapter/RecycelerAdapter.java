package com.example.thetester.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thetester.helper.HelperMethod;
import com.example.thetester.views.fragments.ChooseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycelerAdapter extends RecyclerView.Adapter<RecycelerAdapter.NewRecyclerView> {

    List<String> questionsNumber;
    String[] question_type;
    AppCompatActivity activity;

    public RecycelerAdapter(List<String> questionsNumber,AppCompatActivity appCompatActivity) {
        this.questionsNumber = questionsNumber;
        this.activity = appCompatActivity;
    }

    @NonNull
    @Override
    public NewRecyclerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_style_recyclerview, parent
                , false);

        question_type = new String[]{activity.getResources().getString(R.string.title_choose)
                ,activity.getResources().getString(R.string.title_yes_or_not),
                activity.getResources().getString(R.string.title_why)
                ,activity.getResources().getString(R.string.title_complete)};

        return new NewRecyclerView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewRecyclerView holder, int position) {

        String quetion_number = activity.getResources().getString(R.string.question_number) + " " + questionsNumber.get(position);
        holder.questionNumber.setText(quetion_number);


        ArrayAdapter arrayAdapter = new ArrayAdapter(activity,android.R.layout.simple_spinner_dropdown_item,question_type);
        holder.selectQuestionType.setAdapter(arrayAdapter);
        holder.selectQuestionType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0)
                {
                    HelperMethod.replaceFragment(activity.getSupportFragmentManager(),R.id.recyler_frame,new ChooseFragment());
                }
                else if(position == 1)
                {
                    HelperMethod.replaceFragment(activity.getSupportFragmentManager(),R.id.recyler_frame,new ChooseFragment());
                }
                else if(position == 2)
                {
                    HelperMethod.replaceFragment(activity.getSupportFragmentManager(),R.id.recyler_frame,new ChooseFragment());
                }
                else if(position == 3)
                {
                    HelperMethod.replaceFragment(activity.getSupportFragmentManager(),R.id.recyler_frame,new ChooseFragment());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public static class NewRecyclerView extends RecyclerView.ViewHolder {


        @BindView(R.id.question_number)
        TextView questionNumber;
        @BindView(R.id.select_question_type)
        Spinner selectQuestionType;
        @BindView(R.id.recyler_frame)
        FrameLayout recylerFrame;


        public NewRecyclerView(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
