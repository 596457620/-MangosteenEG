package com.sz.mangosteeneg.base;

import android.app.Activity;
import android.app.Application;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.sz.mangosteeneg.http.IMyServices;
import com.sz.mangosteeneg.http.httptool.BaseObserver;
import com.sz.mangosteeneg.http.httptool.Gloading;
import com.sz.mangosteeneg.http.httptool.RetrofitClient;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * @Time:2021/5/14 15:56
 * @Author:sz
 * @email: 15090708443@163.com
 * @Description: ViewModel最终的父类
 */
public class BaseAppViewModel extends BaseViewModel{

    //加载等待框
    protected Gloading.Holder mHolder;

    public BaseAppViewModel(@NonNull Application application) {
        super(application);
    }

    //关联service
    public IMyServices getRetrofitClient(){
        return getRetrofitClient(IMyServices.class);
    }
    public <T> T getRetrofitClient(Class<T> service) {
        return RetrofitClient.getInstance().create(service);
    }

    public <T> void sendHttp(Observable<T> observable, Observer<T> observer) {
        RetrofitClient.getInstance().execute(observable, observer);
    }

    public class HttpBackObserver<T> extends BaseObserver<T> {

        private boolean showDialog;
        private String dialogText;

        public HttpBackObserver() {
            showDialog = true;
        }

        public HttpBackObserver(boolean showDialog) {
            this.showDialog = showDialog;
        }

        @Override
        public void onSubscribe(Disposable d) {
            super.onSubscribe(d);
            if (showDialog) {
                showDialog("正在请求...");
            }
        }

        @Override
        public void onNext(T t) {
            super.onNext(t);
        }

        @Override
        public void onError(Throwable throwable) {
            super.onError(throwable);
            //关闭对话框
            dismissDialog();
        }

        @Override
        public void onComplete() {
            super.onComplete();
            //关闭对话框
            dismissDialog();
        }

        @Override
        protected void onSuccess(T o) {

        }

        @Override
        protected void onFailed(T t) {
            super.onFailed(t);
            //关闭对话框
            dismissDialog();
        }
    }

    //请求时的等待框
    public class HttpBackObserverNoDialog<T> extends BaseObserver<T> {

        @Override
        public void onSubscribe(Disposable d) {
            super.onSubscribe(d);
        }

        @Override
        public void onError(Throwable throwable) {
            super.onError(throwable);
        }

        @Override
        public void onComplete() {
            super.onComplete();
        }

        @Override
        protected void onSuccess(T o) {

        }

        @Override
        protected void onFailed(T t) {
            super.onFailed(t);
        }

        @Override
        public void onNext(T t) {
            super.onNext(t);
        }
    }

    public void initLoadingStatusView(Activity activity) {
        initLoadingStatusView(activity, "");
    }

    public void initLoadingStatusView(ViewGroup view) {
        initLoadingStatusView(view, "");
    }

    public void initLoadingStatusView(Activity activity, String des) {
        mHolder = Gloading.getDefault().wrap(activity, des).withRetry(new Runnable() {
            @Override
            public void run() {
                onLoadRetry();
            }
        });
    }

    public void initLoadingStatusView(ViewGroup view, String des) {
        mHolder = Gloading.getDefault().wrap(view, des).withRetry(new Runnable() {
            @Override
            public void run() {
                onLoadRetry();
            }
        });
    }

    protected void onLoadRetry() {
        // override this method in subclass to do retry task
    }

    public void showLoading() {
        if (mHolder != null) {
            mHolder.showLoading();
        }
    }

    public void showLoadSuccess() {
        if (mHolder != null) {
            mHolder.showLoadSuccess();
        }
    }

    public void showLoadFailed() {
        if (mHolder != null) {
            mHolder.showLoadFailed();
        }
    }

    public void showEmpty() {
        if (mHolder != null) {
            mHolder.showEmpty();
        }
    }

}