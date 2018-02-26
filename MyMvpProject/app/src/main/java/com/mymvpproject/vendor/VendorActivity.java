package com.mymvpproject.vendor;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import com.mymvpproject.R;

/**
 * Created by Ashutosh Ojha on 2/22/18.
 */

public class VendorActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView tvSeekBarValue;
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_vendor);

        seekBar=findViewById(R.id.seekBar);
        tvSeekBarValue=findViewById(R.id.tvSeekBarValue);


//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(final SeekBar seekBar, final int i, final boolean b) {
//
//            }
//
//            @Override
//            public void onStartTrackingTouch(final SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(final SeekBar seekBar) {
//
//            }
//        });


        seekBar.getProgressDrawable().setColorFilter(getColor(R.color.gradient_start), PorterDuff.Mode.SRC_ATOP);
        seekBar.setProgress(10);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int a = Color.alpha(getColor(R.color.gradient_start));
                int r = Color.red(getColor(R.color.gradient_start));
                int g = Color.green(getColor(R.color.gradient_start));
                int b = Color.blue(getColor(R.color.gradient_start));
                int rr = (progress*r)/100;
                int gg = (progress*g)/100;
                int bb = (progress*b)/100;
//                seekBar.set(ColorStateList.valueOf(Color.argb(a, rr, gg, bb)));
                seekBar.getProgressDrawable().setColorFilter(Color.rgb( rr, gg, bb), PorterDuff.Mode.SRC_ATOP);

                tvSeekBarValue.setText("Value"+progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
