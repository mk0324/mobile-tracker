package com.icon.mobiletracker.detail.presenter;
import com.icon.mobiletracker.data.Result;
import com.icon.mobiletracker.data.TxHashResult;
import com.icon.mobiletracker.detail.model.BlockDetailRequestCallback;
import com.icon.mobiletracker.detail.model.BlockDetailRequestService;

import org.json.JSONException;

public class BlockDetailPresenter
        implements BlockDetailContract.Presenter, BlockDetailRequestCallback.RequestCallback{

    private BlockDetailRequestService requestService;
    private BlockDetailContract.View view;

    public BlockDetailPresenter() {
        requestService = new BlockDetailRequestService();
        requestService.setCallback(this);
    }

    @Override
    public void onSuccess(TxHashResult result) {
        view.onBindTxHashResult(result);
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void getTransactionByHash(String txHash) throws JSONException {
        requestService.getTransactionByHash(txHash);
    }

    @Override
    public void attachView(BlockDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }
}
