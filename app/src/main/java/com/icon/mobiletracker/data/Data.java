package com.icon.mobiletracker.data;

public class Data {
    public Data(String method, Params params) {
        this.method = method;
        this.params = params;
    }

    private String method;
    private Params params;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

}
