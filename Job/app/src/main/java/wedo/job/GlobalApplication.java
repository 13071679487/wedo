package wedo.job;

import android.app.Application;

/**
 * Created by Lifu on 2017/9/15.
 */

public class GlobalApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 通过继承Thread.UncaughtExceptionHandler，记录App发生异常的信息
         */
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);

        /*
        * 注册网络状态接受者
        * */
        NetStateReceiver.registerNetworkStateReceiver(this);
    }
}
