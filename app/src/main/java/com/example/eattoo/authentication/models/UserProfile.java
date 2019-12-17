package com.example.eattoo.authentication.models;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserProfile extends ViewModel {

    private MutableLiveData<String> mobileNumber;
    private MutableLiveData<String> countryNumber;
    private MutableLiveData<String> name;
    private MutableLiveData<String> email;

    public MutableLiveData<String> getMobileNumber() {
        if(null == mobileNumber) {
            mobileNumber = new MutableLiveData<>();
            mobileNumber.setValue("1122334455");
        }
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.getMobileNumber().setValue(mobileNumber);
    }

    public MutableLiveData<String> getCountryNumber() {
        if(null == countryNumber) {
            countryNumber = new MutableLiveData<>();
            countryNumber.setValue("+91");
        }
        return countryNumber;
    }

    public void setCountryNumber(String countryNumber) {
        this.getCountryNumber().setValue(countryNumber);
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public void setName(String name) {
        this.getName().setValue(name);
    }

    public MutableLiveData<String> getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.getEmail().setValue(email);
    }
}
