package com.wei.retrofitdemo;

import java.util.List;

/**
 * Created by wei on 2016/10/31.
 */
public class ISMDetail {

    /**
     * proDescript : 本ISM为3×2组合，其中3个行业分别为：房地产;电力及公用事业;电力设备;每个行业下辖不多于2个股票。信号数量为7个。
     * buildBeginDate : 2016-10-28 00:00:00
     * broads : [{"broadProportionDown":"15.0","broadName":"电力及公用事业","subBroads":[{"downPrice":"15.85","secName":"滨海能源","innerCode":"369","validStatus":"1","price":"17.61","proId":"161027191905022","broadId":"20","priorType":"1","upPrice":"19.37","secId":"000695"},{"downPrice":"2.89","secName":"内蒙华电","innerCode":"2110","validStatus":"1","price":"3.21","proId":"161027191905022","broadId":"20","priorType":"1","upPrice":"3.53","secId":"600863"}],"broadProportionUp":"22.0","proId":"161027191905022","broadId":"20","broadProportion":"17"},{"broadProportionDown":"20.0","broadName":"电力设备","subBroads":[{"downPrice":"9.54","secName":"创元科技","innerCode":"238","validStatus":"1","price":"10.60","proId":"161027191905022","broadId":"27","priorType":"1","upPrice":"11.66","secId":"000551"},{"downPrice":"19.75","secName":"积成电子","innerCode":"9540","validStatus":"1","price":"21.94","proId":"161027191905022","broadId":"27","priorType":"1","upPrice":"24.13","secId":"002339"}],"broadProportionUp":"33.0","proId":"161027191905022","broadId":"27","broadProportion":"27"},{"broadProportionDown":"48.0","broadName":"房地产","subBroads":[{"downPrice":"44.82","secName":"海德股份","innerCode":"255","validStatus":"1","price":"49.80","proId":"161027191905022","broadId":"42","priorType":"1","upPrice":"54.78","secId":"000567"},{"downPrice":"16.34","secName":"中体产业","innerCode":"1278","validStatus":"1","price":"18.15","proId":"161027191905022","broadId":"42","priorType":"1","upPrice":"19.97","secId":"600158"}],"broadProportionUp":"63.0","proId":"161027191905022","broadId":"42","broadProportion":"56"}]
     * buildEndDate : 2016-11-07 00:00:00
     * propaEndDate : 2016-10-28 00:00:00
     * raiseEndDate : 2016-10-28 00:00:00
     * inviestNumMin : 13345
     * carryNumMax : 10000000
     * proBeginDate : 2016-10-28 00:00:00
     * expectProfit : 0.4000
     * riskNum : 0.08341084649141978
     * proId : 161027191905022
     * proSource : 01
     * sliceCycle : 7
     * proRisk : 013
     * proName : I161027191905022
     * propaBeginDate : 2016-10-28 00:00:00
     * proEndDate : 2016-11-07 00:00:00
     * totalOperatingDays : 11
     * createDate : 2016-10-27 00:00:00
     * raiseBeginDate : 2016-10-28 00:00:00
     */

    private String proDescript;
    private String buildBeginDate;
    private String buildEndDate;
    private String propaEndDate;
    private String raiseEndDate;
    private String inviestNumMin;
    private String carryNumMax;
    private String proBeginDate;
    private String expectProfit;
    private double riskNum;
    private String proId;
    private String proSource;
    private String sliceCycle;
    private String proRisk;
    private String proName;
    private String propaBeginDate;
    private String proEndDate;
    private String totalOperatingDays;
    private String createDate;
    private String raiseBeginDate;
    /**
     * broadProportionDown : 15.0
     * broadName : 电力及公用事业
     * subBroads : [{"downPrice":"15.85","secName":"滨海能源","innerCode":"369","validStatus":"1","price":"17.61","proId":"161027191905022","broadId":"20","priorType":"1","upPrice":"19.37","secId":"000695"},{"downPrice":"2.89","secName":"内蒙华电","innerCode":"2110","validStatus":"1","price":"3.21","proId":"161027191905022","broadId":"20","priorType":"1","upPrice":"3.53","secId":"600863"}]
     * broadProportionUp : 22.0
     * proId : 161027191905022
     * broadId : 20
     * broadProportion : 17
     */

    private List<BroadsBean> broads;

    public String getProDescript() {
        return proDescript;
    }

    public void setProDescript(String proDescript) {
        this.proDescript = proDescript;
    }

    public String getBuildBeginDate() {
        return buildBeginDate;
    }

    public void setBuildBeginDate(String buildBeginDate) {
        this.buildBeginDate = buildBeginDate;
    }

    public String getBuildEndDate() {
        return buildEndDate;
    }

    public void setBuildEndDate(String buildEndDate) {
        this.buildEndDate = buildEndDate;
    }

    public String getPropaEndDate() {
        return propaEndDate;
    }

    public void setPropaEndDate(String propaEndDate) {
        this.propaEndDate = propaEndDate;
    }

    public String getRaiseEndDate() {
        return raiseEndDate;
    }

    public void setRaiseEndDate(String raiseEndDate) {
        this.raiseEndDate = raiseEndDate;
    }

