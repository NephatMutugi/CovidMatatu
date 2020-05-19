package com.nephat.covidmatatu;

import android.content.ContentResolver;
import android.os.Bundle;
import android.util.Log;

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

    private ArrayList<String> myNames = new ArrayList<>();
    private ArrayList<String> myImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        mImageUrls.add(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.fever)
                + '/' +getResources().getResourceTypeName(R.drawable.fever)
                + '/' +getResources().getResourceEntryName(R.drawable.fever));
        mNames.add("Fever");

        mImageUrls.add(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.sore_throat)
                + '/' +getResources().getResourceTypeName(R.drawable.sore_throat)
                + '/' +getResources().getResourceEntryName(R.drawable.sore_throat));
        mNames.add("Sore throat");

        mImageUrls.add(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.headache)
                + '/' +getResources().getResourceTypeName(R.drawable.headache)
                + '/' +getResources().getResourceEntryName(R.drawable.headache));
        mNames.add("Headache");

        mImageUrls.add(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.sneezing_tissue)
                + '/' +getResources().getResourceTypeName(R.drawable.sneezing_tissue)
                + '/' +getResources().getResourceEntryName(R.drawable.sneezing_tissue));
        mNames.add("Sneezing");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: Initialize Recyclerview");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
    }

    private void getImages2(){

        Log.d(TAG, "getImages2: Preparing second set of bitmaps");

        myImageUrls.add(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.mask)
                + '/' +getResources().getResourceTypeName(R.drawable.mask)
                + '/' +getResources().getResourceEntryName(R.drawable.mask));

        myNames.add("Wear a face mask in public");


        myImageUrls.add(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.handwashing)
                + '/' +getResources().getResourceTypeName(R.drawable.handwashing)
                + '/' +getResources().getResourceEntryName(R.drawable.handwashing));

        myNames.add("Wash your hands regularly");


        myImageUrls.add(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.distance)
                + '/' +getResources().getResourceTypeName(R.drawable.distance)
                + '/' +getResources().getResourceEntryName(R.drawable.distance));

        myNames.add("Observe social distancing");


        myImageUrls.add(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.sneezing_tissue)
                + '/' +getResources().getResourceTypeName(R.drawable.sneezing_tissue)
                + '/' +getResources().getResourceEntryName(R.drawable.sneezing_tissue));

        myNames.add("Sneeze on disposable tissue");


        myImageUrls.add(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.sleeping_home)
                + '/' +getResources().getResourceTypeName(R.drawable.sleeping_home)
                + '/' +getResources().getResourceEntryName(R.drawable.sleeping_home));

        myNames.add("Stay at home");

        initRecyclerViewPrevention();
    }

    private void initRecyclerViewPrevention(){
        Log.d(TAG, "initRecyclerViewPrevention: Initialize second recycler view");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView = findViewById(R.id.recycler_view2);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerViewAdapter2 adapter2 = new RecyclerViewAdapter2(this, myNames, myImageUrls);
        recyclerView.setAdapter(adapter2);
    }
}
