package com.example.familytracker.dataLayer;



import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.familytracker.Model.Account;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDbManager {

    private VolleySingleton volley;
    private Context context;
    RequestQueue requestQueue;

    public AccountDbManager(Context context){
        this.volley = VolleySingleton.getInstance(context);
        this.context = context;
    }



    public Account getAccount(String username) {

        return new Account("","");
    }

    public void createAccount(Account account){
        volley.sendRequest("CREATE (n:Account{ Username:'"+account.getUsername()+"', Password:'"+account.getPassword()+"' }) RETURN id(n)");

    }
}