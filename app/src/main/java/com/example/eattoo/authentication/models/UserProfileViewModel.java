package com.example.eattoo.authentication.models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserProfileViewModel extends ViewModel {
    private MutableLiveData<UserProfile> userProfileMutableLiveData;

    public void setUserProfile(UserProfile item) {
        userProfileMutableLiveData.setValue(item);
    }

    public LiveData<UserProfile> getUserProfile() {
        if (userProfileMutableLiveData == null) {
            userProfileMutableLiveData = new MutableLiveData<>();
        }
        return userProfileMutableLiveData;
    }

}
