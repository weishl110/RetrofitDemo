package com.wei.retrofitdemo;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * Created by ${wei} on 2016/11/18.
 */

public class AFragment extends Fragment {

    private ViewPager view_pager;
    private ArrayList<BannerADBean> list;
    private ArrayList<ImageView> views;
    private ImageView iv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       /* View view = inflater.inflate(R.layout.fragment_viewpager, null);
        view_pager = (ViewPager) view.findViewById(R.id.view_pager);*/
        iv = new ImageView(getActivity());
        ViewPager.LayoutParams params = new ViewPager.LayoutParams();
        params.height = ViewPager.LayoutParams.MATCH_PARENT;
        params.width = ViewPager.LayoutParams.WRAP_CONTENT;
        iv.setLayoutParams(params);
        iv.setPadding(20, 0, 20, 0);
        iv.requestLayout();
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        return iv;
    }

    private static final String TAG = "zpy_AFragment";
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated: ");
        Picasso.with(getActivity()).load("http://10.0.150.26:7070/xire_store/XIRE_FILES/XiReApp/banner/1478858045754.jpg").into(iv);
//        initView();
        /*view_pager.setOffscreenPageLimit(2);
        view_pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                view_pager.invalidate();
            }

            @Override
            public void onPageSelected(int position) {
                view_pager.postInvalidate();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                view_pager.postInvalidate();
            }
        });*/
//        initBannerData();

    }

    private void initView() {
        views = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ImageView iv = new ImageView(getActivity());
            ViewPager.LayoutParams params = new ViewPager.LayoutParams();
            params.height = ViewPager.LayoutParams.MATCH_PARENT;
            params.width = ViewPager.LayoutParams.WRAP_CONTENT;
            iv.setLayoutParams(params);
            iv.setPadding(20, 0, 20, 0);
            iv.requestLayout();
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            views.add(iv);
        }
    }

    private void initBannerData() {
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            BannerADBean bannerADBean = new BannerADBean();
            bannerADBean.setActiveUrl("http://10.0.140.39:8080/hero-rank.html");
            bannerADBean.setBannerId("20161101174409");
            bannerADBean.setBannerImgUrl("http://10.0.150.26:7070/xire_store/XIRE_FILES/XiReApp/banner/1478858045754.jpg");
            bannerADBean.setBannerName("月榜单");
            bannerADBean.setDate("2016-11-01 00:00:00");
            list.add(bannerADBean);
        }

        initBanner(list);
    }

    /**
     * 初始化底部banner
     */
    private void initBanner(List<BannerADBean> response) {
        view_pager.setAdapter(new MyAdapter());
        if (response.size() > 1) {
            view_pager.setCurrentItem(500);//设置开始显示中间的图片
            mHandler.removeMessages(6);
            mHandler.sendEmptyMessage(6);
        }
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            view_pager.setCurrentItem(view_pager.getCurrentItem() + 1);
            sendEmptyMessageDelayed(6, 2000);
        }
    };

    private class MyAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return list.size() > 1 ? 1000 : list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            if (list.size() > 0) {
                position = position % list.size();
            }
            ImageView iv = views.get(position);
            Picasso.with(getActivity()).load(list.get(position).getBannerImgUrl()).into(iv);
            container.addView(iv);
            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView(views.get(position > 1 ? position % list.size() : position));
//            container.removeView((View) object);
        }
    }

}
