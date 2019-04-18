package com.icon.mobiletracker.main.presenter;

import com.icon.mobiletracker.data.ConfirmedTransactionList;
import com.icon.mobiletracker.data.Result;
import com.icon.mobiletracker.main.adapter.BlockAdapterContract;
import com.icon.mobiletracker.main.adapter.OnItemClickListener;
import com.icon.mobiletracker.main.adapter.OnPositionListener;
import com.icon.mobiletracker.main.model.RequestService;
import com.icon.mobiletracker.main.model.RequestServiceCallback;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class BlockPresenter
        implements BlockContract.Presenter, RequestServiceCallback.RequestCallback,
        OnItemClickListener, OnPositionListener {

    private RequestService requestService;
    private BlockContract.View view;
    private BlockAdapterContract.View adapterView;
    private BlockAdapterContract.Model adapterModel;

    public BlockPresenter() {
        requestService = new RequestService();
        requestService.setCallback(this);
    }

    @Override
    public void setAdapterView(BlockAdapterContract.View adapterView) {
        this.adapterView = adapterView;
        this.adapterView.setOnClickListener(this);
        this.adapterView.setOnPositionListener(this);
    }

    @Override
    public void setAdapterModel(BlockAdapterContract.Model adapterModel) {
        this.adapterModel = adapterModel;
    }

    @Override
    public void getLastTenBlock(String id) throws JSONException {
        requestService.getLastBlock(id);
    }

    @Override
    public void attachView(BlockContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void onSuccess(List<Result> results) {
        //public void onSuccess(int id, String hash, String prevHash) {
        //String hash;
        /*hash = jsonObject.get("prev_block_hash").toString();
        JSONObject confTList = (JSONObject) jsonObject.get("confirmed_transaction_list");
        JSONObject data = (JSONObject) confTList.get("data");
        JSONObject params = (JSONObject) data.get("params");*/
        //adapterModel.addResults(hash);
        adapterModel.addResults((ArrayList) results);
        /*if(id < 3){
            getBlockByHash(String.valueOf(id+1), prevHash);
        }*/
        /*adapterModel.addItems(new ConfirmedTransactionList(
                confTList.get("version").toString(),
                confTList.get("from").toString(),
                confTList.get("to").toString(),
                confTList.get("value").toString(),
                confTList.get("stepLimit").toString(),
                confTList.get("timestamp").toString(),
                confTList.get("nid").toString(),
                confTList.get("nonce").toString(),
                confTList.get("signature").toString(),
                confTList.get("txHash").toString(),
                confTList.get("dataType").toString(),
                new Data(
                        data.get("method").toString(),
                        new Params(
                                params.get("_to").toString(),
                                params.get("_value").toString()
                        )
                )
        ));*/
        view.onSuccessGetList();
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onLoad(int page) {

    }

    @Override
    public void onItemClick(ConfirmedTransactionList confTList, int position) {
        view.startDetailActivity(confTList);
    }
}
