package com.mymvpproject.home.landing;

/**
 * Created by Ashutosh Ojha on 11/24/17.
 */

public interface LandingView {

    void showFirstDigitError(String msg);

    void showSecondDigitError(String msg);

    void showSuccess(String msg);
    void showFailure(String msg);
}
