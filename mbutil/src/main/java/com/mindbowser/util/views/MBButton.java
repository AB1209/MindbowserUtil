package com.mindbowser.util.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

import com.mindbowser.util.R;


/**
 * Extension of Button which has customFont attribute, by which we can set the custom fonts to button.
 *
 * @author MindBowser
 */
public class MBButton extends Button {
    private static final String TAG = "MBButton";

    public MBButton(Context context) {
        super(context);
    }

    public MBButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomButtonFont(context, attrs);
    }

    public MBButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomButtonFont(context, attrs);
    }

    private void setCustomButtonFont(Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.MBButton);
        String customFont = a.getString(R.styleable.MBButton_customFont);
        setCustomButtonFont(ctx, customFont);
        a.recycle();
    }

    public boolean setCustomButtonFont(Context ctx, String asset) {
        Typeface tfBtn = null;
        String fullPathBtn = "fonts/" + asset;
        try {
            tfBtn = Typeface.createFromAsset(ctx.getAssets(), fullPathBtn);
        } catch (Exception e) {
            Log.i(TAG, "Could not get Button typeface: " + e.getMessage(), e);
            return false;
        }
        fullPathBtn = null;
        setTypeface(tfBtn);
        return true;
    }

}
