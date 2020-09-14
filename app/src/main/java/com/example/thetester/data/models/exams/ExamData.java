
package com.example.thetester.data.models.exams;


import com.google.gson.annotations.SerializedName;

public class ExamData {

    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("end_time")
    private String mEndTime;
    @SerializedName("exam_degree")
    private String mExamDegree;
    @SerializedName("exam_name")
    private String mExamName;
    @SerializedName("id")
    private String mId;
    @SerializedName("start_time")
    private String mStartTime;
    @SerializedName("subject_id")
    private String mSubjectId;
    @SerializedName("teacher_id")
    private String mTeacherId;
    @SerializedName("time")
    private String mTime;
    @SerializedName("updated_at")
    private String mUpdatedAt;
    @SerializedName("year_id")
    private String mYearId;

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getEndTime() {
        return mEndTime;
    }

    public void setEndTime(String endTime) {
        mEndTime = endTime;
    }

    public String getExamDegree() {
        return mExamDegree;
    }

    public void setExamDegree(String examDegree) {
        mExamDegree = examDegree;
    }

    public String getExamName() {
        return mExamName;
    }

    public void setExamName(String examName) {
        mExamName = examName;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getStartTime() {
        return mStartTime;
    }

    public void setStartTime(String startTime) {
        mStartTime = startTime;
    }

    public String getSubjectId() {
        return mSubjectId;
    }

    public void setSubjectId(String subjectId) {
        mSubjectId = subjectId;
    }

    public String getTeacherId() {
        return mTeacherId;
    }

    public void setTeacherId(String teacherId) {
        mTeacherId = teacherId;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public String getYearId() {
        return mYearId;
    }

    public void setYearId(String yearId) {
        mYearId = yearId;
    }

}
