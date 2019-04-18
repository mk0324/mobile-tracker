package com.icon.mobiletracker.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.icon.mobiletracker.R;
import com.icon.mobiletracker.data.ConfirmedTransactionList;
import com.icon.mobiletracker.data.Result;
import com.icon.mobiletracker.detail.presenter.BlockDetailPresenter;
import com.icon.mobiletracker.main.presenter.BlockPresenter;

import org.json.JSONException;

public class BlockViewHolder extends RecyclerView.ViewHolder{
    private OnItemClickListener onItemClickListener;
    private OnPositionListener onPositionListener;
    private BlockPresenter presenter;
    private TextView titleTextView;

    public BlockViewHolder(final Context context, ViewGroup parent, OnItemClickListener onItemClickListener, OnPositionListener onPositionListener) {
        super(LayoutInflater.from(context).inflate(R.layout.block_item, parent, false));
        this.onItemClickListener = onItemClickListener;
        this.onPositionListener = onPositionListener;
        presenter = new BlockPresenter();

        titleTextView = itemView.findViewById(R.id.block_title);
    }

    public void onBind(Result result, int position, int listSize){
        titleTextView.setText(result.getBlockHash());
        titleTextView.setOnClickListener(v -> onItemClickListener.onItemClick(result.getConfirmedTransactionList(), position));
        /*if (position == listSize - 1) {
            int page = (listSize / 10) + 1;
            onPositionListener.onLoad(page);
        }*/
    }
}

