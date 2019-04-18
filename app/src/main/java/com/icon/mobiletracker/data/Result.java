package com.icon.mobiletracker.data;


import java.util.List;

public class Result {

    public Result(){}

    private String version;
    private String prevBlockHash;
    private String merkleTreeRootHash;
    private Integer timeStamp;
    private List<ConfirmedTransactionList> confirmedTransactionList = null;
    private String blockHash;
    private Integer height;
    private String peerId;
    private String signature;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPrevBlockHash() {
        return prevBlockHash;
    }

    public void setPrevBlockHash(String prevBlockHash) {
        this.prevBlockHash = prevBlockHash;
    }

    public String getMerkleTreeRootHash() {
        return merkleTreeRootHash;
    }

    public void setMerkleTreeRootHash(String merkleTreeRootHash) {
        this.merkleTreeRootHash = merkleTreeRootHash;
    }

    public Integer getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Integer timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<ConfirmedTransactionList> getConfirmedTransactionList() {
        return confirmedTransactionList;
    }

    public void setConfirmedTransactionList(List<ConfirmedTransactionList> confirmedTransactionList) {
        this.confirmedTransactionList = confirmedTransactionList;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getPeerId() {
        return peerId;
    }

    public void setPeerId(String peerId) {
        this.peerId = peerId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

}
