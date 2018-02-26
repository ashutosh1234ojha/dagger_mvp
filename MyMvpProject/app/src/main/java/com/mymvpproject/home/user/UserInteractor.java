package com.mymvpproject.home.user;

/**
 * Created by Ashutosh Ojha on 11/27/17.
 */

public interface UserInteractor {

    void inputFromView(String first, String second, UserServerResult userServerResult);
    interface UserServerResult {

        void successResult(String msg);
        void failureResult(String msg);

    }
}
