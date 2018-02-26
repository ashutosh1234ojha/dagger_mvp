package com.mymvpproject.otp;

/**
 * Created by cl-macmini-86 on 10/13/17.
 */

public interface OtpView {
    void otpError(String msg);
    void otpFailedError(String failureMsg);
    void navigateToHome();
    void showProgress();
    void dismissProgress();
}
