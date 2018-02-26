package com.mymvpproject.signup;

/**
 * Created by Ashutosh Ojha on 10/27/17.
 */

public interface SignUpPresenter {
    void validateRegisterInfo(String fName, String lName, String email,String phone,
                              String address, String dob, String password, String confirmPassword);
}
