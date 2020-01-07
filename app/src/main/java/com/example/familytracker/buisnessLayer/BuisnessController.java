package com.example.familytracker.buisnessLayer;

import android.content.Context;

import com.example.familytracker.dataLayer.DbController;

public class BuisnessController {
    private DbController dbController;
    private AccountManager accountManager;

    public BuisnessController(Context context){
        dbController = new DbController(context);
        accountManager = new AccountManager(dbController.getAccountDbManager());
    }

    public AccountManager getAccountManager(){
        return accountManager;
    }
}
