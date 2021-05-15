package com.sz.mangosteeneg.http.httptool;

import com.sz.mangosteeneg.tools.AppTokenUtil;
import com.sz.mangosteeneg.tools.AppUser;
import com.sz.mangosteeneg.tools.StringUtil;
import com.sz.mangosteeneg.tools.ToastUtils;

import java.net.ConnectException;
import java.net.UnknownHostException;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

/**
 * @Time:2021/5/14 16:49
 * @Author:sz
 * @email: 15090708443@163.com
 * @Description:
 */
public abstract class BaseObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {
    }

    @Override
    public void onComplete() {
        onfinish();
        onFinish(false);
    }

    @Override
    public void onError(Throwable e) {
        onfinish();
        onFinish(true);
        Exception ex = handleException(e);
        if(StringUtil.isNotEmpty(ex.getMessage())){
            ToastUtils.showShort(ex.getMessage());
        }

    }

    @Override
    public void onNext(T t) {
        if (t == null) {
            ToastUtils.showShort("系统升级中");
            return;
        }

    }

    protected void onFailed(T t) {

    }

//    public void finishPage(){}

    protected abstract void onSuccess(T t);

    // 错误，正确都回调
    public void onfinish(){

    }

    public void onFinish(boolean error){

    }

    public static final int HTTP_OK = 200;
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;
    private static final int OCR_FAIL = 463;

    public Exception handleException(Throwable e) {
        Exception ex;
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            ResponseBody responseBody = httpException.response().errorBody();
            switch (httpException.code()) {
                case UNAUTHORIZED:
                    ex = new Exception("登录状态失效，请重新登录");
                    AppTokenUtil.getInstance().setAutoLogin(false);
                    AppUser.getInstance().logoutSuccess();

                    RetrofitClient.getInstance().resetRetrofitClient();

                    break;
                case OCR_FAIL:
                    ex = new Exception("无效的证件照片");
                    break;
                case INTERNAL_SERVER_ERROR:
                case NOT_FOUND:
                case REQUEST_TIMEOUT:
                case GATEWAY_TIMEOUT:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    ex = new Exception("服务器忙！");
                    break;
            }
            return ex;
        } else if (e instanceof ConnectException || e instanceof UnknownHostException) {
            ex = new Exception("系统升级中，请稍候再试");
            return ex;
        }
        return new Exception();
    }
}
