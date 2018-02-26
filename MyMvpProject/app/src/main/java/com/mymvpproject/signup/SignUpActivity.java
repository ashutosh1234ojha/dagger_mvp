package com.mymvpproject.signup;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.mymvpproject.R;
import com.mymvpproject.modal.SignUpData;
import com.mymvpproject.requestcause.RequestCauseActivity;
import com.mymvpproject.util.DatePickerFragment;
import com.mymvpproject.util.ProgressDialog;

import java.util.Calendar;

import static com.mymvpproject.util.Util.getStringFromEditText;

/**
 * Created by Ashutosh Ojha on 10/27/17.
 */

public class SignUpActivity extends AppCompatActivity implements SignUpView, View.OnClickListener {

    private EditText etFirstName, etLastName, etEmail, etPhone, etAddress, etDateOfBirth, etPassword, etConfirmPassword;
    private SignUpPresenter signUpPresenter;
    private Button btnNext;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        init();

        signUpPresenter = new SignUpPresenterImpl(this);


    }


    private void init() {
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etAddress = (EditText) findViewById(R.id.etAddress);
        etDateOfBirth = (EditText) findViewById(R.id.etDateOfBirth);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);

        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);
        etDateOfBirth.setOnClickListener(this);
    }

    @Override
    public void fNameError(final String msg) {
        etFirstName.setError(msg);
    }

    @Override
    public void lNameError(final String msg) {
        etLastName.setError(msg);
    }

    @Override
    public void emailError(final String msg) {
        etEmail.setError(msg);
    }

    @Override
    public void phoneError(final String msg) {
        etPhone.setError(msg);
    }

    @Override
    public void addressError(final String msg) {
        etAddress.setError(msg);
    }

    @Override
    public void dobError(final String msg) {
        etDateOfBirth.setError(msg);
    }

    @Override
    public void passwordError(final String msg) {
        etPassword.setError(msg);
    }

    @Override
    public void passwordConfirmError(final String msg) {
        etConfirmPassword.setError(msg);
    }

    @Override
    public void signUpFailed(final String failureMsg) {

    }

    @Override
    public void navigateToOtp() {

        SignUpData signUpData = new SignUpData();
        signUpData.setfName(getStringFromEditText(etFirstName));
        signUpData.setlName(getStringFromEditText(etLastName));
        signUpData.setEmail(getStringFromEditText(etEmail));
        signUpData.setPhone(getStringFromEditText(etPhone));
        signUpData.setAddress(getStringFromEditText(etAddress));
        signUpData.setDateOfBirth(getStringFromEditText(etDateOfBirth));
        signUpData.setPassword(getStringFromEditText(etPassword));

        Intent requestCauseIntent = new Intent(this, RequestCauseActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("signupdata", signUpData);
        requestCauseIntent.putExtras(bundle);
        startActivityForResult(requestCauseIntent, 100);
    }

    @Override
    public void showProgress() {

        ProgressDialog.showProgressDialog(this);
    }

    @Override
    public void dismissProgress() {

        ProgressDialog.dismissProgressDialog();
    }

    /**
     * This method sets dob of user
     */
    private void setDob() {
        DatePickerFragment.newInstanceMin(Calendar.getInstance().getTimeInMillis(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(final DatePicker view, final int year, final int monthOfYear, final int dayOfMonth) {


                etDateOfBirth.setText(dayOfMonth + "/" + monthOfYear + "/" + year);

            }
        }).show(getSupportFragmentManager(), "Select dob");
    }


    @Override
    public void onClick(final View view) {
        switch (view.getId()) {
            case R.id.btnNext:

                signUpPresenter.validateRegisterInfo(getStringFromEditText(etFirstName)
                        , getStringFromEditText(etLastName), getStringFromEditText(etEmail)
                        , getStringFromEditText(etPhone), getStringFromEditText(etAddress), getStringFromEditText(etDateOfBirth)
                        , getStringFromEditText(etPassword), getStringFromEditText(etConfirmPassword)
                );

                break;

            case R.id.etDateOfBirth:
                setDob();
                break;
        }
    }
}
