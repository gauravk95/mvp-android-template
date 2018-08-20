package com.github.mvpbasearchitecture.ui.custom;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.github.mvpbasearchitecture.utils.font.CustomFontHelper;

public class CustomTextView extends AppCompatTextView {

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }
}
