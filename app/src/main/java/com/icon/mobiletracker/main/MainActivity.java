package com.icon.mobiletracker.main;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.toolbox.Volley;
import com.icon.mobiletracker.detail.view.BlockDetailActivity;
import com.icon.mobiletracker.R;
import com.icon.mobiletracker.ServerServiceManager;
import com.icon.mobiletracker.data.ConfirmedTransactionList;
import com.icon.mobiletracker.main.adapter.BlockAdapter;
import com.icon.mobiletracker.main.presenter.BlockContract;
import com.icon.mobiletracker.main.presenter.BlockPresenter;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements BlockContract.View{

    private BlockAdapter adapter;
    private BlockPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ServerServiceManager.requestQueue == null) {
            ServerServiceManager.requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        adapter = new BlockAdapter(this);
        presenter = new BlockPresenter();
        presenter.attachView(this);
        presenter.setAdapterModel(adapter);
        presenter.setAdapterView(adapter);
        try {
            presenter.getLastTenBlock("1");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerview_block_title);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // 여기서 BlockPresenter 로 값을 요청하면
        // BlockPresenter 에서 요청을 받아서 네트워크 요청 처리해 주고 -> 요청시 각 9개 추가 요청
        // Pull to refresh 진행시 추가 요청 -> Main UI -> BlockPresenter 로 재요청
        // BlockPresenter 에서는 다시 요청하기에 네트워크 자원 낭비 -> 한번 요청했을 때 값을 모두 객체로 저장 -> List 추가
        // List<ConfirmedTransactionList> blockList -> blockList 에 대한 값을 어디서 책임 질 것인지
        // BlockPresenter 에서 view 로 다시 필요한 값을 리스트로 전송
        // jsonObject 는 어디서 완성해서 넘겨줄 지
        // jsonObject -> jsonrpc, method, id, params
    }

    @Override
    public void onResume(){
        super.onResume();
        refreshList();
    }

    protected void refreshList() {
        //presenter.getBlockByHash();
        Log.d("refreshList : ", "요청");
    }

    @Override
    public void toast(String msg) {

    }


    @Override
    public void startDetailActivity(List<ConfirmedTransactionList> detailInfo) {
        Intent intent = new Intent(this, BlockDetailActivity.class);
        intent.putParcelableArrayListExtra("detailInfo", (ArrayList<? extends Parcelable>) detailInfo);
        startActivity(intent);
    }

    @Override
    public void onSuccessGetList() {

    }
}
