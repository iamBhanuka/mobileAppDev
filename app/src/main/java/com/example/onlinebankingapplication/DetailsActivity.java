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
    }
}
