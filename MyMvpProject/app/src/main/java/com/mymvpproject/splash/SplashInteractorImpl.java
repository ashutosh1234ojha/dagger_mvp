package com.mymvpproject.splash;

import android.os.Handler;
import android.util.Log;

/**
 * Created by cl-macmini-86 on 10/12/17.
 */

public class SplashInteractorImpl implements SplashIntractor {
    @Override
    public void passReference(final Wait wait) {


        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                Log.d("Tag","onWaitFinished");
               wait.onWaitFinished();
            }
        }, 2000);
    }
}
