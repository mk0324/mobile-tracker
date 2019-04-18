package com.icon.mobiletracker.data;

import android.os.Parcel;
import android.os.Parcelable;

public class TxHashResult implements Parcelable {
    private String version;
    private String from;
    private String to;
    private String value;
    private String stepLimit;
    private String timestamp;
    private String nid;
    private String nonce;
    private String txHash;
    private String txIndex;
    private String blockHeight;
    private String blockHash;
    private String signature;

    private String dataType;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getStepLimit() {
        return stepLimit;
    }

    public void setStepLimit(String stepLimit) {
        this.stepLimit = stepLimit;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public String getTxIndex() {
        return txIndex;
    }

    public void setTxIndex(String txIndex) {
        this.txIndex = txIndex;
    }

    public String getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(String blockHeight) {
        this.blockHeight = blockHeight;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.version);
        dest.writeString(this.from);
        dest.writeString(this.to);
        dest.writeString(this.value);
        dest.writeString(this.stepLimit);
        dest.writeString(this.timestamp);
        dest.writeString(this.nid);
        dest.writeString(this.nonce);
        dest.writeString(this.txHash);
        dest.writeString(this.txIndex);
        dest.writeString(this.blockHeight);
        dest.writeString(this.blockHash);
        dest.writeString(this.signature);
        dest.writeString(this.dataType);
    }

    public TxHashResult() {
    }

    protected TxHashResult(Parcel in) {
        this.version = in.readString();
        this.from = in.readString();
        this.to = in.readString();
        this.value = in.readString();
        this.stepLimit = in.readString();
        this.timestamp = in.readString();
        this.nid = in.readString();
        this.nonce = in.readString();
        this.txHash = in.readString();
        this.txIndex = in.readString();
        this.blockHeight = in.readString();
        this.blockHash = in.readString();
        this.signature = in.readString();
        this.dataType = in.readString();
    }

    public static final Creator<TxHashResult> CREATOR = new Creator<TxHashResult>() {
        @Override
        public TxHashResult createFromParcel(Parcel source) {
            return new TxHashResult(source);
        }

        @Override
        public TxHashResult[] newArray(int size) {
            return new TxHashResult[size];
        }
    };
}

