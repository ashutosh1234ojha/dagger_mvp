package com.mymvpproject.home.user;

/**
 * Created by Ashutosh Ojha on 11/27/17.
 */

public class UserInteractorImpl implements UserInteractor {
    @Override
    public void inputFromView(final String first, final String second, final UserServerResult userServerResult) {
        String result = first + second;

        if (result.length() < 2) {
            userServerResult.failureResult("length is small");
        } else {
            userServerResult.successResult(result);
        }
    }
}
