package com.icon.mobiletracker.main.model;

import android.util.Log;

import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.JsonIOException;
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

public class BlockRequestService {
    private BlockRequestCallback.RequestCallback callback;
    private List<Result> results;
    //private List<String> titles;

    public BlockRequestService() {
        //titles = new ArrayList<>();
        results = new ArrayList<>();
    }

    public void setCallback(BlockRequestCallback.RequestCallback callback) {
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

    public void storeConfTList(JSONObject result) {
        Result resultObj = new Result();
        List<ConfirmedTransactionList> confTList = new ArrayList<>();

        try {
            resultObj.setBlockHash(result.get("block_hash").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = null;
        try {
            jsonArray = (JSONArray) result.get("confirmed_transaction_list");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = null;
            try {
                object = jsonArray.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ConfirmedTransactionList confTListObj = new ConfirmedTransactionList();
            try {
                confTListObj.setVersion(object.get("version").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                confTListObj.setFrom(object.get("from").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                confTListObj.setTo(object.get("to").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                confTListObj.setValue(object.get("value").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                confTListObj.setStepLimit(object.get("stepLimit").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                confTListObj.setTimestamp(object.get("timestamp").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                confTListObj.setNid(object.get("nid").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                confTListObj.setNonce(object.get("nonce").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                confTListObj.setSignature(object.get("signature").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                confTListObj.setTxHash(object.get("txHash").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                confTListObj.setDataType(object.get("dataType").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //confTListObj.setData(confTList.get("data").toString());
            confTList.add(confTListObj);
        }
        resultObj.setConfirmedTransactionList(confTList);

        results.add(resultObj);
    }
}

