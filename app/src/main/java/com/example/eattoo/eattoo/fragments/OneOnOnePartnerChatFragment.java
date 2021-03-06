package com.example.eattoo.eattoo.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eattoo.R;
import com.example.eattoo.base.views.BaseFragment;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneOnOnePartnerChatFragment extends BaseFragment implements View.OnClickListener {


    public OneOnOnePartnerChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one_on_one_partner_chat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Objects.requireNonNull(getActivity()).finish();
    }
}
