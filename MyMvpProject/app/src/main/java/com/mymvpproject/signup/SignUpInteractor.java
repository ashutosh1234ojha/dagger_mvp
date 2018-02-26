package com.mymvpproject.signup;

import com.mymvpproject.CommonInteractor;

/**
 * Created by Ashutosh Ojha on 10/27/17.
 */

public interface SignUpInteractor extends CommonInteractor{


    interface OnSignUpFinished {
        void fNameError(String errorMsg);

        void lNameError(String errorMsg);
        void emailError(String errorMsg);

        void phoneError(String errorMsg);

        void addressError(String errorMsg);

        void dobError(String errorMsg);

        void paswordError(String errorMsg);

        void confirmPasswordError(String errorMsg);



        void success();

        void signUpFailedError(String failureMsg);
    }

    void signUpData(String fName, String lName, String email, String phone,
                    String address, String dob, String password, String confirmPassword, OnSignUpFinished onSignUpFinished);

    @Override
    void onRetrofitFailure(String msg);
}
