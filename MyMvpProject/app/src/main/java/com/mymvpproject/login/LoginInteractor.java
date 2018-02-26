package com.mymvpproject.login;

import com.mymvpproject.CommonInteractor;

/**
 * Created by cl-macmini-86 on 10/13/17.
 */

public interface LoginInteractor extends CommonInteractor{


    void loginData(String email, String password,  OnLoginFinished onLoginFinished);

    interface OnLoginFinished {
        void emailError(String errorMsg);

        void passwordError(String errorMsg);

        void success();

        void loginFailedError(String failureMsg);
    }

    @Override
    void onRetrofitFailure(String msg);
}
