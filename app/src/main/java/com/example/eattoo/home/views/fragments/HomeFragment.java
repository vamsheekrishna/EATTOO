package com.example.eattoo.home.views.fragments;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.eattoo.R;
import com.example.eattoo.base.views.BaseFragment;
import com.example.eattoo.base.views.CustomDialogFragment;
import com.example.eattoo.eattoo.EatTooMainFunctionActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener, OnMapReadyCallback, OnSuccessListener<Location>, OnFailureListener {

    private GoogleMap mMap;
    private FusedLocationProviderClient locationService;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        locationService = LocationServices.getFusedLocationProviderClient(Objects.requireNonNull(getActivity()));
        locationService.getLastLocation().addOnSuccessListener(this).addOnFailureListener(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);


        SupportMapFragment mSupportMapFragment;
        mSupportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        //SupportMapFragment mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.map);
        Objects.requireNonNull(mSupportMapFragment).getMapAsync(this);
        view.findViewById(R.id.submit).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(getActivity(), EatTooMainFunctionActivity.class));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        LatLng myLocation = new LatLng(-34, 151);
        showMark(myLocation);
    }

    private void showMark(LatLng myLocation) {
        if(null != mMap) {
            mMap.addMarker(new MarkerOptions().position(myLocation).title("Marker in Your Position"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 17));
        }
    }

    @Override
    public void onSuccess(Location location) {
        Toast.makeText(getActivity(), "onSuccess",Toast.LENGTH_SHORT).show();
        // Got last known location. In some rare situations this can be null.
        if (location != null) {
            LatLng myLocation = new LatLng(location.getLatitude(), location.getLongitude());
            showMark(myLocation);
        }
    }

    @Override
    public void onFailure(@NonNull Exception e) {
        Toast.makeText(getActivity(), "onFailure",Toast.LENGTH_SHORT).show();
    }
}
