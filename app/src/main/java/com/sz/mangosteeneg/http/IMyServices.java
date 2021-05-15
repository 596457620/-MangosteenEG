package com.sz.mangosteeneg.http;

import com.sz.mangosteeneg.entity.CityAreasBean;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

/**
 * @Time:2021/5/14 15:58
 * @Author:sz
 * @email: 15090708443@163.com
 * @Description: 接口service
 */
public interface IMyServices {

    //获取地址数据
    @GET(UrlModule.Url_cityaddress)
    Observable<CityAreasBean> getcityaddress();

}
