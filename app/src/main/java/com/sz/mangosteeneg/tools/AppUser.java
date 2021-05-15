package com.sz.mangosteeneg.tools;

import android.text.TextUtils;

import com.sz.mangosteeneg.http.httptool.RetrofitClient;

/**
 * @Time:2021/5/14 16:46
 * @Author:sz
 * @email: 15090708443@163.com
 * @Description:用户信息
 */
public class AppUser {

    private static volatile AppUser instance = null;

    public static long firstTime = 0;
    public static long intervalTime = 1*1000 + 500;

    public static AppUser getInstance() {
        if (instance == null) {
            synchronized (AppUser.class) {
                if (instance == null) {
                    instance = new AppUser();
                }
            }
        }
        return instance;
    }

    private AppUser() {
    }

    private String token;
    private String userId;
    private String userType;        //
    private String name;
    private String nodeType;
    private String pubKey;
    private String mobile;


    public void loginSuccess(String token, String userId, String userType, String name,
                             String nodeType, String pubKey, String mobile) {
        this.token = token;
        this.userId = userId;
        this.userType = userType;
        this.name = name;
        this.nodeType = nodeType;
        this.pubKey = pubKey;
        this.mobile = mobile;
    }

    public void loginSuccess(String token) {
        this.token = token;
    }

    /**
     * 退出登录
     */
    public void logoutSuccess() {
        token = "";
        userId = "";
        userType = "";
        name = "";
        nodeType = "";
        pubKey = "";
        mobile = "";

        RetrofitClient.getInstance().resetRetrofitClient();
//        RouterManager.gotoLoginMainActivity();
    }

    public boolean isLogined() {
        return !TextUtils.isEmpty(AppTokenUtil.getToken());
    }

    public boolean doesNeedAutoLogin() {
        if (!isLogined() && !TextUtils.isEmpty(AppTokenUtil.getToken())) {
            return true;
        }
        return false;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getPubKey() {
        return pubKey;
    }

    public void setPubKey(String pubKey) {
        this.pubKey = pubKey;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
