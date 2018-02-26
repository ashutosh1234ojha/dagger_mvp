package com.mymvpproject.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mymvpproject.R;
import com.mymvpproject.login.LoginActivity;
import com.mymvpproject.util.ProgressDialog;

/**
 * Created by cl-macmini-86 on 10/12/17.
 */

public class SplashActivity extends AppCompatActivity implements SplashView {
    private SplashPresenterImpl splashPresenter;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        ((MyApplication)getApplication()).getAppComponent().inject(this);
        init();
    }

    private void init() {
        splashPresenter = new SplashPresenterImpl(this);
        splashPresenter.performCheck();
    }

    @Override
    public void startNewActivity() {
        Log.d("Tag","MoveOnCalled");
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void showProgress() {

        ProgressDialog.showProgressDialog(this);

    }

    @Override
    public void dismissProgress() {
        ProgressDialog.dismissProgressDialog();
    }
}
