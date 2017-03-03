package com.wei.retrofitdemo.request;

import com.wei.retrofitdemo.ISMDetail;
import com.wei.retrofitdemo.ISMRequestResult;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by wei on 2016/10/28.
 */
public interface IRetrofitApi {

    @GET("xire-app-ism/OneDetailsIsm/QueryOne/{ismCode}")
    Observable<ISMRequestResult<ISMDetail>> getQueryOneISM(@Path("ismCode") String ismCode);
//    @GET("xire-app-ism/OneDetailsIsm/QueryOne/{ismCode}")
//    Call<String> getQueryOneISM(@Path("ismCode") String ismCode);
}
