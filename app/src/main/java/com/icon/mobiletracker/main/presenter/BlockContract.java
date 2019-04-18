package com.icon.mobiletracker.main.presenter;

import com.icon.mobiletracker.main.adapter.BlockAdapterContract;
import com.icon.mobiletracker.data.ConfirmedTransactionList;

import org.json.JSONException;

import java.util.List;

public interface BlockContract {
    interface View {
        void toast(String msg);
        //void onAuthorization();
        //void onBadRequest();
        //void onSuccess();
        //void onConnectFail();
        void startDetailActivity(List<ConfirmedTransactionList> confTList);
        void onSuccessGetList();
    }

    interface Presenter {
        void getLastTenBlock(String id) throws JSONException;
        void attachView(View view);
        void detachView();
        void setAdapterView(BlockAdapterContract.View adapterView);
        void setAdapterModel(BlockAdapterContract.Model adapterModel);
    }
}
