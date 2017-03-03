package com.wei.retrofitdemo;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;

import com.squareup.picasso.Picasso;
import com.wei.retrofitdemo.request.BaseInterceptor;
import com.wei.retrofitdemo.request.IRetrofitApi;
import com.wei.retrofitdemo.request.MyException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private static HashMap<String, String> headerMap = new HashMap<>();
    private final long READTIMEOUT = 15;
    private final long CONNECTTIMEOUT = 15;

    private static final String TAG = "zpy_MainActivity";
    private Context context;
    private ViewPager view_pager;
    private List<BannerADBean> list;
    private ScrollView scroll_view;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        scroll_view = (ScrollView) findViewById(R.id.scroll_view);
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        initBannerData();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(manager);
        setAdapter();

        mHandler.sendEmptyMessageDelayed(8, 2000);
    }

    private void setAdapter() {
        recyclerView.setAdapter(new RecyclerView.Adapter<MyViewHolder>() {
            @Override
            public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = View.inflate(MainActivity.this, R.layout.item_iv, null);
                return new MyViewHolder(view);
            }

            @Override
            public void onBindViewHolder(MyViewHolder holder, int position) {
                Picasso.with(MainActivity.this).load("http://10.0.150.26:7070/xire_store/XIRE_FILES/XiReApp/banner/1478858045754.jpg")
                        .into(holder.iv);
            }

            @Override
            public int getItemCount() {
                return 5;
            }
        });
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }

    private void http_request() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.retryOnConnectionFailure(true).addInterceptor(new BaseInterceptor(headerMap))
                .readTimeout(READTIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECTTIMEOUT, TimeUnit.SECONDS).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://103.235.228.70:5050/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient.build())
                .build();
        IRetrofitApi iRetrofitApi = retrofit.create(IRetrofitApi.class);

        iRetrofitApi.getQueryOneISM("16102719190502")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ISMRequestResult<ISMDetail>>() {
                    @Override
                    public void onCompleted() {
                        Log.e(TAG, "onCompleted:  = ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError:  = ");
                    }

                    @Override
                    public void onNext(ISMRequestResult<ISMDetail> result) {
                        Log.e(TAG, "onNext:  = ");
                        String status = result.getStatus();
                        if (!TextUtils.isEmpty(status) && status.equals("0")) {
                            ISMDetail data = result.getData();
                            Log.e(TAG, "onNext: ismName = " + data.getProName());
                        } else {
                            Log.e(TAG, "onNext: status = " + status);

                            String errorInfo = result.getErrorInfo();
                            String code = result.getCode();
                            MyException myException = new MyException(errorInfo, code);
                        }
                    }

                    @Override
                    public void onStart() {
                        super.onStart();
                        Log.e(TAG, "onStart:  = ");
                    }
                });
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
        view_pager.setCurrentItem(500);//设置开始显示中间的图片
        mHandler.removeMessages(6);
        mHandler.sendEmptyMessage(6);
        view_pager.setPageMargin(30);
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 6:
                    view_pager.setCurrentItem(view_pager.getCurrentItem() + 1);
                    sendEmptyMessageDelayed(6, 2000);
                    break;
                case 8:
//                    recyclerView.setNextFocusLeftId(3);
                    break;
            }
        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                http_request();
                break;
            default:
                break;
        }
    }

    private class MyAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return 1000;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            final ImageView iv = new ImageView(context);
            ViewPager.LayoutParams params = new ViewPager.LayoutParams();
            params.height = ViewPager.LayoutParams.MATCH_PARENT;
            params.width = ViewPager.LayoutParams.WRAP_CONTENT;
//        int padding = context.getResources().getDimensionPixelSize(R.dimen.value_20_px);
//        iv.setPadding(padding,0,padding,0);
            iv.setLayoutParams(params);
            iv.requestLayout();
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            if (list.size() > 0) {
                position = position % list.size();
            }
            Picasso.with(context).load(list.get(position).getBannerImgUrl()).into(iv);
            container.addView(iv);
            return iv;
        }

    }

    private class MyFragmentAdapter extends FragmentPagerAdapter {

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            AFragment aFragment = new AFragment();
            return aFragment;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

}
