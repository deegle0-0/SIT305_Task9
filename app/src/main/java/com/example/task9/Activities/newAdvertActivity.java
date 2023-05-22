package com.example.task9.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.task9.BuildConfig;
import com.example.task9.R;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.Arrays;

public class newAdvertActivity extends AppCompatActivity {

    RadioGroup radioGroup;

    Button save;
    EditText name,phone,desc,date;

    String location2;
    Double lat;
    Double lon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_advert);

        save = findViewById(R.id.button);
        name= findViewById(R.id.itemName);
        phone= findViewById(R.id.phoneNo);
        desc= findViewById(R.id.itemDesc);
        date= findViewById(R.id.date);
        radioGroup = findViewById(R.id.radioGroup);

        Places.initialize(getApplicationContext(), BuildConfig.API_KEY);// can add api key regularly or buildConfig.apikey

        // Initialize the AutocompleteSupportFragment.
        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment2);

        // Specify the types of place data to return.
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME,Place.Field.LAT_LNG));

        // Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull Place place) {
                // TODO: Get info about the selected place.
                location2 = place.getName();
                lat = place.getLatLng().latitude;
                lon = place.getLatLng().longitude;

                Log.i("Tag", "Place: " + place.getName() + ", " + place.getId());
                Log.i("Tag", "Lat Long: " + lat + ", " + lon);

            }
            @Override
            public void onError(@NonNull Status status) {
                // TODO: Handle the error.
                Log.i("Tag", "An error occurred: " + status);
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.lostItem)
                {
                    boolean found = false;
                    save.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent();
                            if(TextUtils.isEmpty(name.getText())){
                                setResult(RESULT_CANCELED, intent);
                            }
                            else{
                                String nameValue = name.getText().toString();
                                String descValue = desc.getText().toString();
                                String phoneVal = phone.getText().toString();
                                String dateVal = date.getText().toString();

                                intent.putExtra("add_value1", nameValue);
                                intent.putExtra("add_value2", descValue);
                                intent.putExtra("add_value3", phoneVal);
                                intent.putExtra("add_value4", dateVal);
                                intent.putExtra("add_value5", location2);
                                intent.putExtra("add_value6", found);
                                intent.putExtra("add_value7", lat);
                                intent.putExtra("add_value8", lon);


                                setResult(RESULT_OK, intent);
                            }
                            finish();
                        }

                    });
                }
                else if(checkedId== R.id.foundButton)
                {
                    boolean found = true;
                    save.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent();
                            if(TextUtils.isEmpty(name.getText())){
                                setResult(RESULT_CANCELED, intent);
                            }
                            else{

                                String nameValue = name.getText().toString();
                                String descValue = desc.getText().toString();
                                String phoneVal = phone.getText().toString();
                                String dateVal = date.getText().toString();



                                intent.putExtra("add_value1", nameValue);
                                intent.putExtra("add_value2", descValue);
                                intent.putExtra("add_value3", phoneVal);
                                intent.putExtra("add_value4", dateVal);
                                intent.putExtra("add_value5", location2);
                                intent.putExtra("add_value6", found);
                                intent.putExtra("add_value7", lat);
                                intent.putExtra("add_value8", lon);

                                setResult(RESULT_OK, intent);

                            }
                            finish();
                        }
                    });
                }
            }
        });

    }
}