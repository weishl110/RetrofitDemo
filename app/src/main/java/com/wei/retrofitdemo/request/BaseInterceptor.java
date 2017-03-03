package com.wei.retrofitdemo.request;

import android.util.Log;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http.HttpMethod;
import retrofit2.http.HTTP;

/**
 * Created by wei on 2016/10/28.
 */
public class BaseInterceptor implements Interceptor {

    private static final String TAG = "zpy_BaseInterceptor";
    private String header_type = "application/json; charset=UTF-8";
    private Map<String, String> headers;

    /**
     * @param headers 请求头
     */
    public BaseInterceptor(Map<String, String> headers) {
        this.headers = headers;
    }

    /**
     * 添加消息头
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        if (headers != null && headers.size() > 0) {
            Set<String> keys = headers.keySet();
            for (String header_key : keys) {
                builder.addHeader(header_key, headers.get(header_key));
            }
        } else
            builder.addHeader("Content-Type", header_type);

        Request request = chain.request();
        HttpUrl url = request.url();

        Log.e(TAG, "intercept: url = " + url);
        RequestBody body = request.body();
        String method = request.method();
        if ("POST".equals(method)) {
            Log.e(TAG, "intercept: body = " + body);
        }
        return chain.proceed(builder.build());
    }
}
