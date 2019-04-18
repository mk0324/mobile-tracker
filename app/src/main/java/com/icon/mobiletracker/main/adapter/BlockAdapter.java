package com.icon.mobiletracker.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.icon.mobiletracker.data.Result;

import java.util.ArrayList;
import java.util.List;

public class BlockAdapter extends RecyclerView.Adapter<BlockViewHolder>
            implements BlockAdapterContract.View, BlockAdapterContract.Model{

    private static final String TAG = BlockAdapter.class.getSimpleName();
    private List<Result> results;
    private OnItemClickListener onItemClickListener;
    private OnPositionListener onPositionListener;
    private Context context;

    public BlockAdapter(Context context) {
        this.context = context;
        results =  new ArrayList<>();
    }

    @NonNull
    @Override
    public BlockViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        //TextView textView = new TextView();
        return new BlockViewHolder(context, parent, onItemClickListener, onPositionListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BlockViewHolder holder, int position) {
        if (holder == null)
            return;
        holder.onBind(results.get(position), position, getItemCount());
        //BlockResponse blockItem = this.blockItemsList.get(position);
        //viewHolder.bindBlockItem(blockItem);
    }

    @Override
    public int getItemCount() {
        if (results == null) {
            return 0;
        }
        return results.size();
    }

    @Override
    public void setOnClickListener(OnItemClickListener onClickListener) {
        this.onItemClickListener = onClickListener;
    }

    @Override
    public void setOnPositionListener(OnPositionListener onPositionListener) {
        this.onPositionListener = onPositionListener;
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public ArrayList getItems() {
        return (ArrayList) results;
    }

    @Override
    public void setItems(ArrayList items) {
        //Log.d(TAG, "setItems");
        results.clear();
        results = items;
        notifyDataSetChanged();
    }

    @Override
    public void addResults(ArrayList result) {
        results.addAll(result);
        notifyDataSetChanged();
    }

    @Override
    public void clearItem() {
        results.clear();
        notifyDataSetChanged();
    }
}