package com.example.xuanfengwuxiang.listviewinscrollview.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.xuanfengwuxiang.listviewinscrollview.R;


import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class LeftFragment extends Fragment {

    @InjectView(R.id.lv)
    ListView mLv;
    @InjectView(R.id.sv)
    ScrollView mSv;
    @InjectView(R.id.vp_banner)
    ViewPager mVpBanner;
    @InjectView(R.id.bt_alarm)
    Button mBtAlarm;
    private List<String> mList;
    private int image[];
    public List<ImageView> imageList = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
    Bundle savedInstanceState) {
        View view = View.inflate(getActivity(),R.layout.fragment_left,null);
        ButterKnife.inject(this,view);

        image = new int[]{R.drawable.test1, R.drawable.test2, R.drawable.test3};
        mList = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            mList.add("我是你干爹" + i);
        }
        mLv.setAdapter(new ListViewAdapter());
        mSv.smoothScrollTo(0, 0);
        for (int i = 0; i < image.length; i++) {
            ImageView iv = new ImageView(getActivity());
            iv.setImageResource(image[i]);
            imageList.add(iv);
        }
        mVpBanner.setAdapter(new ViewPagerAdapter());
        mBtAlarm.setOnClickListener(new click());
        return view;
    }
    private class ListViewAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int i) {
            return mList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(getActivity(), R.layout.item_list, null);

            }
            TextView tv_item = (TextView) view.findViewById(R.id.tv_item);
            tv_item.setText(mList.get(i));
            return view;
        }
    }


    private class ViewPagerAdapter extends PagerAdapter {

        @Override
        public void destroyItem(View container, int position, Object object) {
            //((ViewPag.er)container).removeView((View)object);
            ((ViewPager) container).removeView(imageList.get(position));
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //ImageView imageView = imageList.get(position);

            //mImageLoader.displayImage(null,imageView);
            container.addView(imageList.get(position));
            return imageList.get(position);
        }

        public int getCount() {
            return image.length;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0 == arg1;
        }


    }



    private class click implements View.OnClickListener {
        public void onClick(View view) {
            String phone = "666";
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
