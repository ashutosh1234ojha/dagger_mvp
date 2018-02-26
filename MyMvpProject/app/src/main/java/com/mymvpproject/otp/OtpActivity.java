package com.mymvpproject.otp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mymvpproject.R;
import com.mymvpproject.home.HomeActivity;
import com.mymvpproject.util.CustomAlertDialog;
import com.mymvpproject.util.ProgressDialog;
import com.mymvpproject.util.Util;

/**
 * Created by cl-macmini-86 on 10/13/17.
 */

public class OtpActivity extends AppCompatActivity implements View.OnClickListener, OtpView {
    private EditText etOtpOne, etOtpTwo, etOtpThree, etOtpFour;
    private Button btnOtp;
    private OtpPresenter otpPresenter;


    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp_activity);

        init();
    }

    private void init() {

        etOtpOne = (EditText) findViewById(R.id.etOtpOne);
        etOtpTwo = (EditText) findViewById(R.id.etOtpTwo);
        etOtpThree = (EditText) findViewById(R.id.etOtpThree);
        etOtpFour = (EditText) findViewById(R.id.etOtpFour);
        btnOtp = (Button) findViewById(R.id.btnOtp);

        btnOtp.setOnClickListener(this);

        otpPresenter = new OtpPresenterImpl(this);
    }

    @Override
    public void onClick(final View view) {
        switch (view.getId()) {
            case R.id.btnOtp:
                String otp = Util.getStringFromEditText(etOtpOne) + Util.getStringFromEditText(etOtpTwo) +
                        Util.getStringFromEditText(etOtpThree) + Util.getStringFromEditText(etOtpFour);
                otpPresenter.checkValidations(otp);
                break;


        }
    }


    @Override
    public void otpError(final String msg) {
        showErrorMsg(msg);
    }

    @Override
    public void otpFailedError(final String failureMsg) {
        showErrorMsg(failureMsg);
    }

    void showErrorMsg(String failureMsg) {
        new CustomAlertDialog.Builder(this)
                .setMessage(failureMsg)
                .setPositiveButton(R.string.text_ok, null)
                .show();
    }

    @Override
    public void navigateToHome() {
        Log.d("Tag", "MoveOnCalled");
        startActivity(new Intent(this, HomeActivity.class));
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
