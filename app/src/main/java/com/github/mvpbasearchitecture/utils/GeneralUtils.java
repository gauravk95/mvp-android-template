package com.github.mvpbasearchitecture.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.signature.StringSignature;
import com.github.mvpbasearchitecture.R;

/**
 * Utilities for other general stuffs
 *
 * Created by gk
 */

public final class GeneralUtils {

    public static boolean checkStringNotEmpty(String str) {
        return (str != null && !str.equals(""));
    }

    public static void loadImageFromLink(Context context, ImageView pic, String link) {
        if (GeneralUtils.checkStringNotEmpty(link)) {
            Glide.with(context.getApplicationContext())
                    .load(link)
                    .signature(new StringSignature(link))
                    .dontAnimate()
                    .placeholder(R.drawable.ic_image)
                    .into(pic);
        }
    }

}
