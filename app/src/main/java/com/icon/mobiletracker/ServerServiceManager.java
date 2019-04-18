package com.icon.mobiletracker;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class ServerServiceManager {
    public static RequestQueue requestQueue;

    public static String host = "bicon.net.solidwallet.io/api/v3";

    public static RequestQueue getRequestQueue(Context context) {
        return Volley.newRequestQueue(context);
    }
}
