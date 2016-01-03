package com.cts.sample.tddbdddemo.newsstand;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;

public class MyViewPager extends ViewPager {
    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
//        System.out.println(scrollX+"::"+scrollY);
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
    }
}
