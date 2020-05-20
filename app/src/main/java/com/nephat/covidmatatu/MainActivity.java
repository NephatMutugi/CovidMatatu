package com.nephat.covidmatatu;

import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nephat.covidmatatu.adapters.RecyclerViewAdapter;
import com.nephat.covidmatatu.adapters.RecyclerViewAdapter2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //Vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mSymptomDescription = new ArrayList<>();

    private ArrayList<String> myNames = new ArrayList<>();
    private ArrayList<String> myImageUrls = new ArrayList<>();
    private ArrayList<String> myDescriptions = new ArrayList<>();

    //Widgets
    private Button mEmergency, mStatistics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmergency = findViewById(R.id.emergencyButton);
        mStatistics = findViewById(R.id.statisticsButton);

        mEmergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EmergencyActivity.class);
                startActivity(intent);
            }
        });

        mStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StatisticsActivity.class);
                startActivity(intent);
            }
        });

        getImages();
        getImages2();
    }

    private void getImages(){
        Log.d(TAG, "getImages: Preparing Bitmaps");

        mImageUrls.add(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.coughing)
        + '/' +getResources().getResourceTypeName(R.drawable.coughing)
        + '/' +getResources().getResourceEntryName(R.drawable.coughing));

        mNames.add("Coughing");
        mSymptomDescription.add("COVID 19 causes a dry cough to most of the infected patients");


        mImageUrls.add(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.fever)
                + '/' +getResources().getResourceTypeName(R.drawable.fever)
                + '/' +getResources().getResourceEntryName(R.drawable.fever));
        mNames.add("Fever");
        mSymptomDescription.add("Fever is mostly the first symptom of COVID 19 infection");


        mImageUrls.add(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.sore_throat)
                + '/' +getResources().getResourceTypeName(R.drawable.sore_throat)
                + '/' +getResources().getResourceEntryName(R.drawable.sore_throat));
        mNames.add("Sore throat");
        mSymptomDescription.add("You may experience a sore throat in the early stages of the infection");


        mImageUrls.add(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.headache)
                + '/' +getResources().getResourceTypeName(R.drawable.headache)
                + '/' +getResources().getResourceEntryName(R.drawable.headache));
        mNames.add("Headache");
        mSymptomDescription.add("Some patients experience headaches and sometimes, backaches");



        mImageUrls.add(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.sneezing_tissue)
                + '/' +getResources().getResourceTypeName(R.drawable.sneezing_tissue)
                + '/' +getResources().getResourceEntryName(R.drawable.sneezing_tissue));
        mNames.add("Shortness of breath");
        mSymptomDescription.add("Shortness of breath is a less frequent symptom "
                + "experienced at advanced stages of COVID 19");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: Initialize Recyclerview");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls, mSymptomDescription);
        recyclerView.setAdapter(adapter);
    }

    private void getImages2(){

        Log.d(TAG, "getImages2: Preparing second set of bitmaps");

        myImageUrls.add(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.mask)
                + '/' +getResources().getResourceTypeName(R.drawable.mask)
                + '/' +getResources().getResourceEntryName(R.drawable.mask));

        myNames.add("Wear a face mask in public");
        myDescriptions.add("Wear a mask to avoid spreading the virus to others in case you are sick");


        myImageUrls.add(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.handwashing)
                + '/' +getResources().getResourceTypeName(R.drawable.handwashing)
                + '/' +getResources().getResourceEntryName(R.drawable.handwashing));

        myNames.add("Wash your hands regularly");
        myDescriptions.add("Wash your hands often with soap and water for at least 20 seconds");


        myImageUrls.add(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.distance)
                + '/' +getResources().getResourceTypeName(R.drawable.distance)
                + '/' +getResources().getResourceEntryName(R.drawable.distance));

        myNames.add("Observe social distancing");
        myDescriptions.add("Observe social distancing guidelines since asymptomatic people can also spread the virus");


        myImageUrls.add(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.sneezing_tissue)
                + '/' +getResources().getResourceTypeName(R.drawable.sneezing_tissue)
                + '/' +getResources().getResourceEntryName(R.drawable.sneezing_tissue));

        myNames.add("Sneeze on disposable tissue");
        myDescriptions.add("Cover your coughs and sneezes with a disposable tissue over your nose and mouth");


        myImageUrls.add(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.sleeping_home)
                + '/' +getResources().getResourceTypeName(R.drawable.sleeping_home)
                + '/' +getResources().getResourceEntryName(R.drawable.sleeping_home));

        myNames.add("Stay at home");
        myDescriptions.add("Avoid unnecessary movement so as not to contract or spread the virus to others");


        initRecyclerViewPrevention();
    }

    private void initRecyclerViewPrevention(){
        Log.d(TAG, "initRecyclerViewPrevention: Initialize second recycler view");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView = findViewById(R.id.recycler_view2);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerViewAdapter2 adapter2 = new RecyclerViewAdapter2(this, myNames, myImageUrls, myDescriptions);
        recyclerView.setAdapter(adapter2);
    }
}
