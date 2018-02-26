package com.mymvpproject.requestcause;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mymvpproject.R;
import com.mymvpproject.callback.PreferenceCallback;
import com.mymvpproject.modal.SignUpData;
import com.mymvpproject.modal.preference.PreferenceData;
import com.mymvpproject.otp.OtpActivity;
import com.mymvpproject.util.CustomAlertDialog;
import com.mymvpproject.util.ProgressDialog;

import java.util.List;

/**
 * Created by Ashutosh Ojha on 10/30/17.
 */

public class RequestCauseActivity extends AppCompatActivity implements RequestCauseView, View.OnClickListener, PreferenceCallback {

    private RecyclerView rvCauses;
    private RequestAdapter requestAdapter;
    private LinearLayoutManager layoutManager;
    private RequestCausePresenter requestCausePresenter;
    private TextView tv_back, tv_heading;
    private List<String> preferenceNameList, preferenceIdList;
    private Button btnSignUp;
    private SignUpData signUpData;


    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_cause);

        init();

        requestCausePresenter.getDataFromRequestApi();


    }

    private void init() {
        tv_back = (TextView) findViewById(R.id.tv_Back);
        tv_heading = (TextView) findViewById(R.id.tv_heading);
        rvCauses = (RecyclerView) findViewById(R.id.rvCauses);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        layoutManager = new LinearLayoutManager(getApplicationContext());

        requestCausePresenter = new RequestCausePresenterImpl(this);
        requestAdapter = new RequestAdapter(this);

        rvCauses.setAdapter(requestAdapter);
        rvCauses.setLayoutManager(layoutManager);

        tv_back.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
        tv_heading.setText("Preference");

//        tv_back.setText("<----");
    }

    @Override
    public void notifyAdapter(PreferenceData preferenceData) {

        Log.d("Tag", preferenceData.getReqCausePref().size() + " size");
        requestAdapter.setData(preferenceData.getReqCausePref());
    }

    @Override
    public void showProgress() {
        ProgressDialog.showProgressDialog(this);
    }

    @Override
    public void hideProgress() {

        ProgressDialog.dismissProgressDialog();
    }

    @Override
    public void showApiError(final String msg) {
        new CustomAlertDialog.Builder(this)
                .setMessage(msg)
                .setPositiveButton(R.string.text_ok, null)
                .show();
    }


    @Override
    public void successfulRegister() {

        startActivity(new Intent(this, OtpActivity.class));
    }

    @Override
    public void onClick(final View view) {
        switch (view.getId()) {
            case R.id.tv_Back:
                finish();
                break;

            case R.id.btnSignUp:

                signUpData = getIntent().getParcelableExtra("signupdata");

                if(signUpData!=null)
                {
                    signUpData.setPreferenceNameList(preferenceNameList);
                    signUpData.setPreferenceIdList(preferenceIdList);
                    requestCausePresenter.signUpData(signUpData);
                }else {
                    Toast.makeText(this, "sign up data null", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }


    @Override
    public void setPreference(final List<String> preferenceName, final List<String> preferenceId, final int position) {

        if (preferenceNameList != null) {
            preferenceNameList.clear();
        }

        if (preferenceIdList != null) {
            preferenceIdList.clear();
        }
        this.preferenceNameList = preferenceName;
        this.preferenceIdList = preferenceId;

        Log.d("Tag", preferenceNameList.size() + " size");
        Log.d("Tag", preferenceIdList.size() + " size");
    }
}
