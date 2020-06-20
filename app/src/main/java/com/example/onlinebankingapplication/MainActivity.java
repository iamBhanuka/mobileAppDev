package com.example.onlinebankingapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import org.threeten.bp.LocalDate;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNic;
    private EditText etAccNumber;
    private Spinner spSalutation;
    private String[] salutes = {"Mr.", "Ms.", "Prof.", "Dr.", "Rev.", "Other", "Select Salute"};
    private EditText etSalute;
    private EditText etFirstName;
    private EditText etLastName;
    private DatePicker dpDob;
    private EditText etPhoneNumber;
    private EditText etEmail;
    private EditText etAddress;
    private Button btnReset;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindUI();
    }

    private void bindUI() {
        etNic = findViewById(R.id.et_nic);
        etAccNumber = findViewById(R.id.et_acc_number);
        spSalutation = findViewById(R.id.sp_salutation);
        etSalute = findViewById(R.id.et_salutation);
        etFirstName = findViewById(R.id.et_first_name);
        etLastName = findViewById(R.id.et_last_name);
        dpDob = findViewById(R.id.dp_dob);
        etPhoneNumber = findViewById(R.id.et_phone_number);
        etEmail = findViewById(R.id.et_email);
        etAddress = findViewById(R.id.et_address);
        btnSubmit = findViewById(R.id.btn_submit);
        btnReset = findViewById(R.id.btn_reset);

        ArrayAdapter saluteAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, salutes) {
            @Override
            public int getCount() {
                return salutes.length - 1;
            }
        };
        spSalutation.setAdapter(saluteAdapter);
        spSalutation.setSelection(salutes.length - 1);
        spSalutation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                etSalute.setEnabled(salutes[position].equals("Other"));
                if (!salutes[position].equals("Other")) etSalute.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        dpDob.setMaxDate(Calendar.getInstance().getTimeInMillis());
        btnSubmit.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    private boolean validate() {
        boolean valid = true;

        if (isEmptyNIC()) {
            valid = false;
            etNic.setError("Nic can't be empty!");
        }

        if (isEmptyAccNumber()) {
            valid = false;
            etAccNumber.setError("Account number can't be empty!");
        } else {
            if (!isAccNumberValid()) {
                valid = false;
                etAccNumber.setError("Account number should start from 0");
            }
        }

        if (!isSaluteSelected()) {
            valid = false;
            ((AppCompatTextView) spSalutation.getSelectedView()).setError("Select an valid salute!");
        } else {
            if (spSalutation.getSelectedItem().toString().equals("Other") && isEmptySalute()) {
                valid = false;
                etSalute.setError("enter an salute");
            }
        }

        if (isEmptyFirstName()) {
            valid = false;
            etFirstName.setError("First Name cam't be empty!");
        }

        if (isEmptyLastName()) {
            valid = false;
            etLastName.setError("Last Name cam't be empty!");
        }

        if (!isValidPhoneNumber()) {
            valid = false;
            etPhoneNumber.setError("Phone number invalid!");
        }

        if (!isValidEmail()) {
            valid = false;
            etEmail.setError("Email invalid!");
        }

        if (isEmptyAddress()) {
            valid = false;
            etAddress.setError("Address empty!");
        }
        return valid;
    }

    private boolean isEmptyNIC() {
        return isEmptyEditText(etNic);
    }

    private boolean isEmptyAccNumber() {
        return isEmptyEditText(etAccNumber);
    }

    private boolean isAccNumberValid() {
        String accNumber = etAccNumber.getText().toString();
        return accNumber.startsWith("0");
    }

    private boolean isSaluteSelected() {
        return spSalutation.getSelectedItemPosition() != salutes.length - 1;
    }

    private boolean isEmptySalute() {
        return isEmptyEditText(etSalute);
    }

    private boolean isEmptyFirstName() {
        return isEmptyEditText(etFirstName);
    }

    private boolean isEmptyLastName() {
        return isEmptyEditText(etLastName);
    }

    private boolean isValidPhoneNumber() {
        return Pattern.compile("^[0-9]{10}$").matcher(etPhoneNumber.getText()).matches();
    }

    private boolean isValidEmail() {
        return Pattern.matches(Patterns.EMAIL_ADDRESS.pattern(), etEmail.getText().toString());
    }

    private boolean isEmptyAddress() {
        return isEmptyEditText(etAddress);
    }

    private boolean isEmptyEditText(EditText et) {
        String text = et.getText().toString();
        return text.isEmpty();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                if (validate()) {
                    new AlertDialog.Builder(this)
                            .setTitle("Confirm")
                            .setMessage("Are you sure you want to confirm!")
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Details details = createDetails();
//                                    System.out.println(details.toString());
//                                    Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
//                                    intent.putExtra("details", details);
//                                    startActivity(intent);
                                    startService(details);
                                }
                            })
                            .setNegativeButton(android.R.string.no, null)
                            .show();
                }
                break;
            case R.id.btn_reset:
                reset();
        }
    }

    private void reset() {
        etNic.setText("");
        etAccNumber.setText("");
        spSalutation.setSelection(salutes.length - 1);
        etSalute.setText("");
        etFirstName.setText("");
        etLastName.setText("");
        LocalDate date = LocalDate.now();
        dpDob.updateDate(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
        etPhoneNumber.setText("");
        etEmail.setText("");
        etAddress.setText("");
    }

    private Details createDetails() {
        String nic = etNic.getText().toString();
        String accNumber = etAccNumber.getText().toString();
        String salute1 = spSalutation.getSelectedItem().toString();
        String salute2 = etSalute.getText().toString();
        String firstName = etFirstName.getText().toString();
        String lastName = etLastName.getText().toString();
        int dobYear = dpDob.getYear();
        int dobMonth = dpDob.getMonth() + 1;
        int dobDay = dpDob.getDayOfMonth();
        String phoneNumber = etPhoneNumber.getText().toString();
        String email = etEmail.getText().toString();
        String address = etAddress.getText().toString();

        return new Details(nic, accNumber, salute1, salute2, firstName, lastName, dobYear, dobMonth, dobDay, phoneNumber, email, address);

    }

    private void startService(Details details) {
        Intent serviceIntent = new Intent(this, Postmaster.class);
        Bundle data = new Bundle();
        data.putSerializable("details", details);
        serviceIntent.putExtras(data);
        startService(serviceIntent);
    }
}