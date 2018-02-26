package com.mymvpproject.splash;

/**
 * Created by cl-macmini-86 on 10/12/17.
 */

public interface SplashIntractor {

     interface Wait {
        void onWaitFinished();
    }

    void passReference( Wait wait);
}
