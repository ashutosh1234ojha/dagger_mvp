package com.mymvpproject.constant;

/**
 * Developer: Saurabh Verma
 * Dated: 19-02-2017.
 */

public interface ApiKeyConstant {
    String MESSAGE = "message";
    String DATA = "data";
    String STATUS_CODE = "status";
    //    String STATUS_CODE = "statusCode";
    String AUTHORIZATION = "authorization";
    String BOOKING_ID = "bookingId";
    String LATITUDE = "lat";
    String LONGITUDE = "lng";
    String TIMESTAMP = "timestamp";
    String PUBLISH_KEY = "pk_test_RTVzphs76rIN1TNaQAXXcleR";


    //Church api key
    String KEY_FIRST_NAME = "first_name";
    String KEY_ACCESS_TOKEN = "access_token";
    String KEY_LAST_NAME = "last_name";
    String KEY_EMAIL = "email";
    String KEY_EDIT_EMAIL = "customer_email";
    String KEY_PHONE = "phone";
    String KEY_EDIT_PHONE = "customer_phone";
    String KEY_PASSWORD = "password";
    String KEY_DEVICE_TYPE = "device_type";
    String KEY_DEVICE_TOKEN = "device_token";
    String KEY_DEVICE_OS = "device_os";
    String KEY_DEVICE_DESC = "device_desc";
    String KEY_IMEI_NUMBER = "imei_number";
    String KEY_STORE_VERSION = "store_version";
    String KEY_APP_VERSION = "app_version";
    String KEY_TRANSPORT_TYPE = "transport_type";
    String KEY_ADDRESS = "address";
    String KEY_DOB = "dob";
    String KEY_IMAGE = "image";
    String KEY_PREFERENCE = "preferences";
    String KEY_DEVICE_ID = "device_id";
    String KEY_TIME_ZONE = "timezone";
    String KEY_VERIFICATION_CODE = "verification_code";
    String KEY_PARAMS = "params";
    String KEY_FACEBOOK_ID = "facebook_id";
    String KEY_OLD_PASSWORD = "old_password";
    String KEY_NEW_PASSWORD = "new_password";
    String KEY_CUSTOMER_EMAIL = "customer_email";
    String KEY_CUSTOMER_PHONE = "customer_phone";
    String KEY_PEREFENCE_ID = "req_cause_ids";
    String KEY_LIMIT = "limit";
    String KEY_SKIP = "skip";
    String KEY_REQ_ID = "req_id";
    String KEY_DONATION_ID = "donation_id";
    String KEY_STRIPE_TOKEN = "stripe_token";
    String KEY_DEFAULT = "default";
    String KEY_CARD_TOKEN = "card_token";
    String KEY_AMOUNT = "amount";
    String KEY_NOTIFICATION_ID = "notification_id";
    String KEY_CUSTOMER_ID = "customer_job_id";
    String KEY_REQUEST_STATUS = "status";


    //Intent keys
    String EXTRA_IS_PHONE_VERIFIED = "EXTRA_IS_PHONE_VERIFIED";
    String EXTRA_FIRST_NAME = "EXTRA_FIRST_NAME";
    String EXTRA_LAST_NAME = "EXTRA_LAST_NAME";
    String EXTRA_KEY_EMAIL = "EXTRA_KEY_EMAIL";
    String EXTRA_PHONE = "EXTRA_PHONE";
    String EXTRA_PASSWORD = "EXTRA_PASSWORD";
    String EXTRA_DOB = "EXTRA_DOB";
    String EXTRA_ADDRESS = "EXTRA_ADDRESS";
    String EXTRA_FACEBOOK_ID = "EXTRA_FACEBOOK_ID";
    String EXTRA_IMAGE = "EXTRA_IMAGE";
    String EXTRA_ACCESS_TOKEN = "EXTRA_ACCESS_TOKEN";
    String EXTRA_INTENT_FROM = "intent_from";
    String EXTRA_NOTIFICATION_ID = "intent_notification_id_from";
    String EXTRA_SELECTED_STATUS = "selected_status";
    String EXTRA_HANDLE_NOTIFICATION = "handle_notification";
    String EXTRA_REFRESH_HOME = "refresh home";
    String HANDLE_NOTIFICATION = "handle_notification";


    //extra keys
    String FROM_REQUEST = "from_request";
    String FROM_NOTIFICATION = "from_notification";
    String FROM_HISTORY = "from_history";
    String EXTRA_IMAGES = "images";


    //status
    int STATUS_PENDING = 0;
    int STATUS_ACCEPTED = 1;
    int STATUS_REJECTED = 2;
    int STATUS_COMPLETED = 3;
    int STATUS_UNASSIGNED = 6;
    int STATUS_ACTION_HIDE = 5;

    int STATUS_DECLINE = 8;
    int STATUS_CLOSE = 12;
    int STATUS_INPROCESS = 13;
    int STATUS_APPROVED = 15;

    int STATUS_DONOR_PENDING = 0;
    int STATUS_DONOR_ACCEPTED = 1;
    int STATUS_DONOR_FUNDED = 3;

    //page positions
    int POSITION_ZERO = 0;
    int POSITION_ONE = 1;
    int POSITION_TWO = 2;
    int POSITION_THREE = 3;


    String PENDING = "PENDING";
    String ACCEPTED = "ACCEPTED";
    String KEEP = "KEEP";
    String NOT_DELIVERED = "NOT DELIVERED";
    String ARRIVED = "ARRIVED";
    String STARTED = "STARTED";
    String COMPLETED = "COMPLETED";
    String CANCELLED = "CANCELLED";
    String DECLINED = "DECLINED";
    String DELETED = "DELETED";
    String CLOSED = "CLOSED";
    String EXPIRED = "EXPIRED";
    String IGNORED = "IGNORED";
    String UNASSIGNED = "UNASSIGNED";
    String PARTIAL = "PARTIAL";
    String FUNDED = "FUNDED";


}
