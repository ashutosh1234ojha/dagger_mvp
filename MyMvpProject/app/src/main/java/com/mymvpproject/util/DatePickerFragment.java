package com.mymvpproject.util;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Date picker fragment
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private static long mMinDate = 0L, mMaxDate = 0L;
    private static final int MAX_DAY = 14, HOUR_IN_DAY = 24, MIN_IN_HOUR = 60, SEC_IN_HOUR = 60;
    private static final long MILLI_IN_SEC = 1000L;
    private DatePickerDialog.OnDateSetListener listener;


    /**
     * @param listener of the date pidker
     * @return fragment
     */
    public static DatePickerFragment newInstance(final DatePickerDialog.OnDateSetListener listener) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.listener = listener;
        return fragment;
    }

    /**
     * @param maxDate  to set in picker
     * @param listener of the date picker
     * @return fragment
     */
    public static DatePickerFragment newInstance(final long maxDate, final DatePickerDialog.OnDateSetListener listener) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.listener = listener;
        mMaxDate = maxDate;
        mMinDate = 0L;
        return fragment;
    }

    /**
     * @param minDate  to set in picker
     * @param listener of the date picker
     * @return fragment
     */
    public static DatePickerFragment newInstanceMin(final long minDate, final DatePickerDialog.OnDateSetListener listener) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.listener = listener;
        mMinDate = minDate;
        mMaxDate = 0L;
        return fragment;
    }


    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

//        long maxDate = MAX_DAY * HOUR_IN_DAY * MIN_IN_HOUR * SEC_IN_HOUR * MILLI_IN_SEC;

        DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, day);

//        dialog.getDatePicker().setMinDate(mMinDate);
        if (mMaxDate != 0L) {
            dialog.getDatePicker().setMaxDate(mMaxDate);
        }

        if (mMinDate != 0L) {
            dialog.getDatePicker().setMinDate(mMinDate);
        }
        return dialog;

        // Create a new instance of DatePickerDialog and return it
        //return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    /**
     * @param view  date picker
     * @param year  selected
     * @param month selected
     * @param day   selected
     */
    public void onDateSet(final DatePicker view, final int year, final int month, final int day) {
        // Do something with the date chosen by the user
        listener.onDateSet(view, year, month, day);
    }
}