package com.wei.retrofitdemo.request;

import android.util.Log;

import rx.Subscriber;

/**
 * Created by wei on 2016/10/31.
 */
public class MyDefalutCallBack<T> extends Subscriber<T> {
    private static final String TAG = "zpy_MyDefalutCallBack";
    @Override
    public void onCompleted() {
        Log.e(TAG, "onCompleted:  = ");
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "onError:  = ");
    }

    @Override
    public void onNext(T t) {
        Log.e(TAG, "onNext:  = ");
    }
}
