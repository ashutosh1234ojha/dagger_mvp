package com.mymvpproject.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.mymvpproject.R;
import com.mymvpproject.dialog.CustomAlertDialog;

import java.io.File;
import java.io.FileOutputStream;


/**
 * Developer: Saurabh Verma
 * Dated: 19-02-2017.
 */

public final class Util {

    public static final int TEN = 10;
    public static final int QUALITY = 60;

    /**
     * Empty Constructor
     * not called
     */
    private Util() {
    }

    /**
     * Method to check if internet is connected
     *
     * @param context context of calling class
     * @return true if connected to any network else return false
     */
    public static boolean isNetworkAvailable(final Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) (context.getApplicationContext()).getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     * Method to show toast
     *
     * @param message  that disaply in the Toast
     * @param mContext context of calling activity or fragment
     */
    public static void showToast(final Context mContext, final String message) {
        if (mContext == null
                || message == null
                || message.isEmpty()) {
            return;
        }
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param mContext context of calling activity or fragment
     * @param msg      message to display
     */
    public static void restartAppOnSessionExpired(final Context mContext, final String msg) {
        //Util.showToast(mContext, mContext.getString(R.string.session_expired));
        /**
         * m context
         */
        new CustomAlertDialog.Builder(mContext)
                .setMessage(msg)
                .setPositiveButton(R.string.text_ok, new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                    @Override
                    public void onClick() {

//
                    }
                })
                .show();
    }


    /**
     * @param context of calling activity or fragment
     * @return pixel scale factor
     */
    private static float getPixelScaleFactor(final Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT;
    }


    /**
     * Method to convert dp into pixel
     *
     * @param context of calling activity or fragment
     * @param dp      dp value that need to convert into px
     * @return px converted dp into px
     */
    public static int dpToPx(final Context context, final int dp) {
        int px = Math.round(dp * getPixelScaleFactor(context));
        return px;
    }

    /**
     * Method to convert pixel into dp
     *
     * @param context of calling activity or fragment
     * @param px      pixel value that need to convert into dp
     * @return dp converted px into dp
     */
    public static int pxToDp(final Context context, final int px) {
        int dp = Math.round(px / getPixelScaleFactor(context));
        return dp;
    }

    /**
     * @param context of calling activity or fragment
     * @return app version
     */
    public static String getAppVersion(final Context context) {
        int versionCode = 0;
        try {
            versionCode = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("version errr", "" + e.getLocalizedMessage());
        }
        return String.valueOf(versionCode);
    }

    /**
     * @param activity context
     */
    public static void hideSoftKeyboard(final Activity activity) {

        View focusedView = activity.getCurrentFocus();
        if (focusedView == null) {
            return;
        }

        IBinder windowToken = focusedView.getWindowToken();
        if (windowToken == null) {
            return;
        }

        InputMethodManager inputMethodManager = (InputMethodManager) activity
                .getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
    }

    /**
     * @param bitmapImage to store in internal storage
     * @param context     of fragment or activity
     * @return path of image
     */
    public static String saveToInternalStorage(final Bitmap bitmapImage, final Context context) {
        ContextWrapper cw = new ContextWrapper(context);
        // path to /data/data/yourapp/app_data/imageDir
        String name = context.getResources().getString(R.string.app_name);
        //Folder name in device android/data/
        File directory = cw.getDir(name, Context.MODE_PRIVATE);
        // Create imageDir
        File mypath = new File(directory, "dummy.png");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, QUALITY, fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        android.util.Log.d("Path", mypath.getAbsolutePath() + "");
        return mypath.getAbsolutePath();
    }


    public static String getStringFromEditText(EditText editText) {

        if (editText != null) {
            return editText.getText().toString();
        } else {
            return "";
        }
    }


}
