package com.example.onlinebankingapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private EditText etnic;
    private EditText etacc_number;
    private EditText etfname;
    private EditText etlname;
    private EditText etphoneNumber;
    private EditText etemail;
    private EditText etaddress;

    Spinner salutation;
    DatePicker datePicker1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnic = findViewById(R.id.etnic);
        etacc_number = findViewById(R.id.acc_number);
        etfname = findViewById(R.id.fname);
        etlname = findViewById(R.id.lname);
        etphoneNumber = findViewById(R.id.phoneNumber);
        etemail = findViewById(R.id.email);
        etaddress = findViewById(R.id.address);
        Button reset = (Button)findViewById(R.id.reset);
      final  DatePicker dp= (DatePicker) findViewById(R.id.datePicker1);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etnic.setText("");
                etacc_number.setText("");
                etaddress.setText("");
                etemail.setText("");
                etfname.setText("");
                etlname.setText("");
                etphoneNumber.setText("");

            }
        });


        Spinner dropdown = findViewById(R.id.salutation);
        String[] items = new String[]{"Mr.", "Ms.", "Prof.","Dr","Rev."};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

    }
    private boolean validatenicl() {
        String nicInput = etnic.getText().toString().trim();
        if (nicInput.isEmpty()) {
            etnic.setError("Field can't be empty");
            return false;
        } else {
            etnic.setError(null);
            return true;
        }
    }

    private boolean validateacnumber() {
        String nicInput = etacc_number.getText().toString().trim();
        if (nicInput.isEmpty()) {
            etacc_number.setError("Field can't be empty");
            return false;
        } else {
            etacc_number.setError(null);
            return true;
        }
    }

    private boolean validatefname() {
        String nicInput = etfname.getText().toString().trim();
        if (nicInput.isEmpty()) {
            etfname.setError("Field can't be empty");
            return false;
        } else {
            etfname.setError(null);
            return true;
        }
    }
    private boolean validatelname() {
        String nicInput = etnic.getText().toString().trim();
        if (nicInput.isEmpty()) {
            etlname.setError("Field can't be empty");
            return false;
        } else {
            etlname.setError(null);
            return true;
        }
    }
    private boolean validatephonenumber() {
        String nicInput = etphoneNumber.getText().toString().trim();

        if (nicInput.isEmpty()) {
            etphoneNumber.setError("Field can't be empty");
            return false;
//            if (!Pattern.matches("(\\d{3}-){1,2}\\d{4}",s)) {
//                etphoneNumber.setError("Enter a valid Phone Number");
//            }

        } else {
            etphoneNumber.setError(null);
            return true;
        }
    }
    private boolean validateemail() {
        String nicInput = etemail.getText().toString().trim();
        if (nicInput.isEmpty()) {
            etemail.setError("Field can't be empty");
            return false;
        } else {
            etemail.setError(null);
            return true;
        }
    }
    private boolean validateaddress() {
        String nicInput = etnic.getText().toString().trim();
        if (nicInput.isEmpty()) {
            etaddress.setError("Field can't be empty");
            return false;
        } else {
            etaddress.setError(null);
            return true;
        }
    }
    public void confirmInput(View v) {
        if (!validatenicl() | !validateacnumber() | validateaddress() | validateemail() | validatefname() | validatelname() | validatephonenumber()) {

            return;
        }
        String input = "NIC: " + etnic.getText().toString();
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }


    }
