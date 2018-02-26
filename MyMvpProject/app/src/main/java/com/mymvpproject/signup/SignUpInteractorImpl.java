package com.mymvpproject.signup;

import com.mymvpproject.constant.ApiKeyConstant;
import com.mymvpproject.retrofit.APIError;
import com.mymvpproject.retrofit.CommonParams;
import com.mymvpproject.retrofit.CommonResponse;
import com.mymvpproject.retrofit.ResponseResolver;
import com.mymvpproject.retrofit.RestClient;
import com.mymvpproject.util.Validation;

import static com.mymvpproject.constant.AppConstant.ANDROID;
import static com.mymvpproject.constant.AppConstant.DEVICE_OS;

/**
 * Created by Ashutosh Ojha on 10/27/17.
 */

public class SignUpInteractorImpl implements SignUpInteractor, ApiKeyConstant {
    private OnSignUpFinished mOnSignUpFinished;

    @Override
    public void signUpData(final String fName, final String lName,
                           final String email, final String phone,
                           final String address, final String dob,
                           final String password, final String confirmPassword,
                           final OnSignUpFinished onSignUpFinished) {

        mOnSignUpFinished = onSignUpFinished;
        if (isValid(fName, lName, email, phone,
                address, dob, password, confirmPassword, onSignUpFinished)) {
            onSignUpFinished.success();
            CommonParams commonParams = new CommonParams.Builder()
                    .add(KEY_EMAIL, email)
                    .add(KEY_PASSWORD, password)
                    .add(KEY_DEVICE_TOKEN, "sdf")
                    .add(KEY_DEVICE_ID, ANDROID)
                    .add(KEY_DEVICE_OS, DEVICE_OS)
                    .add(KEY_DEVICE_TYPE, ANDROID)
                    .add(KEY_TIME_ZONE, 330)
                    .build();
            RestClient.getApiInterface().login(commonParams.getMap()).enqueue(new ResponseResolver<CommonResponse>() {
                @Override
                public void success(final CommonResponse commonResponse) {

                    onSignUpFinished.success();
                }

                @Override
                public void failure(final APIError error) {

                    onSignUpFinished.signUpFailedError(error.getMessage());
                }
            });
        }

    }

    @Override
    public void onRetrofitFailure(final String msg) {
        mOnSignUpFinished.signUpFailedError(msg);
    }


    private boolean isValid(final String fName, final String lName,
                            final String email, final String phone,
                            final String address, final String dob,
                            final String password, final String confirmPassword,
                            final OnSignUpFinished onSignUpFinished) {

        if (!Validation.isFnameValid(fName).isEmpty()) {
            onSignUpFinished.fNameError(Validation.isFnameValid(fName));
            return false;
        } else if (!Validation.isLnameValid(lName).isEmpty()) {
            onSignUpFinished.lNameError(Validation.isLnameValid(lName));
            return false;
        } else if (!Validation.isEmailValid(email).isEmpty()) {
            onSignUpFinished.emailError(Validation.isEmailValid(email));
            return false;
        } else if (!Validation.isPhoneValid(phone).isEmpty()) {
            onSignUpFinished.phoneError(Validation.isPhoneValid(phone));
            return false;
        } else if (!Validation.isAddressValid(address).isEmpty()) {
            onSignUpFinished.addressError(Validation.isAddressValid(address));
            return false;
        } else if (!Validation.isDobValid(dob).isEmpty()) {
            onSignUpFinished.dobError(Validation.isDobValid(dob));
            return false;
        } else if (!Validation.isPasswordValid(password).isEmpty()) {
            onSignUpFinished.paswordError(Validation.isPasswordValid(password));
            return false;
        } else if (!Validation.isComparePassowrdValid(password, confirmPassword).isEmpty()) {
            onSignUpFinished.confirmPasswordError(Validation.isComparePassowrdValid(password, confirmPassword));
            return false;
        } else {
            return true;
        }
    }
}
