package com.sz.mangosteeneg.tools;

import com.sz.mangosteeneg.widget.application.Constants;

/**
 * @Time:2021/5/14 16:42
 * @Author:sz
 * @email: 15090708443@163.com
 * @Description:
 */
public class AppTokenUtil {

    private static SPUtils spUtils;
    public static void initSp() {
        spUtils = SPUtils.getInstance(Constants.SP_NAME);
    }

    private static volatile AppTokenUtil instance = null;

    public static String getToken() {
        if (spUtils == null) {
            initSp();
        }
        String token = spUtils.getString("token");

        return token;
    }

    public static AppTokenUtil getInstance() {
        if (instance == null) {
            synchronized (AppTokenUtil.class) {
                if (instance == null) {
                    instance = new AppTokenUtil();
                }
            }
        }
        return instance;
    }

    public static void setAutoLogin(boolean auto) {
        if (spUtils == null) {
            initSp();
        }
        spUtils.put("autoLogin", auto);
    }
}
