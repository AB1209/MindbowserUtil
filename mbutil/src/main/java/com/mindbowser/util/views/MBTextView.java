package com.mindbowser.util.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.mindbowser.util.R;

/**
 * Extension of TextView which has customFont attribute, by which we can set the
 * custom fonts.
 *
 * @author MindBowser
 */
public class MBTextView extends TextView {
    private static final String TAG = "MBTextView";

    public MBTextView(Context context) {
        super(context);
    }

    public MBTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomTextFont(context, attrs);
    }

    public MBTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomTextFont(context, attrs);
    }

    private void setCustomTextFont(Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.MBButton);
        String customFont = a.getString(R.styleable.MBButton_customFont);
        setCustomTextFont(ctx, customFont);
        a.recycle();
    }

    public boolean setCustomTextFont(Context ctx, String asset) {
        Typeface tf = null;
        String fullPath = "fonts/" + asset;
        try {
            tf = Typeface.createFromAsset(ctx.getAssets(), fullPath);
        } catch (Exception e) {
            Log.e(TAG, "Could not get Text typeface: " + e.getMessage(), e);
            return false;
        }
        fullPath = null;
        setTypeface(tf);
        return true;
    }

}
