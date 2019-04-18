package com.icon.mobiletracker.data;

import android.os.Parcel;
import android.os.Parcelable;

public class ConfirmedTransactionList implements Parcelable {

    public ConfirmedTransactionList(){}

    public ConfirmedTransactionList(
            String version,
            String from,
            String to,
            String value,
            String stepLimit,
            String timestamp,
            String nid,
            String nonce,
            String signature,
            String txHash,
            String dataType,
            Data data
    ) {
        this.version = version;
        this.from = from;
        this.to = to;
        this.value = value;
        this.stepLimit = stepLimit;
        this.timestamp = timestamp;
        this.nid = nid;
        this.nonce = nonce;
        this.signature = signature;
        this.txHash = txHash;
        this.dataType = dataType;
        this.data = data;
    }

    private String version;
    private String from;
    private String to;
    private String value;
    private String stepLimit;
    private String timestamp;
    private String nid;
    private String nonce;
    private String signature;
    private String txHash;
    private String dataType;
    private Data data;

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

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
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
        dest.writeString(this.signature);
        dest.writeString(this.txHash);
        dest.writeString(this.dataType);
        dest.writeParcelable((Parcelable) this.data, flags);
    }

    protected ConfirmedTransactionList(Parcel in) {
        this.version = in.readString();
        this.from = in.readString();
        this.to = in.readString();
        this.value = in.readString();
        this.stepLimit = in.readString();
        this.timestamp = in.readString();
        this.nid = in.readString();
        this.nonce = in.readString();
        this.signature = in.readString();
        this.txHash = in.readString();
        this.dataType = in.readString();
        this.data = in.readParcelable(Data.class.getClassLoader());
    }

    public static final Parcelable.Creator<ConfirmedTransactionList> CREATOR = new Parcelable.Creator<ConfirmedTransactionList>() {
        @Override
        public ConfirmedTransactionList createFromParcel(Parcel source) {
            return new ConfirmedTransactionList(source);
        }

        @Override
        public ConfirmedTransactionList[] newArray(int size) {
            return new ConfirmedTransactionList[size];
        }
    };
}
