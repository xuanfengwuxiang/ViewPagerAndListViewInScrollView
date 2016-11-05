package com.example.xuanfengwuxiang.listviewinscrollview;

import android.support.v4.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.xuanfengwuxiang.listviewinscrollview.fragment.CenterFragment;
import com.example.xuanfengwuxiang.listviewinscrollview.fragment.LeftFragment;
import com.example.xuanfengwuxiang.listviewinscrollview.fragment.RightFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.rb_left)
    RadioButton mRbLeft;
    @InjectView(R.id.rb_center)
    RadioButton mRbCenter;
    @InjectView(R.id.rb_right)
    RadioButton mRbRight;
    @InjectView(R.id.rg)
    RadioGroup mRg;
    @InjectView(R.id.ll_containnar)
    LinearLayout mLlContainnar;
    @InjectView(R.id.vp_banner)
    ViewPager mVpBanner;
    private FragmentTransaction mTransaction;
    private LeftFragment mLeftFragment;
    private CenterFragment mCenterFragment;
    private List<Fragment> mList;
    private RightFragment mRightFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        mList = new ArrayList<>();
        mLeftFragment = new LeftFragment();
        mCenterFragment = new CenterFragment();
        mRightFragment = new RightFragment();
        mList.add(mLeftFragment);
        mList.add(mCenterFragment);
        mList.add(mRightFragment);
        FragmentManager manager = getSupportFragmentManager();

        mVpBanner.setAdapter(new ViewPagerAdapter(manager));
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_left:
                        mVpBanner.setCurrentItem(0);
                        break;
                    case R.id.rb_center:
                        mVpBanner.setCurrentItem(1);
                        break;
                    case R.id.rb_right:
                        mVpBanner.setCurrentItem(2);
                        break;

                }
            }
        });


    }


    private class ViewPagerAdapter extends FragmentPagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mList.size();
        }


        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }


    }
}
