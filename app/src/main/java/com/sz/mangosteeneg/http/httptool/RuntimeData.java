package com.sz.mangosteeneg.http.httptool;

/**
 * @Time:2021/5/14 16:13
 * @Author:sz
 * @email: 15090708443@163.com
 * @Description:超时对象
 */
public class RuntimeData {
    private static final RuntimeData ourInstance = new RuntimeData();

    public static RuntimeData getInstance() {
        return ourInstance;
    }

    private RuntimeData() {
    }

    private String httpUrl;
    private String imHost;
    private String imHttpHost;
    private String webHost;
    private String AppType;
    private String ApplicationId;

    private boolean isGetBseConfig;

    private boolean needPushMsg = true;

    private String rongCloudAppKey;


    public String getHttpUrl() {
        return httpUrl;
    }

    public void setHttpUrl(String httpUrl) {
        this.httpUrl = httpUrl;
    }

    public String getImHost() {
        return imHost;
    }

    public void setImHost(String imHost) {
        this.imHost = imHost;
    }

    public String getImHttpHost() {
        return imHttpHost;
    }

    public void setImHttpHost(String imHttpHost) {
        this.imHttpHost = imHttpHost;
    }

    public String getWebHost() {
        return webHost;
    }

    public void setWebHost(String webHost) {
        this.webHost = webHost;
    }

    public boolean isNeedPushMsg() {
        return needPushMsg;
    }

    public void setNeedPushMsg(boolean needPushMsg) {
        this.needPushMsg = needPushMsg;
    }

    public String getAppType() {
        return AppType;
    }

    public void setAppType(String appType) {
        AppType = appType;
    }

    public String getApplicationId() {
        return ApplicationId;
    }

    public void setApplicationId(String applicationId) {
        ApplicationId = applicationId;
    }

    public boolean isGetBseConfig() {
        return isGetBseConfig;
    }

    public void setGetBseConfig(boolean getBseConfig) {
        isGetBseConfig = getBseConfig;
    }

    public String getRongCloudAppKey() {
        return rongCloudAppKey;
    }

    public void setRongCloudAppKey(String rongCloudAppKey) {
        this.rongCloudAppKey = rongCloudAppKey;
    }
}
