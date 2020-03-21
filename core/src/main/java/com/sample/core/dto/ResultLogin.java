package com.sample.core.dto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultLogin {
    @SerializedName("textResult")
    @Expose
    private String textResult;
    @SerializedName("reason")
    @Expose
    private String reason;

    public ResultLogin(String textResult, String reason){
        this.textResult = textResult;
        this.reason = reason;
    }

    public String getTextResult() {
        return textResult;
    }

    public void setTextResult(String textResult) {
        this.textResult = textResult;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @NonNull
    @Override
    public String toString() {
        return "textResult :"+ textResult + "  " + "reason: " + reason;
    }
}
