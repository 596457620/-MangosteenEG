package com.sz.mangosteeneg.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.sz.mangosteeneg.base.BaseAppViewModel;
import com.sz.mangosteeneg.base.BaseViewModel;
import com.sz.mangosteeneg.entity.CityAreasBean;
import com.sz.mangosteeneg.http.httptool.BaseObserver;
import com.sz.mangosteeneg.tools.ToastUtils;

/**
 * @Time:2021/5/14 18:49
 * @Author:sz
 * @email: 15090708443@163.com
 * @Description: mvvm示例
 */
public class TestMvvmViewModel extends BaseAppViewModel {

    public MutableLiveData<CityAreasBean> liveAddress = new MutableLiveData<>();

    //获取地址数据
    public void reqAddress(){
        sendHttp(getRetrofitClient().getcityaddress(), new BaseObserver<CityAreasBean>() {
            @Override
            protected void onSuccess(CityAreasBean o) {
                if(o.isSuccess()){
                    liveAddress.setValue(o);
                }else {
                    ToastUtils.showShort(o.getResultMsg());
                }
            }
        });
    }

    public TestMvvmViewModel(@NonNull Application application) {
        super(application);
    }
}