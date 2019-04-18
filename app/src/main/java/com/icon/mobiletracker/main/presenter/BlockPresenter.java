package com.icon.mobiletracker.main.presenter;

import com.icon.mobiletracker.data.ConfirmedTransactionList;
import com.icon.mobiletracker.data.Result;
import com.icon.mobiletracker.main.adapter.BlockAdapterContract;
import com.icon.mobiletracker.main.adapter.OnItemClickListener;
import com.icon.mobiletracker.main.adapter.OnPositionListener;
import com.icon.mobiletracker.main.model.BlockRequestService;
import com.icon.mobiletracker.main.model.BlockRequestCallback;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class BlockPresenter
        implements BlockContract.Presenter, BlockRequestCallback.RequestCallback,
        OnItemClickListener, OnPositionListener {

    private BlockRequestService requestService;
    private BlockContract.View view;
    private BlockAdapterContract.View adapterView;
    private BlockAdapterContract.Model adapterModel;

    public BlockPresenter() {
        requestService = new BlockRequestService();
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
        adapterModel.addResults((ArrayList) results);
        view.onSuccessGetList();
    }

    @Override
    public void onSuccess(Result result) {

    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onLoad(int page) {

    }

    @Override
    public void onItemClick(List<ConfirmedTransactionList> confTList, int position) {
        view.startDetailActivity(confTList);
    }
}
