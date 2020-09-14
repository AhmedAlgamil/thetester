package com.algamil.thetester.data.models.GeneralData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GeneralResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tesche_id")
    @Expose
    private String tescheId;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<GeneralResponseData> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTescheId() {
        return tescheId;
    }

    public void setTescheId(String tescheId) {
        this.tescheId = tescheId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<GeneralResponseData> getData() {
        return data;
    }

    public void setData(List<GeneralResponseData> data) {
        this.data = data;
    }
}
