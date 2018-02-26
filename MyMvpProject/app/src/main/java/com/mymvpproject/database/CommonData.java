package com.mymvpproject.database;


import com.mymvpproject.constant.PaperDbConstant;
import com.mymvpproject.modal.registration.RegistrationDataObj;

import java.util.Map;

import io.paperdb.Paper;

/**
 * Developer: Saurabh Verma
 * Dated: 19-02-2017.
 */
public final class CommonData implements PaperDbConstant {

    private static Map<String, String> mPushData;
    private static String value;

    /**
     * Empty Constructor
     * not called
     */
    private CommonData() {
    }

    /**
     * Update fcm token.
     *
     * @param token the token
     */
//======================================== FCM token ==============================================
    public static void updateFCMToken(final String token) {
        Paper.book().write(PAPER_DEVICE_TOKEN, token);
    }

    /**
     * Gets fcm token.
     *
     * @return the fcm token
     */
    public static String getFCMToken() {
        return Paper.book().read(PAPER_DEVICE_TOKEN);
    }

    /**
     * @param registrationDataObj data model object
     */
    public static void saveRegisterationData(final RegistrationDataObj registrationDataObj) {
        Paper.book().write(PAPER_SAVE_DATA, registrationDataObj);
    }

    /**
     * @return saved data
     */
    public static RegistrationDataObj getRegisterationData() {
        return Paper.book().read(PAPER_GET_DATA);
    }
//======================================== Access Token ============================================

    /**
     * Save access token.
     *
     * @param accessToken the access token
     */

    public static void saveAccessToken(final String accessToken) {
        Paper.book().write(PAPER_ACCESS_TOKEN, accessToken);
    }

    /**
     * Gets access token.
     *
     * @return the access token
     */
    public static String getAccessToken() {
        return Paper.book().read(PAPER_ACCESS_TOKEN);
    }

//======================================== Push Data ============================================

    /**
     * Save push data.
     *
     * @param pushData the access token
     */

    public static void savePushData(final Map<String, String> pushData) {
        mPushData = pushData;
    }

    /**
     * Gets access token.
     *
     * @return the access token
     */
    public static Map<String, String> getPushData() {
        return mPushData;
    }

    //======================================== Clear data ===============================================

    /**
     * Delete paper.
     */
    public static void clearData() {
        String deviceToken = getFCMToken();
        Paper.book().destroy();
        updateFCMToken(deviceToken);
    }
}
