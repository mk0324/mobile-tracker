package com.icon.mobiletracker.main.adapter;

import com.icon.mobiletracker.data.Result;

import java.util.ArrayList;
import java.util.List;

public interface BlockAdapterContract {
    interface View {
        void setOnClickListener(OnItemClickListener onClickListener);
        void setOnPositionListener(OnPositionListener onPositionListener);
        void notifyAdapter();
    }

    interface Model {
        ArrayList getItems();
        void setItems(ArrayList items);
        void addResults(ArrayList titles);
        //void addItems(ConfirmedTransactionList items);
        void clearItem();
    }
}
