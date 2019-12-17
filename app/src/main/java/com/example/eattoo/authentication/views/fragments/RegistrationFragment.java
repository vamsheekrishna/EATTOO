package com.example.eattoo.authentication.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eattoo.R;
import com.example.eattoo.authentication.models.UserProfile;
import com.example.eattoo.base.views.BaseFragment;
import com.example.eattoo.databinding.FragmentRegistrationBinding;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends BaseFragment implements View.OnClickListener {

    private UserProfile userProfile;

    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        UserProfile userProfile = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(UserProfile.class);
        //userProfile = new UserProfile();
        FragmentRegistrationBinding fragmentRegistrationBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_registration,container, false);
        fragmentRegistrationBinding.setUserprofile(userProfile);
        return fragmentRegistrationBinding.getRoot();
        //return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.submit).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        navController.navigate(R.id.action_registrationFragment_to_mobileVerificationFragment);
    }
}
