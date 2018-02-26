package com.mymvpproject.otp;

import com.mymvpproject.CommonInteractor;

/**
 * Created by cl-macmini-86 on 10/13/17.
 */

public interface OtpInteractor  extends CommonInteractor{


    void otpData(String email, OtpFinished onLoginFinished);

    interface OtpFinished {
        void otpError(String errorMsg);


        void success();

        void otpFailedError(String failureMsg);
    }

    @Override
    void onRetrofitFailure(String msg);
}
