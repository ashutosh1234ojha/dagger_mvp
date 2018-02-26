package com.mymvpproject.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.mymvpproject.R;


/**
 * Created by cl-mac-mini-3 on 1/4/17.
 */

public final class SingleBtnDialog {

    private Dialog dialog;

    /**
     * @param context of the activity or fragment
     */
    private SingleBtnDialog(final Context context) {
        if (dialog != null) {
            dialog.dismiss();
        }
        // custom dialog
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.custom_single_btn_layout);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        Button btnOk = (Button) dialog.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                dialog.dismiss();
            }
        });
    }

    /**
     * @param context of activity or fragment
     * @return new object
     */
    public static SingleBtnDialog with(final Context context) {
        return new SingleBtnDialog(context);
    }

    /**
     * @param msg to show
     * @return context
     */
    public SingleBtnDialog setMessage(final String msg) {
        if (dialog != null) {
            TextView tvMessage = (TextView) dialog.findViewById(R.id.tv_message);
            tvMessage.setText(msg);
        }
        return this;
    }

    /**
     * @param bool to show cancel button or not
     * @return context
     */
    public SingleBtnDialog setCancelable(final boolean bool) {
        if (dialog != null) {
            dialog.setCancelable(false);
        }
        return this;
    }

    /**
     * @param bool to show cancel button or not
     * @return context
     */
    public SingleBtnDialog setCancelableOnTouchOutside(final boolean bool) {
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
        return this;
    }

    /**
     * @param heading to show
     * @return context
     */
    public SingleBtnDialog setHeading(final String heading) {
        if (dialog != null) {
            TextView tvMessage = (TextView) dialog.findViewById(R.id.tv_heading);
            tvMessage.setText(heading);
            tvMessage.setVisibility(View.VISIBLE);
        }
        return this;
    }

    /**
     * @param optionPositive msg
     * @return object of the SingleBtnDialog
     */
    public SingleBtnDialog setOptionPositive(final String optionPositive) {
        if (dialog != null) {
            Button btnOk = (Button) dialog.findViewById(R.id.btn_ok);
            btnOk.setText(optionPositive);
            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    dialog.dismiss();
                }
            });
        }
        return this;
    }

    /**
     * @param onActionPerformed object
     * @return object of the SingleBtnDialog
     */
    public SingleBtnDialog setCallback(final OnActionPerformed onActionPerformed) {
        if (dialog != null && onActionPerformed != null) {
            Button btnOk = (Button) dialog.findViewById(R.id.btn_ok);
            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    dialog.dismiss();
                    onActionPerformed.positive();
                }
            });
        }
        return this;
    }

    /**
     * To show alert dialog
     */
    public void show() {
        if (dialog != null) {
            dialog.show();
        }
    }

    /**
     * Interface
     */
    public interface OnActionPerformed {
        /**
         * positive listener
         */
        void positive();


    }

}
