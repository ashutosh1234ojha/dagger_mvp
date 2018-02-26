package com.mymvpproject.home.landing;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mymvpproject.R;

/**
 * Created by cl-macmini-86 on 10/14/17.
 */

public class LandingFragment extends Fragment implements View.OnClickListener, LandingView {

    private EditText etFirstDigit, etSecondDigit;
    private Button btnOperation;
    private Activity activity;
    private LandingPresenter ladingPresenter;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_landing, container, false);

        init(view);
        return view;
    }

    private void init(View view) {
        etFirstDigit = (EditText) view.findViewById(R.id.etFirstDigit);
        etSecondDigit = (EditText) view.findViewById(R.id.etSecondDigit);
        btnOperation = (Button) view.findViewById(R.id.btnOperation);

        ladingPresenter=new LandingPresenterImpl(this);

        btnOperation.setOnClickListener(this);
    }

    @Override
    public void onClick(final View view) {
        switch (view.getId()) {
            case R.id.btnOperation:
                ladingPresenter.inputDigit(etFirstDigit.getText().toString(),etSecondDigit.getText().toString());
                break;
        }
    }

    @Override
    public void showFirstDigitError(String error) {
        etFirstDigit.setError(error);
    }

    @Override
    public void showSecondDigitError(String error) {
        etSecondDigit.setError(error);
    }

    @Override
    public void showSuccess(String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailure(final String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }
}
