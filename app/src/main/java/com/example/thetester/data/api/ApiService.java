package com.example.thetester.data.api;

import com.example.thetester.data.models.GeneralData.GeneralResponse;
import com.example.thetester.data.models.exams.Exam;
import com.example.thetester.data.models.year.Years;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("teachers/Login.php")
    @FormUrlEncoded
    Call<GeneralResponse> login(@Field("phone") String phone
            , @Field("password") String password);


    @FormUrlEncoded
    @POST("teachers/insert.php")
    Call<GeneralResponse> signUp(@Field("name") String name
            , @Field("email") String email
            , @Field("phone") String phone
            , @Field("password") String password
            , @Field("image_url") String image_url
    );

    @FormUrlEncoded
    @POST("exams/insert.php")
    Call<Exam> addExam(
              @Field("exam_name") String exam_name
            , @Field("time") String time
            , @Field("exam_degree") String exam_degree
            , @Field("start_time") String start_time
            , @Field("end_time") String end_time
            , @Field("year_id") String year_id
            , @Field("subject_id") String subject_id
            , @Field("teacher_id") String teacher_id
    );

    @GET("subjects/select.php")
    Call<GeneralResponse> getAllSubjects();

    @FormUrlEncoded
    @POST("subjects_teachers/insert.php")
    Call<GeneralResponse> insertSubjects(@Field("subject_id") String subject_id,@Field("teachers_id") String teacher_id);

    @FormUrlEncoded
    @POST("subjects_teachers/delete.php")
    Call<GeneralResponse> deleteSubjects(@Field("subject_id") String subject_id,@Field("teachers_id") String teacher_id);

    @FormUrlEncoded
    @POST("subjects/selectwithid.php")
    Call<GeneralResponse> get_subject(@Field("subject_id") String subject_id);

    @FormUrlEncoded
    @POST("subjects_teachers/select.php")
    Call<GeneralResponse> getsubjects_teachers(@Field("teachers_id") String teachers_id);

    @FormUrlEncoded
    @POST("subjects/selectwithid.php")
    Call<GeneralResponse> getsubjects_teachers_with_id(@Field("subject_id") String subject_id);


    @GET("years/select.php")
    Call<Years> getAllyears();

}
