package com.example.covid19vaccinesurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText dateOfBirth;
    EditText nameSurname;
    EditText city;
    EditText gender;
    EditText vaccineType;
    EditText sideEffects;
    EditText casesAndSymptoms;
    Button buttonSend;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateOfBirth = findViewById(R.id.tv_date);
        nameSurname = findViewById(R.id.name_surname);
        city = findViewById(R.id.city);
        gender = findViewById(R.id.gender);
        vaccineType = findViewById(R.id.vaccine_type);
        sideEffects = findViewById(R.id.side_effects);
        casesAndSymptoms = findViewById(R.id.cases_and_symptoms);
        buttonSend = findViewById(R.id.send);

        nameSurname.addTextChangedListener(enterTextWatcher);
        city.addTextChangedListener(enterTextWatcher);
        gender.addTextChangedListener(enterTextWatcher);
        vaccineType.addTextChangedListener(enterTextWatcher);
        sideEffects.addTextChangedListener(enterTextWatcher);
        casesAndSymptoms.addTextChangedListener(enterTextWatcher);
        dateOfBirth.addTextChangedListener(enterTextWatcher);

        // etDate = findViewById(R.id.et_date);

        Calendar calendar = Calendar.getInstance();

        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        setListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                dateOfBirth.setText(date);
            }
        };

        /*etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = day + "/" + month + year;
                        etDate.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });*/
    }
    private TextWatcher enterTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String userName = nameSurname.getText().toString().trim();
            String userCity = city.getText().toString().trim();
            String userGender = gender.getText().toString().trim();
            String userVaccine = vaccineType.getText().toString().trim();
            String userSideEffect = sideEffects.getText().toString().trim();
            String userCaseNSymptom = casesAndSymptoms.getText().toString().trim();
            String userDate = dateOfBirth.getText().toString().trim();

            buttonSend.setEnabled(!userName.isEmpty() && !userCity.isEmpty() && !userGender.isEmpty() &&
                    !userVaccine.isEmpty() && !userSideEffect.isEmpty() && !userCaseNSymptom.isEmpty() && !userDate.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}