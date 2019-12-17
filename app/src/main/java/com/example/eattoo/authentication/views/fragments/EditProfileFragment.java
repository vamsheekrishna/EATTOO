package com.example.eattoo.authentication.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eattoo.R;
import com.example.eattoo.authentication.models.UserProfile;
import com.example.eattoo.base.views.BaseFragment;
import com.example.eattoo.databinding.FragmentEditProfileBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditProfileFragment extends BaseFragment implements View.OnClickListener {

    public EditProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        UserProfile userProfile = ViewModelProviders.of(getActivity()).get(UserProfile.class);
        FragmentEditProfileBinding profile = DataBindingUtil.inflate(inflater,R.layout.fragment_edit_profile, container, false);
        profile.setUserProfile(userProfile);
        return profile.getRoot();//inflater.inflate(R.layout.fragment_edit_profile, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.submit).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        navController.navigate(R.id.action_editProfileFragment_to_interestFragment);
    }
}
