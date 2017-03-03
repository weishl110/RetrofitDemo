package com.wei.retrofitdemo.request;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wei on 2016/10/28.
 */
public class OkhttpUtils {

    public static final String HEADER_JSON = "application/json; charset=UTF-8";
    public static final String HEADER_TEXT = "text/plain";
    private static HashMap<String, String> headerMap = new HashMap<>();

    private static final String BASE_URL = "";

    private static final long READTIMEOUT = 5000;
    private static final long CONNECTTIMEOUT = 5000;
    private static boolean retryOnConnectionFailure = false;//失败是否重连

    private static Retrofit createOkhttp(){
        if(TextUtils.isEmpty(BASE_URL)){
            throw new IllegalArgumentException("BASE_URL 不能为空");
        }
        Retrofit retrofit = getRetrofit(BASE_URL);
        return retrofit;
    }

    private static Retrofit createOkhttp(String baseUrl){
        if(TextUtils.isEmpty(baseUrl)){
            throw new IllegalArgumentException("baseUrl 不能为空");
        }
        Retrofit retrofit = getRetrofit(baseUrl);
        return retrofit;
    }

    @NonNull
    private static Retrofit getRetrofit(String baseUrl) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.retryOnConnectionFailure(retryOnConnectionFailure).addInterceptor(new BaseInterceptor(headerMap))
                .readTimeout(READTIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECTTIMEOUT,TimeUnit.SECONDS).build();

/*        Request.Builder builder = new Request.Builder();
        builder.addHeader("constant-type", "application/json").addHeader("ChartSet", " UTF-8");
        Request request = builder.build();*/

        return new Retrofit.Builder().baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient.build())
                .build();
    }

    public static void addHeader_json(){
        headerMap.put("Content-type",HEADER_JSON);
    }
    public static void addHeader_plain(){
        headerMap.put("Content-type",HEADER_TEXT);
    }
}
