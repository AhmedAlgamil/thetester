package com.algamil.thetester.views.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.algamil.thetester.R;
import com.algamil.thetester.data.datastructure.StringHighArray;
import com.algamil.thetester.data.local.TinyDB;
import com.algamil.thetester.data.models.GeneralData.GeneralResponse;
import com.algamil.thetester.data.models.year.Years;
import com.algamil.thetester.helper.GeneralRequest;
import com.algamil.thetester.helper.HelperMethod;
import com.algamil.thetester.views.activities.QuestionActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.os.Build.ID;
import static com.algamil.thetester.data.api.ApiClient.getApiClient;
import static com.algamil.thetester.data.local.SharedPreferencesManger.YEARS_DATA;

public class AddExamFragment extends Fragment {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.tx_exam_name)
    TextInputEditText txExamName;
    @BindView(R.id.tx_exam_time)
    TextInputEditText txExamTime;
    @BindView(R.id.tx_exam_degree)
    TextInputEditText txExamDegree;
    @BindView(R.id.tx_exam_start_time)
    TextInputEditText txExamStartTime;
    @BindView(R.id.tx_exam_end_time)
    TextInputEditText txExamEndTime;
    @BindView(R.id.sp_add_exam_years)
    Spinner spAddExamYears;
    @BindView(R.id.sp_add_exam_subjects)
    Spinner spAddExamSubjects;
    @BindView(R.id.fab_ok_add_exam)
    FloatingActionButton fabOkAddExam;

    String year;
    String[] years;
    StringHighArray subjects,subjects_id;
    TinyDB tinydb;
    String teacher_id;
    String mySubjectId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_exam, container, false);
        ButterKnife.bind(this, view);
        getYears();
        tinydb = new TinyDB(getContext());
        teacher_id = tinydb.getString(ID);
        getSubjectsOfTeachers(teacher_id);
        return view;
    }

    @OnClick({R.id.tx_exam_time, R.id.tx_exam_start_time, R.id.tx_exam_end_time, R.id.fab_ok_add_exam})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tx_exam_time:
                HelperMethod.showTime(getContext(),txExamTime.getHint().toString(),txExamTime,true);
                break;
            case R.id.tx_exam_start_time:
                HelperMethod.showTime(getContext(),txExamStartTime.getHint().toString(),txExamStartTime,true);
                break;
            case R.id.tx_exam_end_time:
                HelperMethod.showTime(getContext(),txExamEndTime.getHint().toString(),txExamEndTime,true);
                break;
            case R.id.fab_ok_add_exam:
                fab_ok_add(txExamName.getText().toString()
                        ,txExamTime.getText().toString()
                        ,txExamDegree.getText().toString()
                        ,txExamStartTime.getText().toString()
                        ,txExamEndTime.getText().toString()
                        ,year
                        ,mySubjectId
                        ,teacher_id);
                break;
        }
    }

    public void getYears()
    {
        getApiClient().getAllyears().enqueue(new Callback<Years>() {
            @Override
            public void onResponse(Call<Years> call, Response<Years> response) {
                try{
                    if(response.body().getStatus().equals("true")) {
                        years = new String[response.body().getData().size()];
                        for(int i =0;i<years.length;i++)
                        {
                            years[i] = response.body().getData().get(i).getYears();
                        }
                        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_dropdown_item
                        ,years);

                        spAddExamYears.setAdapter(arrayAdapter);
                        spAddExamYears.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                year = response.body().getData().get(position).getId();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }
                    else {

                    }
                }
                catch (Exception e)
                {

                }
            }

            @Override
            public void onFailure(Call<Years> call, Throwable t) {
                try{

                }
                catch (Exception e)
                {

                }
            }
        });
    }

    public void getAllSubjectsTeachers(String subject_id)
    {
        getApiClient().getsubjects_teachers_with_id(subject_id).enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
                try{
                    if(response.body().getStatus().equals("true"))
                    {
                        subjects.insert(response.body().getData().get(0).getSubjectName());
                        Log.d("Subject_namesssss", response.body().getData().get(0).getSubjectName());
                        subjects_id.insert(subject_id);
                        ArrayAdapter<String> arrsubject = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item
                        ,subjects.getStringArray());
                        spAddExamSubjects.setAdapter(arrsubject);
                        spAddExamSubjects.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                mySubjectId = subjects_id.getStringArray()[position];
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }
                }
                catch (Exception e)
                {

                }
            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {
                try{

                }
                catch (Exception e)
                {

                }
            }
        });
    }



    public void getSubjectsOfTeachers(String teacher_id)
    {
        getApiClient().getsubjects_teachers(teacher_id).enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
                try{
                    if(response.body().getStatus().equals("true"))
                    {
                        subjects = new StringHighArray(response.body().getData().size());
                        subjects_id = new StringHighArray(response.body().getData().size());
                        for (int i = 0; i < response.body().getData().size(); i++) {
                            getAllSubjectsTeachers(response.body().getData().get(i).getSubjectId());
                        }
                    }
                }
                catch (Exception e)
                {

                }
            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {
                try{

                }
                catch (Exception e)
                {

                }
            }
        });
    }

    public void fab_ok_add
            (String examName
            ,String time
            ,String examDegree
            ,String startTime
            ,String endTime
            ,String years
            ,String subject
            ,String teacher_id)
    {
        GeneralRequest.addingExams(getApiClient().addExam(examName,time,examDegree,startTime,endTime,years,subject,teacher_id),getActivity());
        Intent intent = new Intent(getActivity(), QuestionActivity.class);
        startActivity(intent);
    }

}
