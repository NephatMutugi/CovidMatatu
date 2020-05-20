package com.nephat.covidmatatu.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nephat.covidmatatu.R;

public class StatisticsRecyclerAdapter {

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView countyName;
        TextView countyCases;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            countyName = itemView.findViewById(R.id.textCountyName);
            countyCases = itemView.findViewById(R.id.textCasesNumber);
        }
    }
}
