package com.icon.mobiletracker.detail.model;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.icon.mobiletracker.ServerServiceManager;
import com.icon.mobiletracker.data.ConfirmedTransactionList;
import com.icon.mobiletracker.data.Result;
import com.icon.mobiletracker.data.TxHashResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockDetailRequestService {
    private BlockDetailRequestCallback.RequestCallback callback;

    public void setCallback(BlockDetailRequestCallback.RequestCallback callback) {
        this.callback = callback;
    }

    public void getTransactionByHash(String txHash) throws JSONException{
        String url = "https://" + ServerServiceManager.host;
        JSONObject jsonObject = new JSONObject();
        JSONObject params = new JSONObject();

        jsonObject.put("jsonrpc", "2.0");
        jsonObject.put("method", "icx_getTransactionByHash");
        jsonObject.put("id", "txHash");
        params.put("txHash", txHash);
        jsonObject.put("params", params);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                url,
                jsonObject,
                response -> {
                    JSONObject result;
                    try {
                        result = (JSONObject) response.get("result");
                        hashResult(result);
                        callback.onSuccess(hashResult(result));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.d("TAG", response.toString());
                    }
                },
                error -> Log.e("TAG", error.getMessage(), error)
        ) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> HeaderParams = new HashMap<>();
                HeaderParams.put("Content-Type", "application/json");
                return HeaderParams;
            }
        };
        request.setShouldCache(false);
        ServerServiceManager.requestQueue.add(request);
    }

    public TxHashResult hashResult(JSONObject result){
        TxHashResult resultObj = new TxHashResult();


        try {
            resultObj.setVersion(result.get("version").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            resultObj.setFrom(result.get("from").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            resultObj.setTo(result.get("to").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            resultObj.setValue(result.get("value").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            resultObj.setStepLimit(result.get("stepLimit").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            resultObj.setTimestamp(result.get("timestamp").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            resultObj.setNid(result.get("nid").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            resultObj.setNonce(result.get("nonce").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            resultObj.setTxHash(result.get("txHash").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            resultObj.setTxIndex(result.get("txIndex").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            resultObj.setBlockHeight(result.get("blockHeight").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            resultObj.setBlockHash(result.get("blockHash").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            resultObj.setSignature(result.get("signature").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return resultObj;
    }
}

