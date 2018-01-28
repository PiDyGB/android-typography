/*
 * Copyright (C) 2014 Giuseppe Buzzanca
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.github.pidygb.typography.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.github.pidygb.typography.R;
import com.github.pidygb.typography.graphics.Typefaces;
import com.github.pidygb.typography.text.method.TextViewTransformationMethod;

@SuppressWarnings("unused")
public class Button extends android.support.v7.widget.AppCompatButton {

    private float mScaleLetterSpacing = 0;
    private boolean mAllCaps;
    private String mTypeFaceName;

    public Button(Context context) {
        super(context);
    }

    public Button(Context context, AttributeSet attrs) {
        super(context, attrs);
        parseAttrs(context, attrs);
    }

    public Button(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        parseAttrs(context, attrs);
    }

    private void parseAttrs(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.Button, 0, 0);
        try {
            mScaleLetterSpacing = a.getFloat(
                    R.styleable.Button_scaleLetterSpacing, 0f);
            mAllCaps = a.getBoolean(R.styleable.Button_textUpperCase, false);
            mTypeFaceName = a.getString(R.styleable.Button_typeface);
        } finally {
            a.recycle();
        }
        setTypefaceName(context, mTypeFaceName);
        setTransformationMethod(new TextViewTransformationMethod(context,
                mAllCaps, mScaleLetterSpacing));
    }

    /**
     * Sets the properties of this field to transform input to ALL CAPS display.
     * This may use a "small caps" formatting if available. This setting will be
     * ignored if this field is editable or selectable.
     * <p/>
     * This call replaces the current transformation method. Disabling this will
     * not necessarily restore the previous behavior from before this was
     * enabled.
     *
     * @param allCaps android.R.styleable#TextView_textAllCaps
     * @see #setTransformationMethod(android.text.method.TransformationMethod)
     */
    public void setAllCaps(boolean allCaps) {
        mAllCaps = allCaps;
        setTransformationMethod(new TextViewTransformationMethod(getContext(),
                allCaps, mScaleLetterSpacing));
    }

    /**
     * Sets the text color, size, style, hint color, and highlight color from
     * the specified TextAppearance resource.
     */
    @Override
    public void setTextAppearance(Context context, int resId) {
        super.setTextAppearance(context, resId);

        TypedArray appearance = context.obtainStyledAttributes(resId,
                R.styleable.Button);

        boolean allCaps = appearance.getBoolean(
                R.styleable.Button_textUpperCase, false);

        float scaleLetterSpacing = appearance.getFloat(
                R.styleable.Button_scaleLetterSpacing, 0f);

        mTypeFaceName = appearance.getString(R.styleable.Button_typeface);

        setTypefaceName(context, mTypeFaceName);

        setTransformationMethod(new TextViewTransformationMethod(context,
                allCaps, scaleLetterSpacing));

        appearance.recycle();
    }

    /**
     * Set a custom font from the assets/fonts folder
     *
     * @param ctx  The {@link android.content.Context}
     * @param font A {@link String} that represent a filename in the assets/fonts
     *             folder
     */
    @SuppressWarnings("WeakerAccess")
    public void setTypefaceName(Context ctx, String font) {
        mTypeFaceName = font;
        if (mTypeFaceName != null) {
            setPaintFlags(this.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG
                    | Paint.LINEAR_TEXT_FLAG);
            Typeface tf = Typefaces.get(ctx, mTypeFaceName);
            if (tf != null)
                setTypeface(tf);

        }
    }

    /**
     * Return the font filename
     *
     * @return A {@link String} that represent the font filename
     */
    public String getTypefaceName() {
        return mTypeFaceName;
    }

    /**
     * Return the scale factor for the letter spacing
     *
     * @return A {@link float} that represent the scaling factor
     */
    public float getScaleLetterSpacing() {
        return mScaleLetterSpacing;
    }

    /**
     * Set a scale factor for the letter spacing
     *
     * @param scaleLetterSpacing A {@link float}
     */
    public void setScaleLetterSpacing(float scaleLetterSpacing) {
        setTransformationMethod(new TextViewTransformationMethod(getContext(),
                mAllCaps, scaleLetterSpacing));
    }
}
