package com.mymvpproject.retrofit;


import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

import static com.mymvpproject.constant.ApiKeyConstant.AUTHORIZATION;


/**
 * Developer: Amit Sharam
 * Dated: 20-07-2017.
 */
public interface ApiInterface {
    String UPDATE_PROFILE = "/cp_edit_profile";
    String UPDATE_LOCATION = "api/v1/user/updateLocation";
    String REGISTRATION = "/cp_register";
    String LOGIN = "/cp_login";
    String PREFERENCE = "/get_req_cause_pref";
    String VERIFY_OTP = "/verify_otp";
    String RESEND_OTP = "/cp_resend_otp";
    String FORGOT_PASSWORD_FROM_EMAIL = "/cp_forgot_password";
    String LOGOUT = "/cp_logout";
    String ACCESS_TOKEN = "/cp_access_token_login";
    String FACEBOOK_LOGIN = "/cp_fb_login";
    String CHANGE_PASSWORD = "/cp_change_password";
    String GET_REQUEST_LIST = "/get_assigned_request";
    String GET_REQUEST_LIST_DETAILS = "/get_assigned_request_detail";
    String ACCEPT_REQUEST = "/cp_accept_request";
    String REJECT_REQUEST = "/cp_decline_request";
    String REQUEST_ACTION = "/cp_request_action";
    String SAVE_CARD = "/customer_save_card";
    String GET_USER_CARDS = "/get_customer_card";
    String SET_DEFAULT_CARD = "/set_default_card";
    String DELETE_USER_CARD = "/delete_customer_card";
    String MAKE_PAYMENT = "/make_payment";
    String DONATION_HISTORY = "/cp_donation_history";
    String DONATION_DETAIL = "/cp_job_donation_detail";
    String NOTIFICATION_LIST = "/cp_push_notifications";
    String NOTIFICATION_DETAILS = "/cp_push_notifications_detail";
    String CLEAR_NOTIFICATION = "/clear_all_donor_notifications";
    String GET_FAQ = "/get_faqs";
    String GET_PRIVACY_POLICY = "/get_privacy_policy";
    String GET_CONTACT_US = "/get_contact_us_details";
    String APP_VERSION = "/cp_appversion";


    /**
     * @param map registration info
     * @return registration data
     */
    @Multipart
    @POST(REGISTRATION)
    Call<CommonResponse> register(@PartMap HashMap<String, RequestBody> map);

    /**
     * @param hashMap updated information
     * @return updated profile data
     */
    @Multipart
    @POST(UPDATE_PROFILE)
    Call<CommonResponse> updateProfile(@PartMap HashMap<String, RequestBody> hashMap);

    /**
     * @param hashMap password data
     * @return result t/f
     */
    @FormUrlEncoded
    @POST(CHANGE_PASSWORD)
    Call<CommonResponse> changePassword(@FieldMap HashMap<String, String> hashMap);


    /**
     * @param map login info
     * @return login data
     */
    @FormUrlEncoded
    @POST(LOGIN)
    Call<CommonResponse> login(@FieldMap HashMap<String, String> map);


    /**
     * Update location call.
     *
     * @param authorization the authorization
     * @param map           the map
     * @return the call
     */
    @FormUrlEncoded
    @POST(UPDATE_LOCATION)
    Call<CommonParams> updateLocation(@Header(AUTHORIZATION) String authorization,
                                      @FieldMap HashMap<String, String> map);

    /**
     * Update location call.
     *
     * @return preferences
     */
    @GET(PREFERENCE)
    Call<CommonResponse> preferenceApi();

    /**
     * @param map otp info
     * @return verify otp data
     */
    @FormUrlEncoded
    @POST(VERIFY_OTP)
    Call<CommonResponse> verifyOtp(@FieldMap Map<String, String> map);

    /**
     * @param map resend info
     * @return resend otp data
     */
    @FormUrlEncoded
    @POST(RESEND_OTP)
    Call<CommonResponse> resendOTP(@FieldMap Map<String, String> map);


    /**
     * @param map forgot password info
     * @return forgot password data
     */
    @FormUrlEncoded
    @POST(FORGOT_PASSWORD_FROM_EMAIL)
    Call<CommonResponse> forgotPassword(@FieldMap Map<String, String> map);

    /**
     * @param map contains access token
     * @return Common response
     */
    @FormUrlEncoded
    @POST(LOGOUT)
    Call<CommonResponse> logout(@FieldMap Map<String, String> map);

    /**
     * @param map contains access token
     * @return Common response
     */
    @FormUrlEncoded
    @POST(ACCESS_TOKEN)
    Call<CommonResponse> accessToken(@FieldMap Map<String, String> map);

