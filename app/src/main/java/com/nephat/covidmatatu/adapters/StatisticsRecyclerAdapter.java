package com.nephat.covidmatatu.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nephat.covidmatatu.R;

import java.util.ArrayList;

public class StatisticsRecyclerAdapter extends RecyclerView.Adapter<StatisticsRecyclerAdapter.ViewHolder> {

    private static final String TAG = "StatisticsRecyclerAdapt";

    private ArrayList<String> countyNames = new ArrayList<>();
    private ArrayList<String> countyCases = new ArrayList<>();
    private Context mContext;

    public StatisticsRecyclerAdapter(Context mContext, ArrayList<String> countyNames,
                                     ArrayList<String> countyCases) {
        this.countyNames = countyNames;
        this.countyCases = countyCases;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: Called");
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.counties_layout_list_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.countyName.setText(countyNames.get(position));
        holder.countyNoOfCases.setText(countyCases.get(position));
    }

    @Override
    public int getItemCount() {
        return countyNames.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView countyName;
        TextView countyNoOfCases;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            countyName = itemView.findViewById(R.id.textCountyName);
            countyNoOfCases = itemView.findViewById(R.id.textCasesNumber);
        }
    }
}
