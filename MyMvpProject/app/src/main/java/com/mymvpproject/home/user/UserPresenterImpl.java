package com.mymvpproject.home.user;

/**
 * Created by Ashutosh Ojha on 11/24/17.
 */

public class UserPresenterImpl implements UserPresenter, UserInteractor.UserServerResult {
    private UserView landingView;
    private UserInteractor userInteractor;

    public UserPresenterImpl(UserView landingView) {
        this.landingView = landingView;
        userInteractor=new UserInteractorImpl();
    }

    @Override
    public void inputDigit(final String first, final String second) {

        if (first.equals("0")) {
            landingView.showFirstDigitError("first zero not allowed");

        } else if (second.equals("0")) {
            landingView.showSecondDigitError("second zero not allowed");
        } else {

            userInteractor.inputFromView(first,second,this);
        }
    }

    @Override
    public void successResult(final String msg) {
        landingView.showSuccess(msg);
    }

    @Override
    public void failureResult(final String msg) {
        landingView.showFailure(msg);
    }
}
