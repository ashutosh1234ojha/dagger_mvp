package com.mymvpproject.requestcause;

import com.mymvpproject.CommonInteractor;
import com.mymvpproject.modal.SignUpData;
import com.mymvpproject.modal.preference.PreferenceData;

/**
 * Created by Ashutosh Ojha on 10/30/17.
 */

public interface RequestCauseInteractor extends CommonInteractor {

    void RequestApiHit(OnApiHitFinished onApiHitFinished);

    void SignUpApiHit(SignUpData signUpData,OnApiHitFinished onApiHitFinished);

    interface OnApiHitFinished {

        void success(PreferenceData preferenceData);

        void requestApiFailedError(String failureMsg);

        void signUpSuccess();
    }

    @Override
    void onRetrofitFailure(String msg);
}
