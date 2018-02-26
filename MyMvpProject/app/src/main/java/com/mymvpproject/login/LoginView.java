package com.mymvpproject.login;

/**
 * Created by cl-macmini-86 on 10/13/17.
 */

public interface LoginView {
    void emailError(String msg);
    void passwordError(String msg);
    void loginFailed(String failureMsg);
    void navigateToHome();
    void showProgress();
    void dismissProgress();

}
