package com.example.eattoo.authentication.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.eattoo.R;
import com.example.eattoo.authentication.models.UserProfile;
import com.example.eattoo.base.views.BaseFragment;
import com.example.eattoo.base.views.CustomDialogFragment;
import com.example.eattoo.databinding.FragmentRegistrationBinding;
import com.example.eattoo.retrofitclient.EatTooV1;
import com.example.eattoo.retrofitclient.RetrofitClientInstance;
import com.example.eattoo.retrofitclient.SentOTPRequest;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends BaseFragment implements View.OnClickListener, CustomDialogFragment.OnDialogFragmentInteractionListener {

    private UserProfile userProfile;
    CustomDialogFragment customDialogFragment;
    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        userProfile = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(UserProfile.class);
        FragmentRegistrationBinding fragmentRegistrationBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_registration,container, false);
        fragmentRegistrationBinding.setUserprofile(userProfile);
        return fragmentRegistrationBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.submit).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String number  = userProfile.getMobileNumber().getValue();
        EatTooV1 eatTooV1API = RetrofitClientInstance.getRetrofitClientInstance().create(EatTooV1.class);
        Call<SentOTPRequest> sentOtpRequest = eatTooV1API.sentOTP(number);
        Log.d("Mobile number: ", userProfile.getMobileNumber().toString());
        sentOtpRequest.enqueue(new Callback<SentOTPRequest>() {
            @Override
            public void onResponse(Call<SentOTPRequest> call, Response<SentOTPRequest> response) {
                if (Objects.requireNonNull(response.body()).getCode() == 200) {
                    navController.navigate(R.id.action_registrationFragment_to_mobileVerificationFragment);
                    /*SentOTPRequest.OTPRequestData temp = (SentOTPRequest.OTPRequestData) response.body().getData();
                    Toast.makeText(getActivity(), "onResponse "+temp.getOtp(), Toast.LENGTH_SHORT).show();*/
                } else {

                    String temp = (String) response.body().getData();
                    Toast.makeText(getActivity(), "onResponse "+temp, Toast.LENGTH_SHORT).show();
                    customDialogFragment = CustomDialogFragment.newInstance(temp,false, RegistrationFragment.this);
                    customDialogFragment.show(Objects.requireNonNull(getActivity()).getSupportFragmentManager(), "Custom Dialog");
                }
                /*String text = "onResponse: "+Objects.requireNonNull(response.body()).getType()+" "+Objects.requireNonNull(response.body()).getData();
                Log.d("onResponse: ", text);
                Toast.makeText(getActivity(), "onResponse "+text, Toast.LENGTH_SHORT).show();*/
            }

            @Override
            public void onFailure(Call<SentOTPRequest> call, Throwable t) {
                String text = "onFailure: "+t.getMessage();
                Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
                Log.d("Exception: ", text);
            }
        });
        //navController.navigate(R.id.action_registrationFragment_to_mobileVerificationFragment);
    }

    @Override
    public void onOkButtonClicked() {
        if(null != customDialogFragment) {
            customDialogFragment.dismiss();
        }
    }

    @Override
    public void onCancelButtonClicked() {
        Objects.requireNonNull(getActivity()).onBackPressed();
    }
}
