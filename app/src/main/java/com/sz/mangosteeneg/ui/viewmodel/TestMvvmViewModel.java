package com.sz.mangosteeneg.ui.viewmodel;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;

import com.sz.mangosteeneg.base.BaseAppViewModel;
import com.sz.mangosteeneg.base.BaseViewModel;
import com.sz.mangosteeneg.entity.CityAreasBean;
import com.sz.mangosteeneg.http.httptool.BaseObserver;
import com.sz.mangosteeneg.tools.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time:2021/5/14 18:49
 * @Author:sz
 * @email: 15090708443@163.com
 * @Description: mvvm示例
 */
public class TestMvvmViewModel extends BaseAppViewModel {

    public MutableLiveData<CityAreasBean> liveAddress = new MutableLiveData<>();
    public MutableLiveData<List<String>> liveString = new MutableLiveData<>();

    //文本内容
    public ObservableField<String> name = new ObservableField<>();

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

    //假装自己是个网络请求
    public void reqJiade(){
        List<String> list = new ArrayList<>();
        for(int i=0;i<200;i++){
            list.add("扫地欧尼"+i);
        }
        liveString.setValue(list);
        name.set("文本改变");
    }

    //文本的点击事件
    public void click(View view){
        ToastUtils.showShort("文本被点击");
    }

    public TestMvvmViewModel(@NonNull Application application) {
        super(application);
    }
}