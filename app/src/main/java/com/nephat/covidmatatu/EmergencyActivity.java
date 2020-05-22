package com.nephat.covidmatatu;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class EmergencyActivity extends AppCompatActivity {

    private static final String TAG = "EmergencyActivity";
    private static final String[] SACCOS = new String[]{
            "Kukena", "4NK", "4NTE", "Embasava", "Eastliegh Commuters", "Jonsaga", "Latema",
            "Super Metro", "Metro Trans", "City Hoppa", "KBS", "Walokana", "Naboka sacco",
            "Nyara sacco", "Nanyuki cab", "NPA", "NJUPACOM", "Nyahururu Rumuruti", "Njuri Nceke"
    };

    //Widgets
    private Spinner mSpinner;
    private AutoCompleteTextView mSacco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        mSpinner = findViewById(R.id.spinner);

        ArrayAdapter<String> emergencyTypeAdapter = new ArrayAdapter<String>(EmergencyActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.emergency_list));
        emergencyTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(emergencyTypeAdapter);

        mSacco = findViewById(R.id.enterSaccoName);
        ArrayAdapter<String> saccoAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, SACCOS);
        mSacco.setAdapter(saccoAdapter);
        String saccoName = mSacco.getText().toString();
    }
}
