package com.mymvpproject.otp;

/**
 * Created by cl-macmini-86 on 10/13/17.
 */

public class OtpPresenterImpl implements OtpPresenter ,OtpInteractor.OtpFinished{
    private OtpView otpView;
    private OtpInteractor otpInteractor;

    public OtpPresenterImpl(OtpView loginView) {
        this.otpView = loginView;
        otpInteractor=new OtpInteractorImpl();
    }

    @Override
    public void checkValidations(final String otp) {
        otpView.showProgress();
        otpInteractor.otpData(otp,this);

    }

    @Override
    public void otpError(String emailError) {
        otpView.dismissProgress();
        otpView.otpError(emailError);
    }


    @Override
    public void success() {

        otpView.dismissProgress();
        otpView.navigateToHome();

    }

    @Override
    public void otpFailedError(final String failureMsg) {
        otpView.dismissProgress();
        otpView.otpFailedError(failureMsg);
    }
}
