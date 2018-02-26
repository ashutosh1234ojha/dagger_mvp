package com.mymvpproject.modal.registration;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cl-macmini-86 on 5/24/17.
 */

public class RegistrationDataObj {
    @SerializedName("customer_id")
    public int customer_id;
    @SerializedName("customer_email")
    public String customer_email;
    @SerializedName("customer_phone")
    public String customer_phone;
    @SerializedName("access_token")
    public String access_token;
    @SerializedName("first_name")
    public String first_name;
    @SerializedName("last_name")
    public String last_name;
    @SerializedName("customer_code")
    public String customer_code;
    @SerializedName("verification_code")
    public String verification_code;
    @SerializedName("verification_status")
    public int verification_status;
    @SerializedName("facebook_id")
    public String facebook_id;
    @SerializedName("password_reset_token")
    public String password_reset_token;
    @SerializedName("referral_code")
    public String referral_code;
    @SerializedName("timezone")
    public String timezone;
    @SerializedName("device_token")
    public String device_token;
    @SerializedName("device_type")
    public String device_type;
    @SerializedName("device_os")
    public String device_os;
    @SerializedName("app_version")
    public String app_version;
    @SerializedName("imei_number")
    public String imei_number;
    @SerializedName("device_id")
    public String device_id;
    @SerializedName("creation_datetime")
    public String creation_datetime;
    @SerializedName("customer_latitude")
    public String customer_latitude;
    @SerializedName("customer_longitude")
    public String customer_longitude;
    @SerializedName("is_active")
    public int is_active;
    @SerializedName("user_id")
    public int user_id;
    @SerializedName("dob")
    public String dob;
    @SerializedName("address")
    public String address;
    @SerializedName("requestCausePref")
    public List<String> requestCausePref;
    @SerializedName("reqCausePrefIds")
    public List<String> reqCausePrefIds;
    @SerializedName("profile_thumb_image_url")
    public String profile_thumb_image_url;
    @SerializedName("profile_image_url")
    public String profile_image_url;
    @SerializedName("isFbRegistraion")
    public int isFbRegistraion;
    @SerializedName("isAdminVerify")
    public int isAdminVerify;
    @SerializedName("verifiedBy")
    public String verifiedBy;
    @SerializedName("is_blocked")
    public int is_blocked;

    public int getCustomer_id() {
        return customer_id;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getCustomer_code() {
        return customer_code;
    }

    public String getVerification_code() {
        return verification_code;
    }

    public int getVerification_status() {
        return verification_status;
    }

    public String getFacebook_id() {
        return facebook_id;
    }

    public String getPassword_reset_token() {
        return password_reset_token;
    }

    public String getReferral_code() {
        return referral_code;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getDevice_token() {
        return device_token;
    }

    public String getDevice_type() {
        return device_type;
    }

    public String getDevice_os() {
        return device_os;
    }

    public String getApp_version() {
        return app_version;
    }

    public String getImei_number() {
        return imei_number;
    }

    public String getDevice_id() {
        return device_id;
    }

    public String getCreation_datetime() {
        return creation_datetime;
    }

    public String getCustomer_latitude() {
        return customer_latitude;
    }

    public String getCustomer_longitude() {
        return customer_longitude;
    }

    public int getIs_active() {
        return is_active;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public List<String> getRequestCausePref() {
        return requestCausePref;
    }

    public List<String> getReqCausePrefIds() {
        return reqCausePrefIds;
    }

    public String getProfile_thumb_image_url() {
        return profile_thumb_image_url;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public int getIsFbRegistraion() {
        return isFbRegistraion;
    }

    public int getIsAdminVerify() {
        return isAdminVerify;
    }

    public String getVerifiedBy() {
        return verifiedBy;
    }

    public int getIs_blocked() {
        return is_blocked;
    }
}
