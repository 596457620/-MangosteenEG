package com.sz.mangosteeneg.http.httptool;

import android.content.Context;
import android.text.TextUtils;

import com.sz.mangosteeneg.tools.AppTokenUtil;
import com.sz.mangosteeneg.tools.AppUser;
import com.sz.mangosteeneg.tools.StringUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * @Time:2021/5/14 16:11
 * @Author:sz
 * @email: 15090708443@163.com
 * @Description:网络封装-RetrofitClient
 */
public class RetrofitClient {
    //超时时间
    private static final int DEFAULT_TIMEOUT = 20;
    //缓存大小
    private static final int CACHE_SIZE = 10 * 1024 * 1024;
    //服务端根路径
    public static String baseUrl = RuntimeData.getInstance().getHttpUrl();


    private static Context mContext = Utils.getContext();

    private static OkHttpClient okHttpClient;
    private static Retrofit retrofit;

    private static String phoneToken;   // 网络电话token

    private Cache cache = null;
    private File httpCacheDirectory;

    public static void setPhoneToken(String phoneToken) {
        RetrofitClient.phoneToken = phoneToken;
    }

    public static OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    private static class SingletonHolder {
        private static RetrofitClient INSTANCE = new RetrofitClient();
    }

    public static RetrofitClient getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private RetrofitClient() {
        this(baseUrl, null);
    }

    public void resetRetrofitClient() {
        new RetrofitClient();
    }


    private Map<String, String> createHttpHead() {
        Map<String, String> headers = new HashMap<>();



        //大佬们 这是我的token 不要删除  方便使用
        String item_spinner_cityzhongliang_token = "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFM1MTIifQ.eyJzdWIiOiIxMDIwNSIsImlhdCI6MTYxMjI2NjI1MSwiZXhwIjoxNjE0ODU4MjUxfQ.qU8kg8Jwghf1XaonYd5xIiNdW70wE8vQU8V1xpzWFlWIRUZz8mgsXEMZ2jCy0ncPjHPH4y2O07iolN6MMEORzA";
        String token_sz = "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFM1MTIifQ.eyJzdWIiOiIxMDEyMSIsImlhdCI6MTYxNDc0ODgzNiwiZXhwIjoxNjE3MzQwODM2fQ.Aj-KYvklfbSQFE6ddj4VTkqTvU5ERe_L6VWJ2mY0_cefsTRnAiZB1t1s4a_mLIokoipT2s_BX7Csnxp5eZ0rHw";

        // eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFM1MTIifQ.eyJzdWIiOiIxMDIwNSIsImlhdCI6MTYxMjI2NjI1MSwiZXhwIjoxNjE0ODU4MjUxfQ.qU8kg8Jwghf1XaonYd5xIiNdW70wE8vQU8V1xpzWFlWIRUZz8mgsXEMZ2jCy0ncPjHPH4y2O07iolN6MMEORzA

        headers.put("X-Auth-Token", getToken());
        headers.put("X-App-Type", "Android");

      /*   headers.put("Content-Type", "application/json");
        headers.put("X-App-Token", "e5d8edfc390c328f65c188c3f0e5702e");
        headers.put("X-App-Type", "Android");
        //headers.put("X-App-Name", RuntimeData.getInstance().getAppType());
        headers.put("X-App-Version", SystemUtil.getVersionName(Utils.getContext()));
        headers.put("X-Session-Id", CommUtils.getDeviceId(Utils.getContext()));

        if(StringUtil.isNotEmpty(phoneToken)){
            headers.put("SDB-Authorization", phoneToken);
        }*/


        return headers;
    }

    private String getToken(){
        String token = AppTokenUtil.getToken();
        if(StringUtil.isEmpty(token)){
            token = AppUser.getInstance().getToken();
        }
        if(StringUtil.isEmpty(token)){
            token = "";
        }
        return token;
    }

    private RetrofitClient(String url, Map<String, String> headers) {
        if (headers == null) {
            headers = createHttpHead();
        } else {
            headers.putAll(createHttpHead());
        }

        if (TextUtils.isEmpty(url)) {
            url = baseUrl;
        }

        if (httpCacheDirectory == null) {
            httpCacheDirectory = new File(FileUtil.getAppCachePath());
        }

        try {
            if (cache == null) {
                cache = new Cache(httpCacheDirectory, CACHE_SIZE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory();
//        okHttpClient = new OkHttpClient.Builder()
//                .cookieJar(new CookieJarImpl(new PersistentCookieStore(mContext)))
//                .cache(cache)
//                .addInterceptor(new BaseInterceptor(headers))
//                .addInterceptor(new CacheInterceptor(mContext))
//                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
//                .addInterceptor(new LoggingInterceptor
//                                .Builder()//构建者模式
//                                .loggable(BuildConfig.DEBUG) //是否开启日志打印
////                        .loggable(true) //是否开启日志打印
//                                .setLevel(Level.BASIC) //打印的等级
//                                .log(Platform.INFO) // 打印类型
//                                .request("Request") // request的Tag
//                                .response("Response")// Response的Tag
//                                .build()
//                )
//                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//                .connectionPool(new ConnectionPool(8, 15, TimeUnit.SECONDS))
//                .build();
//        retrofit = new Retrofit.Builder()
//                .client(okHttpClient)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
//                .baseUrl(url)
//                .build();
    }

    /**
     * create you ApiService
     * Create an implementation of the API endpoints defined by the {@code service} interface.
     */
    public <T> T create(final Class<T> service) {
        if (service == null) {
            throw new RuntimeException("Api service is null!");
        }
        return retrofit.create(service);
    }

    /**
     * /**
     * execute your customer API
     * For example:
     * MyApiService service =
     * RetrofitClient.getInstance(MainActivity.this).create(MyApiService.class);
     * <p>
     * RetrofitClient.getInstance(MainActivity.this)
     * .execute(service.lgon("name", "password"), subscriber)
     * * @param subscriber
     */

    public static <T> T execute(Observable<T> observable, Observer<T> subscriber) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

        return null;
    }
}