    /**
     * @param map contains access token
     * @return Common response
     */
    @FormUrlEncoded
    @POST(FACEBOOK_LOGIN)
    Call<CommonResponse> facebookLogin(@FieldMap Map<String, String> map);

    /**
     * @param stringMap map
     * @return common response
     */
    @FormUrlEncoded
    @POST(GET_REQUEST_LIST)
    Call<CommonResponse> requestList(@FieldMap Map<String, String> stringMap);

    /**
     * @param stringStringMap map
     * @return common response
     */
    @FormUrlEncoded
    @POST(GET_REQUEST_LIST_DETAILS)
    Call<CommonResponse> requestDetails(@FieldMap Map<String, String> stringStringMap);

    /**
     * hit on accept button click
     *
     * @param stringStringMap map
     * @return common responce
     */
    @FormUrlEncoded
    @POST(ACCEPT_REQUEST)
    Call<CommonResponse> acceptRequest(@FieldMap Map<String, String> stringStringMap);


    /**
     * hit on reject button click
     *
     * @param stringStringMap map
     * @return common responce
     */
    @FormUrlEncoded
    @POST(REJECT_REQUEST)
    Call<CommonResponse> rejectRequest(@FieldMap Map<String, String> stringStringMap);

    /**
     * action of accept /reject
     *
     * @param stringStringMap Map
     * @return comman responce
     */
    @FormUrlEncoded
    @POST(REQUEST_ACTION)
    Call<CommonResponse> actionOnRequest(@FieldMap Map<String, String> stringStringMap);

    /**
     * action save card
     *
     * @param stringMapSaveCard map
     * @return commom responce
     */
    @FormUrlEncoded
    @POST(SAVE_CARD)
    Call<CommonResponse> saveCard(@FieldMap Map<String, String> stringMapSaveCard);

    /**
     * api to get the list of the cards
     *
     * @param stringMapSaveCard map
     * @return list of user card
     */
    @FormUrlEncoded
    @POST(GET_USER_CARDS)
    Call<CommonResponse> getUserCards(@FieldMap Map<String, String> stringMapSaveCard);

    /**
     * api to get the list of the cards
     *
     * @param stringMapDefaultCard map
     * @return list of user card with which is default card
     */
    @FormUrlEncoded
    @POST(SET_DEFAULT_CARD)
    Call<CommonResponse> setDefaultCard(@FieldMap Map<String, String> stringMapDefaultCard);


    /**
     * api to get the list of the cards
     *
     * @param stringMapDeleteUserCard map
     * @return message
     */
    @FormUrlEncoded
    @POST(DELETE_USER_CARD)
    Call<CommonResponse> deleteUserCard(@FieldMap Map<String, String> stringMapDeleteUserCard);

    /**
     * Call to make payment
     *
     * @param map the map
     * @return the call
     */
    @FormUrlEncoded
    @POST(MAKE_PAYMENT)
    Call<CommonResponse> makePayment(@FieldMap Map<String, String> map);

    /**
     * Method to get the donation history
     *
     * @param stringMap map
     * @return common response
     */
    @FormUrlEncoded
    @POST(DONATION_HISTORY)
    Call<CommonResponse> getDonationHistory(@FieldMap Map<String, String> stringMap);

    /**
     * Method to get the donation history detail
     *
     * @param stringMap map
     * @return common response
     */
    @FormUrlEncoded
    @POST(DONATION_DETAIL)
    Call<CommonResponse> getDonationDetail(@FieldMap Map<String, String> stringMap);

    /**
     * @param map map
     * @return comman responce
     */
    @FormUrlEncoded
    @POST(NOTIFICATION_LIST)
    Call<CommonResponse> notificationList(@FieldMap Map<String, String> map);

    /**
     * @param map map
     * @return comman responce
     */
    @FormUrlEncoded
    @POST(NOTIFICATION_DETAILS)
    Call<CommonResponse> notificationDetails(@FieldMap Map<String, String> map);

    /**
     * @param map map
     * @return comman responce
     */
    @FormUrlEncoded
    @POST(CLEAR_NOTIFICATION)
    Call<CommonResponse> clearNotification(@FieldMap Map<String, String> map);

    /**
     * @return common response
     */
    @GET(GET_FAQ)
    Call<CommonResponse> faqApiHit();

    /**
     * @return common response
     */
    @GET(GET_PRIVACY_POLICY)
    Call<CommonResponse> privacyPoilcyApiHit();

    /**
     * @return common response
     */
    @GET(GET_CONTACT_US)
    Call<CommonResponse> contactUsApiHit();

    /**
     * @param map map
     * @return comman responce
     */
    @FormUrlEncoded
    @POST(APP_VERSION)
    Call<CommonResponse> appVersionCheck(@FieldMap Map<String, String> map);


}

