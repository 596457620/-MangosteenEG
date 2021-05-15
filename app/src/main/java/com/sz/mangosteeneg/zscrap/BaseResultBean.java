package com.sz.mangosteeneg.zscrap;

/**
 * @Time:2021/5/14 16:07
 * @Author:sz
 * @email: 15090708443@163.com
 * @Description: 用于封装Httpservice的bean（暂时弃用）
 */
public class BaseResultBean<T> {

    private int resultCode;
    private String resultMsg;
    private int errCode;
    private T data;
    private boolean success;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public boolean doesSuccess() {
        return resultCode == 200 && errCode == 0;
    }

    @Override
    public String toString() {
        return "BaseResultBean{" +
                "resultCode=" + resultCode +
                ", resultMsg='" + resultMsg + '\'' +
                ", errCode=" + errCode +
                ", data=" + data +
                ", success=" + success +
                '}';
    }
}