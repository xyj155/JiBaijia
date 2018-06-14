package com.administrator.jibaijia.base.baseactivity;

/**
 * Created by Adaministrator on 2018/4/11.
 */

public interface IDataCallback<T> { //我们一样传入通用类型
    public void onNewData(T data);
    public void onError(String msg, int code);
}