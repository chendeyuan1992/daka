package daka.com.example.chen.daka.util;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by chen on 2016/3/5.
 */
public class AppContext extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ShareUtil.initShared(this);
        OkHttpUtil.initOkHttp();
        FrescoUtil.initFresco(this);
        Fresco.initialize(this);
    }
}
