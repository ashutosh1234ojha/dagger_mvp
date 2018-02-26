package com.mymvpproject.requestcause;

import com.mymvpproject.constant.ApiKeyConstant;
import com.mymvpproject.database.CommonData;
import com.mymvpproject.modal.SignUpData;
import com.mymvpproject.modal.preference.PreferenceData;
import com.mymvpproject.modal.registration.RegistrationDataObj;
import com.mymvpproject.retrofit.APIError;
import com.mymvpproject.retrofit.CommonResponse;
import com.mymvpproject.retrofit.MultipartParams;
import com.mymvpproject.retrofit.ResponseResolver;
import com.mymvpproject.retrofit.RestClient;

import org.json.JSONArray;

import static com.mymvpproject.constant.AppConstant.DEVICE_OS;

/**
 * Created by Ashutosh Ojha on 10/30/17.
 */

public class RequestCauseInteractorImpl implements RequestCauseInteractor, ApiKeyConstant {
    private OnApiHitFinished mOnApiHitFinished;

    @Override
    public void RequestApiHit(final OnApiHitFinished onApiHitFinished) {
        mOnApiHitFinished = onApiHitFinished;

        RestClient.getApiInterface().preferenceApi().
                enqueue(new ResponseResolver<CommonResponse>() {
                    @Override
                    public void success(final CommonResponse commonResponse) {


                        PreferenceData preferenceData = (PreferenceData) commonResponse.toResponseModel(PreferenceData.class);
                        onApiHitFinished.success(preferenceData);

                    }

                    @Override
                    public void failure(final APIError error) {
                        onApiHitFinished.requestApiFailedError(error.getMessage());
                    }
                });
    }

    @Override
    public void SignUpApiHit(final SignUpData signUpData, final OnApiHitFinished onApiHitFinished) {

        JSONArray jsonArray = new JSONArray();
        if (signUpData.getPreferenceNameList() != null && signUpData.getPreferenceNameList().size() > 0) {
            for (int i = 0; i < signUpData.getPreferenceNameList().size(); i++) {
                jsonArray.put(signUpData.getPreferenceNameList().get(i));
            }
        }

        JSONArray jsonArrayId = new JSONArray();
        if (signUpData.getPreferenceIdList() != null && signUpData.getPreferenceIdList().size() > 0) {
            for (int i = 0; i < signUpData.getPreferenceIdList().size(); i++) {
                jsonArrayId.put(signUpData.getPreferenceIdList().get(i));
            }
        }

        MultipartParams.Builder builder = new MultipartParams.Builder()
                .add(KEY_FIRST_NAME, signUpData.getfName())
                .add(KEY_LAST_NAME, signUpData.getlName())
                .add(KEY_EMAIL, signUpData.getEmail())
                .add(KEY_PHONE, signUpData.getPhone())
                .add(KEY_DEVICE_TOKEN, "fd")
                .add(KEY_DEVICE_OS, DEVICE_OS)
                .add(KEY_APP_VERSION, 100)
                .add(KEY_ADDRESS, signUpData.getAddress())
                .add(KEY_DOB, signUpData.getAddress())
                .add(KEY_TIME_ZONE, 300)
                .add(KEY_PREFERENCE, jsonArray.toString())
                .add(KEY_PEREFENCE_ID, jsonArrayId.toString())
                .add(KEY_PASSWORD, signUpData.getPassword());


        MultipartParams commonParams = builder.build();


        RestClient.getApiInterface().register(commonParams.getMap()).enqueue(new ResponseResolver<CommonResponse>() {
            @Override
            public void success(final CommonResponse commonResponse) {
                RegistrationDataObj registrationDataObj = (RegistrationDataObj) commonResponse.toResponseModel(RegistrationDataObj.class);

                onApiHitFinished.signUpSuccess();
//
//                if (getIntent().getStringExtra(EXTRA_FACEBOOK_ID) != null) {
//
                CommonData.saveAccessToken(registrationDataObj.getAccess_token());
                CommonData.saveRegisterationData(registrationDataObj);
//                    Intent intentPhone = getIntent();
//                    intentPhone.putExtra(EXTRA_IS_PHONE_VERIFIED, true);
//                    setResult(RESULT_OK, intentPhone);
//                    finish();
//
//                } else {
//
//                    Intent intentOtp = new Intent(PreferenceActivity.this, OtpVerificationActivity.class);
//                    intentOtp.putExtra(EXTRA_PHONE, registrationDataObj.getCustomer_phone());
//                    intentOtp.putExtra(EXTRA_ACCESS_TOKEN, registrationDataObj.getAccess_token());
//                    startActivityForResult(intentOtp, REQUEST_OTP);
//                }


            }

            @Override
            public void failure(final APIError error) {
                onApiHitFinished.requestApiFailedError(error.getMessage());
            }
        });

    }

    @Override
    public void onRetrofitFailure(final String msg) {
        mOnApiHitFinished.requestApiFailedError(msg);
    }


}
