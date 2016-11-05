package com.example.xuanfengwuxiang.listviewinscrollview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Created by xuanfengwuxiang on 2016/10/14.
 */
public class ViewPagerINScrollView extends ViewPager{
    public ViewPagerINScrollView(Context context) {
        super(context);
    }

    public ViewPagerINScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,

                MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
