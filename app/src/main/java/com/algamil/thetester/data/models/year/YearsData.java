
package com.algamil.thetester.data.models.year;

import com.google.gson.annotations.SerializedName;

public class YearsData {

    @SerializedName("id")
    private String mId;
    @SerializedName("years")
    private String mYears;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getYears() {
        return mYears;
    }

    public void setYears(String years) {
        mYears = years;
    }

}
