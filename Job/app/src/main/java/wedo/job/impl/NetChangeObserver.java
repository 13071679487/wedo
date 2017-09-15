package wedo.job.impl;


import wedo.job.util.NetStateUtil;

/**
 * 网络改变观察者，观察网络改变后回调的方法
 * Created by Lifu on 2017/9/15.
 */

public interface NetChangeObserver {

    /**
     * 网络连接回调 type为网络类型
     */
    void onNetConnected(NetStateUtil.NetType type);

    /**
     * 没有网络
     */
    void onNetDisConnect();
}
