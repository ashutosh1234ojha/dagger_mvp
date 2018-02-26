package com.mymvpproject.splash;

import android.util.Log;

/**
 * Created by cl-macmini-86 on 10/12/17.
 */

public class SplashPresenterImpl implements SplashPresenter, SplashIntractor.Wait {

    private SplashView splashView;
    private SplashIntractor splashIntractor;


    public SplashPresenterImpl(final SplashView splashView) {
        this.splashView = splashView;
        splashIntractor = new SplashInteractorImpl();
    }

    @Override
    public void performCheck() {
        splashIntractor.passReference(this);
        splashView.showProgress();
    }

    @Override
    public void onWaitFinished() {
        Log.d("Tag", "onWaitFinished");
        splashView.startNewActivity();
        splashView.dismissProgress();
    }
}
