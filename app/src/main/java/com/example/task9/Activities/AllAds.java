package com.example.task9.Activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task9.R;
import com.example.task9.Adapter.AdvertListAdapter;
import com.example.task9.Adapter.AdvertViewModel;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

public class AllAds extends AppCompatActivity {

    private AdvertViewModel advertViewModel;

    AdvertListAdapter listAdapter;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_ads);

        recyclerView = findViewById(R.id.recyclerview);

        advertViewModel = new ViewModelProvider(AllAds.this).get(AdvertViewModel.class);

        listAdapter = new AdvertListAdapter(new AdvertListAdapter.AdvertDiff(),
                this,advertViewModel);

        recyclerView.setAdapter(listAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        advertViewModel.getFoundList().observe(this, students -> {
            //update the cached copy of the words in the adapter
            listAdapter.submitList(students);
        });
    }

}