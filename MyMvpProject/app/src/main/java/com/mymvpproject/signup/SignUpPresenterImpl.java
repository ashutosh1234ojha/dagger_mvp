package com.mymvpproject.signup;

/**
 * Created by Ashutosh Ojha on 10/27/17.
 */

public class SignUpPresenterImpl implements SignUpPresenter, SignUpInteractor.OnSignUpFinished {


    private SignUpInteractor signUpInteractor;
    private SignUpView signUpView;

    public SignUpPresenterImpl(final SignUpView signUpView) {
        this.signUpView = signUpView;
        signUpInteractor = new SignUpInteractorImpl();

    }

    @Override
    public void validateRegisterInfo(final String fName, final String lName, final String email, final String phone,
                                     final String address, final String dob, final String password, final String confirmPassword) {

        signUpInteractor.signUpData(fName, lName, email, phone,
                address, dob, password, confirmPassword, this);

    }

    @Override
    public void fNameError(final String errorMsg) {

        signUpView.fNameError(errorMsg);
    }

    @Override
    public void lNameError(final String errorMsg) {

        signUpView.lNameError(errorMsg);
    }

    @Override
    public void emailError(final String errorMsg) {
        signUpView.emailError(errorMsg);
    }

    @Override
    public void phoneError(final String errorMsg) {

        signUpView.phoneError(errorMsg);
    }

    @Override
    public void addressError(final String errorMsg) {

        signUpView.addressError(errorMsg);
    }

    @Override
    public void dobError(final String errorMsg) {

        signUpView.dobError(errorMsg);
    }

    @Override
    public void paswordError(final String errorMsg) {

        signUpView.phoneError(errorMsg);
    }

    @Override
    public void confirmPasswordError(final String errorMsg) {

        signUpView.passwordConfirmError(errorMsg);
    }


    @Override
    public void success() {

        signUpView.navigateToOtp();
    }

    @Override
    public void signUpFailedError(final String failureMsg) {

        signUpView.signUpFailed(failureMsg);
    }
}
