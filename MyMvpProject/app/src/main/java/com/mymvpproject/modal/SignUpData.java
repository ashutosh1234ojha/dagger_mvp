package com.mymvpproject.modal;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Ashutosh Ojha on 10/31/17.
 */

public class SignUpData implements Parcelable {

    private String fName;
    private String lName;
    private String email;
    private String phone;
    private String address;
    private String dateOfBirth;
    private String password;
    private List<String> preferenceNameList;
    private List<String> preferenceIdList;

    public List<String> getPreferenceNameList() {
        return preferenceNameList;
    }

    public void setPreferenceNameList(final List<String> preferenceNameList) {
        this.preferenceNameList = preferenceNameList;
    }

    public List<String> getPreferenceIdList() {
        return preferenceIdList;
    }

    public void setPreferenceIdList(final List<String> preferenceIdList) {
        this.preferenceIdList = preferenceIdList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(final String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(final String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }


    public SignUpData() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fName);
        dest.writeString(this.lName);
        dest.writeString(this.email);
        dest.writeString(this.phone);
        dest.writeString(this.address);
        dest.writeString(this.dateOfBirth);
        dest.writeString(this.password);
        dest.writeStringList(this.preferenceNameList);
        dest.writeStringList(this.preferenceIdList);
    }

    protected SignUpData(Parcel in) {
        this.fName = in.readString();
        this.lName = in.readString();
        this.email = in.readString();
        this.phone = in.readString();
        this.address = in.readString();
        this.dateOfBirth = in.readString();
        this.password = in.readString();
        this.preferenceNameList = in.createStringArrayList();
        this.preferenceIdList = in.createStringArrayList();
    }

    public static final Creator<SignUpData> CREATOR = new Creator<SignUpData>() {
        @Override
        public SignUpData createFromParcel(Parcel source) {
            return new SignUpData(source);
        }

        @Override
        public SignUpData[] newArray(int size) {
            return new SignUpData[size];
        }
    };
}
