package com.example.eattoo.authentication.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eattoo.R;
import com.example.eattoo.authentication.models.UserProfile;
import com.example.eattoo.base.views.BaseFragment;
import com.example.eattoo.retrofitclient.EatTooV1;
import com.example.eattoo.retrofitclient.RetrofitClientInstance;
import com.example.eattoo.retrofitclient.VerifyOTPRequest;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MobileVerificationFragment extends BaseFragment implements View.OnClickListener {
    private UserProfile userProfile;
    private EditText OTPET;

    public MobileVerificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        userProfile = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(UserProfile.class);

        return inflater.inflate(R.layout.fragment_mobile_verification, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.submit).setOnClickListener(this);
        OTPET= view.findViewById(R.id.otp);
        //view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submit:
                verifyOTP();
                break;
        }
        //navController.navigate(R.id.action_mobileVerificationFragment_to_editProfileFragment);
    }

    private void verifyOTP() {
        String otp = OTPET.getText().toString();
        EatTooV1 service = RetrofitClientInstance.getRetrofitClientInstance().create(EatTooV1.class);
        Call<VerifyOTPRequest> verifyOTPEnqueue = service.verifyOTP(userProfile.getMobileNumber().getValue(), otp);
        verifyOTPEnqueue.enqueue(new Callback<VerifyOTPRequest>() {
            @Override
            public void onResponse(Call<VerifyOTPRequest> call, Response<VerifyOTPRequest> response) {
                if(response.body().getCode() == 200 || response.body().getCode() == 400) {
                    navController.navigate(R.id.action_mobileVerificationFragment_to_editProfileFragment);
                } else {
                    String msg = (String) response.body().getData();
                    Toast.makeText(getActivity(),"error msg: "+msg,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<VerifyOTPRequest> call, Throwable t) {

            }
        });
    }
}
