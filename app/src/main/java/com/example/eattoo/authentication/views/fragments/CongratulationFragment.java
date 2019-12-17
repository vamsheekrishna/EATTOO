package com.example.eattoo.authentication.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eattoo.R;
import com.example.eattoo.base.views.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class CongratulationFragment extends BaseFragment implements View.OnClickListener {


    public CongratulationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_congratulation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        navController.navigate(R.id.action_congratulationFragment_to_homeActivity);
        getActivity().finish();
    }
}
