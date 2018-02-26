package com.mymvpproject.requestcause;

import com.mymvpproject.modal.preference.PreferenceData;

/**
 * Created by Ashutosh Ojha on 10/30/17.
 */

public interface RequestCauseView {

    void notifyAdapter(PreferenceData preferenceData);
    void showProgress();
    void hideProgress();
    void showApiError(String msg);
    void successfulRegister();
}
