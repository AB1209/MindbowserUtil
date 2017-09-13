package com.mindbowser.util.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

import com.mindbowser.util.R;


/**
 * Extension of EditText which has customFont attribute, by which we can set the custom fonts.
 *
 * @author MindBowser
 */
public class MBEditText extends EditText {

    private static final String TAG = "MBEditText";

    public MBEditText(Context context) {
        super(context);
    }

    public MBEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomEditFont(context, attrs);
    }

    public MBEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomEditFont(context, attrs);
    }

    private void setCustomEditFont(Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.MBButton);
        String customFont = a.getString(R.styleable.MBButton_customFont);
        setCustomEditFont(ctx, customFont);
        a.recycle();
    }

    public boolean setCustomEditFont(Context ctx, String asset) {
        Typeface tfEdit = null;
        String fullPathEdit = "fonts/" + asset;
        try {
            tfEdit = Typeface.createFromAsset(ctx.getAssets(), fullPathEdit);
        } catch (Exception e) {
            Log.i(TAG, "Could not get Edit typeface: " + e.getMessage(), e);
            return false;
        }
        fullPathEdit = null;
        setTypeface(tfEdit);
        return true;
    }
}
