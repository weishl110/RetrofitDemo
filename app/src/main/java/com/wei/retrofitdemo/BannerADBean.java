package com.wei.retrofitdemo;

import com.google.gson.Gson;

/**
 * Created by lenovo0000 on 2016/3/24.
 */
public class BannerADBean {


    /**
     * activeUrl : http://www.zipeiyi.com:9090/xire_store/XIRE_FILES/XiReApp/website/page4.html
     * bannerId : 20150605110421
     * bannerImgUrl : http://10.0.150.5:7070/xire_store/XIRE_FILES/XiReApp/banner/1446189347639.jpg
     * bannerName : 更多4
     * date : 2015-06-05 00:00:00
     */

    private String activeUrl;
    private String bannerId;
    private String bannerImgUrl;
    private String bannerName;
    private String date;

    public static BannerADBean objectFromData(String str) {

        return new Gson().fromJson(str, BannerADBean.class);
    }

    public void setActiveUrl(String activeUrl) {
        this.activeUrl = activeUrl;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

    public void setBannerImgUrl(String bannerImgUrl) {
        this.bannerImgUrl = bannerImgUrl;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getActiveUrl() {
        return activeUrl;
    }

    public String getBannerId() {
        return bannerId;
    }

    public String getBannerImgUrl() {
        return bannerImgUrl;
    }

    public String getBannerName() {
        return bannerName;
    }

    public String getDate() {
        return date;
    }
}
