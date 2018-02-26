package com.mymvpproject.constant;

import android.content.Context;

import com.mymvpproject.R;

/**
 * Developer: Saurabh Verma
 * Dated: 19-02-2017.
 */

public interface AppConstant {
    String DATE_WITH_SLASH = "yyyy/MM/dd";
    String TIME_AM_PM = "hh:mm aa";
    int ANDROID = 0;
    String KEY_LIST = "list";

    String KEY_LIST_ID = "list_id";
    String KEY_DETAILS_OBJ = "details";
    String KEY_REQUEST_ACCEPTED_HIT = "requestAcceptedHit";
    String TAG = "tag";
    String EMPTY_STRING = "";
    String FROM_EDIT_PROFILE = "fromEditProfile";
    String WHITE_SPACE = " ";
    String KEY_JOB_STATUS = "job_status";
    String KEY_JOB_ID = "job_id";
    // deviceType: 0 = ANDROID, 1 = IOS
    String FACEBOOK = "FACEBOOK";
    String NORMAL = "NORMAL";
    String DEVICE_OS = "ANDROID";
    String FROM_HOME = "fromHome";
    int DELAY_ONE_SECOND = 1000;
    int mNum11 = 11;
    int PERCENTAGE = 100;

    //Intent Filter
    String NOTIFICATION_RECEIVED = "notification_received";

    int SESSION_EXPIRED = 101;
    int DEFAULT_STATUS = 900;
    int NUM_EXP_DATE = 2000;
    int NUM_ASD = 2022;
    int FACEBOOK_ERROR_CODE = 402;
    int SET_DEFAULT = 1;
    int DELETE_SELECTED_CARD = 2;

    int CUSTOMER = 1;                              // (0 - Fleet, 1 - Customer, 2 - Service Company)
    int FROM_CP = 1;                   //1 - From CP ~ no sp found, 2 - From SP ~ login email not found
    int OTP_NOT_VERIFIED = 0;
    int NUM = 60;

    //RequestObj code
    int REQ_CODE_DEFAULT_SETTINGS = 16061;
    int REQ_CODE_FILTER = 160;
    int REQ_CODE_PLAY_SERVICES_RESOLUTION = 16061;
    int REQ_CODE_SCREEN_OVERLAY = 10101;
    int REQ_CODE_CARD = 2413487;
    int REQUEST_CODE_DEATILS = 19280;
    int REQ_CODE_GET_PREFRENCS = 11011;
    int REQ_CODE_CHANGE_PASSWORD = 13032;
    int REQ_CODE_ADD_CARD = 23243;
    int REQ_CODE_EDIT_PROFILE = 14011;
    int IMAGE_COMPRESSED_HEIGHT = 4000;
    int IMAGE_COMPRESSED_WIDTH = 4000;
    int IMAGE_COMPRESSED_QUALITY = 100;
    int REQ_CODE_PAYMENT = 12432;
    int REQUEST_FILTER = 2007;
    int REQUEST_UPDATE = 2017;
    int LIMIT_VALUE = 10;
    int NUM_YEAR = 12;
    int REQ_CODE_SCAN_CARD = 4312;
    int REQ_CODE_MAKE_DONATION = 12987;
    int REQ_CODE_MULTIPLE_IMAGES = 12988;
    int REQ_NOTIFICATION_DETAIL = 206;
    int NUM_CARD_MIN_LENGTH = 12;


    String Visa = "Visa";
    String MasterCard = "MasterCard";
    String American_Express = "American Express";
    String JCB = "JCB";
    String Discover = "Discover";
    String Diners_Club = "Diners Club";


    String COMMON_TOKEN = "clickpass";

    String EXTRA_FACEBOOK = "extra_facebook";
    String EXTRA_FACEBOOK_DETAILS = "extra_facebook_details";
    String EXTRA_AMOUNT_DONATED = "extra_amount_donated";
    String EXTRA_FROM_HISTORY = "extra_from_history";
    String EXTRA_DONATION_ID = "extra_donation_id";
    String ARGS_DOCUMENTS = "args_documents";


    //Status
    int KEY_STATUS_PENDING = 0;
    int KEY_STATUS_STARTED = 1;
    int KEY_STATUS_ENDED = 2;
    int KEY_STATUS_FAILED = 3;
    int KEY_STATUS_ARRIVED = 4;
    int KEY_STATUS_PARTIAL = 5;
    int KEY_STATUS_UNASSIGNED = 6;
    int KEY_STATUS_ACCEPTED = 7;
    int KEY_STATUS_DECLINE = 8;
    int KEY_STATUS_CANCELED = 9;
    int KEY_STATUS_DELETED = 10;
    int KEY_STATUS_IGNORED = 11;
    int KEY_STATUS_CANCELLED_DA = 11;
    int KEY_STATUS_CLOSE = 12;
    int KEY_STATUS_INPROCESS = 13;
    int KEY_STATUS_EXPIRED = 14;
    int KEY_STATUS_APPROVED = 15;



    /**
     * Status Codes of the Response sent by the
     * Server. These status codes will be used
     * for segregation of the Actions to be
     * performed after getting .
     */
    enum StatusCode {

        // No Error
        NONE(0),

        // Server Errors
        ACTION_COMPLETE(200),
        SHOW_ERROR_MESSAGE(202),
        PARAMETER_MISSING(100),

        INVALID_ACCESS_TOKEN(101),
        PICK_UP_INCOMPLETE(410),
        BILLING_PLAN_EXPIRED(401),
        TASK_DELETED(501),
        AVAIBALITY_STATUS_CHANGED(210),

        // Retrofit Errors
        REQUEST_ERROR(400),
        EXECUTION_ERROR(404),
        NETWORK_ERROR(411),
        PARSING_ERROR(413);

        private final int statusCode;

        /**
         * Constructor
         *
         * @param statusCode
         */
        StatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        /**
         * @param statusCode
         * @return
         */
        public static StatusCode get(int statusCode) {

            StatusCode status = NONE;

            for (StatusCode value : values()) {
                if (value.getStatusCode() == statusCode) {
                    status = value;
                    break;
                }
            }

            return status;
        }

        public int getStatusCode() {
            return statusCode;
        }
    }

    /**
     * The messages to be conveyed when an error
     * is reported as a result of Api Call Failure
     */
    enum StatusDescription {

        CUSTOM(-1),

        NONE(R.string.empty),
        HTTP_ERROR(R.string.http_error),
        CONNECTION_REFUSED(R.string.connection_refused_error),
        SSL_HANDSHAKE_FAILED(R.string.ssl_handshake_error),
        NO_INTERNET(R.string.msg_not_connected_to_internet),
        SOCKET_TIMED_OUT(R.string.remote_server_failed_error),
        CONNECTION_TIMED_OUT(R.string.connection_timed_out_error),
        NO_HTTP_RESPONSE(R.string.remote_server_could_not_respond),
        PARSING_ERROR(R.string.an_error_was_procured_while_parsing),
        RUNTIME_ERROR(R.string.an_unexpected_error_occurred),
        UNKNOWN_ERROR_OCCURRED(R.string.an_unexpected_error_occurred),
        CONNECTION_RESET_BY_PEER(R.string.connection_reset_error),
        UNEXPECTED_END_OF_STREAM(R.string.unexpected_end_stream);

        private final int resourceId;
        private String message;

        StatusDescription(int resourceId) {
            this.resourceId = resourceId;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getMessage(Context context) {

            return resourceId == -1 ? message : context.getString(resourceId);
        }
    }

}
