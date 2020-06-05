package com.example.onlinebankingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Details details = (Details) getIntent().getSerializableExtra("details");
        ((TextView) findViewById(R.id.tv_nic)).setText(details.getNic());
        ((TextView) findViewById(R.id.tv_accnumber)).setText(details.getAccNumber());
        ((TextView) findViewById(R.id.tv_mr)).setText(details.getSalute1());
        ((TextView) findViewById(R.id.tv_mr)).setText(details.getGetSalute2());
        ((TextView) findViewById(R.id.tv_fname)).setText(details.getFirstName());
        ((TextView) findViewById(R.id.tv_lname)).setText(details.getLastName());
        ((TextView) findViewById(R.id.tv_phone)).setText(details.getPhoneNumber());
        ((TextView) findViewById(R.id.tv_email)).setText(details.getEmail());
        ((TextView) findViewById(R.id.tv_address)).setText(details.getAddress());

    }
}

