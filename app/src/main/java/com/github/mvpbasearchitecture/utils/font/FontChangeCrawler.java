package com.github.mvpbasearchitecture.utils.font;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FontChangeCrawler
{
    private Typeface typeface;

    public FontChangeCrawler(Typeface typeface)
    {
        this.typeface = typeface;
    }

    public FontChangeCrawler(AssetManager assets, String assetsFontFileName)
    {
        typeface = TypefaceHelper.get(assets,assetsFontFileName);
    }

    public void replaceFonts(ViewGroup viewTree)
    {
        View child;
        for(int i = 0; i < viewTree.getChildCount(); ++i)
        {
            child = viewTree.getChildAt(i);
            if(child instanceof ViewGroup)
            {
                // recursive call
                replaceFonts((ViewGroup)child);
            }
            else if(child instanceof TextView)
            {
                // base case
                ((TextView) child).setTypeface(typeface);
            }
        }
    }
}