package com.example.xuanfengwuxiang.listviewinscrollview.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.xuanfengwuxiang.listviewinscrollview.R;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class RightFragment extends Fragment {
    @InjectView(R.id.iv)
    ImageView mIv;
    private int mWidth;
    private int mHeight;
    private float mEndX;
    private float mEndY;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_right, null);
        ButterKnife.inject(this, view);
        initView();
        return view;
    }

    private void initView() {
        String url = "http://media.51jhle.com/upload/img/20160615/201606151220125591.jpg";
        Picasso.with(getActivity()).load(url).into(mIv);

    }

    @Override
    public void onResume() {
        Display display = getActivity().getWindowManager().getDefaultDisplay();

        int w = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        int rbw = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        int rbh = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        mIv.measure(w, h);
        mHeight = mIv.getMeasuredHeight();
        mWidth = mIv.getMeasuredWidth();
        System.out.println(mWidth+"..."+mHeight);
        mEndX = display.getWidth()-mWidth;
        mEndY = display.getHeight()-mHeight-350;
        TranslateAnimation translateAnimation = new TranslateAnimation(0f, mEndX,0f, mEndY);
        translateAnimation.setDuration(2000);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        translateAnimation.setRepeatCount(Animation.INFINITE);

        RotateAnimation rotateAnimation = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(2000);
        rotateAnimation.setRepeatMode(Animation.REVERSE);
        rotateAnimation.setRepeatCount(Animation.INFINITE);

        ScaleAnimation scaleAnimation = new ScaleAnimation(0.2f, 1.5f, 0.2f, 1.5f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
        scaleAnimation.setDuration(2000);// 动画执行的时间
        scaleAnimation.setRepeatCount(Animation.INFINITE); //设置动画执行重复次数
        scaleAnimation.setRepeatMode(Animation.REVERSE); //设置动画的模式

        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(2000);// 动画执行的时间
        alphaAnimation.setRepeatCount(Animation.INFINITE); //设置动画执行重复次数
        alphaAnimation.setRepeatMode(Animation.REVERSE); //设置动画的模式

        AnimationSet set = new AnimationSet(false);
        set.addAnimation(scaleAnimation);
        set.addAnimation(alphaAnimation);
        set.addAnimation(translateAnimation);
       // set.addAnimation(rotateAnimation);

        set.setDuration(2000);
        set.setRepeatMode(AnimationSet.REVERSE);
        set.setRepeatCount(AnimationSet.INFINITE);
        //mIv.setAnimation(set);
        //set.startNow();
        mIv.startAnimation(set);

        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
