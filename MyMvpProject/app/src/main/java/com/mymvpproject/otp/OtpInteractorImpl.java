package com.mymvpproject.otp;

import com.mymvpproject.database.CommonData;
import com.mymvpproject.retrofit.APIError;
import com.mymvpproject.retrofit.CommonParams;
import com.mymvpproject.retrofit.CommonResponse;
import com.mymvpproject.retrofit.ResponseResolver;
import com.mymvpproject.retrofit.RestClient;
import com.mymvpproject.util.Validation;

import static com.mymvpproject.constant.ApiKeyConstant.KEY_ACCESS_TOKEN;
import static com.mymvpproject.constant.ApiKeyConstant.KEY_VERIFICATION_CODE;

/**
 * Created by cl-macmini-86 on 10/13/17.
 */

public class OtpInteractorImpl implements OtpInteractor {
    private OtpFinished mOtpFinished;

    @Override
    public void otpData(final String otp, final OtpFinished otpFinished) {

        mOtpFinished = otpFinished;
        if (isValid(otp, otpFinished)) {


            CommonParams commonParams = new CommonParams.Builder()
                    .add(KEY_ACCESS_TOKEN, CommonData.getAccessToken())
                    .add(KEY_VERIFICATION_CODE, otp)
                    .build();
            RestClient.getApiInterface().verifyOtp(commonParams.getMap()).
                    enqueue(new ResponseResolver<CommonResponse>() {
                        @Override
                        public void success(final CommonResponse commonResponse) {

                            otpFinished.success();


                        }

                        @Override
                        public void failure(final APIError error) {
                            otpFinished.otpFailedError(error.getMessage());

                        }
                    });
        }

    }

    @Override
    public void onRetrofitFailure(final String msg) {
        mOtpFinished.otpFailedError(msg);

    }

    private boolean isValid(final String otpError, final OtpFinished otpFinished) {
        if (!Validation.isOtpValid(otpError).isEmpty()) {
            otpFinished.otpError(otpError);
            return false;
        } else {
            return true;
        }
    }
}
