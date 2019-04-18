package com.icon.mobiletracker.detail.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.icon.mobiletracker.R;
import com.icon.mobiletracker.data.ConfirmedTransactionList;
import com.icon.mobiletracker.data.TxHashResult;
import com.icon.mobiletracker.detail.presenter.BlockDetailContract;
import com.icon.mobiletracker.detail.presenter.BlockDetailPresenter;

import org.json.JSONException;

import java.util.List;

public class BlockDetailActivity extends AppCompatActivity
        implements BlockDetailContract.View {

    private BlockDetailPresenter presenter;
    private TxHashResult txHashResult;

    private TextView title;
    private TextView confTContents;
    private TextView txHashTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_detail);

        Intent intent = getIntent();
        List<ConfirmedTransactionList> confTList = intent.getParcelableArrayListExtra("detailInfo");
        title = findViewById(R.id.detail_view_title);
        confTContents = findViewById(R.id.detail_view_contents);
        txHashTransaction = findViewById(R.id.detail_view_txHash_transaction_result);

        presenter = new BlockDetailPresenter();
        presenter.attachView(this);

        try {
            presenter.getTransactionByHash(confTList.get(0).getTxHash());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        title.setText(
                "from : " + confTList.get(0).getFrom() +"\n" +
                "to : " + confTList.get(0).getTo() + "\n" +
                "txHash : " + confTList.get(0).getTxHash());

        for (int i = 0; i<confTList.size(); i++) {
            if(i==confTList.size()-1){
                confTContents.append(
                        "version : " + confTList.get(i).getVersion() + "\n" +
                                "value : " + confTList.get(i).getValue() + "\n" +
                                "stepLimit : " + confTList.get(i).getStepLimit() + "\n" +
                                "timestamp : " + confTList.get(i).getTimestamp() + "\n" +
                                "nid : " + confTList.get(i).getNid() + "\n" +
                                "nonce : " + confTList.get(i).getNonce() + "\n" +
                                "signature : " + confTList.get(i).getSignature() + "\n" +
                                "dataType : " + confTList.get(i).getDataType());
            }
            confTContents.append(
                    "version : " + confTList.get(i).getVersion() + "\n" +
                            "value : " + confTList.get(i).getValue() + "\n" +
                            "stepLimit : " + confTList.get(i).getStepLimit() + "\n" +
                            "timestamp : " + confTList.get(i).getTimestamp() + "\n" +
                            "nid : " + confTList.get(i).getNid() + "\n" +
                            "nonce : " + confTList.get(i).getNonce() + "\n" +
                            "signature : " + confTList.get(i).getSignature() + "\n" +
                            "dataType : " + confTList.get(i).getDataType() + "\n\n");
        }
    }

    public void refresh(){
        onResume();
    }

    @Override
    public void toast(String msg) {

    }

    @Override
    public void onBindTxHashResult(TxHashResult txHashResult) {
        this.txHashResult = txHashResult;

        txHashTransaction.setText(
                "version : " + txHashResult.getVersion() + "\n" +
                        "from : " + txHashResult.getFrom() +"\n" +
                        "to : " + txHashResult.getTo() + "\n" +
                        "value : " + txHashResult.getValue() + "\n" +
                        "stepLimit : " + txHashResult.getStepLimit() + "\n" +
                        "timestamp : " + txHashResult.getTimestamp() + "\n" +
                        "nid : " + txHashResult.getNid() + "\n" +
                        "nonce : " + txHashResult.getNonce() + "\n" +
                        "txHash : " + txHashResult.getTxHash() + "\n" +
                        "txIndex : " + txHashResult.getTxIndex() + "\n" +
                        "blockHeight : " + txHashResult.getBlockHeight() + "\n" +
                        "blockHash : " + txHashResult.getBlockHash() + "\n" +
                        "signature : " + txHashResult.getSignature() + "\n" +
                        "dataType : " + txHashResult.getDataType());

        refresh();
    }
}
