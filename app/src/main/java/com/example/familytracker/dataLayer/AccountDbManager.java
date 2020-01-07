package com.example.familytracker.dataLayer;



import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

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

        VolleyLog.DEBUG = true;
        RequestQueue queue = volley.getRequestQueue();
        // String uri_page_one = String.format("/api/users?page=%1$s");

        HashMap headers = new HashMap();
        headers.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

// body fixen
        JSONObject params = new JSONObject();

        try{

            JSONObject statement = new JSONObject();
            statement.put("statement","CREATE (n:account) RETURN id(n)" );

            JSONArray jsonArrayStatments = new JSONArray();
            jsonArrayStatments.put(0,statement);

            params.put("statements", jsonArrayStatments);

//            JSONArray jArray = params.getJSONArray("statements");
//            for(int ii=0; ii < jArray.length(); ii++){
//                Log.d("Body builder",jArray.getJSONObject(ii).getString("value"));
//            }

        } catch (Exception e) {
            Log.d("request builder error", e.getMessage());
        }

// request bouwen
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.POST, "https://hobby-amliolnkjhecgbkenjccfial.dbs.graphenedb.com:24780/db/data/transaction/commit", params,  new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("D", "RESPONSE FOUND!");
                        try{
                            int errorcode = response.getInt("errorCode");
                            Log.d("error", errorcode + "");
                            String errormessage = response.getString("errorMessage");
                            Log.d("error", errormessage);
                            JSONObject data = response.getJSONObject("data");
                            JSONArray results =  data.getJSONArray("results");

                            JSONArray errors =  data.getJSONArray("errors");
                            JSONObject firstError = errors.getJSONObject(0);
                            Log.d("resonse error code", firstError.getString("code"));
                            Log.d("resonse error message", firstError.getString("message"));
                            String token = data.getString("token");
                            Toast.makeText(context,"Token: " + token, Toast.LENGTH_SHORT).show();
                        } catch (Exception ex) {

                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        VolleyLog.e("Error: ", error.getMessage());
                    }
                });

        queue.add(jsObjRequest);

    }
}