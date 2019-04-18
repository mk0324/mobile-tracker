package com.icon.mobiletracker.main.adapter;

import com.icon.mobiletracker.data.ConfirmedTransactionList;
import com.icon.mobiletracker.data.Result;

public interface OnItemClickListener {
    void onItemClick(ConfirmedTransactionList confTList, int position);
}
