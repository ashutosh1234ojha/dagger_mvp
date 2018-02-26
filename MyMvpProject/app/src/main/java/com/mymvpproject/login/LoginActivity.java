package com.mymvpproject.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mymvpproject.MyApplication;
import com.mymvpproject.R;
import com.mymvpproject.home.HomeActivity;
import com.mymvpproject.otp.OtpActivity;
import com.mymvpproject.signup.SignUpActivity;
import com.mymvpproject.util.CustomAlertDialog;
import com.mymvpproject.util.ProgressDialog;

import javax.inject.Inject;

/**
 * Created by cl-macmini-86 on 10/13/17.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {
    private EditText etEmail, etPassword;
    private Button btnLogin, btnSignUp;
    @Inject
     LoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ((MyApplication)getApplication()).getAppComponent().inject(this);
        init();

    }

    private void init() {

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        btnLogin.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);


//        loginPresenter = new LoginPresenterImpl( this);

        loginPresenter.setView(this);
    }

    @Override
    public void onClick(final View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                loginPresenter.checkValidations(etEmail.getText().toString(), etPassword.getText().toString());
                break;

            case R.id.btnSignUp:
                startActivityForResult(new Intent(this, SignUpActivity.class), 100);
                break;
        }
    }

    @Override
    public void emailError(String emailErrorMsg) {
        etEmail.setError(emailErrorMsg);
    }

    @Override
    public void passwordError(String passwordErrorMsg) {

        etPassword.setError(passwordErrorMsg);
    }

    @Override
    public void loginFailed(final String failureMsg) {
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

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {

                case 100:
                    if (data != null) {
                        startActivityForResult(new Intent(this, OtpActivity.class), 101);
                    } else {
                        etEmail.setText("");
                        etPassword.setText("");
                    }

                case 101:
                    startActivity(new Intent(this, HomeActivity.class));
                    break;
            }
        }
    }

}
