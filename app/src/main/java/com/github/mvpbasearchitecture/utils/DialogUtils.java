package com.github.mvpbasearchitecture.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.github.mvpbasearchitecture.R;

/**
 * Created by gk.
 */

public class DialogUtils {

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
