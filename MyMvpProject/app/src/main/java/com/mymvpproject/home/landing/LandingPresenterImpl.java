package com.mymvpproject.home.landing;

/**
 * Created by Ashutosh Ojha on 11/24/17.
 */

public class LandingPresenterImpl implements LandingPresenter, LandingInteractor.LandingServerResult {
    private LandingView landingView;
    private LandingInteractor landingInteractor;

    public LandingPresenterImpl(LandingView landingView) {
        this.landingView = landingView;
        landingInteractor=new LandingInteractorImpl();
    }

    @Override
    public void inputDigit(final String first, final String second) {

        if (first.equals("0")) {
            landingView.showFirstDigitError("first zero not allowed");

        } else if (second.equals("0")) {
            landingView.showSecondDigitError("second zero not allowed");
        } else {

            landingInteractor.inputFromView(first,second,this);
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
