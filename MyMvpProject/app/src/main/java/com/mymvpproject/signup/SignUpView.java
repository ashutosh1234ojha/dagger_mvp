package com.mymvpproject.signup;

/**
 * Created by cl-macmini-86 on 10/13/17.
 */

public interface SignUpView {
    void fNameError(String msg);
    void lNameError(String msg);
    void emailError(String msg);
    void phoneError(String msg);
    void addressError(String msg);
    void dobError(String msg);
    void passwordError(String msg);
    void passwordConfirmError(String msg);
    void signUpFailed(String failureMsg);
    void navigateToOtp();
    void showProgress();
    void dismissProgress();
}
