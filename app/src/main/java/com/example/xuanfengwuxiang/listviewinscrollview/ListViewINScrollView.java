package com.example.xuanfengwuxiang.listviewinscrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

import java.util.List;

/**
 * Created by xuanfengwuxiang on 2016/10/14.
 */
public class ListViewINScrollView extends ListView {

    public ListViewINScrollView(Context context) {
        super(context);
    }

    public ListViewINScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListViewINScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,

                MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
