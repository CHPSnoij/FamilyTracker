package com.example.familytracker.buisnessLayer;

import com.example.familytracker.Model.Account;
import com.example.familytracker.dataLayer.AccountDbManager;
import com.example.familytracker.dataLayer.DbController;

public class AccountManager {
    private AccountDbManager accountDbManager;

    public AccountManager(AccountDbManager accountDbManager){
        this.accountDbManager = accountDbManager;
    }

    public void CreateAccount(Account account){
        accountDbManager.createAccount(account);
    }
}
