package com.example.eattoo.authentication.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.eattoo.R;
import com.example.eattoo.authentication.models.UserProfile;
import com.example.eattoo.base.views.BaseFragment;
import com.example.eattoo.retrofitclient.CuisineListRequest;
import com.example.eattoo.retrofitclient.CuisineListRequest.Cuisine;
import com.example.eattoo.retrofitclient.EatTooV1;
import com.example.eattoo.retrofitclient.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class InterestFragment extends BaseFragment implements View.OnClickListener {

    private ArrayList<Cuisine> arrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private UserProfile userProfile;
    public InterestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        userProfile = ViewModelProviders.of(getActivity()).get(UserProfile.class);

        if(null == arrayList || arrayList.size()<=0) {
            EatTooV1 service = RetrofitClientInstance.getRetrofitClientInstance().create(EatTooV1.class);
            Call<CuisineListRequest> call = service.getCuisineList();
            call.enqueue(new Callback<CuisineListRequest>() {
                @Override
                public void onResponse(Call<CuisineListRequest> call, Response<CuisineListRequest> response) {
                    if (Objects.requireNonNull(response.body()).getCode() == 200) {
                        arrayList = (ArrayList<Cuisine>) response.body().getCuisine();
                        if(null != recyclerView) {
                            recyclerView.setAdapter(new CuisineAdapter(arrayList, InterestFragment.this));
                        }
                        Toast.makeText(getActivity(), "response: " + response.body().getCode(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<CuisineListRequest> call, Throwable t) {

                    Toast.makeText(getActivity(), "response: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        return inflater.inflate(R.layout.fragment_interest, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        recyclerView = view.findViewById(R.id.list);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new CuisineAdapter(arrayList, InterestFragment.this));
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getActivity(), "onClick", Toast.LENGTH_SHORT).show();
        navController.navigate(R.id.action_interestFragment_to_congratulationFragment);
    }
}
