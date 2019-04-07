package com.pinery.fun.joke;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.alibaba.android.arouter.launcher.ARouter;
import com.pinery.base.util.LogUtil;
import com.pinery.base.util.ScreenDensityUtil;

/**
 * Created by hesong-os on 2018/8/9.
 */

public class JokeApplication extends Application {
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private static JokeApplication sContext;

  @Override
  public void onCreate() {
    super.onCreate();
    sContext = this;

    init();
  }

  private void init() {
    initArouter();
    screenCompact();
  }

  private void initArouter() {
    ARouter.openLog();     // 打印日志
    ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
    ARouter.init(this); // 尽可能早，推荐在Application中初始化
  }

  private void screenCompact(){
    ScreenDensityUtil.setDensity(this);
  }

  public static JokeApplication getInstance(){
    return sContext;
  }

  public Handler getHandler(){
    return mHandler;
  }

  public void notifyGc(){
    mHandler.postDelayed(new Runnable() {
      @Override public void run() {
        LogUtil.i("System.gc()!!!!!!");
        System.gc();
        System.gc();
      }
    }, 10*1000);
  }

}
