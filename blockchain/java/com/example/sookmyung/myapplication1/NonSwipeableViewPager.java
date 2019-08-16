package com.example.sookmyung.myapplication1;


import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NonSwipeableViewPager extends ViewPager {

    private boolean enabled;

    public NonSwipeableViewPager( Context context) {
        super(context);
    }


    public NonSwipeableViewPager( Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        // 스와이핑되서 페이지가 바뀌는것을 막는다.

            return false;
        }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //스와이핑되서 페이가 바뀌는 것을 막는다.

            return false;


    }



}
