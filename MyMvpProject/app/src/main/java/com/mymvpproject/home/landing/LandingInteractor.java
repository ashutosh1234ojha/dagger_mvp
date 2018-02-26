package com.mymvpproject.home.landing;

/**
 * Created by Ashutosh Ojha on 11/27/17.
 */

public interface LandingInteractor {

    void inputFromView(String first,String second,LandingServerResult landingServerResult);
    interface LandingServerResult {

        void successResult(String msg);
        void failureResult(String msg);

    }
}
