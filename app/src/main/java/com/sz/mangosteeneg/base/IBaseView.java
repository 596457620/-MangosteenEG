package com.sz.mangosteeneg.base;

/**
 * @Time:2021/5/14 17:11
 * @Author:sz
 * @email: 15090708443@163.com
 * @Description:
 */
public interface IBaseView {

    /**
     * 初始化界面传递参数
     */
    void initParam();
    /**
     * 初始化数据
     */
    void initData();

    /**
     * 初始化界面观察者的监听
     */
    void initViewObservable();

}
