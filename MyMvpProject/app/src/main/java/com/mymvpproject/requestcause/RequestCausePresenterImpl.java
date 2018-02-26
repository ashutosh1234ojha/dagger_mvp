package com.mymvpproject.requestcause;

import com.mymvpproject.modal.SignUpData;
import com.mymvpproject.modal.preference.PreferenceData;

/**
 * Created by Ashutosh Ojha on 10/30/17.
 */

public class RequestCausePresenterImpl implements RequestCausePresenter, RequestCauseInteractor.OnApiHitFinished {
    private RequestCauseInteractor requestCauseIntractor;
    private RequestCauseView requestCauseView;
    private PreferenceData preferenceData;


    public RequestCausePresenterImpl(final RequestCauseView requestCauseView) {

        this.requestCauseView = requestCauseView;

        requestCauseIntractor = new RequestCauseInteractorImpl();
    }

    @Override
    public void getDataFromRequestApi() {

        requestCauseView.showProgress();
        requestCauseIntractor.RequestApiHit(this);
    }

    @Override
    public void signUpData(final SignUpData signUpData) {
        requestCauseView.showProgress();
        requestCauseIntractor.SignUpApiHit(signUpData,this);
    }


    @Override
    public void success(final PreferenceData preferenceData) {
        requestCauseView.hideProgress();
        requestCauseView.notifyAdapter(preferenceData);
//        this.preferenceData = preferenceData;
    }

    @Override
    public void requestApiFailedError(final String failureMsg) {
        requestCauseView.hideProgress();
        requestCauseView.showApiError(failureMsg);
    }

    @Override
    public void signUpSuccess() {
        requestCauseView.hideProgress();
        requestCauseView.successfulRegister();
    }
}
