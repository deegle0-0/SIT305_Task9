package com.example.task9.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.task9.R;
import com.example.task9.Adapter.AdvertListAdapter;
import com.example.task9.Adapter.AdvertViewModel;
import com.example.task9.database.Advert;

public class ItemDetailsActivity extends AppCompatActivity {

    TextView name,desc,phoneNo,location;

    private AdvertViewModel advertViewModel;

    AdvertListAdapter listAdapter;

    Button removebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        name = findViewById(R.id.textViewName);
        desc= findViewById(R.id.textViewDescription);
        phoneNo = findViewById(R.id.textViewContact);
        location = findViewById(R.id.textViewLocation);
        removebutton = findViewById(R.id.removeBtn);

        advertViewModel = new ViewModelProvider(ItemDetailsActivity.this).get(AdvertViewModel.class);

        listAdapter = new AdvertListAdapter(new AdvertListAdapter.AdvertDiff(),
                this,advertViewModel);

        String nameVal = getIntent().getStringExtra("name");
        String descVal = getIntent().getStringExtra("desc");
        String locationVal = getIntent().getStringExtra("location");
        String phoneNoVal = getIntent().getStringExtra("phoneNo");

        name.setText(nameVal);
        desc.setText(descVal);
        location.setText(locationVal);
        phoneNo.setText(phoneNoVal);

        removebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Advert advert = null;
                advertViewModel.delete(advert);
            }
        });

    }
}