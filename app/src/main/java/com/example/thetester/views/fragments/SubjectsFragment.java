package com.example.thetester.views.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.thetester.R;
import com.example.thetester.data.datastructure.StringHighArray;
import com.example.thetester.data.local.SharedPreferencesManger;
import com.example.thetester.data.models.GeneralData.GeneralResponse;
import com.example.thetester.helper.GeneralRequest;
import com.example.thetester.helper.HelperMethod;
import com.example.thetester.views.activities.AuthActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.thetester.data.api.ApiClient.getApiClient;
import static com.example.thetester.data.local.SharedPreferencesManger.CHECKED_DATA;
import static com.example.thetester.data.local.SharedPreferencesManger.TEACHER_ID;

public class SubjectsFragment extends Fragment {


    @BindView(R.id.lv_subjects)
    ListView lvSubjects;
    @BindView(R.id.btn_register)
    Button btnRegister;
    StringHighArray subjectsName;
    String itemChecked;
    private String subject_id;
    public SubjectsFragment() {
        // Required empty public constructor
    }
    SparseBooleanArray checked;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_subject, container, false);
        ButterKnife.bind(this, view);
        getAllSubjects();
        return view;
    }

    public void getAllSubjects() {
        getApiClient().getAllSubjects().enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
                try {
                    makecheckbox(response);
                }
                catch (Exception e)
                {

                }
            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {
                try {
                    Toast.makeText(getActivity(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {

                }
            }
        });
    }

    public void makecheckbox(Response<GeneralResponse> response) {

        subjectsName = new StringHighArray(response.body().getData().size());
        for (int i = 0; i < response.body().getData().size(); i++) {
            subjectsName.insert(response.body().getData().get(i).getSubjectName());
        }
        lvSubjects.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),
                android.R.layout.select_dialog_multichoice
                , subjectsName.getStringArray()) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(android.R.id.text1);
                checkedTextView.setTextColor(getResources().getColor(R.color.white));
                return view;
            }
        };
        lvSubjects.setAdapter(arrayAdapter);
        SharedPreferencesManger.clean(getActivity());
        //checkingsubjects(response);
        makeitemsAction(response);
    }

    public void makeitemsAction(Response<GeneralResponse> response)
    {
        lvSubjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(lvSubjects.isItemChecked(position))
                {
                    choosingSubjects(response.body().getData().get(position).getId(),
                            SharedPreferencesManger.loadData(getActivity(),TEACHER_ID));
                }
                else {
                    deletingSubjects(response.body().getData().get(position).getId(),
                            SharedPreferencesManger.loadData(getActivity(),TEACHER_ID));
                }
//
            }

        });
        checked = lvSubjects.getCheckedItemPositions();
        SharedPreferencesManger.saveData(getActivity(),CHECKED_DATA,checked);
    }

    public void checkingsubjects(SparseBooleanArray checking)
    {

        if(SharedPreferencesManger.loadData(getActivity(),TEACHER_ID) ==
                SharedPreferencesManger.loadData(getActivity(),TEACHER_ID))
        {
            for (int i = 0; i < checking.size(); i++)
            {
                lvSubjects.setItemChecked(i,true);
            }
        }
        else
        {
            for (int i = 0; i < checking.size(); i++)
            {
                lvSubjects.setItemChecked(i,false);
            }
        }
    }

    public void deletingSubjects(String subject_id,String teache_id)
    {
        GeneralRequest.deleteSubject(getApiClient().deleteSubjects(subject_id,teache_id),getActivity());
    }

    public void choosingSubjects(String subject_id,String teache_id)
    {
        GeneralRequest.choose_subjects(getApiClient().insertSubjects(subject_id,teache_id),getActivity());
    }

    @OnClick(R.id.btn_register)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), AuthActivity.class);
        startActivity(intent);
    }
}
