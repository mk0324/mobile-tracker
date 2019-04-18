package com.icon.mobiletracker.main.model;

import com.icon.mobiletracker.data.Result;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public interface BlockRequestCallback {
    interface RequestCallback {
        void onSuccess(List<Result> results);
        void onSuccess(Result result);
        //void onSuccessPrev();
        void onFailure();
    }
}
