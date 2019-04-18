package com.icon.mobiletracker.main.model;

import android.util.Log;

import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.JsonObject;
import com.icon.mobiletracker.ServerServiceManager;
import com.icon.mobiletracker.data.ConfirmedTransactionList;
import com.icon.mobiletracker.data.Result;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestService {
    private RequestServiceCallback.RequestCallback callback;
    private List<Result> results;
    //private List<String> titles;

    public RequestService() {
        //titles = new ArrayList<>();
        results = new ArrayList<>();
    }

    public void setCallback(RequestServiceCallback.RequestCallback callback) {
        this.callback = callback;
    }

    public void getLastBlock(String id) throws JSONException {
        String url = "https://" + ServerServiceManager.host;
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", id);
        jsonObject.put("jsonrpc", "2.0");
        jsonObject.put("method", "icx_getLastBlock");

        JsonObjectRequest request = new JsonObjectRequest(
                url,
                jsonObject,
                response -> {
                    JSONObject result;
                    try {
                        result = (JSONObject) response.get("result");
                        String prevHash = result.get("prev_block_hash").toString();
                        storeConfTList(result);
                        getBlockByHash(response.get("id").toString(), prevHash);
                        //callback.onSuccess(getId, hash, prevHash);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.d("TAG", response.toString());
                    }
                    //blockList.add(parseJSONResultToPOJO(result));
                    /*result.get("prev_block_hash").toString();
                    for (int i = 0; i <= getId; i++) {
                        Log.d("TAG", i + " : " + blockList.get(i).toString());
                    }*/
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

    public void getBlockByHash(String id, String hash) throws JSONException {
        String url = "https://" + ServerServiceManager.host;
        JSONObject jsonObject = new JSONObject();
        JSONObject params = new JSONObject();
        String editedHash = "0x" + hash;

        jsonObject.put("jsonrpc", "2.0");
        jsonObject.put("method", "icx_getBlockByHash");
        jsonObject.put("id", id);
        params.put("hash", editedHash);
        jsonObject.put("params", params);

        JsonObjectRequest request = new JsonObjectRequest(
                url,
                jsonObject,
                response -> {
                    JSONObject result;
                    try {
                        int getId = Integer.parseInt(response.get("id").toString());
                        result = (JSONObject) response.get("result");
                        String prevHash = result.get("prev_block_hash").toString();

                        storeConfTList(result);
                        if (getId < 10) {
                            getBlockByHash(String.valueOf(getId + 1), prevHash);
                        } else {
                            callback.onSuccess(results);
                        }
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

    public void storeConfTList(JSONObject result){
        Result resultObj = new Result();
        List<ConfirmedTransactionList> confTList = new ArrayList<>();


        try {
            resultObj.setBlockHash(result.get("block_hash").toString());
            JSONArray jsonArray = (JSONArray) result.get("confirmed_transaction_list");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                ConfirmedTransactionList confTListObj = new ConfirmedTransactionList();
                confTListObj.setTo(object.get("to").toString());
                confTListObj.setFrom(object.get("from").toString());
                confTListObj.setStepLimit(object.get("stepLimit").toString());
                confTListObj.setNid(object.get("nid").toString());
                confTListObj.setVersion(object.get("version").toString());
                confTListObj.setTimestamp(object.get("timestamp").toString());
                confTListObj.setDataType(object.get("dataType").toString());
                //confTListObj.setData(confTList.get("data").toString());
                confTListObj.setSignature(object.get("signature").toString());
                confTListObj.setTxHash(object.get("txHash").toString());
                confTList.add(confTListObj);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        resultObj.setConfirmedTransactionList(confTList);

        results.add(resultObj);
    }
}

