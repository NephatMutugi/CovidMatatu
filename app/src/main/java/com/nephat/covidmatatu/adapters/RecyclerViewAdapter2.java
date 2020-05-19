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

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder2> {

    private static final String TAG = "RecyclerViewAdapter2";

    private ArrayList<String> myNames = new ArrayList<>();
    private ArrayList<String> myImageUrls = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter2( Context mContext, ArrayList<String> myNames, ArrayList<String> myImageUrls) {
        this.myNames = myNames;
        this.myImageUrls = myImageUrls;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item2, parent, false);
        return new ViewHolder2(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder2 holder, int position) {
        Log.d(TAG, "onBindViewHolder: Called");

        Glide.with(mContext)
                .asBitmap()
                .load(myImageUrls.get(position))
                .into(holder.mImage);
        holder.mName.setText(myNames.get(position));
    }

    @Override
    public int getItemCount() {
        return myImageUrls.size();
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {

        CircleImageView mImage;
        TextView mName;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.prev_image);
            mName = itemView.findViewById(R.id.prev_name);
        }
    }
}
