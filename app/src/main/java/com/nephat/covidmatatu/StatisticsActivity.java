package com.nephat.covidmatatu;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.nephat.covidmatatu.adapters.StatisticsRecyclerAdapter;

import java.util.ArrayList;

public class StatisticsActivity extends AppCompatActivity {

    private static final String TAG = "StatisticsActivity";

    //Vars
    private ArrayList<String> countyNames = new ArrayList<>();
    private ArrayList<String> countyCases = new ArrayList<>();

    //Widgets
    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        pieChart = findViewById(R.id.pieChart);

        ArrayList<PieEntry> patients = new ArrayList<>();
        patients.add(new PieEntry(613, "Active cases"));
        patients.add(new PieEntry(366, "Total recovered"));
        patients.add(new PieEntry(50, "Total Deaths"));

        PieDataSet pieDataSet = new PieDataSet(patients, "Coronavirus cases");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLUE);
        pieDataSet.setValueTextSize(18f);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Coronavirus cases");
        pieChart.animate();

        getData();

    }

    private void getData(){
        countyNames.add("Nairobi County");
        countyCases.add("400");

        countyNames.add("Mombasa County");
        countyCases.add("300");

        countyNames.add("Mandera County");
        countyCases.add("70");

        countyNames.add("Kajiado County");
        countyCases.add("55");

        countyNames.add("Kisumu County");
        countyCases.add("50");

        countyNames.add("Homabay County");
        countyCases.add("46");

        countyNames.add("Siaya County");
        countyCases.add("40");

        countyNames.add("Machakos County");
        countyCases.add("30");

        countyNames.add("Kilifi County");
        countyCases.add("20");

        countyNames.add("Kiambu County");
        countyCases.add("12");

        countyNames.add("Kwale County");
        countyCases.add("12");

        countyNames.add("Busia County");
        countyCases.add("10");

        countyNames.add("Muran'ga County");
        countyCases.add("8");

        countyNames.add("Uasin Gishu County");
        countyCases.add("8");

        countyNames.add("Kericho County");
        countyCases.add("5");

        countyNames.add("Bungoma County");
        countyCases.add("5");

        countyNames.add("Wajir County");
        countyCases.add("5");

        countyNames.add("Lamu County");
        countyCases.add("3");

        countyNames.add("Garissa County");
        countyCases.add("2");

        countyNames.add("Embu County");
        countyCases.add("1");

        countyNames.add("Meru County");
        countyCases.add("1");

        countyNames.add("Kirinyaga County");
        countyCases.add("1");


        init();
    }

    private void init(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = findViewById(R.id.statistics_recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        StatisticsRecyclerAdapter adapter = new StatisticsRecyclerAdapter(this, countyNames, countyCases);
        recyclerView.setAdapter(adapter);
    }
}
