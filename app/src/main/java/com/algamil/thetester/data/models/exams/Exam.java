
package com.algamil.thetester.data.models.exams;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Exam {

    @SerializedName("data")
    private List<ExamData> mData;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private String mStatus;

    public List<ExamData> getData() {
        return mData;
    }

    public void setData(List<ExamData> data) {
        mData = data;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
