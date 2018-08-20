package com.github.mvpbasearchitecture.utils.font;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.github.mvpbasearchitecture.R;

/**
 * Created by gk
 */

public class CustomFontHelper {

    /**
     * Sets a font on a textview based on the custom com.my.package:typeface attribute
     * If the custom font attribute isn't found in the attributes nothing happens
     * @param textview
     * @param context
     * @param attrs
     */
    public static void setCustomFont(TextView textview, Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomFont);
        String font = a.getString(R.styleable.CustomFont_typeface);
        setCustomFont(textview, font, context);
        a.recycle();
    }

    /**
     * Sets a font on a textview
     * @param textview
     * @param font
     * @param context
     */
    public static void setCustomFont(TextView textview, String font, Context context) {
        if(font == null) {
            font = "fonts/OpenSans-Light.ttf";
        }
        Typeface tf = FontCache.get(font, context);
        if(tf != null) {
            textview.setTypeface(tf);
        }
    }

}
