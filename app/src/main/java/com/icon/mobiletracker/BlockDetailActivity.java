package com.icon.mobiletracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.icon.mobiletracker.data.ConfirmedTransactionList;

public class BlockDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_detail);

        Intent intent = getIntent();
        ConfirmedTransactionList confTList = intent.getParcelableExtra("detailInfo");
        TextView title = findViewById(R.id.detail_view_title);
        TextView confTContents = findViewById(R.id.detail_view_contents);
        TextView txHashResult = findViewById(R.id.detail_view_txHash_transaction_result);

        title.setText(
                "from : " + confTList.getFrom() +"\n" +
                "to : " + confTList.getTo() + "\n" +
                "txHash : " + confTList.getTxHash());

        confTContents.setText(
                "version : " + confTList.getVersion() + "\n" +
                "value : " + confTList.getValue() + "\n" +
                "stepLimit : " + confTList.getStepLimit() + "\n" +
                "timestamp : " + confTList.getTimestamp() + "\n" +
                "nid : " + confTList.getNid() + "\n" +
                "nonce : " + confTList.getNonce() + "\n" +
                "signature : " + confTList.getSignature() + "\n" +
                "dataTape : " + confTList.getDataType());

        txHashResult.setText("");
    }


}
