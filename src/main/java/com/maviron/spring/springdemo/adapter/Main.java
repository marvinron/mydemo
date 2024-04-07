package com.maviron.spring.springdemo.adapter;

// 定义SSP接口
interface SSP {
    void requestAd(String placementId);
}

// 定义具体的SSP实现类
class SSP1 implements SSP {
    public void requestAd(String placementId) {
        System.out.println("Requesting ad from SSP1 for placement ID: " + placementId);
    }
}

class SSP2 implements SSP {
    public void requestAd(String placementId) {
        System.out.println("Requesting ad from SSP2 for placement ID: " + placementId);
    }
}

// 定义Adapter接口
interface AdxAdapter {
    void requestAd(String adxType, String placementId);
}

// 定义具体的AdxAdapter实现类
class AdxAdapterImpl implements AdxAdapter {
    private SSP ssp;

    public AdxAdapterImpl(SSP ssp) {
        this.ssp = ssp;
    }

    public void requestAd(String adxType, String placementId) {
        System.out.println("Requesting ad from " + adxType + " using SSP adapter for placement ID: " + placementId);
        ssp.requestAd(placementId);
    }
}

// 使用示例
public class Main {
    public static void main(String[] args) {
        SSP ssp1 = new SSP1();
        SSP ssp2 = new SSP2();

        AdxAdapter adxAdapter1 = new AdxAdapterImpl(ssp1);
        AdxAdapter adxAdapter2 = new AdxAdapterImpl(ssp2);

        adxAdapter1.requestAd("ADX1", "12345");
        adxAdapter2.requestAd("ADX2", "67890");
    }
}
