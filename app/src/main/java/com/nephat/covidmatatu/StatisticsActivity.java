package com.nephat.covidmatatu;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class StatisticsActivity extends AppCompatActivity {

    private static final String TAG = "StatisticsActivity";

    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        pieChart = findViewById(R.id.pieChart);

        ArrayList<PieEntry> patients = new ArrayList<>();
        patients.add(new PieEntry(555, "Active cases"));
        patients.add(new PieEntry(358, "Total recovered"));
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

    }
}
