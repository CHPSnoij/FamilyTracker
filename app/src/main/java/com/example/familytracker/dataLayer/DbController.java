package com.example.familytracker.dataLayer;

import android.content.Context;

public class DbController {
    private VolleySingleton volley;
    private AccountDbManager accountDbManager;

    public DbController(Context context){
        volley = new VolleySingleton(context);
        accountDbManager = new AccountDbManager(context);
    }

    public AccountDbManager getAccountDbManager(){
        return accountDbManager;
    }

}
