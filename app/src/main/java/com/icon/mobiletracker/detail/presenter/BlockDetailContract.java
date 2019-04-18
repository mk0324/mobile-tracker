package com.icon.mobiletracker.detail.presenter;

import com.icon.mobiletracker.data.TxHashResult;
import com.icon.mobiletracker.main.presenter.BlockContract;

import org.json.JSONException;

public interface BlockDetailContract {
    interface View {
        void toast(String msg);
        //void onAuthorization();
        //void onBadRequest();
        //void onSuccess();
        //void onConnectFail();
        //void startDetailActivity(ConfirmedTransactionList confTList);
        void onBindTxHashResult(TxHashResult txHashResult);
    }

    interface Presenter {
        void getTransactionByHash(String txHash) throws JSONException;
        void attachView(BlockDetailContract.View view);
        void detachView();
    }
}
