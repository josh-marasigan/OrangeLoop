package com.threeamstudios.theorangeloop;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by Josh M on 12/19/2015.
 */
public class MyCustomButton extends Button {

    public MyCustomButton(Context context, AttributeSet attrs) {

        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Quicksand-Regular.otf"));

    }
}
