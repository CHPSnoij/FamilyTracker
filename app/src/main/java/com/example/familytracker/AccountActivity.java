package com.example.familytracker;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.familytracker.Model.Account;
import com.example.familytracker.buisnessLayer.AccountManager;
import com.example.familytracker.buisnessLayer.BuisnessController;

public class AccountActivity extends AppCompatActivity {

    private Button addButton;
    private BuisnessController buisnessController;
    private AccountManager accountManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        buisnessController = new BuisnessController(this.getApplicationContext());
        accountManager = buisnessController.getAccountManager();

        addButton = (Button) findViewById(R.id.bt_account_create_account) ;
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
