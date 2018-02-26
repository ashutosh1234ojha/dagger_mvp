package com.mymvpproject.home.landing;

/**
 * Created by Ashutosh Ojha on 11/27/17.
 */

public class LandingInteractorImpl implements LandingInteractor {
    @Override
    public void inputFromView(final String first, final String second, final LandingServerResult landingServerResult) {
        String result = first + second;

        if (result.length() < 2) {
            landingServerResult.failureResult("length is small");
        } else {
            landingServerResult.successResult(result);
        }
    }
}
