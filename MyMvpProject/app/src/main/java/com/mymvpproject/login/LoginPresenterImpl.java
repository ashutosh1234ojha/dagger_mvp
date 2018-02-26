package com.mymvpproject.login;

import javax.inject.Inject;

/**
 * Created by cl-macmini-86 on 10/13/17.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinished {
    private LoginView loginView;
   private LoginInteractor loginInteractor;


    @Inject
    public  LoginPresenterImpl(final LoginInteractor loginInteractor) {

//        getApplication().getAppComponent().inject(this);
        this.loginInteractor=loginInteractor;
    }

    @Override
    public void checkValidations(final String email, final String password) {
        loginView.showProgress();
        loginInteractor.loginData(email, password, this);

    }

    @Override
    public void setView(final LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void emailError(String emailError) {
        loginView.dismissProgress();
        loginView.emailError(emailError);
    }

    @Override
    public void passwordError(String passwordError) {
        loginView.dismissProgress();
        loginView.passwordError(passwordError);
    }

    @Override
    public void success() {

        loginView.dismissProgress();
        loginView.navigateToHome();

    }

    @Override
    public void loginFailedError(final String failureMsg) {
        loginView.dismissProgress();
        loginView.loginFailed(failureMsg);
    }
}
