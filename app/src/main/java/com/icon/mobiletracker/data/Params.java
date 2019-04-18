package com.icon.mobiletracker.data;

public class Params {
    public Params(String to, String value) {
        this.to = to;
        this.value = value;
    }

    private String to;
    private String value;

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

}
