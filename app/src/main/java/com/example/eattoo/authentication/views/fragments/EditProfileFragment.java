package com.example.eattoo.authentication.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.eattoo.R;
import com.example.eattoo.authentication.models.UserProfile;
import com.example.eattoo.base.views.BaseFragment;
import com.example.eattoo.databinding.FragmentEditProfileBinding;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditProfileFragment extends BaseFragment implements View.OnClickListener {

    private UserProfile userProfile;
    Button btMale, btFeMail;
    public EditProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        userProfile = ViewModelProviders.of(getActivity()).get(UserProfile.class);
        FragmentEditProfileBinding profile = DataBindingUtil.inflate(inflater,R.layout.fragment_edit_profile, container, false);
        profile.setUserProfile(userProfile);
        return profile.getRoot();//inflater.inflate(R.layout.fragment_edit_profile, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.submit).setOnClickListener(this);
        view.findViewById(R.id.select_preference).setOnClickListener(this);
        btMale = view.findViewById(R.id.male);
        btMale.setOnClickListener(this);
        btFeMail = view.findViewById(R.id.fe_male);
        btFeMail.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.select_preference:
                    navController.navigate(R.id.action_editProfileFragment_to_interestFragment);
                break;
            case R.id.male:
                setGender(true);
                break;
            case R.id.fe_male:
                setGender(false);
                break;
        }
    }

    private void setGender(boolean isMail) {
        if(isMail) {
            userProfile.setGender("male");
            btFeMail.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()), R.drawable.button_white_bg));
            btFeMail.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.button_gray));
            btMale.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()), R.drawable.button_yellow_bg));
            btMale.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
        } else {
            userProfile.setGender("fe mail");
            btMale.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()), R.drawable.button_white_bg));
            btMale.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.button_gray));
            btFeMail.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()), R.drawable.button_yellow_bg));
            btFeMail.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
        }
    }
}
