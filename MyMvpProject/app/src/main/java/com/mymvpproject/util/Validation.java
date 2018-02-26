package com.mymvpproject.util;

import android.util.Patterns;

import java.util.regex.Pattern;

/**
 * Created by cl-macmini-86 on 10/13/17.
 */

public class Validation {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final int MAX_PHONE_LENGTH = 10;


    /**
     * Method to validate email id
     *
     * @param fName instance of edit text
     * @return boolean
     */
    public static String isFnameValid(final String fName) {

        if (genericEmpty(fName)) {
            return "Please enter fName";
        } else {
            return "";
        }
    }


    public static String isLnameValid(final String lName) {

        if (genericEmpty(lName)) {
            return "Please enter lName";
        } else {
            return "";
        }
    }


    public static String isAddressValid(final String address) {

        if (genericEmpty(address)) {
            return "Please enter address";
        } else {
            return "";
        }
    }

    public static String isDobValid(final String dob) {

        if (genericEmpty(dob)) {
            return "Please enter Date Of Birth";
        } else {
            return "";
        }
    }

    /**
     * Method to validate email id
     *
     * @param email instance of edit text
     * @return boolean
     */
    public static String isEmailValid(final String email) {

        if (genericEmpty(email)) {
            return "Please enter email";
        } else if (!email.matches(Patterns.EMAIL_ADDRESS.toString())) {
            return "Please enter valid email";
        } else {
            return "";
        }
    }

    /**
     * Method to validate email id
     *
     * @param otp instance of edit text
     * @return boolean
     */
    public static String isOtpValid(final String otp) {

        if (genericEmpty(otp)) {
            return "Please enter otp";
        } else if (otp.length() !=4) {
            return "Otp should be of four digit";
        } else {
            return "";
        }
    }


    /**
     * Method to validate email id
     *
     * @param password instance of edit text
     * @return boolean
     */
    public static String isPasswordValid(final String password) {

        if (genericEmpty(password)) {
            return "Please enter password";
        } else if (password.length() < 6) {
            return "Please enter valid password";
        } else {
            return "";
        }
    }

    /**
     * phone number validation
     *
     * @param phone editText
     * @return boolean
     */
    public static String isPhoneValid(final String phone) {

        try {

            if (genericEmpty(phone)) {
                return "Please enter phone no";
            } else if (phone.length() < MAX_PHONE_LENGTH) {
                return "Please enter valid phone no";

            } else if (Long.valueOf(phone) == 0) {

                return "Plase enter valid phone no";
            } else {
                return "";
            }


        } catch (NumberFormatException e) {
            return "exception";
        }
    }

    /**
     * @param string instance of edit text
     * @return boolean
     */
    private static boolean genericEmpty(final String string) {
        return string.trim().isEmpty();
    }

    public static String isComparePassowrdValid(final String passEt, final String confirmPassEt) {
        if (genericEmpty(confirmPassEt)) {
            return "Please enter confirm password";


        } else if (!passEt.equals(confirmPassEt)) {
            return "Confirm password should be same as password";

        }
        return "";

    }

}
