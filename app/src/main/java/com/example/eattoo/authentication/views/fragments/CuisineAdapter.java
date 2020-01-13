package com.example.eattoo.authentication.views.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eattoo.R;
import com.example.eattoo.retrofitclient.CuisineListRequest;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class CuisineAdapter extends RecyclerView.Adapter {
    private ArrayList<CuisineListRequest.Cuisine> arrayList;
    private View.OnClickListener mListener;

    CuisineAdapter(ArrayList<CuisineListRequest.Cuisine> arrayList, View.OnClickListener listener) {
        this.arrayList = arrayList;
        mListener = listener;
    }

    @NonNull
    @Override
    public CuisineView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cuisine_row_item,parent, false);
        view.setOnClickListener(mListener);
        return new CuisineView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((CuisineView) holder).mCuisineName.setText(arrayList.get(position).getCusine_name());
        Picasso.get().load(arrayList.get(position).getImage_url()).fit().centerCrop().placeholder(R.drawable.indian).error(R.drawable.avatar)
                .into(((CuisineView) holder).mCuisineViewHolder);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
