package com.mymvpproject.retrofit;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.mymvpproject.constant.ApiKeyConstant.DATA;
import static com.mymvpproject.constant.ApiKeyConstant.MESSAGE;
import static com.mymvpproject.constant.ApiKeyConstant.STATUS_CODE;


/**
 * Developer: Saurabh Verma
 * Dated: 27-09-2016.
 *
 */

/**
 *
 * @param <T> t
 */
public class CommonResponse<T> {
    @SerializedName(STATUS_CODE)
    @Expose
    private int statusCode;
    @SerializedName(MESSAGE)
    @Expose
    private String message;
    @SerializedName(DATA)
    @Expose
    private Object data;

    /**
     * Get message from api response
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Get status code of api response
     *
     * @return statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }


    /**
     * Convert to pojo
     *
     * @param classRef class
     * @param <T>      t
     * @return t
     */
    public <T> T toResponseModel(final Class<T> classRef) {
        return new Gson().fromJson(new Gson().toJson(data), classRef);
    }

//    public <T> T toResponsePolyline(Class<T> classRef) {
//        return new Gson().fromJson(new Gson().toJson(polylines), classRef);
//    }

    @Override
    public String toString() {
        return statusCode + " " + message + "\n" + data;
    }
}
