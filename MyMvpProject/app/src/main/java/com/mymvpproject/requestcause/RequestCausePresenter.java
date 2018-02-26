package com.mymvpproject.requestcause;

import com.mymvpproject.modal.SignUpData;

/**
 * Created by Ashutosh Ojha on 10/30/17.
 */

public interface RequestCausePresenter {

    void getDataFromRequestApi();
    void signUpData(SignUpData signUpData);



}