    public String getInviestNumMin() {
        return inviestNumMin;
    }

    public void setInviestNumMin(String inviestNumMin) {
        this.inviestNumMin = inviestNumMin;
    }

    public String getCarryNumMax() {
        return carryNumMax;
    }

    public void setCarryNumMax(String carryNumMax) {
        this.carryNumMax = carryNumMax;
    }

    public String getProBeginDate() {
        return proBeginDate;
    }

    public void setProBeginDate(String proBeginDate) {
        this.proBeginDate = proBeginDate;
    }

    public String getExpectProfit() {
        return expectProfit;
    }

    public void setExpectProfit(String expectProfit) {
        this.expectProfit = expectProfit;
    }

    public double getRiskNum() {
        return riskNum;
    }

    public void setRiskNum(double riskNum) {
        this.riskNum = riskNum;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProSource() {
        return proSource;
    }

    public void setProSource(String proSource) {
        this.proSource = proSource;
    }

    public String getSliceCycle() {
        return sliceCycle;
    }

    public void setSliceCycle(String sliceCycle) {
        this.sliceCycle = sliceCycle;
    }

    public String getProRisk() {
        return proRisk;
    }

    public void setProRisk(String proRisk) {
        this.proRisk = proRisk;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getPropaBeginDate() {
        return propaBeginDate;
    }

    public void setPropaBeginDate(String propaBeginDate) {
        this.propaBeginDate = propaBeginDate;
    }

    public String getProEndDate() {
        return proEndDate;
    }

    public void setProEndDate(String proEndDate) {
        this.proEndDate = proEndDate;
    }

    public String getTotalOperatingDays() {
        return totalOperatingDays;
    }

    public void setTotalOperatingDays(String totalOperatingDays) {
        this.totalOperatingDays = totalOperatingDays;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getRaiseBeginDate() {
        return raiseBeginDate;
    }

    public void setRaiseBeginDate(String raiseBeginDate) {
        this.raiseBeginDate = raiseBeginDate;
    }

    public List<BroadsBean> getBroads() {
        return broads;
    }

    public void setBroads(List<BroadsBean> broads) {
        this.broads = broads;
    }

    public static class BroadsBean {
        private String broadProportionDown;
        private String broadName;
        private String broadProportionUp;
        private String proId;
        private String broadId;
        private String broadProportion;
        /**
         * downPrice : 15.85
         * secName : 滨海能源
         * innerCode : 369
         * validStatus : 1
         * price : 17.61
         * proId : 161027191905022
         * broadId : 20
         * priorType : 1
         * upPrice : 19.37
         * secId : 000695
         */

        private List<SubBroadsBean> subBroads;

        public String getBroadProportionDown() {
            return broadProportionDown;
        }

        public void setBroadProportionDown(String broadProportionDown) {
            this.broadProportionDown = broadProportionDown;
        }

        public String getBroadName() {
            return broadName;
        }

        public void setBroadName(String broadName) {
            this.broadName = broadName;
        }

        public String getBroadProportionUp() {
            return broadProportionUp;
        }

        public void setBroadProportionUp(String broadProportionUp) {
            this.broadProportionUp = broadProportionUp;
        }

        public String getProId() {
            return proId;
        }

        public void setProId(String proId) {
            this.proId = proId;
        }

        public String getBroadId() {
            return broadId;
        }

        public void setBroadId(String broadId) {
            this.broadId = broadId;
        }

        public String getBroadProportion() {
            return broadProportion;
        }

        public void setBroadProportion(String broadProportion) {
            this.broadProportion = broadProportion;
        }

        public List<SubBroadsBean> getSubBroads() {
            return subBroads;
        }

        public void setSubBroads(List<SubBroadsBean> subBroads) {
            this.subBroads = subBroads;
        }

        public static class SubBroadsBean {
            private String downPrice;
            private String secName;
            private String innerCode;
            private String validStatus;
            private String price;
            private String proId;
            private String broadId;
            private String priorType;
            private String upPrice;
            private String secId;

            public String getDownPrice() {
                return downPrice;
            }

            public void setDownPrice(String downPrice) {
                this.downPrice = downPrice;
            }

            public String getSecName() {
                return secName;
            }

            public void setSecName(String secName) {
                this.secName = secName;
            }

            public String getInnerCode() {
                return innerCode;
            }

            public void setInnerCode(String innerCode) {
                this.innerCode = innerCode;
            }

            public String getValidStatus() {
                return validStatus;
            }

            public void setValidStatus(String validStatus) {
                this.validStatus = validStatus;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getProId() {
                return proId;
            }

            public void setProId(String proId) {
                this.proId = proId;
            }

            public String getBroadId() {
                return broadId;
            }

            public void setBroadId(String broadId) {
                this.broadId = broadId;
            }

            public String getPriorType() {
                return priorType;
            }

            public void setPriorType(String priorType) {
                this.priorType = priorType;
            }

            public String getUpPrice() {
                return upPrice;
            }

            public void setUpPrice(String upPrice) {
                this.upPrice = upPrice;
            }

            public String getSecId() {
                return secId;
            }

            public void setSecId(String secId) {
                this.secId = secId;
            }
        }
    }
}
