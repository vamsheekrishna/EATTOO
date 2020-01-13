package com.example.eattoo.authentication.views.fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eattoo.R;

class CuisineView extends RecyclerView.ViewHolder {
    public ImageView mCuisineViewHolder;
    public TextView mCuisineName;
    public CuisineView(@NonNull View itemView) {
        super(itemView);
        mCuisineName = itemView.findViewById(R.id.title);
        mCuisineViewHolder = itemView.findViewById(R.id.image);
    }
}
