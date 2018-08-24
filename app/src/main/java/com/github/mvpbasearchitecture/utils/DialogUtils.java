package com.github.mvpbasearchitecture.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.github.mvpbasearchitecture.R;

/**
 * Utilities for Dialog related stuffs
 *
 * Note: This used the {@link ProgressDialog} that is Deprecated
 * Its advisable to use {@link android.app.DialogFragment} to Create your own
 * custom progress dialog
 *
 * Created by gk
 */

@SuppressWarnings("deprecation")
public final class DialogUtils {

    /**
     * Creates a Progress Dialog
     * @param context
     * @return
     */
    public static ProgressDialog createProgressDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }
}
