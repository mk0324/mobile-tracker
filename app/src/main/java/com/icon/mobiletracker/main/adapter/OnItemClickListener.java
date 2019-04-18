package com.icon.mobiletracker.main.adapter;

import com.icon.mobiletracker.data.ConfirmedTransactionList;
import com.icon.mobiletracker.data.Result;

import java.util.List;

public interface OnItemClickListener {
    void onItemClick(List<ConfirmedTransactionList> confTList, int position);
}
