package com.mymvpproject.login;

import com.mymvpproject.retrofit.APIError;
import com.mymvpproject.retrofit.CommonParams;
import com.mymvpproject.retrofit.CommonResponse;
import com.mymvpproject.retrofit.ResponseResolver;
import com.mymvpproject.retrofit.RestClient;
import com.mymvpproject.util.Validation;

import static com.mymvpproject.constant.ApiKeyConstant.KEY_DEVICE_ID;
import static com.mymvpproject.constant.ApiKeyConstant.KEY_DEVICE_OS;
import static com.mymvpproject.constant.ApiKeyConstant.KEY_DEVICE_TOKEN;
import static com.mymvpproject.constant.ApiKeyConstant.KEY_DEVICE_TYPE;
import static com.mymvpproject.constant.ApiKeyConstant.KEY_EMAIL;
import static com.mymvpproject.constant.ApiKeyConstant.KEY_PASSWORD;
import static com.mymvpproject.constant.ApiKeyConstant.KEY_TIME_ZONE;
import static com.mymvpproject.constant.AppConstant.ANDROID;
import static com.mymvpproject.constant.AppConstant.DEVICE_OS;

/**
 * Created by cl-macmini-86 on 10/13/17.
 */

public class LoginInteractorImpl implements LoginInteractor, RetrofitFailure {
    private OnLoginFinished monLoginFinished;

    @Override
    public void loginData(final String email, final String password, final OnLoginFinished onLoginFinished) {

        monLoginFinished = onLoginFinished;
        if (isValid(email, password, onLoginFinished)) {


            CommonParams commonParams = new CommonParams.Builder()
                    .add(KEY_EMAIL, email)
                    .add(KEY_PASSWORD, password)
                    .add(KEY_DEVICE_TOKEN, "sdf")
                    .add(KEY_DEVICE_ID, ANDROID)
                    .add(KEY_DEVICE_OS, DEVICE_OS)
                    .add(KEY_DEVICE_TYPE, ANDROID)
                    .add(KEY_TIME_ZONE, 330)
                    .build();
            RestClient.getApiInterface().login(commonParams.getMap()).enqueue(new ResponseResolver<CommonResponse>(this) {
                @Override
                public void success(final CommonResponse commonResponse) {

                    onLoginFinished.success();
                }

                @Override
                public void failure(final APIError error) {

                    onLoginFinished.loginFailedError(error.getMessage());
                }
            });

        }

    }

    private boolean isValid(final String email, final String password, final OnLoginFinished onLoginFinished) {
        if (!Validation.isEmailValid(email).isEmpty()) {
            onLoginFinished.emailError(Validation.isEmailValid(email));
            return false;
        } else if (!Validation.isPasswordValid(password).isEmpty()) {
            onLoginFinished.passwordError(Validation.isPasswordValid(password));
            return false;
        } else {
            return true;
        }

    }

    @Override
    public void onRetrofitFailure(String errorMsg) {
        monLoginFinished.loginFailedError(errorMsg);
    }
}
