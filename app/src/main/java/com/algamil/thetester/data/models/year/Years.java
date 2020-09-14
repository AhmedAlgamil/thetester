
package com.algamil.thetester.data.models.year;

import java.util.List;
import com.google.gson.annotations.SerializedName;
public class Years {

    @SerializedName("data")
    private List<YearsData> mData;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private String mStatus;

    public List<YearsData> getData() {
        return mData;
    }

    public void setData(List<YearsData> data) {
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
