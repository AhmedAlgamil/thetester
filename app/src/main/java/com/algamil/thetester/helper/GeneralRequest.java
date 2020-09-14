package com.algamil.thetester.helper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.algamil.thetester.R;
import com.algamil.thetester.data.local.TinyDB;
import com.algamil.thetester.data.models.GeneralData.GeneralResponse;
import com.algamil.thetester.data.models.exams.Exam;
import com.algamil.thetester.data.models.year.Years;
import com.algamil.thetester.views.activities.AuthActivity;
import com.algamil.thetester.views.activities.QuestionActivity;
import com.algamil.thetester.views.fragments.SubjectsFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.os.Build.ID;
import static com.algamil.thetester.data.local.SharedPreferencesManger.REMEMBER_ME;
import static com.algamil.thetester.data.local.SharedPreferencesManger.TEACHER_ID;
import static com.algamil.thetester.data.local.SharedPreferencesManger.USER_DATA;
import static com.algamil.thetester.data.local.SharedPreferencesManger.saveData;
import static com.algamil.thetester.helper.Constant.LOGIN;
import static com.algamil.thetester.helper.Constant.REGISTER;

public class GeneralRequest {

    public static void onAuth(Call<GeneralResponse> call, String phone, String password, boolean rememberMe, Activity activity
            , String actionType) {

        if(actionType == LOGIN)
        {
            call.enqueue(new Callback<GeneralResponse>() {
                @Override
                public void onResponse(@NonNull Call<GeneralResponse> call,@NonNull Response<GeneralResponse> response) {
                    try {
                        if (response.body().getStatus().equals("true")) {
                            TinyDB tinyDB = new TinyDB(activity);
                            tinyDB.putBoolean(REMEMBER_ME,rememberMe);
                            tinyDB.putString(ID,response.body().getTescheId());
                            Intent intent =new Intent(activity, AuthActivity.class);
                            activity.startActivity(intent);
                            activity.finish();
                        }

                    } catch (Exception e) {

                    }
                }

                @Override
                public void onFailure(@NonNull Call<GeneralResponse> call,@NonNull Throwable t) {
                }
            });
        }
    }

    public static void makeEditProfile(Call<Exam> call, Activity activity)
    {
        call.enqueue(new Callback<Exam>() {
            @Override
            public void onResponse(Call<Exam> call, Response<Exam> response) {
                try {
                    if(response.body().getStatus().equals("true"))
                    {
                        Toast.makeText(activity, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(activity, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
                catch (Exception e)
                {

                }
            }

            @Override
            public void onFailure(Call<Exam> call, Throwable t) {
                try {
                    Toast.makeText(activity, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {

                }
            }
        });
    }

    public static void addingExams(Call<Exam> call,Activity activity)
    {
        call.enqueue(new Callback<Exam>() {
            @Override
            public void onResponse(Call<Exam> call, Response<Exam> response) {
                try{
                    if(response.body().getStatus().equals("true")) {
                        Toast.makeText(activity, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(activity, QuestionActivity.class);
                        activity.startActivity(intent);
                    }
                }
                catch (Exception e)
                {

                }
            }

            @Override
            public void onFailure(Call<Exam> call, Throwable t) {
                try{

                }
                catch (Exception e)
                {

                }
            }
        });
    }

    public static void makeSignUp(Call<GeneralResponse> call, Activity activity, FragmentManager getChildFragmentManager
            , String actionType)
    {
        call.enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
                try
                {
                    if(actionType == REGISTER) {
                        if(response.body().getStatus().equals("true")) {
                            saveData(activity, TEACHER_ID, response.body().getTescheId());
                            Bundle b = new Bundle();
                            b.putString("teacher_id",response.body().getTescheId());
                            HelperMethod.replaceFragmentWithData(getChildFragmentManager,R.id.frame_container,new SubjectsFragment(), b);
                        }
                        else
                        {
                            Toast.makeText(activity, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                catch (Exception e)
                {

                }
            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {
                try {
                    Toast.makeText(activity, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {

                }
            }
        });
    }

    public static void choose_subjects(Call<GeneralResponse> call,Activity activity)
    {
        call.enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
                try{
                    if(response.body().equals("true"))
                    {

                    }
                    Toast.makeText(activity, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {

                }

            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {
                try{
                    Toast.makeText(activity, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {

                }
            }
        });

    }


    public static void deleteSubject(Call<GeneralResponse> call,Activity activity)
    {
        call.enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
                try{
                    if(response.body().equals("true"))
                    {

                    }

                }
                catch (Exception e)
                {

                }

            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {
                try{
                    Toast.makeText(activity, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {

                }
            }
        });

    }



}
