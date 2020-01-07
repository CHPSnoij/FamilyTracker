package com.example.familytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.familytracker.Model.Account;
import com.example.familytracker.buisnessLayer.AccountManager;
import com.example.familytracker.buisnessLayer.BuisnessController;

public class MainActivity extends AppCompatActivity {

    private Button addButton;
    private BuisnessController buisnessController;
    private AccountManager accountManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buisnessController = new BuisnessController(this.getApplicationContext());
        accountManager = buisnessController.getAccountManager();

        addButton = (Button) findViewById(R.id.bt_main_createnewfamilyaccount) ;
        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d("tag","message");
                accountManager.CreateAccount(new Account("vandeWant", "Password"));
            }
        });
    }


}
