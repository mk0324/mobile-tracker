package com.icon.mobiletracker.detail.model;

import com.icon.mobiletracker.data.TxHashResult;


public interface BlockDetailRequestCallback {
    interface RequestCallback {
        void onSuccess(TxHashResult result);
        void onFailure();
    }
}
