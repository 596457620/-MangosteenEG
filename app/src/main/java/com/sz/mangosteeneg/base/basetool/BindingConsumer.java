package com.sz.mangosteeneg.base.basetool;

/**
 * @Time:2021/5/14 17:26
 * @Author:sz
 * @email: 15090708443@163.com
 * @Description:
 */
public interface BindingConsumer<T> {
    void call(T t);
}
