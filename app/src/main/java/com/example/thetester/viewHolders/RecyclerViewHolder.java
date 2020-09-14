package com.example.thetester.viewHolders;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;


public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView textTitle;
    public LinearLayout linearChoose,linearYesOrNot,linearWhy,linearCompelete;
    FrameLayout recyclerFrameLayout;

    public FragmentManager fragmentManager;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
//        textTitle = (TextView) itemView.findViewById(R.id.question_number);
//        linearChoose = (LinearLayout) itemView.findViewById(R.id.ll_choose);
//        linearChoose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(itemView.getContext(), "hello i am LinearLayout Choose from fragmentManager" + textTitle.getText(), Toast.LENGTH_SHORT).show();
//                HelperMethod.replaceFragment(fragmentManager,R.id.frame_recycler,new AddExamFragment());
//            }
//        });
//        linearYesOrNot = (LinearLayout) itemView.findViewById(R.id.ll_yes_or_not);
//        linearYesOrNot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(itemView.getContext(), "hello i am LinearLayout yes or not from fragmentManager" + textTitle.getText(), Toast.LENGTH_SHORT).show();
//                HelperMethod.replaceFragment(fragmentManager,R.id.frame_recycler,new LoginFragment());
//            }
//        });
//        linearWhy = (LinearLayout) itemView.findViewById(R.id.ll_why);
//        linearWhy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(itemView.getContext(), "hello i am LinearLayout why question from fragmentManager" + textTitle.getText(), Toast.LENGTH_SHORT).show();
//                HelperMethod.replaceFragment(fragmentManager,R.id.frame_recycler,new NextFragment());
//            }
//        });
//        linearCompelete = (LinearLayout) itemView.findViewById(R.id.ll_complete);
//        linearCompelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(itemView.getContext(), "hello i am LinearLayout compelete from fragmentManager" + textTitle.getText(), Toast.LENGTH_SHORT).show();
//                HelperMethod.replaceFragment(fragmentManager,R.id.frame_recycler,new SubjectsFragment());
//            }
//        });
//        recyclerFrameLayout = (FrameLayout)itemView.findViewById(R.id.frame_recycler);
//    }
//
    }

}
