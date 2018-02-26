package com.mymvpproject.login;

/**
 * Created by cl-macmini-86 on 10/13/17.
 */

public interface LoginPresenter {

    void checkValidations(String email, String password);

    void setView(LoginView loginView);
}
