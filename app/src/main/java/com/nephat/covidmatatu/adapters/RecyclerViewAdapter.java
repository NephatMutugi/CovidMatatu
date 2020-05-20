package com.nephat.covidmatatu.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nephat.covidmatatu.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    //Vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mSymptomDescription = new ArrayList<>();
    private Context mContext;


    public RecyclerViewAdapter( Context context, ArrayList<String> names, ArrayList<String> imageUrls,
                                ArrayList<String> symptomDescription) {
        this.mNames = names;
        this.mImageUrls = imageUrls;
        this.mContext = context;
        this.mSymptomDescription = symptomDescription;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Called");

        Glide.with(mContext)
                .asBitmap()
                .load(mImageUrls.get(position))
                .into(holder.mImage);
        holder.mName.setText(mNames.get(position));
        holder.mSymptomDesc.setText(mSymptomDescription.get(position));

    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView mImage;
        TextView mName;
        TextView mSymptomDesc;

        public ViewHolder(View itemView){
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
            mName = itemView.findViewById(R.id.name);
            mSymptomDesc = itemView.findViewById(R.id.textDescription);

        }

    }
}
